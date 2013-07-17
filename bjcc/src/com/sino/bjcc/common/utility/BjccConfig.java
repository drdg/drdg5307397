package com.sino.bjcc.common.utility;

import javax.servlet.http.HttpServletRequest;

public class BjccConfig {

	public static String realPath = null;
	
	public static void setRealPath(HttpServletRequest request){
		if(null != realPath){
			return;
		}
		realPath = request.getSession().getServletContext().getRealPath("/");
	}
	
}
