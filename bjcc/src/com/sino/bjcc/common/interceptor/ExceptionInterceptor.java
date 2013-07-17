package com.sino.bjcc.common.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sino.bjcc.common.utility.LogUtil;

@SuppressWarnings("serial")
public class ExceptionInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		String actionResult = null;
		
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			request.getQueryString();
			
			actionResult = invocation.invoke();
		}catch(Exception ex){
			actionResult="error";
			ex.printStackTrace();
			LogUtil.createInstance(invocation.getAction()).error(ex.getMessage(),ex);
		}
		
		return actionResult;
	}

}
