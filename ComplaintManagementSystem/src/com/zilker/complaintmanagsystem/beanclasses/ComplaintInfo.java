package com.zilker.complaintmanagsystem.beanclasses;

public class ComplaintInfo {
private int custId;
private String compTitle;
private String compDesc;
private int compTypeId;
private String compStatus;
private int prod_id;
public ComplaintInfo(int custId,String compTitle, String compDesc, int compTypeId, String compStatus, int prod_id) {
	super();
	this.compTitle = compTitle;
	this.compDesc = compDesc;
	this.compTypeId = compTypeId;
	this.compStatus = compStatus;
	this.prod_id = prod_id;
	this.custId = custId;
}
public ComplaintInfo(int custId,String compTitle, String compDesc, int compTypeId, int prod_id) {
	super();
	this.compTitle = compTitle;
	this.compDesc = compDesc;
	this.compTypeId = compTypeId;
	this.prod_id = prod_id;
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
public int getProd_id() {
	return prod_id;
}
public void setProd_id(int prod_id) {
	this.prod_id = prod_id;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}


}
