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

import com.sino.bjcc.common.utility.BjccConfig;

public class EncodingFilter implements Filter{

	private final String DEFAULT_ENCODING = "UTF-8";
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//设定请求及相应的编码格式
		request.setCharacterEncoding(DEFAULT_ENCODING);
		response.setCharacterEncoding(DEFAULT_ENCODING);
		BjccConfig.setRealPath(request);
		chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
