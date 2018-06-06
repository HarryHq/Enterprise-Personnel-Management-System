package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Administrator;
import com.entity.PageBean;
import com.entity.Salary;
import com.entity.Staff;
import com.utils.JDBCUtils;

/**
 * 工资的dao层
 *
 */
public class SalaryDao {
	PreparedStatement pStatement=null;
	Connection connection=null;
	ResultSet resultSet=null;
	/**
	 * 查询所有的员工工资
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Salary> queryAll(int currentPage,int pageSize) {
		try {
			PageBean<Salary> pageBean = new PageBean<Salary>();
			pageBean.setCurrentPage(currentPage);
			pageBean.setPageSize(pageSize);
			connection = JDBCUtils.getConnection();
			String trSql="select count(*) from salary";
			pStatement=connection.prepareStatement(trSql);
			resultSet=pStatement.executeQuery();
			resultSet.next();
			int totalRows = resultSet.getInt(1);
			pageBean.setTotalRows(totalRows);
			resultSet=null;
			
			/*
			 * 得到beanList
			 */
			String sql="SELECT * FROM salary limit ?,?";		
			pStatement=connection.prepareStatement(sql);
			pStatement.setInt(1, (currentPage-1)*pageSize);
			pStatement.setInt(2, pageSize);
			resultSet=pStatement.executeQuery();
			if (resultSet==null) {
				return null;
			}
			List<Salary> list=new ArrayList<Salary>();
			while (resultSet.next()) {
				Salary salary=new Salary();
				salary.setId(resultSet.getInt("ID"));
				salary.setStaffId(resultSet.getString("Staff_ID"));
				salary.setStaffName(resultSet.getString("Staff_Name"));
				salary.setSalary_year(resultSet.getString("Salary_Year"));
				salary.setSalary_month(resultSet.getString("Salary_Month"));
				salary.setBasic_salary(resultSet.getDouble("Basic_Salary"));
				salary.setOvertime_pay(resultSet.getDouble("Overtime_Pay"));
				salary.setBonus(resultSet.getDouble("Bonus"));
				salary.setTraffic_Allowance(resultSet.getDouble("Traffic_Allowance"));
				salary.setMeal_Allowance(resultSet.getDouble("Meal_Allowance"));
				salary.setBusiness_Travel_Allowance(resultSet.getDouble("Business_Travel_Allowance"));
				salary.setMonthly_Supplement_Salary(resultSet.getDouble("Monthly_Supplement_Salary"));
				salary.setSalary_Should_Pay(resultSet.getDouble("Salary_Should_Pay"));
				salary.setAbsence(resultSet.getDouble("Absence"));
				salary.setForfeit(resultSet.getDouble("Forfeit"));
				salary.setIndividual_Income_Tax(resultSet.getDouble("Individual_Income_Tax"));
				salary.setHouse_Accumulation_Fund(resultSet.getDouble("House_Accumulation_Fund"));
				salary.setEndowment_Insurance(resultSet.getDouble("Endowment_Insurance"));
				salary.setUnemployment_Insurance(resultSet.getDouble("Unemployment_Insurance"));
				salary.setMedical_Insurance(resultSet.getDouble("Medical_Insurance"));
				salary.setInjury_Insurance(resultSet.getDouble("Injury_Insurance"));
				salary.setChildbirth_Insurance(resultSet.getDouble("Childbirth_Insurance"));
				salary.setCut_Payment_Summation(resultSet.getDouble("Cut_Payment_Summation"));
				salary.setActual_Salary(resultSet.getDouble("Actual_Salary"));
				salary.setRemark(resultSet.getString("Remark"));
				list.add(salary);
				}
			pageBean.setBeanList(list);
			return  pageBean;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;
	}
	
	/**
	 * 根据id进行查询记录
	 * @param id
	 * @return
	 */
	public Salary findById(String id) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="SELECT * FROM salary WHERE ID=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, id);			
			
			/*
			 * 4、执行SQL语句并得到结果集
			 */
			resultSet=pStatement.executeQuery();
			
			/*
			 * 从结果集中得到数据， 并封装到Staff对象中
			 */
			if (resultSet==null) {
				return null;
			}
			
			while (resultSet.next()) {
				Salary salary=new Salary();
				salary.setId(resultSet.getInt("ID"));
				salary.setStaffId(resultSet.getString("Staff_ID"));
				salary.setStaffName(resultSet.getString("Staff_Name"));
				salary.setSalary_year(resultSet.getString("Salary_Year"));
				salary.setSalary_month(resultSet.getString("Salary_Month"));
				salary.setBasic_salary(resultSet.getDouble("Basic_Salary"));
				salary.setOvertime_pay(resultSet.getDouble("Overtime_Pay"));
				salary.setBonus(resultSet.getDouble("Bonus"));
				salary.setTraffic_Allowance(resultSet.getDouble("Traffic_Allowance"));
				salary.setMeal_Allowance(resultSet.getDouble("Meal_Allowance"));
				salary.setBusiness_Travel_Allowance(resultSet.getDouble("Business_Travel_Allowance"));
				salary.setMonthly_Supplement_Salary(resultSet.getDouble("Monthly_Supplement_Salary"));
				salary.setSalary_Should_Pay(resultSet.getDouble("Salary_Should_Pay"));
				salary.setAbsence(resultSet.getDouble("Absence"));
				salary.setForfeit(resultSet.getDouble("Forfeit"));
				salary.setIndividual_Income_Tax(resultSet.getDouble("Individual_Income_Tax"));
				salary.setHouse_Accumulation_Fund(resultSet.getDouble("House_Accumulation_Fund"));
				salary.setEndowment_Insurance(resultSet.getDouble("Endowment_Insurance"));
				salary.setUnemployment_Insurance(resultSet.getDouble("Unemployment_Insurance"));
				salary.setMedical_Insurance(resultSet.getDouble("Medical_Insurance"));
				salary.setInjury_Insurance(resultSet.getDouble("Injury_Insurance"));
				salary.setChildbirth_Insurance(resultSet.getDouble("Childbirth_Insurance"));
				salary.setCut_Payment_Summation(resultSet.getDouble("Cut_Payment_Summation"));
				salary.setActual_Salary(resultSet.getDouble("Actual_Salary"));
				salary.setRemark(resultSet.getString("Remark"));
				return salary;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;		
	}

	/**
	 * 更新工资信息
	 * @param salary
	 */
	public void update(Salary salary) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="UPDATE salary SET Staff_ID=?,Staff_Name=?,Salary_Year=?,Salary_Month=?,Basic_Salary=?"
					+ ",Overtime_Pay=?,Bonus=?,Traffic_Allowance=?,Meal_Allowance=?,Business_Travel_Allowance=?"
					+ ",Monthly_Supplement_Salary=?,Salary_Should_Pay=?,Absence=?"
					+ ",Forfeit=?,Individual_Income_Tax=?,House_Accumulation_Fund=?,Endowment_Insurance=?"
					+ ",Unemployment_Insurance=?,Medical_Insurance=?,Injury_Insurance=?,Childbirth_Insurance=?,Cut_Payment_Summation=?"
					+ ",Actual_Salary=?,Remark=? WHERE ID=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, salary.getStaffId());
			pStatement.setString(2, salary.getStaffName());
			pStatement.setString(3, salary.getSalary_year());
			pStatement.setString(4, salary.getSalary_month());
			pStatement.setDouble(5, salary.getBasic_salary());
			pStatement.setDouble(6, salary.getOvertime_pay());
			pStatement.setDouble(7, salary.getBonus());
			pStatement.setDouble(8, salary.getTraffic_Allowance());
			pStatement.setDouble(9, salary.getMeal_Allowance());
			pStatement.setDouble(10, salary.getBusiness_Travel_Allowance());
			pStatement.setDouble(11, salary.getMonthly_Supplement_Salary());
			pStatement.setDouble(12, salary.getSalary_Should_Pay());
			pStatement.setDouble(13, salary.getAbsence());
			pStatement.setDouble(14, salary.getForfeit());
			pStatement.setDouble(15, salary.getIndividual_Income_Tax());
			pStatement.setDouble(16, salary.getHouse_Accumulation_Fund());
			pStatement.setDouble(17, salary.getEndowment_Insurance());
			pStatement.setDouble(18, salary.getUnemployment_Insurance());
			pStatement.setDouble(19, salary.getMedical_Insurance());
			pStatement.setDouble(20, salary.getInjury_Insurance());
			pStatement.setDouble(21, salary.getChildbirth_Insurance());
			pStatement.setDouble(22, salary.getCut_Payment_Summation()); 
			pStatement.setDouble(23, salary.getActual_Salary());
			pStatement.setString(24, salary.getRemark());
			pStatement.setInt(25, salary.getId());
			
			
			/*
			 * 4、执行SQL语句
			 */
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection);
		}
	}

	public PageBean<Salary> listSalaryById(int currentPage, int pageSize, String sid) {
		try {
			PageBean<Salary> pageBean = new PageBean<Salary>();
			pageBean.setCurrentPage(currentPage);
			pageBean.setPageSize(pageSize);
			connection = JDBCUtils.getConnection();
			String trSql="select count(*) from salary";
			pStatement=connection.prepareStatement(trSql);
			resultSet=pStatement.executeQuery();
			resultSet.next();
			int totalRows = resultSet.getInt(1);
			pageBean.setTotalRows(totalRows);
			resultSet=null;
			
			/*
			 * 得到beanList
			 */
			String sql="SELECT * FROM salary WHERE Staff_ID=? limit ?,?";		
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, sid);
			pStatement.setInt(2, (currentPage-1)*pageSize);
			pStatement.setInt(3, pageSize);
			resultSet=pStatement.executeQuery();
			if (resultSet==null) {
				return null;
			}
			List<Salary> list=new ArrayList<Salary>();
			while (resultSet.next()) {
				Salary salary=new Salary();
				salary.setId(resultSet.getInt("ID"));
				salary.setStaffId(resultSet.getString("Staff_ID"));
				salary.setStaffName(resultSet.getString("Staff_Name"));
				salary.setSalary_year(resultSet.getString("Salary_Year"));
				salary.setSalary_month(resultSet.getString("Salary_Month"));
				salary.setBasic_salary(resultSet.getDouble("Basic_Salary"));
				salary.setOvertime_pay(resultSet.getDouble("Overtime_Pay"));
				salary.setBonus(resultSet.getDouble("Bonus"));
				salary.setTraffic_Allowance(resultSet.getDouble("Traffic_Allowance"));
				salary.setMeal_Allowance(resultSet.getDouble("Meal_Allowance"));
				salary.setBusiness_Travel_Allowance(resultSet.getDouble("Business_Travel_Allowance"));
				salary.setMonthly_Supplement_Salary(resultSet.getDouble("Monthly_Supplement_Salary"));
				salary.setSalary_Should_Pay(resultSet.getDouble("Salary_Should_Pay"));
				salary.setAbsence(resultSet.getDouble("Absence"));
				salary.setForfeit(resultSet.getDouble("Forfeit"));
				salary.setIndividual_Income_Tax(resultSet.getDouble("Individual_Income_Tax"));
				salary.setHouse_Accumulation_Fund(resultSet.getDouble("House_Accumulation_Fund"));
				salary.setEndowment_Insurance(resultSet.getDouble("Endowment_Insurance"));
				salary.setUnemployment_Insurance(resultSet.getDouble("Unemployment_Insurance"));
				salary.setMedical_Insurance(resultSet.getDouble("Medical_Insurance"));
				salary.setInjury_Insurance(resultSet.getDouble("Injury_Insurance"));
				salary.setChildbirth_Insurance(resultSet.getDouble("Childbirth_Insurance"));
				salary.setCut_Payment_Summation(resultSet.getDouble("Cut_Payment_Summation"));
				salary.setActual_Salary(resultSet.getDouble("Actual_Salary"));
				salary.setRemark(resultSet.getString("Remark"));
				list.add(salary);
				}
			pageBean.setBeanList(list);
			return  pageBean;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;
	}
	
}
