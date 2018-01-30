package com.zilker.complaintmanagsystem.main;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.zilker.complaintmanagsystem.constants.Constants;
import com.zilker.complaintmanagsystem.dao.DataAcessObject;

public class Application {
	static Scanner scanner = new Scanner(System.in);
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);

	public static void main(String[] args) throws SQLException {
		int choiceOfOption;

		do {
			logger.info(Constants.MAINOPTION);
			choiceOfOption = scanner.nextInt();

			switch (choiceOfOption) {
			case 1: {
				
				DataAcessObject.userLogin();
				break;
			}
			case 2: {
				DataAcessObject.adminView();
				break;
			}
			case 3: {
				DataAcessObject.teamView();
				break;
			}
			}

		} while (choiceOfOption != 0);

	}

}
