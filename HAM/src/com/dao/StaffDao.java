package com.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.PageBean;
import com.entity.Staff;
import com.utils.DateUtils;
import com.utils.JDBCUtils;

public class StaffDao {
	PreparedStatement pStatement=null;
	Connection connection=null;
	ResultSet resultSet=null;
	
	/**
	 * 添加操作
	 * @param staff
	 */
	public void add(Staff staff) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="INSERT INTO staff(Staff_ID,Staff_Name,Password,Staff_Sex,Staff_Birthday,"
					+ "Staff_Stirps,Staff_ID_number,Staff_Native_Place,Staff_Education,"
					+ "Staff_Major,Staff_Tel,Staff_Email,Staff_Department,Staff_Role,"
					+ "Work_HireDate,Work_Type,Work_BankCard,Work_Begin,Work_End,"
					+ "Work_TermDate,Work_TermReason,Remark) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, staff.getSid());
			pStatement.setString(2, staff.getSname());
			pStatement.setString(3, staff.getPassword());
			pStatement.setString(4, staff.getSex());
			/*
			 * java.util.date-->java.sql.date
			 */
			Date birthday=DateUtils.toSqlDate(staff.getBirthday());
			pStatement.setDate(5, birthday);
			pStatement.setString(6, staff.getStirps());
			pStatement.setString(7, staff.getIdNumber());
			pStatement.setString(8, staff.getNativePlace());
			pStatement.setString(9, staff.getEducation());
			pStatement.setString(10, staff.getMajor());
			pStatement.setString(11, staff.getCellphone());
			pStatement.setString(12, staff.getEmail());
			pStatement.setString(13, staff.getDepartment());
			pStatement.setString(14, staff.getRole());
			Date hireDate=DateUtils.toSqlDate(staff.getHireDate());
			pStatement.setDate(15, hireDate);
			pStatement.setString(16, staff.getWorkType());
			pStatement.setString(17, staff.getBankCard());
			Date workBegin = DateUtils.toSqlDate(staff.getWorkBegin());
			pStatement.setDate(18, workBegin);
			Date workEnd = DateUtils.toSqlDate(staff.getWorkEnd());
			pStatement.setDate(19, workEnd);
			Date termDate = DateUtils.toSqlDate(staff.getTermDate());
			pStatement.setDate(20, termDate);
			pStatement.setString(21, staff.getTermReason());
			pStatement.setString(22, staff.get_remark());
			
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
	
	/**
	 * 根据员工Id进行查询
	 * @param id
	 */
	public Staff findById(String id) {
		
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="SELECT * FROM staff WHERE Staff_ID=?";
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
				Staff staff = new Staff();
				staff.setSid(resultSet.getString("Staff_ID"));
				staff.setSname(resultSet.getString("Staff_Name"));
				staff.setSex(resultSet.getString("Staff_Sex"));
				staff.setBirthday(resultSet.getDate("Staff_Birthday"));
				staff.setStirps(resultSet.getString("Staff_Stirps"));
				staff.setIdNumber(resultSet.getString("Staff_ID_number"));
				staff.setNativePlace(resultSet.getString("Staff_Native_Place"));
				staff.setEducation(resultSet.getString("Staff_Education"));
				staff.setMajor(resultSet.getString("Staff_Major"));
				staff.setCellphone(resultSet.getString("Staff_Tel"));
				staff.setEmail(resultSet.getString("Staff_Email"));
				staff.setDepartment(resultSet.getString("Staff_Department"));
				staff.setRole(resultSet.getString("Staff_Role"));
				staff.setHireDate(resultSet.getDate("Work_HireDate"));
				staff.setWorkType(resultSet.getString("Work_Type"));
				staff.setBankCard(resultSet.getString("Work_BankCard"));
				staff.setWorkBegin(resultSet.getDate("Work_Begin"));
				staff.setWorkEnd(resultSet.getDate("Work_End"));
				staff.setTermDate(resultSet.getDate("Work_TermDate"));
				staff.setTermReason(resultSet.getString("Work_TermReason"));
				staff.set_remark(resultSet.getString("Remark"));
				staff.setPassword(resultSet.getString("Password"));
				staff.setState(resultSet.getString("state"));
				
				return staff;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;		
	}
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public PageBean<Staff> findAll(int currentPage,int pageSize) {
		try {
			/*
			 * 得到PageBean对象，设置currentPage，pageSize
			 */
			PageBean<Staff> pageBean = new PageBean<Staff>();
			pageBean.setCurrentPage(currentPage);
			pageBean.setPageSize(pageSize);
			
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String trSql="select count(*) from staff";
			
			pStatement=connection.prepareStatement(trSql);
			/*
			 * 4、执行SQL语句并得到结果集
			 */
			resultSet=pStatement.executeQuery();
			/*
			 * 得到总记录数
			 */
			resultSet.next();
			int totalRows = resultSet.getInt(1);
			pageBean.setTotalRows(totalRows);
			resultSet=null;
			
			/*
			 * 得到beanList
			 */
			String sql="SELECT * FROM staff limit ?,?";		
			pStatement=connection.prepareStatement(sql);
			pStatement.setInt(1, (currentPage-1)*pageSize);
			pStatement.setInt(2, pageSize);
			resultSet=pStatement.executeQuery();
			
			/*
			 * 从结果集中得到数据， 并封装到Staff对象中
			 */
			if (resultSet==null) {
				return null;
			}
			
			List<Staff> list=new ArrayList<Staff>();
			while (resultSet.next()) {
				Staff staff = new Staff();
				staff.setSid(resultSet.getString("Staff_ID"));
				staff.setSname(resultSet.getString("Staff_Name"));
				staff.setSex(resultSet.getString("Staff_Sex"));
				staff.setBirthday(resultSet.getDate("Staff_Birthday"));
				staff.setStirps(resultSet.getString("Staff_Stirps"));
				staff.setIdNumber(resultSet.getString("Staff_ID_number"));
				staff.setNativePlace(resultSet.getString("Staff_Native_Place"));
				staff.setEducation(resultSet.getString("Staff_Education"));
				staff.setMajor(resultSet.getString("Staff_Major"));
				staff.setCellphone(resultSet.getString("Staff_Tel"));
				staff.setEmail(resultSet.getString("Staff_Email"));
				staff.setDepartment(resultSet.getString("Staff_Department"));
				staff.setRole(resultSet.getString("Staff_Role"));
				staff.setHireDate(resultSet.getDate("Work_HireDate"));
				staff.setWorkType(resultSet.getString("Work_Type"));
				staff.setBankCard(resultSet.getString("Work_BankCard"));
				staff.setWorkBegin(resultSet.getDate("Work_Begin"));
				staff.setWorkEnd(resultSet.getDate("Work_End"));
				staff.setTermDate(resultSet.getDate("Work_TermDate"));
				staff.setTermReason(resultSet.getString("Work_TermReason"));
				staff.set_remark(resultSet.getString("Remark"));
				staff.setPassword(resultSet.getString("Password"));
				list.add(staff);				
			}
			pageBean.setBeanList(list);
			return pageBean;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		
		return null;
		
	}

	/**
	 * 更新员工信息
	 * @param staff
	 */
	public void update(Staff staff) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="UPDATE staff SET Staff_Name=?,Password=?,Staff_Sex=?,Staff_Birthday=?,"
					+ "Staff_Stirps=?,Staff_ID_number=?,Staff_Native_Place=?,Staff_Education=?,"
					+ "Staff_Major=?,Staff_Tel=?,Staff_Email=?,Staff_Department=?,Staff_Role=?,"
					+ "Work_HireDate=?,Work_Type=?,Work_BankCard=?,Work_Begin=?,Work_End=?,"
					+ "Work_TermDate=?,Work_TermReason=?,Remark=? WHERE Staff_ID=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			
			pStatement.setString(1, staff.getSname());
			pStatement.setString(2, staff.getPassword());
			pStatement.setString(3, staff.getSex());
			/*
			 * java.util.date-->java.sql.date
			 */
			Date birthday=DateUtils.toSqlDate(staff.getBirthday());
			pStatement.setDate(4, birthday);
			pStatement.setString(5, staff.getStirps());
			pStatement.setString(6, staff.getIdNumber());
			pStatement.setString(7, staff.getNativePlace());
			pStatement.setString(8, staff.getEducation());
			pStatement.setString(9, staff.getMajor());
			pStatement.setString(10, staff.getCellphone());
			pStatement.setString(11, staff.getEmail());
			pStatement.setString(12, staff.getDepartment());
			pStatement.setString(13, staff.getRole());
			Date hireDate=DateUtils.toSqlDate(staff.getHireDate());
			pStatement.setDate(14, hireDate);
			pStatement.setString(15, staff.getWorkType());
			pStatement.setString(16, staff.getBankCard());
			Date workBegin = DateUtils.toSqlDate(staff.getWorkBegin());
			pStatement.setDate(17, workBegin);
			Date workEnd = DateUtils.toSqlDate(staff.getWorkEnd());
			pStatement.setDate(18, workEnd);
			Date termDate = DateUtils.toSqlDate(staff.getTermDate());
			pStatement.setDate(19, termDate);
			pStatement.setString(20, staff.getTermReason());
			pStatement.setString(21, staff.get_remark());
			pStatement.setString(22, staff.getSid());
			
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
	
	/**
	 * 根据员工id删除员工信息
	 * @param id
	 */
	public void delete(String id) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="DELETE FROM staff WHERE Staff_ID=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, id);			
			
			/*
			 * 4、执行SQL语句并得到结果集
			 */
			pStatement.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}	
		
	}

	/**
	 * 根据条件查询员工信息
	 * @param staff
	 * @return
	 */
	public List<Staff> query(Staff staff) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			StringBuilder sql = new StringBuilder("select * from staff where 1=1 ");
			List<Object> list = new ArrayList<Object>();
			String id = staff.getSid();
			if (id != null && !id.trim().isEmpty()) {
//				sql.append("and Staff_ID= ?");
//				list.add( id ); 
				
				sql.append("and Staff_ID like ?");
				list.add("%" + id + "%"); 
			}
			
			String name = staff.getSname();
			if (name != null && !name.trim().isEmpty()) {
				sql.append("and Staff_Name like ?");
				list.add("%" + name + "%");
			}
			
			String sex = staff.getSex();
			if (sex != null && !sex.trim().isEmpty()) {
				sql.append("and Staff_Sex=?");
				list.add(sex);
			}
			
			String cellphone = staff.getCellphone();
			if (cellphone != null && !cellphone.trim().isEmpty()) {
				sql.append("and Staff_Tel like ?");
				list.add("%" + cellphone + "%");
			}
			String email = staff.getEmail();
			if (email != null && !email.trim().isEmpty()) {
				sql.append("and Staff_Email like ?");
				list.add("%" + email + "%");
			}
			
			
			
//			String sql="DELETE FROM staff WHERE Staff_ID=?";
			pStatement=connection.prepareStatement(sql.toString());
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			for (Object object : list) {
				System.out.println(object.toString());
			}
			if (list!=null && list.size()>0) {
				
				for(int i=0; i<list.size();i++) {
					pStatement.setString(i+1, list.get(i).toString());				
				}
				
			}
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
			
			List<Staff> list2=new ArrayList<Staff>();
			while (resultSet.next()) {
				Staff staff1 = new Staff();
				staff1.setSid(resultSet.getString("Staff_ID"));
				staff1.setSname(resultSet.getString("Staff_Name"));
				staff1.setSex(resultSet.getString("Staff_Sex"));
				staff1.setBirthday(resultSet.getDate("Staff_Birthday"));
				staff1.setStirps(resultSet.getString("Staff_Stirps"));
				staff1.setIdNumber(resultSet.getString("Staff_ID_number"));
				staff1.setNativePlace(resultSet.getString("Staff_Native_Place"));
				staff1.setEducation(resultSet.getString("Staff_Education"));
				staff1.setMajor(resultSet.getString("Staff_Major"));
				staff1.setCellphone(resultSet.getString("Staff_Tel"));
				staff1.setEmail(resultSet.getString("Staff_Email"));
				staff1.setDepartment(resultSet.getString("Staff_Department"));
				staff1.setRole(resultSet.getString("Staff_Role"));
				staff1.setHireDate(resultSet.getDate("Work_HireDate"));
				staff1.setWorkType(resultSet.getString("Work_Type"));
				staff1.setBankCard(resultSet.getString("Work_BankCard"));
				staff1.setWorkBegin(resultSet.getDate("Work_Begin"));
				staff1.setWorkEnd(resultSet.getDate("Work_End"));
				staff1.setTermDate(resultSet.getDate("Work_TermDate"));
				staff1.setTermReason(resultSet.getString("Work_TermReason"));
				staff1.set_remark(resultSet.getString("Remark"));
				staff1.setPassword(resultSet.getString("Password"));
				list2.add(staff1);				
			}
			
			return list2;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}	
		
		return null;
	}

	public void updatestate(Staff staff,String state) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="UPDATE staff SET state=? WHERE Staff_ID=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			
			pStatement.setString(1, state);
	
			pStatement.setString(2, staff.getSid());
			
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
}
