package com.battcn.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpServletRequest帮助类
 * 
 * @author ht
 * 
 */
public class RequestUtils
{
	public static final String PARAM_SEP = ",";

	public static String getURI(HttpServletRequest request) throws IllegalStateException
	{
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int start = uri.indexOf(contextPath);
		return uri.substring(start + contextPath.length());
	}

	public static String getString(HttpServletRequest request, String name, String defaultValue)
	{
		String[] values = request.getParameterValues(name);
		if (values == null || values.length == 0)
		{
			return defaultValue;
		}
		return StringUtils.join(values, PARAM_SEP);
	}

	public static Integer getInt(HttpServletRequest request, String name, Integer defaultValue)
	{
		String temp = request.getParameter(name);
		if (StringUtils.isEmpty(temp))
		{
			return defaultValue;
		}
		try
		{
			return Integer.valueOf(temp);
		} catch (Exception e)
		{
			return defaultValue;
		}
	}

	public static Integer[] getIntAll(HttpServletRequest request, String name)
	{
		String[] temps = request.getParameterValues(name);
		if (temps == null)
		{
			return new Integer[0];
		}
		List<Integer> result = new ArrayList<Integer>();
		for (String temp : temps)
		{
			try
			{
				result.add(Integer.valueOf(temp));
			} catch (Exception e)
			{
			}
		}
		return result.toArray(new Integer[] {});
	}

	public static Double getDouble(HttpServletRequest request, String name, Double defaultValue)
	{
		String temp = request.getParameter(name);
		if (StringUtils.isEmpty(temp))
		{
			return defaultValue;
		}
		try
		{
			return Double.valueOf(temp);
		} catch (Exception e)
		{
			return defaultValue;
		}
	}

	public static Double[] getDoubleAll(HttpServletRequest request, String name)
	{
		String[] temps = request.getParameterValues(name);
		if (temps == null)
		{
			return new Double[0];
		}
		List<Double> result = new ArrayList<Double>();
		for (String temp : temps)
		{
			try
			{
				result.add(Double.valueOf(temp));
			} catch (Exception e)
			{
			}
		}
		return result.toArray(new Double[] {});
	}

	public static BigDecimal getBigDecimal(HttpServletRequest request, String name, BigDecimal defaultValue)
	{
		String temp = request.getParameter(name);
		if (StringUtils.isEmpty(temp))
		{
			return defaultValue;
		}
		try
		{
			return new BigDecimal(temp);
		} catch (Exception e)
		{
			return defaultValue;
		}
	}

	public static BigDecimal[] getBigDecimalAll(HttpServletRequest request, String name)
	{
		String[] temps = request.getParameterValues(name);
		if (temps == null)
		{
			return new BigDecimal[0];
		}
		List<BigDecimal> result = new ArrayList<BigDecimal>();
		for (String temp : temps)
		{
			try
			{
				result.add(new BigDecimal(temp));
			} catch (Exception e)
			{
			}
		}
		return result.toArray(new BigDecimal[] {});
	}

	/**
	 * 获取QueryString的参数
	 * 
	 * @param request
	 *            web请求
	 * @param name
	 *            参数名称
	 * @return
	 */
	public static String getQueryParam(HttpServletRequest request, String name)
	{
		if (StringUtils.isBlank(name))
		{
			return null;
		}
		return StringUtils.join(request.getParameterValues(name), PARAM_SEP);
	}

	public static Map<String, Object> getQueryParams(HttpServletRequest request)
	{
		Map<String, String[]> map = request.getParameterMap();
		Map<String, Object> params = new HashMap<String, Object>(map.size());
		int len;
		for (Map.Entry<String, String[]> entry : map.entrySet())
		{
			len = entry.getValue().length;
			if (len == 1)
			{
				params.put(entry.getKey(), entry.getValue()[0]);
			} else if (len > 1)
			{
				params.put(entry.getKey(), entry.getValue());
			}
		}
		return params;
	}

	public static Map<String, String> parseQueryString(String s)
	{
		if (s == null)
		{
			return Collections.emptyMap();
		}
		Map<String, String> ht = new HashMap<String, String>();
		StringTokenizer st = new StringTokenizer(s, "&");
		while (st.hasMoreTokens())
		{
			String pair = (String) st.nextToken();
			int pos = pair.indexOf('=');
			if (pos == -1)
			{
				continue;
			}
			String key = pair.substring(0, pos);
			String val = pair.substring(pos + 1, pair.length());
			if (ht.containsKey(key))
			{
				String oldVals = (String) ht.get(key);
				ht.put(key, oldVals + PARAM_SEP + val);
			} else
			{
				ht.put(key, val);
			}
		}
		return ht;
	}

	public static Map<String, String> getRequestMap(HttpServletRequest request, String prefix)
	{
		Map<String, String> data = new HashMap<String, String>();
		try
		{
			Map<String, String> map = getRequestMap(request);
			for (Map.Entry<String, String> entry : map.entrySet())
			{
				String key = entry.getKey();
				if (key.startsWith(prefix))
				{
					String tmpkey = key;
					String value = entry.getValue();
					data.put(tmpkey, value);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}

	public static Map<String, Object> getRequestMap(HttpServletRequest request, ParameterWrapper wrapper)
	{
		return wrapper.wrap(request);
	}

	public static Map<String, String> getRequestMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> names = request.getParameterNames();
		String name;
		while (names.hasMoreElements())
		{
			name = names.nextElement();
			map.put(name, StringUtils.join(request.getParameterValues(name), PARAM_SEP));
		}
		return map;
	}

	public static void setAttributes(HttpServletRequest request, Map<String, String> map)
	{
		for (Map.Entry<String, String> entry : map.entrySet())
		{
			request.setAttribute(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * 获取访问者IP
	 * 
	 * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 * 
	 * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
	 * 如果还不存在则调用Request.getRemoteAddr()。
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip))
		{
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip))
		{
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1)
			{
				return ip.substring(0, index);
			} else
			{
				return ip;
			}
		} else
		{
			return request.getRemoteAddr();
		}
	}

	public static String getQueryString(HttpServletRequest request, String... exclude)
	{
		StringBuffer sb = new StringBuffer();
		List<String> excludeList = Arrays.asList(exclude);
		Enumeration<String> names = request.getParameterNames();
		String name;
		String value;
		while (names.hasMoreElements())
		{
			name = names.nextElement();
			value = StringUtils.join(request.getParameterValues(name));
			if (!excludeList.contains(name))
			{
				sb.append("&").append(name).append("=").append(value);
			}
		}
		if (sb.length() > 0)
			sb.deleteCharAt(0);
		return sb.toString();
	}

	public static interface ParameterWrapper
	{
		public Map<String, Object> wrap(HttpServletRequest request);
	}
	
	
	protected final static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param)
	{
		String result = "";
		BufferedReader in = null;
		try
		{
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet())
			{
				logger.info("{}{}", key, map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
		} catch (Exception e)
		{
			logger.error("发送GET请求出现异常:{0}", e.getMessage());
		}
		// 使用finally块来关闭输入流
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			} catch (Exception e2)
			{
				logger.error("关闭流出现异常:{0}", e2.getMessage());
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param)
	{
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try
		{
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
		} catch (Exception e)
		{
			logger.error("发送POST请求出现异常:{0}", e.getMessage());
		}
		// 使用finally块来关闭输出流、输入流
		finally
		{
			try
			{
				if (out != null)
				{
					out.close();
				}
				if (in != null)
				{
					in.close();
				}
			} catch (IOException ex)
			{
				logger.error("关闭流出现异常:{0}", ex.getMessage());
			}
		}
		return result;
	}
	
	/**
	 * 获取POST请求提交的参数
	 * 
	 * @param param
	 *            request
	 * @return String 返回的内容
	 */
	public static String getPostValue(HttpServletRequest request)
	{
		byte[] data = null;
		ServletInputStream is = null;
		try
		{
			request.setCharacterEncoding("utf-8");
			is = request.getInputStream();
			int size = request.getContentLength(); // 取HTTP请求流长度
			if (size == -1)
			{

			} else
			{
				data = new byte[size];
				int length = 0;
				int lengthTemp = 0;
				while (-1 != (lengthTemp = is.read(data, length, size - length)))
				{
					length += lengthTemp;
					if (length >= size)
					{
						break;
					}
				}
			}
			return data != null ? new String(data, "UTF-8") : null;
		} catch (IOException e)
		{
			
		}finally{
			try
			{
				if(is != null)
				is.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
