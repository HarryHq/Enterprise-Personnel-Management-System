package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Administrator;
import com.entity.Department;
import com.utils.JDBCUtils;

public class AdminDao {
	PreparedStatement pStatement=null;
	Connection connection=null;
	ResultSet resultSet=null;
	
	public void delete(String id) {
		try {
			
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="DELETE FROM administrator WHERE aid =?";
			
			pStatement=connection.prepareStatement(sql);
			
			pStatement.setString(1, id);
			/*
			 * 4、执行SQL语句并得到结果集
			 */
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection);		
		}
	}
	
	public void update(Administrator ad) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="UPDATE administrator SET aname=?,apassword=?,remark=? WHERE aid=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			
			pStatement.setString(1, ad.getAname());
			pStatement.setString(2, ad.getApassword());
			pStatement.setString(3, ad.getRemark());
			pStatement.setString(4, ad.getAid());
			
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
	
	public void add(Administrator ad) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 * INSERT INTO administrator(aid,aname,apassword,remark) VALUES('003','ad','ad123','');
			 */
			String sql="INSERT INTO administrator(aid,aname,apassword,remark) "
					+ "VALUES(?,?,?,?)";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, ad.getAid());
			pStatement.setString(2, ad.getAname());
			pStatement.setString(3, ad.getApassword());
			pStatement.setString(4, ad.getRemark());
			
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
    public Administrator findById(String id) {
		
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="SELECT * FROM administrator WHERE aid=?";
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
				Administrator ad = new Administrator();
				ad.setAid(resultSet.getString("aid"));
				ad.setAname(resultSet.getString("aname"));
				ad.setApassword(resultSet.getString("apassword"));
				ad.setRemark(resultSet.getString("remark"));
				return ad;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;		
	}
    
    public List<Administrator> findAll(){
    	try {
			
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="select * from administrator";
			
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
			
			List<Administrator> list=new ArrayList<Administrator>();
			while (resultSet.next()) {
				Administrator ad = new Administrator();
				ad.setAid(resultSet.getString("aid"));
				ad.setAname(resultSet.getString("aname"));
				ad.setApassword(resultSet.getString("apassword"));
				ad.setRemark(resultSet.getString("remark"));
				list.add(ad);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;
    }

}
