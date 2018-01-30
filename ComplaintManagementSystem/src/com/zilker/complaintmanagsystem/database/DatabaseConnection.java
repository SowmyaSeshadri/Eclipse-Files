package com.zilker.complaintmanagsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.zilker.complaintmanagsystem.constants.Constants;
import com.zilker.complaintmanagsystem.constants.DatabaseConstants;

public class DatabaseConnection {

    private static Connection con;
	static Logger logger = Logger.getLogger(Constants.LOGGERINFO);
  
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
    
    public static void closeCon(ResultSet rs, PreparedStatement ps,Connection con) throws SQLException {
    	rs.close();
    	ps.close();
    	con.close();
    }

}