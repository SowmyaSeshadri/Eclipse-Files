package com.zilker.complaintmanagsystem.delegator;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.beanclasses.Team;
import com.zilker.complaintmanagsystem.constants.Constants;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;

public class AdminDelegator {
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);

	public static ArrayList<ComplaintInfo> viewAllAdmin() throws SQLException {
		DataAcessObject dao = new DataAcessObject();
		ArrayList<ComplaintInfo> complaints = new ArrayList<>();
		try {
			complaints = dao.getAllComplaints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complaints;
	}

	public static ComplaintInfo compById(String compType) {
		ComplaintInfo complaint = new ComplaintInfo();
		DataAcessObject dao = new DataAcessObject();
		try {
			complaint = dao.getPerComplaintDetails(compType);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(complaint != null)
		return complaint;
		else
			return null;
	}

	public static void addTeamAdmin(Team team) {
		DataAcessObject dao = new DataAcessObject();
		try {
			dao.addTeam(team);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<ComplaintInfo> viewPendingAdmin() {
		DataAcessObject dao = new DataAcessObject();
		ArrayList<ComplaintInfo> complaints = new ArrayList<ComplaintInfo>();
		try {
			complaints = dao.showPending();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complaints;
	}

}
