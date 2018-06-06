package com.service;

import java.util.List;

import com.dao.StaffDao;
import com.entity.PageBean;
import com.entity.Staff;

public class StaffService {
	StaffDao staffDao = new StaffDao();

	/**
	 * 员工入职
	 * 
	 * @param staff
	 * @throws StaffException
	 */
	public void addStaff(Staff staff) throws StaffException {
		Staff _Staff = staffDao.findById(staff.getSid());
		if (_Staff != null) {
			throw new StaffException("员工：" + staff.getSid() + "已经存在！");
		}
		staffDao.add(staff);

	}

	/**
	 * 显示所有员工信息
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Staff> listStaff(int currentPage, int pageSize) {

		return staffDao.findAll(currentPage, pageSize);
	}

	/**
	 * 加载员工信息
	 * 
	 * @param sid
	 * @return
	 */
	public Staff load(String sid) {
		return staffDao.findById(sid);
	}

	/**
	 * 编辑员工信息
	 * 
	 * @param staff
	 */
	public void edit(Staff staff) {
		staffDao.update(staff);
	}

	/**
	 * 删除员工信息
	 * 
	 * @param id
	 */
	public void delete(String id) {
		staffDao.delete(id);
	}

	/**
	 * 根据条件查询员工信息
	 * 
	 * @param staff
	 * @return
	 */
	public List<Staff> query(Staff staff) {
		return staffDao.query(staff);
	}

	/**
	 * 登录功能
	 * 
	 * @param staff
	 * @return
	 * @throws StaffException
	 */
	public Staff login(Staff staff) throws StaffException {
		/*
		 * 1、使用userForm中的username进行查询，得到User user
		 */
		Staff staff2 = staffDao.findById(staff.getSid());
		/*
		 * 2、如果返回为null，说明用户名不存在，抛出异常，异常信息为”用户名不存在“
		 */
		if (staff2 == null) {
			throw new StaffException("用户名不存在！");
		}
		/*
		 * 3、比较user和userForm的password，如果不同，抛出异常，异常信息为”密码错误“
		 */
		if (!staff2.getPassword().trim().equals(staff.getPassword().trim())) {
			throw new StaffException("密码错误");
		}
		/*
		 * 4、 返回数据库中查询出来的User，而不是userForm， 因为userForm中只有用户名和密码，而user是用户所有信息
		 */
		return staff2;
	}

}
