package com.aps.servlet.methods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.AuthorityDAO;
import com.aps.db.dao.itfc.imp.DeaDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model._Authority;
import com.aps.db.model._Dea;

/**
 * 权限数据组装
 * @author Administrator
 *
 */
public class AuthorityServlet {

	/**
	 * 增加权限
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doAddAuthority(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Authority authority = new _Authority();
		authority.setAuno(request.getParameter("auno"));
		authority.setAudesc(request.getParameter("audesc"));
		
		AuthorityDAO authorityDAO = new AuthorityDAO();
		authorityDAO.doInster(authority);
		
		/*增加完权限，跳转到授权页面*/
		doSelectAll(request,response);
	}

	/**
	 * 授权
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doGrantTo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Dea dea = new _Dea();
		dea.setFk_dpid(request.getParameter("fk_dpid"));
		dea.setFk_eid(request.getParameter("fk_eid"));
		dea.setFk_auid(request.getParameter("fk_auid"));
		
		/*操作deaDAO*/
		
		DeaDAO deaDAO = new DeaDAO();
		if(deaDAO.doInster(dea)){
			doSelect(request,response);
		}else{
			System.out.println("授权error");
		}
		
	}
	/**
	 * 查询所有的权限并且给授权页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelectAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		AuthorityDAO authorityDAO = new AuthorityDAO();
		request.setAttribute("almodel", authorityDAO.doSelectGrant());
		request.getRequestDispatcher("ZzCorporation/authority/au_grant.jsp").forward(request, response);
		
	}

	/**
	 * 查询视图：pdlogin得到三个字段配送点、员工、权限
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FenPage page = new FenPage();
		if(null !=request.getParameter("pageNow")){
			page.setPageNow(request.getParameter("pageNow"));
		}else{
			page.setPageNow("1");
		}
		AuthorityDAO authorityDAO = new AuthorityDAO();
		request.setAttribute("almodel", authorityDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/authority/au_list.jsp").forward(request, response);
	}

	
}
