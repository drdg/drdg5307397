package com.aps.servlet.methods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.SparameterDAO;
import com.aps.db.model._Sparameter;

/**
 * 系统参数设置
 * @author Administrator
 *
 */
public class SparameterServlet {

	@SuppressWarnings("unused")
	private static SparameterDAO sparameterDAO = new SparameterDAO();
	
	public static void doAddSparameter(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		_Sparameter sparameter = new _Sparameter();
		sparameter.setSpinto(request.getParameter("spinto"));
		sparameter.setSpof(request.getParameter("spof"));
		sparameter.setSpdeletetime(request.getParameter("spdeletetime"));
		sparameter.setSpfirstkg(request.getParameter("spfirstkg"));
		sparameter.setSpfirstvo(request.getParameter("spfirstvo"));
		
		if(sparameterDAO.doInster(sparameter)){
			System.out.println("系统参数数据插入成功");
			response.getWriter().print("数据插入成功！<a href='http://localhost:8088/aps/ZzCorporation/index.jsp' target='_parent'>爱配送首页</a>");
		}else{
			System.out.println("系统参数数据插入失败");
		}
		
	}

	
	
}
