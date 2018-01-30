package com.zilker.complaintmanagsystem.delegator;

import java.sql.SQLException;
import java.util.ArrayList;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.beanclasses.CustomerInfo;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;

public class UserDelegator {

	public static ArrayList<ComplaintInfo> viewAll(String email){
		  
	        DataAcessObject dao = new DataAcessObject();
	        ArrayList<ComplaintInfo> userComplaints = new ArrayList<>();
	        try {
				userComplaints = dao.getComplaints(email);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userComplaints;
	}
	
	public static void raiseComplaint(String compDesc, int compTypeId, String email, int prodId) {
		DataAcessObject dao = new DataAcessObject();
		ComplaintInfo complaint = new ComplaintInfo();
		try {
			int custId = dao.getCustId(email);
			complaint.setCompDesc(compDesc);
			complaint.setCustId(custId);
			complaint.setCompTypeId(compTypeId);
			complaint.setProdId(prodId);
			int teamId = dao.getTeamId(compTypeId);
			complaint.setTeamId(teamId);
			dao.raiseComplaint(complaint);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static CustomerInfo joinUser (String email, String firstName,String lastName, String password) {
		CustomerInfo customer = new CustomerInfo();
		customer.setEmail(email);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPwd(password);
		DataAcessObject dao = new DataAcessObject();
		
		try {
			dao.userSignUp(customer);
			//response.getWriter().append("Signed up successfully!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return customer;
}

	public static boolean validate(String firstName, String lastName, String email) {
			String names ="^[A-Za-z]+$";
			String phoneNumber = "^[0-9]{10}";
			String emailVal = "[a-zA-Z]\\w+@[a-z]+\\.[a-zA-Z.-]+";
			if(!firstName.matches(names) || !lastName.matches(names) || !email.matches(emailVal))
				return false;
			else
				return true;
	}
}
