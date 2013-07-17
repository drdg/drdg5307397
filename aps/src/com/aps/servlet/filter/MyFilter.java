package com.aps.servlet.filter;
/**
 * π˝¬À”√
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {


	private String encoding = null;
	private FilterConfig filterConfig = null;
	
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest servletReq, ServletResponse servletRes,
			FilterChain chain) throws IOException, ServletException {
		if(filterConfig!=null){
			servletReq.setCharacterEncoding(encoding);
			servletRes.setContentType("text/html;charset="+encoding);
		}
		chain.doFilter(servletReq, servletRes);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	

}
