package com.entity;

import java.util.Date;

public class Approve {
	
	private String Staff_ID;
	private String Staff_Name;
	private Date Attendance_Date;
	private String Attendance_Type;
	private String Remark;
	private String approve_Status;
	private Date Request_Date;
	
	public String getStaff_ID() {
		return Staff_ID;
	}
	public void setStaff_ID(String staff_ID) {
		Staff_ID = staff_ID;
	}
	public String getStaff_Name() {
		return Staff_Name;
	}
	public void setStaff_Name(String staff_Name) {
		Staff_Name = staff_Name;
	}
	public Date getAttendance_Date() {
		return Attendance_Date;
	}
	public void setAttendance_Date(Date attendance_Date) {
		Attendance_Date = attendance_Date;
	}
	public String getAttendance_Type() {
		return Attendance_Type;
	}
	public void setAttendance_Type(String attendance_Type) {
		Attendance_Type = attendance_Type;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getApprove_Status() {
		return approve_Status;
	}
	public void setApprove_Status(String approve_Status) {
		this.approve_Status = approve_Status;
	}
	public Date getRequest_Date() {
		return Request_Date;
	}
	public void setRequest_Date(Date request_Date) {
		Request_Date = request_Date;
	}
	
	
	

}
