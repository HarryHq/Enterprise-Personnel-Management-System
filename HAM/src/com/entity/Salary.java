package com.entity;
/**
 * 用于记录员工的工资
 * @author Autopassion
 *
 */
public class Salary {
	private int id;
	private String staffId;
	private String staffName;
	private String salary_year;
	private String salary_month;
	private Double basic_salary;
	private Double overtime_pay;
	private Double bonus;
	private Double traffic_Allowance;
	private Double meal_Allowance;
	private Double business_Travel_Allowance;
	private Double monthly_Supplement_Salary;
	private Double salary_Should_Pay;
	private Double absence;
	private Double forfeit;
	private Double individual_Income_Tax;
	private Double house_Accumulation_Fund;
	private Double endowment_Insurance;
	private Double unemployment_Insurance;
	private Double medical_Insurance;
	private Double injury_Insurance;
	private Double childbirth_Insurance;
	private Double cut_Payment_Summation;
	private Double actual_Salary;
	private String remark;
	@Override
	public String toString() {
		return "Salary [id=" + id + ", staffId=" + staffId + ", staffName=" + staffName + ", salary_year=" + salary_year
				+ ", salary_month=" + salary_month + ", basic_salary=" + basic_salary + ", overtime_pay=" + overtime_pay
				+ ", bonus=" + bonus + ", traffic_Allowance=" + traffic_Allowance + ", meal_Allowance=" + meal_Allowance
				+ ", business_Travel_Allowance=" + business_Travel_Allowance + ", salary_Should_Pay="
				+ salary_Should_Pay + ", absence=" + absence + ", forfeit=" + forfeit + ", individual_Income_Tax="
				+ individual_Income_Tax + ", injury_Insurance=" + injury_Insurance + ", childbirth_Insurance="
				+ childbirth_Insurance + ", cut_Payment_Summation=" + cut_Payment_Summation + ", actual_Salary="
				+ actual_Salary + ", remark=" + remark + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSalary_year() {
		return salary_year;
	}
	public void setSalary_year(String salary_year) {
		this.salary_year = salary_year;
	}
	public String getSalary_month() {
		return salary_month;
	}
	public void setSalary_month(String salary_month) {
		this.salary_month = salary_month;
	}
	public Double getBasic_salary() {
		return basic_salary;
	}
	public void setBasic_salary(Double basic_salary) {
		this.basic_salary = basic_salary;
	}
	public Double getOvertime_pay() {
		return overtime_pay;
	}
	public void setOvertime_pay(Double overtime_pay) {
		this.overtime_pay = overtime_pay;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	public Double getTraffic_Allowance() {
		return traffic_Allowance;
	}
	public void setTraffic_Allowance(Double traffic_Allowance) {
		this.traffic_Allowance = traffic_Allowance;
	}
	public Double getMeal_Allowance() {
		return meal_Allowance;
	}
	public void setMeal_Allowance(Double meal_Allowance) {
		this.meal_Allowance = meal_Allowance;
	}
	public Double getBusiness_Travel_Allowance() {
		return business_Travel_Allowance;
	}
	public void setBusiness_Travel_Allowance(Double business_Travel_Allowance) {
		this.business_Travel_Allowance = business_Travel_Allowance;
	}
	public Double getMonthly_Supplement_Salary() {
		return monthly_Supplement_Salary;
	}
	public void setMonthly_Supplement_Salary(Double monthly_Supplement_Salary) {
		this.monthly_Supplement_Salary = monthly_Supplement_Salary;
	}
	public Double getSalary_Should_Pay() {
		return salary_Should_Pay;
	}
	public void setSalary_Should_Pay(Double salary_Should_Pay) {
		this.salary_Should_Pay = salary_Should_Pay;
	}
	public Double getAbsence() {
		return absence;
	}
	public void setAbsence(Double absence) {
		this.absence = absence;
	}
	public Double getForfeit() {
		return forfeit;
	}
	public void setForfeit(Double forfeit) {
		this.forfeit = forfeit;
	}
	public Double getIndividual_Income_Tax() {
		return individual_Income_Tax;
	}
	public void setIndividual_Income_Tax(Double individual_Income_Tax) {
		this.individual_Income_Tax = individual_Income_Tax;
	}
	public Double getHouse_Accumulation_Fund() {
		return house_Accumulation_Fund;
	}
	public void setHouse_Accumulation_Fund(Double house_Accumulation_Fund) {
		this.house_Accumulation_Fund = house_Accumulation_Fund;
	}
	public Double getEndowment_Insurance() {
		return endowment_Insurance;
	}
	public void setEndowment_Insurance(Double endowment_Insurance) {
		this.endowment_Insurance = endowment_Insurance;
	}
	public Double getUnemployment_Insurance() {
		return unemployment_Insurance;
	}
	public void setUnemployment_Insurance(Double unemployment_Insurance) {
		this.unemployment_Insurance = unemployment_Insurance;
	}
	public Double getMedical_Insurance() {
		return medical_Insurance;
	}
	public void setMedical_Insurance(Double medical_Insurance) {
		this.medical_Insurance = medical_Insurance;
	}
	public Double getInjury_Insurance() {
		return injury_Insurance;
	}
	public void setInjury_Insurance(Double injury_Insurance) {
		this.injury_Insurance = injury_Insurance;
	}
	public Double getChildbirth_Insurance() {
		return childbirth_Insurance;
	}
	public void setChildbirth_Insurance(Double childbirth_Insurance) {
		this.childbirth_Insurance = childbirth_Insurance;
	}
	public Double getCut_Payment_Summation() {
		return cut_Payment_Summation;
	}
	public void setCut_Payment_Summation(Double cut_Payment_Summation) {
		this.cut_Payment_Summation = cut_Payment_Summation;
	}
	public Double getActual_Salary() {
		return actual_Salary;
	}
	public void setActual_Salary(Double actual_Salary) {
		this.actual_Salary = actual_Salary;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
