package com.zilker.complaintmanagsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.lang.Exception;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.constants.Constants;
import com.zilker.complaintmanagsystem.constants.DatabaseConstants;
import com.zilker.complaintmanagsystem.database.*;

public class Operation {
	static Scanner scanner = new Scanner(System.in);
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);

	public static boolean loginExist(String email, String pwd) throws SQLException {
		Connection con = DatabaseConnection.loadDriver();
		String query = DatabaseConstants.USERLOGIN;
		PreparedStatement preparedStatement = con.prepareStatement(query);
		int flag = 0;
		ResultSet rs = null;
		try {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, pwd);
			rs = preparedStatement.executeQuery();
			if (rs.next())
				if (rs.next() || rs.previous()) {
					logger.info(Constants.SIGNEDIN);
					flag = 1;
				}
				else
					flag = 0;
		} catch (Exception e) {
			logger.info(e.toString());
		} finally {
			DatabaseConnection.closeCon(rs, preparedStatement, con);
		}
		if(flag == 1)
			return true;
		else
			return false;
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

	public static ComplaintInfo insertDetails(int custId, int compTypeId) {
		logger.info(Constants.ENTERPROD);
		int prodId = scanner.nextInt();
		logger.info(Constants.COMPTITLE);
		String compTitle = scanner.next();
		scanner.next();
		logger.info(Constants.DESC);
		String compDesc = scanner.next();
		ComplaintInfo customer = new ComplaintInfo(prodId, compTitle, compDesc, custId, compTypeId);
		customer.setProdId(prodId);
		customer.setCompTitle(compTitle);
		customer.setCompDesc(compDesc);
		customer.setCustId(custId);
		customer.setCompTypeId(compTypeId);
		return customer;

	}

	// Admin view
	public static boolean checkAdmin(String adminEmail, String adminPwd) {
		if (adminEmail.matches("admin@gmail.com") && adminPwd.matches("admin")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkTeam(String teamEmail, String teamPwd) {
		if (teamEmail.matches("teamdefective@gmail.com") && teamPwd.matches("teamdef")) {
			return true;
		} else {
			return false;
		}
	}


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
			DataAcessObject.viewComplaint(rs);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

}
