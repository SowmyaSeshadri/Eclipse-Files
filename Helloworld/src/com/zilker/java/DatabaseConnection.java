package com.zilker.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static Connection con;
	static Logger logger = Logger.getLogger("mylogger");
  
    //to load the database driver and return a database connection
    
    public static Connection loadDriver() throws SQLException {
        try {
            Class.forName(DatabaseConstants.DRIVER);
        } catch (ClassNotFoundException ex) {
        	logger.info(ex.getMessage());
        }
        con = DriverManager.getConnection(DatabaseConstants.URL,DatabaseConstants.UNAME, DatabaseConstants.PASSWORD);
        return con;
    }
    
    public static void closeCon() throws SQLException {
    	con.close();
    }

}