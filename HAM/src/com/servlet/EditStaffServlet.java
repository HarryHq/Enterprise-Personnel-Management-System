package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Staff;
import com.service.StaffService;
import com.utils.DateUtils;

/**
 * Servlet implementation class EditStaffServlet
 */
@WebServlet("/EditStaffServlet")
public class EditStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditStaffServlet() {
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

		service.edit(staff);
		request.getRequestDispatcher("/ListStaffServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
