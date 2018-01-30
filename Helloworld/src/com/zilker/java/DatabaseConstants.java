package com.zilker.java;

public class DatabaseConstants {
	// Database
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/detailsServ?autoReconnect=true&useSSL=false";
	public static final String UNAME = "root";
	public static final String PASSWORD = "ztech@123";
	
	public static final String COMPIDINFO = "select * from complaintInfo where comp_id = ?";
	public static final String COMPLAINTINFO = "select * from complaintInfo";
	
}
