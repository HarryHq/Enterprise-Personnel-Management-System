package com.entity;

import java.util.Date;

/**
 * 出勤表
 * @author yyk46
 *
 */
public class Attendence {
	private Integer id; //主键
	private String sid; //员工编号 
	private String sname;  //员工姓名
	private String clorktime; //参考时间
	private String time;  //上下班打卡时间
	private String state;   // 状态：正常或是迟到
	private String updateTime; //更新时间
	private String remark;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClorktime() {
		return clorktime;
	}
	public void setClorktime(String clorktime) {
		this.clorktime = clorktime;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}  
	
		
}
