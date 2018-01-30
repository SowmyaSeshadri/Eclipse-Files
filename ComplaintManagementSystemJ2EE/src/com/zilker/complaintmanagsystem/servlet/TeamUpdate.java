package com.zilker.complaintmanagsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.complaintmanagsystem.dao.DataAcessObject;
import com.zilker.complaintmanagsystem.delegator.TeamDelegator;

/**
 * Servlet implementation class TeamUpdate
 */
@WebServlet("/TeamUpdate")
public class TeamUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int compId =Integer.parseInt(request.getParameter("compId"));
		String compStatus = request.getParameter("compStatus");
		
		TeamDelegator.teamUpdateStatus(compId, compStatus);
		
		RequestDispatcher rd = request.getRequestDispatcher("JSP/team.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
