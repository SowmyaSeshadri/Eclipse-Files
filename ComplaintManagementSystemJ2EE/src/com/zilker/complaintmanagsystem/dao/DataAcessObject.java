package com.zilker.complaintmanagsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.beanclasses.CustomerInfo;
import com.zilker.complaintmanagsystem.beanclasses.Team;
import com.zilker.complaintmanagsystem.constants.Constants;
import com.zilker.complaintmanagsystem.constants.DatabaseConstants;
import com.zilker.complaintmanagsystem.database.DatabaseConnection;

public class DataAcessObject {

	static Scanner scanner = new Scanner(System.in);
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);

	public ArrayList<ComplaintInfo> getComplaints(String emailLogn) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query;
		PreparedStatement preparedStatement = null;
		ResultSet rs1 = null;
		ArrayList<ComplaintInfo> arrayOfComplaints = new ArrayList<>();
		try {
			query = DatabaseConstants.USERQUERY;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, emailLogn);
			rs1 = preparedStatement.executeQuery();
			arrayOfComplaints = viewComplaint(rs1);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs1, preparedStatement, con);
		}
		return arrayOfComplaints;
	}

	public ArrayList<ComplaintInfo> getAllComplaints() throws SQLException {
		ResultSet rs = null;
		Connection con = DatabaseConnection.loadDriver();
		PreparedStatement preparedStatement = null;
		ArrayList<ComplaintInfo> arrayOfComplaints = new ArrayList<>();
		try {
			String query = DatabaseConstants.COMPLAINTINFO;
			preparedStatement = con.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			arrayOfComplaints = viewComplaintAdmin(rs);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		System.out.println(arrayOfComplaints);
		return arrayOfComplaints;
	}
	

	public static ArrayList<ComplaintInfo> viewComplaintAdmin(ResultSet rs) throws SQLException {
		ArrayList<ComplaintInfo> compInfoArray = new ArrayList<>();
		try {
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					ComplaintInfo compInfo=new ComplaintInfo();
					int compId;
					int custId;
					String compDesc;
					int prod_id;
					int compType_id;
					String date ;
					int teamId;
					String compStatus;
					
					compId = rs.getInt(1);
					custId = rs.getInt(2);
					compDesc = rs.getString(4);
					compType_id = rs.getInt(5);
					prod_id = rs.getInt(6);
					date = rs.getString(7);
					compStatus = rs.getString(8);
					teamId = rs.getInt(9);
					
					compInfo.setTeamId(teamId);
					compInfo.setCompId(compId);
					compInfo.setCustId(custId);
					compInfo.setCompDesc(compDesc);
					compInfo.setCompStatus(compStatus);
					compInfo.setCompTypeId(compType_id);
					compInfo.setProdId(prod_id);
					compInfo.setDate(date);
					logger.info(Constants.DOTS);
					compInfoArray.add(compInfo);
				}
			} else {
				logger.info(Constants.NOCOMP);
			}
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return compInfoArray;
	}

	public static ArrayList<ComplaintInfo> viewComplaint(ResultSet rs) throws SQLException {
		ArrayList<ComplaintInfo> compInfoArray = new ArrayList<>();
		try {
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					ComplaintInfo compInfo=new ComplaintInfo();
					int compId;
					String compDesc;
					int prod_id;
					String date ;
					String compStatus;
					compId = rs.getInt(1);
					compDesc = rs.getString(2);
					prod_id = rs.getInt(3);
					date = rs.getString(4);
					compStatus = rs.getString(5);
					compInfo.setCompId(compId);
					compInfo.setCompDesc(compDesc);
					compInfo.setCompStatus(compStatus);
					compInfo.setProdId(prod_id);
					compInfo.setDate(date);
					logger.info(Constants.DOTS);
					compInfoArray.add(compInfo);
				}
			} else {
				logger.info(Constants.NOCOMP);
			}
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return compInfoArray;
	}

	
	public ArrayList<ComplaintInfo> getAllComplaintsTeam() throws SQLException {
		ResultSet rs = null;
		Connection con = DatabaseConnection.loadDriver();
		PreparedStatement preparedStatement = null;
		int teamId = 1;
		ArrayList<ComplaintInfo> arrayOfComplaints = new ArrayList<>();
		try {
			String query = DatabaseConstants.TEAMVIEWQUERY;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, teamId);
			rs = preparedStatement.executeQuery();
			arrayOfComplaints = viewComplaintAdmin(rs);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		System.out.println(arrayOfComplaints);
		return arrayOfComplaints;
	}

	public static void userSignUp(CustomerInfo customer1) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.SIGNUP;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, customer1.getFirstName());
			preparedStatement.setString(2, customer1.getLastName());
			preparedStatement.setString(3, customer1.getEmail());
			preparedStatement.setString(4, customer1.getPwd());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	public static CustomerInfo getCustomerInfo(String email) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = "select firstName,lastName from customerinfo where (email=?)";
		ResultSet rs = null;
		CustomerInfo customerdetails = new CustomerInfo();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);
			rs = preparedStatement.executeQuery();
			rs.next();
			String firstName = rs.getString(1);
			String lastName = rs.getString(2);
			customerdetails.setFirstName(firstName);
			customerdetails.setLastName(lastName);
			System.out.println(firstName + lastName);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return customerdetails;
	}

	public void raiseComplaint(ComplaintInfo complaint) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			query = DatabaseConstants.INSERTCOMP;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, complaint.getCustId());
			preparedStatement.setString(2, complaint.getCompDesc());
			preparedStatement.setInt(3, complaint.getCompTypeId());
			preparedStatement.setInt(4, complaint.getTeamId());
			preparedStatement.setInt(5, complaint.getProdId());
			preparedStatement.executeUpdate();
			logger.info(Constants.ADDEDCOMP);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}

	}

	public int getCustId(String email) throws SQLException {
		int custId = 0;
		Connection con = DatabaseConnection.loadDriver();
		String query;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			query = "Select cust_id from customerinfo where email=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);
			rs = preparedStatement.executeQuery();
			rs.next();
			custId = rs.getInt(1);
			logger.info(Constants.ADDEDCOMP);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		System.out.println(custId);
		return custId;

	}

	public ComplaintInfo getPerComplaintDetails(String compId) throws SQLException {
		ResultSet rs = null;
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.COMPIDINFO;
		PreparedStatement preparedStatement = null;
		ComplaintInfo complaint = new ComplaintInfo();
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, compId);
			rs = preparedStatement.executeQuery();
			complaint = viewComplaintById(rs);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		if(complaint != null)
		return complaint;
		else
			return null;
	}
	
	public static ComplaintInfo viewComplaintById(ResultSet rs) throws SQLException {
		ComplaintInfo complaint = new ComplaintInfo();
		int flag = 0;
		try {
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					int compId;
					String compDesc;
					int prod_id;
					String date ;
					String compStatus;
					compId = rs.getInt(1);
					complaint.setCompId(compId);
					compDesc = rs.getString(4);
					complaint.setCompDesc(compDesc);
					prod_id = rs.getInt(6);
					date = rs.getString(7);
					compStatus = rs.getString(8);
					complaint.setCompStatus(compStatus);
					complaint.setProdId(prod_id);
					complaint.setDate(date);
					logger.info(Constants.DOTS);
					flag = 1;
				}
			} else {
				logger.info(Constants.NOCOMP);
				flag = 0;
			}
		} catch (Exception e) {
			logger.info(e.toString());
		}
		if(flag == 1)
			return complaint;
		else
			return null;
	}

	public void addTeam(Team team) throws SQLException {
		int teamId = team.getTeamId();
		String teamName = team.getTeamName();
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.TEAMQUERY;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, teamId);
			preparedStatement.setString(2, teamName);
			preparedStatement.executeUpdate();
			logger.info(Constants.ADDEDTEAM);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}

	}

	public ArrayList<ComplaintInfo> showPending() throws SQLException {
		ResultSet rs = null;
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.STATUSQUERY;
		PreparedStatement preparedStatement = null;
		ArrayList<ComplaintInfo> complaints = new ArrayList<ComplaintInfo>();
		try {
			preparedStatement = con.prepareStatement(query);
			String status = Constants.PENDING;
			preparedStatement.setString(1, status);
			rs = preparedStatement.executeQuery();
			complaints = pendingComplaint(rs);

		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		System.out.println(complaints);
		return complaints;
	}
	
	public static ArrayList<ComplaintInfo> pendingComplaint(ResultSet rs) throws SQLException {
		ArrayList<ComplaintInfo> comp = new ArrayList<ComplaintInfo>();
		
		try {
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					ComplaintInfo complaint = new ComplaintInfo();
					int compId;
					String compDesc;
					int teamId;
					int prod_id;
					String date;
					compId = rs.getInt(1);
					complaint.setCompId(compId);
					compDesc = rs.getString(3);
					complaint.setCompDesc(compDesc);
					teamId = rs.getInt(2);
					complaint.setTeamId(teamId);
					prod_id = rs.getInt(4);
					complaint.setProdId(prod_id);
					date = rs.getString(5);
					complaint.setDate(date);
					logger.info(Constants.DOTS);
					comp.add(complaint);
				}
			} else {
				logger.info(Constants.NOCOMP);
			}
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return comp;
	}
	
	
	public ArrayList<ComplaintInfo> teamShowPending() throws SQLException {
		ResultSet rs = null;
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.STATUSTEAMQUERY;
		int teamId=1;
		PreparedStatement preparedStatement = null;
		ArrayList<ComplaintInfo> complaints = new ArrayList<ComplaintInfo>();
		try {
			preparedStatement = con.prepareStatement(query);
			String status = Constants.PENDING;
			preparedStatement.setInt(1, teamId);
			preparedStatement.setString(2, status);
			rs = preparedStatement.executeQuery();
			complaints = pendingTeamComplaint(rs);

		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		System.out.println(complaints);
		return complaints;
	}
	
	public static ArrayList<ComplaintInfo> pendingTeamComplaint(ResultSet rs) throws SQLException {
		ArrayList<ComplaintInfo> comp = new ArrayList<ComplaintInfo>();
		
		try {
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					ComplaintInfo complaint = new ComplaintInfo();
					int compId;
					int teamId;
					String date;
					String compDesc;
					int prod_id;
					compId = rs.getInt(1);
					complaint.setCompId(compId);
					date = rs.getString(3);
					complaint.setDate(date);
					teamId = rs.getInt(2);
					complaint.setTeamId(teamId);
					compDesc = rs.getString(4);
					complaint.setCompDesc(compDesc);
					prod_id = rs.getInt(5);
					complaint.setProdId(prod_id);
					logger.info(Constants.DOTS);
					comp.add(complaint);
				}
			} else {
				logger.info(Constants.NOCOMP);
			}
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return comp;
	}

	public int getTeamId(int compType_id) {

		int teamId = 0;

		if (compType_id == 1 || compType_id == 3)
			teamId = 1;
		else if (compType_id == 2)
			teamId = 2;
		else if (compType_id == 4)
			teamId = 3;

		return teamId;

	}
	
	public void statusUpdate(int compId,String compStatus) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.UPDATESTATUSQUERY;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, compStatus);
			preparedStatement.setInt(2, compId);
			preparedStatement.executeUpdate();
			logger.info(Constants.STATUSUPDATED);
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
	}
	
}
