package com.entity;

public class Administrator {

	private String aid;
	private String aname;
	private String apassword;
	private String remark;
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "Administrator [aid=" + aid + ", aname=" + aname + ", apassword=" + apassword + ", remark=" + remark
				+ "]";
	}
	
	
	
	
	

	
	
}
