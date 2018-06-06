package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Attendence;
import com.service.AttendenceService;
import com.utils.DateUtils;

/**
 * Servlet implementation class PounchClorkServlet
 */
@WebServlet("/PounchClorkServlet")
public class PounchClorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PounchClorkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AttendenceService service = new AttendenceService();
		// StaffService staffService = new StaffService();

		String sid = request.getParameter("sid");
		// Staff staff = staffService.load(sid);
		String sname = request.getParameter("sname");
		Attendence attendence = new Attendence();
		attendence.setSid(sid);
		attendence.setSname(sname);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String pounch = request.getParameter("clork");
		if (pounch.equals("in")) { // 上班打卡
			Date inTime = DateUtils.setClork(9, 0, 0); // 设定上班时间为9点
			attendence.setClorktime(sdf.format(inTime));
			Date pounchTime = new Date();
			attendence.setTime(sdf.format(pounchTime));// 设置上班打卡时间
			if (inTime.before(pounchTime)) {
				attendence.setState("上班迟到");
			} else {
				attendence.setState("上班正常");
			}
			String state = "on";
			service.pounchClork(attendence, sid, state);
			request.getRequestDispatcher("/ListStaffAttenServlet?sid=" + sid).forward(request, response);
		}

		if (pounch.equals("out")) { // 下班打卡
			Date outTime = DateUtils.setClork(18, 30, 0); // 下班时间
			attendence.setClorktime(sdf.format(outTime));
			Date pounchTime = new Date();
			attendence.setTime(sdf.format(pounchTime));
			if (outTime.before(pounchTime)) {
				attendence.setState("正常下班");
			} else {
				attendence.setState("早退下班");
			}
			String state = "out";
			service.pounchClork(attendence, sid, state);
			// request.setAttribute("state", state);
			request.getRequestDispatcher("/ListStaffAttenServlet?sid=" + sid).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
