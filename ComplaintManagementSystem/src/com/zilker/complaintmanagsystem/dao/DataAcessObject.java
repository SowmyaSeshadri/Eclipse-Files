package com.zilker.complaintmanagsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.zilker.complaintmanagsystem.beanclasses.ComplaintInfo;
import com.zilker.complaintmanagsystem.constants.Constants;
import com.zilker.complaintmanagsystem.constants.DatabaseConstants;
import com.zilker.complaintmanagsystem.database.DatabaseConnection;
import com.zilker.complaintmanagsystem.utilityfunctions.UtilityFunctions;

public class DataAcessObject {

	static Scanner scanner = new Scanner(System.in);
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);

	// User View
	public static void userLogin() throws SQLException {
		logger.info(Constants.MAILPWD);
		String emailLogn = scanner.next();
		String password = scanner.next();
		int custId = Operation.loginExist(emailLogn, password);
		int option;
		do {
			logger.info(Constants.USEROPTION);
			option = scanner.nextInt();

			if (option == 1) {
				Connection con = DatabaseConnection.loadDriver();
				String query;
				PreparedStatement preparedStatement = null;
				ResultSet rs1 = null;
				try {
					query = DatabaseConstants.USERQUERY;
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, emailLogn);
					preparedStatement.setString(2, password);
					rs1 = preparedStatement.executeQuery();
					UtilityFunctions.viewComplaint(rs1);
				} catch (Exception e) {
					logger.info(e.toString());
				} finally {
					DatabaseConnection.closeCon(rs1, preparedStatement, con);
				}
			}
			if (option == 2) {
				logger.info(Constants.COMPOPTION);
				int complaintId = scanner.nextInt();
				Connection con = DatabaseConnection.loadDriver();
				String query;
				PreparedStatement preparedStatement = null;
				ComplaintInfo customer;
				customer = Operation.insertDetails(custId, complaintId);
				ResultSet rs = null;
				try {
					query = DatabaseConstants.INSERTCOMP;
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setInt(1, customer.getCustId());
					preparedStatement.setString(2, customer.getCompTitle());
					preparedStatement.setString(3, customer.getCompDesc());
					preparedStatement.setInt(4, customer.getCompTypeId());
					preparedStatement.setInt(5, customer.getProd_id());
					preparedStatement.executeUpdate();
					logger.info(Constants.ADDEDCOMP);
				} catch (Exception e) {
					logger.info(e.toString());
				} finally {
					DatabaseConnection.closeCon(rs, preparedStatement, con);
				}
			}
			if (option == 3) {
				logger.info(Constants.ENTERCOMP);
				int compId = scanner.nextInt();
				Connection con = DatabaseConnection.loadDriver();
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = null;
				try {
					String query;
					query = DatabaseConstants.COMP;
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setInt(1, compId);
					preparedStatement.setString(2, emailLogn);
					resultSet = preparedStatement.executeQuery();
					UtilityFunctions.viewComplaint(resultSet);
				} catch (Exception e) {
					logger.info(e.toString());
				} finally {
					DatabaseConnection.closeCon(resultSet, preparedStatement, con);
				}
			}
		} while ((option != 0));

	}

	// ADMIN VIEW
	public static void adminView() throws SQLException {
		Operation.checkAdmin();
		logger.info(Constants.ADMINSIGNIN);
		int option = 0;
		logger.info(Constants.ADMINOPTIONS);
		option = scanner.nextInt();

		switch (option) {
		case 1: {
			ResultSet rs = null;
			Connection con = DatabaseConnection.loadDriver();
			PreparedStatement preparedStatement = null;
			try {
				String query = DatabaseConstants.COMPLAINTINFO;
				preparedStatement = con.prepareStatement(query);
				rs = preparedStatement.executeQuery();
				UtilityFunctions.viewComplaint(rs);
			} catch (Exception e) {
				logger.info(e.toString());
			} finally {
				DatabaseConnection.closeCon(rs, preparedStatement, con);
			}

			break;
		}
		case 2: {
			logger.info(Constants.COMPLAINTID);
			int compId = 0;
			compId = scanner.nextInt();
			ResultSet rs = null;
			Connection con = DatabaseConnection.loadDriver();
			String query = DatabaseConstants.COMPIDINFO;
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, compId);
				rs = preparedStatement.executeQuery();
				UtilityFunctions.viewComplaint(rs);
			} catch (Exception e) {
				logger.info(e.toString());
			} finally {
				DatabaseConnection.closeCon(rs, preparedStatement, con);
			}
			break;
		}
		case 3: {
			logger.info(Constants.TEAMID);
			int teamId = scanner.nextInt();
			logger.info(Constants.NEWTEAM);
			String teamName = scanner.next();
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
			break;
		}
		case 4: {
			logger.info(Constants.COMPTYPEID);
			int compId = scanner.nextInt();
			logger.info(Constants.COMPTYPE);
			String compName = scanner.next();
			Connection con = DatabaseConnection.loadDriver();
			String query = DatabaseConstants.COMPTYPEINSERTQUERY;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			try {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, compId);
				preparedStatement.setString(2, compName);
				preparedStatement.executeUpdate();
				logger.info(Constants.ADDEDCOMPTYPE);
			} catch (Exception e) {
				logger.info(e.toString());
			} finally {
				DatabaseConnection.closeCon(rs, preparedStatement, con);
			}
			break;
		}
		case 5: {
			ResultSet rs = null;
			Connection con = DatabaseConnection.loadDriver();
			String query = DatabaseConstants.STATUSQUERY;
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = con.prepareStatement(query);
				String status = Constants.PENDING;
				preparedStatement.setString(1, status);
				rs = preparedStatement.executeQuery();
				UtilityFunctions.viewComplaint(rs);

			} catch (Exception e) {
				logger.info(e.toString());
			} finally {
				DatabaseConnection.closeCon(rs, preparedStatement, con);
			}
			break;
		}
		case 6: {
			logger.info(Constants.TEAMID);
			int teamId = scanner.nextInt();
			logger.info(Constants.ENTERSTATUS);
			String status = scanner.next();
			ResultSet rs = null;
			Connection con = DatabaseConnection.loadDriver();
			String query = DatabaseConstants.STATUSTEAMQUERY;
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, teamId);
				preparedStatement.setString(2, status);
				rs = preparedStatement.executeQuery();
				UtilityFunctions.viewComplaint(rs);
			} catch (Exception e) {
				logger.info(e.toString());
			} finally {
				DatabaseConnection.closeCon(rs, preparedStatement, con);
			}
			break;
		}
		}
	}

	// TEAM VIEW
	public static void teamView() throws SQLException {
		logger.info(Constants.TEAMVIEWOPTION);
		int teamId = 0;
		teamId = scanner.nextInt();
		if (teamId == 1) {
			logger.info(Constants.SUBTEAMOPTION);
			int option = scanner.nextInt();
			if (option == 1) {
				int compId = 1, compId1 = 3;
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
				} finally {
					DatabaseConnection.closeCon(rs, preparedStatement, con);
				}
			}

			if (option == 2) {
				Connection con = DatabaseConnection.loadDriver();
				logger.info(Constants.COMPIDSTATUS);
				int compId = scanner.nextInt();
				logger.info(Constants.ENTERSTATUS);
				String status = scanner.next();
				String query = DatabaseConstants.UPDATESTATUSQUERY;
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
				try {
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, status);
					preparedStatement.setInt(2, teamId);
					preparedStatement.setInt(3, compId);
					preparedStatement.executeUpdate();
					logger.info(Constants.STATUSUPDATED);
				} catch (Exception e) {
					logger.info(e.toString());
				} finally {
					DatabaseConnection.closeCon(rs, preparedStatement, con);
				}
			}
		} else if (teamId == 2) {
			logger.info(Constants.SUBTEAMOPTION);
			int option = scanner.nextInt();
			if (option == 1) {
				int compId = 2;
				Connection con = DatabaseConnection.loadDriver();
				String query = DatabaseConstants.TEAMVIEWQUERY1;
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
				try {
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setInt(1, compId);
					rs = preparedStatement.executeQuery();
					UtilityFunctions.viewComplaint(rs);
				} catch (Exception e) {
					logger.info(e.toString());
				} finally {
					DatabaseConnection.closeCon(rs, preparedStatement, con);
				}
			}

			if (option == 2) {
				Connection con = DatabaseConnection.loadDriver();
				logger.info(Constants.COMPIDSTATUS);
				int compId = scanner.nextInt();
				logger.info(Constants.ENTERSTATUS);
				String status = scanner.next();
				String query = DatabaseConstants.UPDATESTATUSQUERY;
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
				try {
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, status);
					preparedStatement.setInt(2, teamId);
					preparedStatement.setInt(3, compId);
					preparedStatement.executeUpdate();
					logger.info(Constants.STATUSUPDATED);
				} catch (Exception e) {
					logger.info(e.toString());
				} finally {
					DatabaseConnection.closeCon(rs, preparedStatement, con);
				}
			}
		}

	}

}
