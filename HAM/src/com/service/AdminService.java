package com.service;

import java.util.List;

import com.dao.AdminDao;
import com.entity.Administrator;
import com.entity.Staff;

public class AdminService {
	AdminDao adminDao = new AdminDao();
	
	/**
	 * 添加管理员
	 * @param admin
	 * @throws AdminException 
	 */
	public void add(Administrator admin) throws AdminException {
		Administrator administrator = adminDao.findById(admin.getAid());
		if (administrator!=null) {
			throw new AdminException("员工："+admin.getAid()+"已经存在！");
		}
		adminDao.add(admin);
	}

	public List<Administrator> findAll() {
		return adminDao.findAll();
	}


	/**
	 * 登录功能
	 * @param ad
	 * @return
	 * @throws AdminException 
	 */
	public Administrator login(Administrator ad) throws AdminException {
		/*
		 * 1、使用userForm中的username进行查询，得到User user
		 */
		Administrator administrator = adminDao.findById(ad.getAid());
		/*
		 * 2、如果返回为null，说明用户名不存在，抛出异常，异常信息为”用户名不存在“
		 */
		if (administrator == null) {
			throw new AdminException("管理id不存在！");
		}
		/*
		 * 3、比较user和userForm的password，如果不同，抛出异常，异常信息为”密码错误“
		 */
		if (!administrator.getApassword().equals(ad.getApassword())) {
			throw new AdminException("密码错误");
		}
		/*
		 * 4、 返回数据库中查询出来的User，而不是userForm， 因为userForm中只有用户名和密码，而user是用户所有信息
		 */
		return administrator;
	}

	/**
	 * 加载管理员信息
	 * @param aid
	 * @return
	 */
	public Administrator load(String aid) {
		return adminDao.findById(aid);
	}

	/**
	 * 删除管理员
	 * @param id
	 */
	public void delete(String id) {
		adminDao.delete(id);
	}

	/**
	 * 更新管理员
	 * @param admin
	 */
	public void update(Administrator admin) {
		adminDao.update(admin);
	}

}
