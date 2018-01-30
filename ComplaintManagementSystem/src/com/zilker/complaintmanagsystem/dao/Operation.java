package com.zilker.complaintmanagsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.lang.Exception;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.beanclasses.CustomerInfo;
import com.zilker.complaintmanagsystem.constants.Constants;
import com.zilker.complaintmanagsystem.constants.DatabaseConstants;
import com.zilker.complaintmanagsystem.database.*;
import com.zilker.complaintmanagsystem.utilityfunctions.UtilityFunctions;

public class Operation {
	static Scanner scanner = new Scanner(System.in);
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);

	public static int loginExist(String email, String pwd) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.USERLOGIN;
		PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet rs = null;
		int custId = 0;
		try {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, pwd);
			rs = preparedStatement.executeQuery();
			if (rs.next())
				if (rs.next() || rs.previous()) {
					logger.info(Constants.SIGNEDIN);
				} else {
					logger.info(Constants.SIGNINPROMT);
					int option = 0;
					option = scanner.nextInt();
					if (option == 1) {
						Operation.userSignUp();
					}
				}

			custId = rs.getInt(1);

		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		return custId;
	}

	public static ResultSet viewCompById(int compId, String email) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			String query;
			query = DatabaseConstants.COMP;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, compId);
			preparedStatement.setString(2, email);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return null;
	}

	public static ResultSet complaintHistory(String email, String password) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query;
		PreparedStatement preparedStatement;
		ResultSet rs1 = null;
		try {
			query = DatabaseConstants.USERQUERY;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			rs1 = preparedStatement.executeQuery();
			return rs1;
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return null;
	}
//
//	public static void raiseComplaint(int custId, int compId) throws SQLException {
//		Connection con = DatabaseConnection.loadDriver();
//		String query;
//		PreparedStatement preparedStatement;
//		ComplaintInfo customer;
//		customer = insertDetails(custId, compId);
//		try {
//			query = DatabaseConstants.INSERTCOMP;
//			preparedStatement = con.prepareStatement(query);
//			preparedStatement.setInt(1, customer.getCustId());
//			preparedStatement.setString(2, customer.getCompTitle());
//			preparedStatement.setString(3, customer.getCompDesc());
//			preparedStatement.setInt(4, customer.getCompTypeId());
//			preparedStatement.setInt(5, customer.getProd_id());
//			preparedStatement.executeUpdate();
//			logger.info(Constants.ADDEDCOMP);
//		} catch (Exception e) {
//			logger.info(e.toString());
//		}
//	}

	public static ComplaintInfo insertDetails(int custId, int compTypeId) {
		logger.info(Constants.ENTERPROD);
		int prodId = scanner.nextInt();
		logger.info(Constants.COMPTITLE);
		String compTitle = scanner.next();
		scanner.next();
		logger.info(Constants.DESC);
		String compDesc = scanner.next();
		ComplaintInfo customer = new ComplaintInfo(prodId, compTitle, compDesc, custId, compTypeId);
		customer.setProd_id(prodId);
		customer.setCompTitle(compTitle);
		customer.setCompDesc(compDesc);
		customer.setCustId(custId);
		customer.setCompTypeId(compTypeId);
		return customer;

	}

	public static void userSignUp() throws SQLException {
		CustomerInfo customer1 = UtilityFunctions.getNewUserDetails();
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
			logger.info(Constants.CREATEDSUC);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	// Admin view
	public static boolean checkAdmin() {
		logger.info(Constants.ADMINPWD);
		String admin = scanner.next();
		if (admin.matches("admin")) {
			return true;
		} else {
			logger.info(Constants.WRONPWD);
			System.exit(0);
			return false;
		}
	}

//	public static ResultSet adminComplaintHistory() throws SQLException {
//		Connection con = DatabaseConnection.loadDriver();
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//		try {
//			String query = DatabaseConstants.COMPLAINTINFO;
//			preparedStatement = con.prepareStatement(query);
//			rs = preparedStatement.executeQuery();
//		} catch (Exception e) {
//			logger.info(e.toString());
//		}
//		return rs;
//	}

	public static ResultSet viewAllCompByIdAdmin(int compId) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.COMPIDINFO;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, compId);
			rs = preparedStatement.executeQuery();
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return rs;
	}

	public static void addTeam(int teamId, String teamName) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.TEAMQUERY;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, teamId);
			preparedStatement.setString(2, teamName);
			preparedStatement.executeUpdate();
			logger.info(Constants.ADDEDTEAM);
		} catch (Exception e) {
			logger.info(e.toString());
		}

	}

//	public static void addCompType(int compId, String compName) throws SQLException {
//		Connection con = DatabaseConnection.loadDriver();
//		String query = DatabaseConstants.COMPTYPEINSERTQUERY;
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = con.prepareStatement(query);
//			preparedStatement.setInt(1, compId);
//			preparedStatement.setString(2, compName);
//			preparedStatement.executeUpdate();
//			logger.info(Constants.ADDEDCOMPTYPE);
//		} catch (Exception e) {
//			logger.info(e.toString());
//		}
//	}

//	public static ResultSet pendingComp() throws SQLException {
//		Connection con = DatabaseConnection.loadDriver();
//		String query = DatabaseConstants.STATUSQUERY;
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//		try {
//			preparedStatement = con.prepareStatement(query);
//			String status = Constants.PENDING;
//			preparedStatement.setString(1, status);
//			rs = preparedStatement.executeQuery();
//			
//		} catch (Exception e) {
//			logger.info(e.toString());
//		}
//		return rs;
//	}

	public static ResultSet pendingPerTeam(int teamId, String status) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.STATUSTEAMQUERY;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, teamId);
			preparedStatement.setString(2, status);
			rs = preparedStatement.executeQuery();
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return rs;

	}

	public static void teamViewAllComp(int compId, int compId1) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.TEAMVIEWQUERY;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, compId);
			preparedStatement.setInt(2, compId1);
			rs = preparedStatement.executeQuery();
			UtilityFunctions.viewComplaint(rs);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

//	public static void teamViewAllComp(int compId) throws SQLException {
//		Connection con = DatabaseConnection.loadDriver();
//		String query = DatabaseConstants.TEAMVIEWQUERY1;
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//		try {
//			preparedStatement = con.prepareStatement(query);
//			preparedStatement.setInt(1, compId);
//			rs = preparedStatement.executeQuery();
//			UtilityFunctions.viewComplaint(rs);
//		} catch (Exception e) {
//			logger.info(e.toString());
//		}
//
//	}

//	public static void teamStatusUpdate(int teamId) throws SQLException {
//		Connection con = DatabaseConnection.loadDriver();
//		logger.info(Constants.COMPIDSTATUS);
//		int compId = scanner.nextInt();
//		logger.info(Constants.ENTERSTATUS);
//		String status = scanner.next();
//		String query = DatabaseConstants.UPDATESTATUSQUERY;
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = con.prepareStatement(query);
//			preparedStatement.setString(1, status);
//			preparedStatement.setInt(2, teamId);
//			preparedStatement.setInt(3, compId);
//			preparedStatement.executeUpdate();
//			logger.info(Constants.STATUSUPDATED);
//		} catch (Exception e) {
//			logger.info(e.toString());
//		}
//	}

}
