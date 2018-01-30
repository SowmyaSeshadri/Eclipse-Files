package com.zilker.complaintmanagsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zilker.complaintmanagsystem.beanclasses.CustomerInfo;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;
import com.zilker.complaintmanagsystem.dao.Operation;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		if(Operation.checkAdmin(email, pwd) == true){
			RequestDispatcher rd = request.getRequestDispatcher("JSP/admin.jsp");
			rd.include(request, response);
		}
		else if(Operation.checkTeam(email, pwd)) {
			RequestDispatcher rd = request.getRequestDispatcher("JSP/team.jsp");
			rd.include(request, response);
		}
		else 
		{
		CustomerInfo customer = new CustomerInfo(email, pwd);
		DataAcessObject dao = new DataAcessObject();
		try {
			boolean valid = Operation.loginExist(customer.getEmail(), customer.getPwd());
			if (valid == true) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				CustomerInfo customerdetails = new CustomerInfo();
				customerdetails = dao.getCustomerInfo(email);
				String firstName = customerdetails.getFirstName();
				String lastName = customerdetails.getLastName();
				session.setAttribute("firstname", firstName);
				session.setAttribute("lastname", lastName);
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/page.jsp");
				rd.include(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
