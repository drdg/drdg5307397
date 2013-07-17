package com.aps.servlet.methods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.DpointDAO;
import com.aps.db.dao.itfc.imp.RouteDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model._Dpoint;

public class DpointServlet {

	/**
	 * 增加配送点
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doAddRoute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		_Dpoint dpoint = new _Dpoint();
		dpoint.setDpname(request.getParameter("dpname"));
		dpoint.setDppro(request.getParameter("tid1")+request.getParameter("tid2")+request.getParameter("tid3"));
		dpoint.setDpaddress(request.getParameter("dpaddress"));
		dpoint.setDptel(request.getParameter("dptel"));
		dpoint.setDpemail(request.getParameter("dpemail"));
		dpoint.setDpnote(request.getParameter("dpnote"));
		dpoint.setDpname(request.getParameter("dpname"));
		
		DpointDAO dpointDAO = new DpointDAO();
		
		if(dpointDAO.doInster(dpoint)){
			System.out.println("insert ok");
			doListRoute(request,response);
		}else{
			System.out.println("insert error");
		}
		
	}
	
	/**
	 * 查看配送点
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * 1*8-9+9+/899
	 */
	public static void doListRoute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DpointDAO modelDAO = new DpointDAO();
		request.setAttribute("almodel", modelDAO.doSelect());
		request.getRequestDispatcher("ZzCorporation/dpoint/dpoint_list.jsp").forward(request, response);
	}

	/**
	 * 执行分页
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doPageRoute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DpointDAO model = new DpointDAO();
		FenPage fpage = new FenPage();
		fpage.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("almodel", model.doSelectPage(fpage));
		request.getRequestDispatcher("ZzCorporation/dpoint/dpoint_list.jsp").forward(request, response);
	}

	/**
	 * 视图详情查看
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doV_empDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DpointDAO model = new DpointDAO();
		FenPage fpage = new FenPage();
		fpage.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("almodel", model.doSelectDetail(fpage));
		request.getRequestDispatcher("ZzCorporation/dpoint/dpoint_empdetail.jsp").forward(request, response);
	}

	
}
