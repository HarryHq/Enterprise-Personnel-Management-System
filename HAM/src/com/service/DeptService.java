package com.service;

import java.util.List;

import com.dao.DeptDao;
import com.entity.Department;

public class DeptService {
	DeptDao dao = new DeptDao();

	/**
	 * 添加部门
	 * @param department
	 * @throws ErrorException
	 */
	public void add(Department department) throws ErrorException {
		Department dep= dao.findById(department.getDid());
		if (dep != null) {
			throw new ErrorException("该部门已经存在");
		}
		dao.add(department);		
	}

	/**
	 * 查找全部部门信息
	 * @return
	 */
	public List<Department> findAll() {
		
		return dao.findAll();
	}

	/**
	 * 加载部门信息
	 * @param deptid
	 * @return
	 */
	public Department load(String deptid) {
		return dao.findById(deptid);
	}

	/**
	 * 删除部门
	 * @param id
	 */
	public void delete(String id) {
		dao.delete(id);
	}

	/**
	 * 编辑部门
	 * @param department
	 */
	public void edit(Department department) {
		dao.update(department);
	}


}
