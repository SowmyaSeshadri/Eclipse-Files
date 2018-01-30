package com.zilker.complaintmanagsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;
import com.zilker.complaintmanagsystem.delegator.UserDelegator;


/**
 * Servlet implementation class RaiseComplaint
 */
@WebServlet("/RaiseComplaint")
public class RaiseComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RaiseComplaint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String compDesc = request.getParameter("desc");
		int compTypeId = Integer.parseInt(request.getParameter("radio"));
		int prodId = Integer.parseInt(request.getParameter("radioProduct"));
		String email = (String) request.getSession().getAttribute("email");
	
		UserDelegator.raiseComplaint(compDesc, compTypeId, email, prodId);

		RequestDispatcher rd = request.getRequestDispatcher("JSP/raisecomplaint.jsp");
		rd.include(request, response);
	}

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
