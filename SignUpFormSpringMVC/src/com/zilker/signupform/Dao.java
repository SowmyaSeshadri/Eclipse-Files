package com.zilker.signupform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.zilker.signupform.bean.Details;
import com.zilker.signupform.database.DatabaseConnection;



public class Dao {
	Logger logger = Logger.getLogger("My-Info");
	public void insertIntoDatabase(Details details) throws SQLException {
		 Connection con =  DatabaseConnection.loadDriver();
		 PreparedStatement preparedStatement = null;
		 try {
			 	
				String query = "insert into details(firstName,lastName,email,phone,username)values(?,?,?,?,?)";
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, details.getFirstName());
				preparedStatement.setString(2, details.getLastName());
				preparedStatement.setString(3,details.getEmail());
				preparedStatement.setString(4, details.getPhone());
				preparedStatement.setString(5, details.getUername());
				
				preparedStatement.executeUpdate();
		
		 }
		 catch(Exception e) {
			logger.info(e.toString());
		 }
		 finally {
			 preparedStatement.close();
			 DatabaseConnection.closeCon();
		 }
	}

}
