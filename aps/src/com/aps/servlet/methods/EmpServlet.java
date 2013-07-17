package com.aps.servlet.methods;
/**
 * 数据组装层
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.EmpDAO;
import com.aps.db.dao.itfc.imp.RouteDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model._Emp;

public class EmpServlet {

	/**
	 * 增加员工
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doAddEmp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Emp emp = new _Emp();
		
		emp.setEname(request.getParameter("ename"));
		emp.setEsex(request.getParameter("esex"));
		emp.setEage(request.getParameter("eage"));
		emp.setEbirthday(request.getParameter("ebirthday"));
		emp.setEpa(request.getParameter("epa"));
		emp.setEaddress(request.getParameter("tid1")+request.getParameter("tid2")+request.getParameter("tid3"));
		emp.setEphone(request.getParameter("ephone"));
		emp.setEemail(request.getParameter("eemail"));
		emp.setEpost(request.getParameter("epost"));
		emp.setEdept(request.getParameter("edept"));
		emp.setEindate(request.getParameter("eindate"));
		emp.setEsal(request.getParameter("esal"));
		emp.setEstate(request.getParameter("estate"));
		emp.setEnote(request.getParameter("enote"));
		
		EmpDAO empDAO = new EmpDAO();
		if(empDAO.doInster(emp)){
			System.out.println("增加员工ok");
			doPageRoute(request,response);
		}else{
			System.out.println("增加员工error");
		}
		
	}
	
	/**
	 * 分页
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doPageRoute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmpDAO modelDAO = new EmpDAO();
		FenPage page = new FenPage();
		page.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("almodel", modelDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/emp/emp_list.jsp").forward(request, response);
	}

	
	
}
