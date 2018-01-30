package com.zilker.complaintmanagsystem.constants;

public class DatabaseConstants {
	// Database
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/complaintSys?autoReconnect=true&useSSL=false";
	public static final String UNAME = "root";
	public static final String PASSWORD = "ztech@123";
	
	public static final String COMPIDINFO = "select * from complaintInfo where comp_id = ?";
	public static final String COMPLAINTINFO = "select * from complaintInfo";

	public static final String USERLOGIN ="select cust_id,firstName,lastName from customerInfo where (email = ? AND pwd = ?)";
	public static final String USERQUERY = "select comp_id,compTitle,prod_id,dateOfComp,complaintStatus from complaintInfo where cust_id in (select cust_id from customerInfo where email=? AND pwd =?)";
	public static final String COMP="select comp_id,compTitle,complaintStatus from complaintInfo where comp_id=? AND cust_id in(select cust_id from customerInfo where email=?)";
	public static final String SIGNUP = "insert into customerInfo(firstName,lastName,email,pwd) values(?,?,?,?)";
	public static final String TEAMQUERY = "insert into teamInfo (team_id,team_name) values(?,?)";;
	public static final String COMPTYPEINSERTQUERY = "insert into complaintType (compType_id,compType_name) values(?,?)";
	public static final String STATUSQUERY ="select comp_id,teamId,compTitle from complaintInfo where complaintStatus=?";
	public static final String STATUSTEAMQUERY = "select comp_id,teamId,dateOfComp from complaintInfo where teamId = ? AND complaintStatus = ?";
	public static final String TEAMVIEWQUERY = "select * from complaintInfo where compType_id=? OR compType_id=?"; 
	public static final String TEAMVIEWQUERY1 = "select * from complaintInfo where compType_id=?";
	public static final String UPDATESTATUSQUERY = "update complaintInfo set complaintStatus = ?,teamId = ? where comp_id = ?";
	public static final String INSERTCOMP = "insert into complaintInfo(cust_id,compTitle,compDesc,compType_id,prod_id) values(?,?,?,?,?)";
	
	
	
}
