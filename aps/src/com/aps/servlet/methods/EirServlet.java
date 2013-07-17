package com.aps.servlet.methods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.EirDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Eirs;

/**
 * 交接单管理
 * @author Administrator
 *
 */
public class EirServlet {

	@SuppressWarnings("unused")
	private static EirDAO empDAO = new EirDAO();
	
	
	/**
	 * 查询所有的订单并以分页方式显示
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelectOnPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FenPage page = new FenPage();
		page.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("almodel", empDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/eir/eir_list.jsp").forward(request, response);
	}

	
}
