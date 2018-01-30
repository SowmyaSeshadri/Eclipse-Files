package com.zilker.complaintmanagsystem.beanclasses;

public class ComplaintInfo {
private int custId;
private String compTitle;
private String compDesc;
private int compTypeId;
private String compStatus;
private int prodId;
private int compId;
private String date;
private int teamId;


public int getTeamId() {
	return teamId;
}
public void setTeamId(int teamId) {
	this.teamId = teamId;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public ComplaintInfo() {
	super();
}
public ComplaintInfo(int custId,String compTitle, String compDesc, int compTypeId, String compStatus, int prodId) {
	super();
	this.compTitle = compTitle;
	this.compDesc = compDesc;
	this.compTypeId = compTypeId;
	this.compStatus = compStatus;
	this.prodId = prodId;
	this.custId = custId;
}
public ComplaintInfo(String compTitle, int compTypeId, String compStatus, int prodId, int compId) {
	super();
	this.compTitle = compTitle;
	this.compTypeId = compTypeId;
	this.compStatus = compStatus;
	this.prodId = prodId;
	this.compId = compId;
}
public ComplaintInfo(int custId,String compTitle, String compDesc, int compTypeId, int prodId) {
	super();
	this.compTitle = compTitle;
	this.compDesc = compDesc;
	this.compTypeId = compTypeId;
	this.prodId = prodId;
	this.custId = custId;
}
public String getCompTitle() {
	return compTitle;
}
public void setCompTitle(String compTitle) {
	this.compTitle = compTitle;
}
public String getCompDesc() {
	return compDesc;
}
public void setCompDesc(String compDesc) {
	this.compDesc = compDesc;
}
public int getCompTypeId() {
	return compTypeId;
}
public void setCompTypeId(int compTypeId) {
	this.compTypeId = compTypeId;
}
public String getCompStatus() {
	return compStatus;
}
public void setCompStatus(String compStatus) {
	this.compStatus = compStatus;
}

public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public int getCompId() {
	return compId;
}
public void setCompId(int compId) {
	this.compId = compId;
}



}
