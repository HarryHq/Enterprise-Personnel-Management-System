package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Administrator;
import com.entity.Attendence;
import com.entity.Department;
import com.entity.PageBean;
import com.entity.Staff;
import com.utils.JDBCUtils;

public class AttendenceDao {
	PreparedStatement pStatement=null;
	Connection connection=null;
	ResultSet resultSet=null;

	/**
	 * 添加记录
	 * @param sid 
	 * @param attendence
	 */
	public void add(Attendence at, String sid,String state) {
		StaffDao dao = new StaffDao();
		Staff staff = dao.findById(sid);
		dao.updatestate(staff,state);
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 * INSERT INTO administrator(aid,aname,apassword,remark) VALUES('003','ad','ad123','');
			 */
			String sql="INSERT INTO attendance(Staff_ID,Staff_Name,clorkTime,state,pounchTime) \r\n" + 
					"VALUES(?,?,?,?,?)";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, at.getSid());
			pStatement.setString(2, at.getSname());
			pStatement.setString(3, at.getClorktime());
			pStatement.setString(4, at.getState());
			pStatement.setString(5, at.getTime());
			
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
	
	 public PageBean<Attendence> findAll(int currentPage,int pageSize){
	    	try {
	    		/*
				 * 得到PageBean对象，设置currentPage，pageSize
				 */
				PageBean<Attendence> pageBean = new PageBean<Attendence>();
				pageBean.setCurrentPage(currentPage);
				pageBean.setPageSize(pageSize);
				
				/*
				 * 1、获取数据库连接
				 */
				connection = JDBCUtils.getConnection();
				
				String trSql="SELECT count(*) FROM attendance ";
				
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
				String sql="SELECT * FROM attendance ORDER BY ID DESC limit ?,?";		
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
				
				List<Attendence> list=new ArrayList<Attendence>();
				while (resultSet.next()) {
					Attendence attendence=new Attendence();
					attendence.setId(resultSet.getInt("ID"));
					attendence.setSid(resultSet.getString("Staff_ID"));
					attendence.setSname(resultSet.getString("Staff_Name"));
					attendence.setClorktime(resultSet.getString("clorkTime"));
					attendence.setState(resultSet.getString("state"));
					attendence.setTime(resultSet.getString("pounchTime"));
					attendence.setUpdateTime(resultSet.getString("update_Time"));
					attendence.setRemark(resultSet.getString("Remark"));
					list.add(attendence);
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
	  * 根据员工id查找出勤信息
	  * @param sid
	  * @return
	  */
	public Attendence findById(String id) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="SELECT * FROM attendance WHERE ID=?";
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
				Attendence att= new Attendence();
				att.setId(resultSet.getInt("ID"));
				att.setSid(resultSet.getString("Staff_ID"));
				att.setSname(resultSet.getString("Staff_Name"));
				att.setClorktime(resultSet.getString("clorkTime"));
				att.setState(resultSet.getString("state"));
				att.setTime(resultSet.getString("pounchTime"));
				att.setUpdateTime(resultSet.getString("update_Time"));
				att.setRemark(resultSet.getString("Remark"));
				return att;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pStatement, connection, resultSet);
		}
		return null;		
	}

	/**
	 * 更新出勤信息
	 * @param attendence
	 */
	public void update(Attendence att) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="UPDATE attendance SET Staff_Name=?,clorkTime=?,state=?,"
					+ "pounchTime=?,update_Time=?,Remark=?,Staff_ID=?  WHERE ID=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, att.getSname());
			pStatement.setString(2, att.getClorktime());
			pStatement.setString(3, att.getState());
			pStatement.setString(4, att.getTime());
			pStatement.setString(5, att.getUpdateTime());
			pStatement.setString(6, att.getRemark());
			pStatement.setString(7, att.getSid());
			pStatement.setInt(8, att.getId());
			
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

	public PageBean<Attendence> findById(int currentPage, int pageSize, String sid) {
		try {
    		/*
			 * 得到PageBean对象，设置currentPage，pageSize
			 */
			PageBean<Attendence> pageBean = new PageBean<Attendence>();
			pageBean.setCurrentPage(currentPage);
			pageBean.setPageSize(pageSize);
			
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			
			String trSql="SELECT count(*) FROM attendance WHERE Staff_ID=?";
			
			pStatement=connection.prepareStatement(trSql);
			pStatement.setString(1, sid);
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
			String sql="SELECT * FROM attendance WHERE Staff_ID=? ORDER BY ID DESC limit ?,?";		
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, sid);
			pStatement.setInt(2, (currentPage-1)*pageSize);
			pStatement.setInt(3, pageSize);
			
			resultSet=pStatement.executeQuery();
			
			/*
			 * 从结果集中得到数据， 并封装到Staff对象中
			 */
			if (resultSet==null) {
				return null;
			}
			
			List<Attendence> list=new ArrayList<Attendence>();
			while (resultSet.next()) {
				Attendence attendence=new Attendence();
				attendence.setId(resultSet.getInt("ID"));
				attendence.setSid(resultSet.getString("Staff_ID"));
				attendence.setSname(resultSet.getString("Staff_Name"));
				attendence.setClorktime(resultSet.getString("clorkTime"));
				attendence.setState(resultSet.getString("state"));
				attendence.setTime(resultSet.getString("pounchTime"));
				attendence.setUpdateTime(resultSet.getString("update_Time"));
				attendence.setRemark(resultSet.getString("Remark"));
				list.add(attendence);
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
	 * 根据员工ID修改
	 * @param i
	 */
	public void SupplementAtten(int i) {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="UPDATE attendance SET Remark=? WHERE ID=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, "申请补签");
			pStatement.setInt(2, i);
			
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
	 * 根据备注查询
	 */
	public List<Attendence> findByRemark() {
		try {
			/*
			 * 1、获取数据库连接
			 */
			connection = JDBCUtils.getConnection();
			/*
			 * 2、创建执行SQL语句的preparedStatement对象
			 */
			String sql="SELECT * FROM attendance WHERE Remark=?";
			pStatement=connection.prepareStatement(sql);
			/*
			 * 3、为SQL语句中的参数赋值
			 */
			pStatement.setString(1, "申请补签");			
			
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
			List<Attendence> list = new ArrayList<Attendence>();
			while (resultSet.next()) {
				Attendence att= new Attendence();
				att.setId(resultSet.getInt("ID"));
				att.setSid(resultSet.getString("Staff_ID"));
				att.setSname(resultSet.getString("Staff_Name"));
				att.setClorktime(resultSet.getString("clorkTime"));
				att.setState(resultSet.getString("state"));
				att.setTime(resultSet.getString("pounchTime"));
				att.setUpdateTime(resultSet.getString("update_Time"));
				att.setRemark(resultSet.getString("Remark"));
				list.add(att);
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
