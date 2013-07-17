package com.aps.servlet;
/**
 * ·Ö¹«Ë¾
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.servlet.methods.LoginServlet;

public class Branch extends HttpServlet {

	public void destroy() {
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int type = Integer.parseInt(request.getParameter("type"));
		switch (type) {
		case 1:
			LoginServlet.doGetPwdToEmail(request,response);
			break;

		default:
			break;
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
	}

}
