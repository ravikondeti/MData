package org.servlets.learning;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServelet
 */
@WebServlet(description = "My First Servlet", urlPatterns = { "/FirstServelet" })
public class FirstServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userName =request.getParameter("UserName");
		PrintWriter out = response.getWriter();
		out.print("My First Servlet Executed!" + userName);
		System.out.println("First Servlet Execute");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String userName =request.getParameter("UserName");
		PrintWriter out = response.getWriter();
		out.print("My First Servlet Executed from post method!" + userName);
		System.out.println("First Servlet Execute");
	}

}
