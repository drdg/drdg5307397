package com.sino.bjcc.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sino.bjcc.common.bean.UserInfo;
import com.sino.login.service.IUserInfoService;
import com.sino.system.constant.Constant;
import com.sino.system.constant.util.ConstantUtil;

public class SessionFilter implements Filter {
	
	private String SESSION_KEY_FOR_USER;
	private WebApplicationContext webApplicationContext;
	private IUserInfoService userInfoService;
	private String SSOLoginUrl;
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		if (null == userInfoService) {
			init(req);
		}
//		if(session.getAttribute(SESSION_KEY_FOR_USER) == null  && !"noLogin".equals(req.getParameter("noLogin"))) {
//			if(req.getRequestURI().contains("/loginPersonCenterAction")) {
//				String login_name = getReqParam(req, "userName");
//				String passwd = getReqParam(req, "password");
//				String deptid = getReqParam(req, "currDeptId");
//				
//				if(null != login_name && null != passwd) {
//					try {
//						if(null!=deptid && deptid.equals("-1")) {
//							deptid = null;
//						}
//						UserInfo userinfo= userInfoService.validataUserinfo(login_name, passwd, deptid);
		
//						session.setAttribute(SESSION_KEY_FOR_USER, userinfo);
//						chain.doFilter(req, res);
//					} catch (Exception e) {
//						System.err.println("验证用户登录出错:login_name=" + login_name);
//					}
//				}else{
//					res.sendRedirect(SSOLoginUrl+ "&toUrl="+req.getRequestURL());
//				}
//			}else{
//				res.sendRedirect(SSOLoginUrl+ "&toUrl="+req.getRequestURL());
//			}
//		} else {
//			chain.doFilter(req, res);
//		}
		
		
		if(req.getSession().getAttribute(SESSION_KEY_FOR_USER) == null) {
			// 不过滤登录的url，进行登录的url不进行过滤
			if(req.getRequestURI().contains("/loginPersonCenterAction")) {
				String login_name = getReqParam(req, "userName");
				String passwd = getReqParam(req, "password");
				String deptid = getReqParam(req, "currDeptId");
				
				if(null != login_name && null != passwd) {
					try {
						if(null!=deptid && deptid.equals("-1")) {
							deptid = null;
						}
						UserInfo userinfo= userInfoService.validataUserinfo(login_name, passwd, deptid);
						if(userinfo!=null) {
							session.setAttribute(SESSION_KEY_FOR_USER, userinfo);
							chain.doFilter(req, res);
							//用户验证成功
						}else{
							//记录日志 用户信息出错  验证失败
							//登录失败跳转到  长城网首页
							chain.doFilter(req, res);
						}
					} catch (Exception e) {
						System.err.println("验证用户登录出错:login_name=" + login_name);
						e.printStackTrace();
					}
				}else{
					//记录日志 用户信息出错  验证失败
					//登录失败跳转到  长城网首页
//					res.sendRedirect(SSOLoginUrl+ "&toUrl="+req.getRequestURL());
					chain.doFilter(req, res); 									// 需要修改
				}
			} else {
				chain.doFilter(request, response);
				//放行，到具体action判断session，再决定怎么返回是长城网首页，还是怎么返回
			}
		} else {
			chain.doFilter(request, response);
			//放行
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
		SSOLoginUrl = filterConfig.getInitParameter("SSOLoginUrl");
		webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
		ConstantUtil.initWebApplicationContext(webApplicationContext);
		initBean();
		SESSION_KEY_FOR_USER = Constant.SESSION_KEY_FOR_USER;
	}
	
	public void init(HttpServletRequest req) {
		webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());
		ConstantUtil.initWebApplicationContext(webApplicationContext);
		initBean();
	}
	
	public void initBean() {
		userInfoService = (IUserInfoService) webApplicationContext.getBean("userInfoService");
	}
	
	public String getReqParam(HttpServletRequest req, String key) {
		String value = null;
		value = req.getParameter(key);
		if(null == value || value.equalsIgnoreCase("null")) {
			value = null;
		}
		return value;
	}
}