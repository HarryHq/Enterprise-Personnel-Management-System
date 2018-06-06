package com.entity;

import java.util.Date;

public class Staff {

	private String sid;
	private String sname;
	private String sex;
	private Date birthday;
	private String stirps; //民族
	private String idNumber;  //身份证号
	private String nativePlace; //籍贯
	private String education;  //学历
	private String major;  // 专业
	private String cellphone;
	private String email;
	private String department;
	private String role; //职务
	private String password;  
	private Date hireDate; //入职日期
	private String workType;  //用工形式
	private String bankCard; 
	private Date workBegin; //合同开始
	private Date workEnd;   //合同结束
	private Date termDate; //离职日期
	private String termReason;  //离职原因
	private String _remark;   //备注
	private String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStirps() {
		return stirps;
	}
	public void setStirps(String stirps) {
		this.stirps = stirps;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public Date getWorkBegin() {
		return workBegin;
	}
	public void setWorkBegin(Date workBegin) {
		this.workBegin = workBegin;
	}
	public Date getWorkEnd() {
		return workEnd;
	}
	public void setWorkEnd(Date workEnd) {
		this.workEnd = workEnd;
	}
	public Date getTermDate() {
		return termDate;
	}
	public void setTermDate(Date termDate) {
		this.termDate = termDate;
	}
	public String getTermReason() {
		return termReason;
	}
	public void setTermReason(String termReason) {
		this.termReason = termReason;
	}
	public String get_remark() {
		return _remark;
	}
	public void set_remark(String _remark) {
		this._remark = _remark;
	}
	@Override
	public String toString() {
		return "Staff [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", birthday=" + birthday + ", stirps="
				+ stirps + ", idNumber=" + idNumber + ", nativePlace=" + nativePlace + ", education=" + education
				+ ", major=" + major + ", cellphong=" + cellphone + ", email=" + email + ", department=" + department
				+ ", role=" + role + ", password=" + password + ", hireDate=" + hireDate + ", workType=" + workType
				+ ", bankCard=" + bankCard + ", workBegin=" + workBegin + ", workEnd=" + workEnd + ", termDate="
				+ termDate + ", termReason=" + termReason + ", _remark=" + _remark + "]";
	}
	


	

}
