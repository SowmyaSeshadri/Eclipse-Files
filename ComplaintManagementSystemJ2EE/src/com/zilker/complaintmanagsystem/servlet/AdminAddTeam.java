package com.zilker.complaintmanagsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.zilker.complaintmanagsystem.beanclasses.Team;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;
import com.zilker.complaintmanagsystem.delegator.AdminDelegator;

/**
 * Servlet implementation class AdminAddTeam
 */
@WebServlet("/AdminAddTeam")
public class AdminAddTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		String teamName = request.getParameter("teamName");
		
		Team team = new Team();
		team.setTeamId(teamId);
		team.setTeamName(teamName);
		
		AdminDelegator.addTeamAdmin(team);
		
		RequestDispatcher rd = request.getRequestDispatcher("JSP/AddTeam.jsp");
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
