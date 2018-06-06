package com.service;

import java.util.List;

import com.dao.SalaryDao;
import com.entity.PageBean;
import com.entity.Salary;

/**
 * 工资service层
 * @author Autopassion
 *
 */
public class SalaryService {
	SalaryDao salaryDao=new SalaryDao();
	//查询所有的员工工资
	public PageBean<Salary> querySalary(int currentPage,int pageSize){
		return salaryDao.queryAll(currentPage,pageSize);
		
	}

	/**
	 * 加载工资信息
	 * @param id
	 * @return
	 */
	public Salary load(String id) {
		return salaryDao.findById(id);
	}

	/**
	 * 编辑工资信息
	 * @param salary
	 */
	public void edit(Salary salary) {
		salaryDao.update(salary);
	}


	/**
	 * 列出一个员工的工资情况
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Salary> liststaffsalary(int currentPage, int pageSize,String sid) {
		return salaryDao.listSalaryById(currentPage,pageSize,sid);
	}

}
