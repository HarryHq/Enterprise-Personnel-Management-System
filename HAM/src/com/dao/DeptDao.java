package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Department;
import com.utils.DateUtils;
import com.utils.JDBCUtils;

public class DeptDao {
	PreparedStatement pStatement=null;
	Connection connection=null;
	ResultSet resultSet=null;
	
	/**
	 * 更新部门
	 * @param dept
	 */
	public void update(Department dept) { 
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="UPDATE department SET dname=?,dmanager=?,dmPhone=?,remark=? WHERE did=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			
			pStatement.setString(1, dept.getDname());
			pStatement.setString(2, dept.getDmanager());
			pStatement.setString(3, dept.getDmPhone());
			pStatement.setString(4, dept.getRemark());
			pStatement.setString(5, dept.getDid());
			
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
	 * 添加部门
	 * @param department
	 */
	public void add(Department department) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 * INSERT INTO administrator(aid,aname,apassword,remark) VALUES('003','ad','ad123','');
			 */
			String sql="INSERT INTO department(did,dname,dmanager,dmPhone,remark) "
					+ "VALUES(?,?,?,?,?)";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, department.getDid());
			pStatement.setString(2, department.getDname());
			pStatement.setString(3, department.getDmanager());
			pStatement.setString(4, department.getDmPhone());
			pStatement.setString(5, department.getRemark());
			
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
	 * 根据管理id进行查找 
	 * @param id
	 * @return
	 */
    public Department findById(String id) {
		
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="SELECT * FROM department WHERE did=?";
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
				Department department = new Department();
				department.setDid(resultSet.getString("did"));
				department.setDname(resultSet.getString("dname"));
				department.setDmanager(resultSet.getString("dmanager"));
				department.setDmPhone(resultSet.getString("dmPhone"));
				department.setRemark(resultSet.getString("remark"));
				return department;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;		
	}
    
    /**
     * 查找全部
     * @return
     */
    public List<Department> findAll(){
    	try {
			
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="SELECT * FROM department";
			
			pStatement=connection.prepareStatement(sql);
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
			
			List<Department> list=new ArrayList<Department>();
			while (resultSet.next()) {
				Department department = new Department();
				department.setDid(resultSet.getString("did"));
				department.setDname(resultSet.getString("dname"));
				department.setDmanager(resultSet.getString("dmanager"));
				department.setDmPhone(resultSet.getString("dmPhone"));
				department.setRemark(resultSet.getString("remark"));
				list.add(department);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;
    }

    /**
     * 删除部门
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
			String sql="DELETE FROM department WHERE did =?";
			
			pStatement=connection.prepareStatement(sql);
			
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
}
