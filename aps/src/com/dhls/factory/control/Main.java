package com.dhls.factory.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhls.factory.ReadFile;
import com.dhls.factory.downhtml.DownHtml;
import com.dhls.factory.impl.ReadTxt;
import com.dhls.factory.impl.ReplaceHtmlTagImpl;

public class Main {

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void doDownHtml(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DownHtml downHtml = new DownHtml(new ReplaceHtmlTagImpl());
		downHtml.doDownHtml("http://topic.csdn.net/u/20110331/23/f7ae08f2-5824-4162-8949-65e618fa5e82.html?47267");
		request.getRequestDispatcher("ZzCorporation/index.jsp").forward(request, response);
	}

}
