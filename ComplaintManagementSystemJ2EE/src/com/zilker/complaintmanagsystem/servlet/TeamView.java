package com.zilker.complaintmanagsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;
import com.zilker.complaintmanagsystem.delegator.TeamDelegator;

/**
 * Servlet implementation class TeamView
 */
@WebServlet("/TeamView")
public class TeamView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeamView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		ArrayList<ComplaintInfo> complaints = new ArrayList<>();
		complaints = TeamDelegator.teamView();
		request.setAttribute("complaintsForTeam", complaints);
		
		RequestDispatcher rd = request.getRequestDispatcher("JSP/TeamView.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
