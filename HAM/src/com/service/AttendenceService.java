package com.service;

import java.util.List;

import com.dao.AttendenceDao;
import com.entity.Attendence;
import com.entity.PageBean;
import com.entity.Salary;

public class AttendenceService {
	AttendenceDao dao = new AttendenceDao();

	/**
	 * 打卡功能
	 * @param attendence
	 * @param sid 
	 */
	public void pounchClork(Attendence attendence, String sid,String state) {
		dao.add(attendence,sid,state);
	}

	/**
	 * 查询所有打卡信息
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Attendence> listAtten(int currentPage, int pageSize) {
		return dao.findAll(currentPage,pageSize);
	}

	/**
	 * 加载出勤信息
	 * @param sid
	 * @return
	 */
	public Attendence load(String sid) {
		return dao.findById(sid);
	}

	/**
	 * 更新出勤信息
	 * @param attendence
	 */
	public void update(Attendence attendence) {
		dao.update(attendence);
	}

	/**
	 * 员工查询出勤
	 * @param currentPage
	 * @param pageSize
	 * @param sid
	 * @return
	 */
	public PageBean<Attendence> listStaffAtten(int currentPage, int pageSize, String sid) {
		return dao.findById(currentPage,pageSize,sid);
	}

	/**
	 * 员工补签申请
	 * @param i
	 */
	public void Supplement(int i) {
		dao.SupplementAtten(i);
	}

	/**
	 * 审核补签
	 */
	public List<Attendence> verifyAtten() {
		return dao.findByRemark();
	}


}
