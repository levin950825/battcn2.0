package com.battcn.platform.logAop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.battcn.annotation.SystemLog;
import com.battcn.platform.entity.pub.LogsEntity;
import com.battcn.platform.service.pub.LogsService;
import com.battcn.util.CommonUtil;
import com.battcn.util.SessionUtil;
import com.battcn.util.http.RequestUtils;
import com.github.pagehelper.StringUtil;

/**
 * 切点类
 */
@Aspect
@Component
public class LogAopAction
{
	// 本地异常日志记录对象
	private static final Logger logger = LoggerFactory.getLogger(LogAopAction.class);

	@Autowired LogsService logsService;

	/**
	 * Controller 拦截点,前置通知
	 */
	@Pointcut("@annotation(com.battcn.annotation.SystemLog)")
	public void beforeController()
	{
	}

	/**
	 * 操作异常记录
	 * 
	 * @param point
	 * @param e
	 * @author LJN
	 * @date 2015年5月5日
	 * @version 1.0
	 */
	@AfterThrowing(pointcut = "beforeController()", throwing = "e")
	public void doAfterThrowing(JoinPoint point, Throwable e)
	{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		LogsEntity logForm = new LogsEntity();
		Map<String, Object> map = null;
		String accountName = null;
		String ip = null;
		try
		{
			ip = CommonUtil.toIpAddr(request);
		} catch (Exception ee)
		{
			ip = "无法获取登录用户Ip";
		}
		try
		{
			map = getControllerMethodDescription(point);
			// 登录名
			accountName = SessionUtil.getSession().getAccount();
			if (StringUtil.isEmpty(accountName))
			{
				accountName = "无法获取登录用户信息！";
			}
		} catch (Exception ee)
		{
			accountName = "无法获取登录用户信息！";
		}

		try
		{
			logForm.setUrl(RequestUtils.getURI(request));
			logForm.setAccount(accountName);
			logForm.setTitle(String.valueOf(map.get("module")));
			logForm.setMethods(String.valueOf(map.get("methods")));
			logForm.setMessage(String.valueOf(map.get("description")));
			logForm.setDuration(0L);
			logForm.setIp(ip);
			logForm.setOptime(new Date());
			logForm.setIp(ip);
			logsService.insert(logForm);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 *
	 * @param joinPoint
	 *            切点
	 */
	@Around("beforeController()")
	public Object doController(ProceedingJoinPoint point)
	{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Object result = null;
		// 执行方法名
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().getSimpleName();
		LogsEntity logForm = new LogsEntity();
		Map<String, Object> map = null;
		String accountName = null;
		Long start = 0L;
		Long end = 0L;
		Long time = 0L;
		String ip = null;
		try
		{
			ip = CommonUtil.toIpAddr(request);
		} catch (Exception e)
		{
			ip = "无法获取登录用户Ip";
		}
		try
		{
			// 登录名
			accountName = SessionUtil.getSession().getAccount();
			if (StringUtil.isEmpty(accountName))
			{
				accountName = "无法获取登录用户信息！";
			}
		} catch (Exception e)
		{
			accountName = "无法获取登录用户信息！";
		}
		try
		{
			map = getControllerMethodDescription(point);
			// 执行方法所消耗的时间
			start = System.currentTimeMillis();
			result = point.proceed();
			end = System.currentTimeMillis();
			time = end - start;
		} catch (Throwable e)
		{
			throw new RuntimeException(e);
		}
		// 当前用户
		try
		{

			logger.debug("=====通知开始=====");
			logger.debug("请求方法:{}", className + "." + methodName + "()");
			logger.debug("方法描述:{}", map);
			logger.debug("请求IP:{}", ip);
			logger.debug("=====通知结束=====");
			logForm.setUrl(RequestUtils.getURI(request));
			logForm.setAccount(accountName);
			logForm.setTitle(String.valueOf(map.get("module")));
			logForm.setMethods(String.valueOf(map.get("methods")));
			logForm.setMessage(String.valueOf(map.get("description")));
			logForm.setDuration(time);
			logForm.setIp(ip);
			logForm.setOptime(new Date());
			logForm.setIp(ip);
			logsService.insert(logForm);
		} catch (Throwable e)
		{
			// 记录本地异常日志
			logger.error("====通知异常====");
			logger.error("异常信息:", e.getMessage());
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint) throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		for (Method method : methods)
		{
			if (method.getName().equals(methodName))
			{
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length)
				{
					map.put("module", method.getAnnotation(SystemLog.class).module());
					map.put("methods", method.getAnnotation(SystemLog.class).methods());
					String de = method.getAnnotation(SystemLog.class).description();
					if (StringUtil.isEmpty(de))
						de = "执行成功!";
					map.put("description", de);
					break;
				}
			}
		}
		return map;
	}
}
