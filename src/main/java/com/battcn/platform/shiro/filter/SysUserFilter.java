package com.battcn.platform.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

public class SysUserFilter extends PathMatchingFilter
{

	//@Autowired
	//private UserService userService;

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception
	{
		/*String accountName = (String) SecurityUtils.getSubject().getPrincipal();
		if (StringUtils.isNoneEmpty(accountName))
		{
			request.setAttribute("user", userService.findByLoginName(accountName));
		}*/
		return true;
	}
}