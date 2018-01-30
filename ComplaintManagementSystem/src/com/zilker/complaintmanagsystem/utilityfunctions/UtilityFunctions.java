package com.zilker.complaintmanagsystem.utilityfunctions;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.zilker.complaintmanagsystem.beanclasses.CustomerInfo;
import com.zilker.complaintmanagsystem.constants.Constants;

public class UtilityFunctions {
	static Scanner scanner = new Scanner(System.in);
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);


	

	public static void viewComplaint(ResultSet rs) throws SQLException {
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		try {
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					for (int i = 1; i <= columnsNumber; i++) {
						String name = rsmd.getColumnName(i);
						logger.info(name + ": " + rs.getString(i) + " ");
					}
					logger.info(Constants.DOTS);
				}
			} else {
				logger.info(Constants.NOCOMP);
			}
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	public static CustomerInfo getNewUserDetails() {
		logger.info(Constants.FIRSTNAME);
		String firstName = scanner.next();
		logger.info(Constants.LASTNAME);
		String lastName = scanner.next();
		logger.info(Constants.EMAIL);
		String email = scanner.next();
		logger.info(Constants.PWD);
		String pwd = scanner.next();
		CustomerInfo customer1 = new CustomerInfo(firstName, lastName, email, pwd);
		customer1.setEmail(email);
		customer1.setFirstName(firstName);
		customer1.setLastName(lastName);
		customer1.setPwd(pwd);
		return customer1;

	}

}
