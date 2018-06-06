package com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Staff;
import com.service.StaffException;
import com.service.StaffService;
import com.utils.DateUtils;

/**
 * Servlet implementation class AddStaffServlet
 */
@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStaffServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StaffService service = new StaffService();

		Staff staff = new Staff();
		staff.setPassword(request.getParameter("Password"));
		staff.setSid(request.getParameter("Staff_ID"));
		staff.setSname(request.getParameter("Staff_Name"));
		staff.setSex(request.getParameter("Staff_Sex"));
		Date Birthday = DateUtils.toUtilDate(request.getParameter("Staff_Birthday"));
		staff.setBirthday(Birthday);
		staff.setStirps(request.getParameter("Staff_Stirps"));
		staff.setIdNumber(request.getParameter("Staff_ID_number"));
		staff.setNativePlace(request.getParameter("Staff_Native_Place"));
		staff.setEducation(request.getParameter("Staff_Education"));
		staff.setMajor(request.getParameter("Staff_Major"));
		staff.setCellphone(request.getParameter("Staff_Tel"));
		staff.setEmail(request.getParameter("Staff_Email"));
		staff.setDepartment(request.getParameter("Staff_Department"));
		staff.setRole(request.getParameter("Staff_Role"));
		Date HireDate = DateUtils.toUtilDate(request.getParameter("Work_HireDate"));
		staff.setHireDate(HireDate);
		staff.setWorkType(request.getParameter("Work_Type"));
		staff.setBankCard(request.getParameter("Work_BankCard"));
		Date Begin = DateUtils.toUtilDate(request.getParameter("Work_Begin"));
		staff.setWorkBegin(Begin);
		Date End = DateUtils.toUtilDate(request.getParameter("Work_End"));
		staff.setWorkEnd(End);
		Date TermDate = DateUtils.toUtilDate(request.getParameter("Work_TermDate"));
		staff.setTermDate(TermDate);
		staff.setTermReason(request.getParameter("Work_TermReason"));
		staff.set_remark(request.getParameter("Remark"));
		Map<String, String> errors = new HashMap<String, String>();

		String staff_id = staff.getSid();
		if (staff_id == null || staff_id.trim().isEmpty()) {
			errors.put("staff_id", "员工编号不能为空");
		}

		if (errors != null && errors.size() > 0) {
			/*
			 * 1、保存errors到request域 2、保存user到request域，为了回显 3、转发到register.jsp
			 */
			request.setAttribute("errors", errors);
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/admin/addStaff.jsp").forward(request, response);
			return;
		}

		try {
			service.addStaff(staff);
			request.getRequestDispatcher("/ListStaffServlet").forward(request, response);
		} catch (StaffException e) {
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/admin/addStaff.jsp").forward(request, response);
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
