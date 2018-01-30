package com.zilker.complaintmanagsystem.delegator;

import java.sql.SQLException;
import java.util.ArrayList;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;

public class TeamDelegator {
	
	public static void teamUpdateStatus(int compId, String compStatus) {
		DataAcessObject dao = new DataAcessObject();
		try {
			dao.statusUpdate(compId, compStatus);
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static ArrayList<ComplaintInfo> teamView(){
		DataAcessObject dao = new DataAcessObject();
		ArrayList<ComplaintInfo> complaints = new ArrayList<>();
		try {
			complaints = dao.getAllComplaintsTeam();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return complaints;
	}
	
	public static ArrayList<ComplaintInfo> teamViewPending(){
		DataAcessObject dao = new DataAcessObject();
		ArrayList<ComplaintInfo> complaints = new ArrayList<ComplaintInfo>();
		try {
			complaints = dao.teamShowPending();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complaints;
	}
}
