package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Staff;
import com.service.StaffService;

/**
 * Servlet implementation class QueryStaffServlet
 */
@WebServlet("/QueryStaffServlet")
public class QueryStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStaffServlet() {
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
		staff.setCellphone(request.getParameter("Staff_Tel"));
		staff.setEmail(request.getParameter("Staff_Email"));

		List<Staff> list = service.query(staff);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/listQuery.jsp").forward(request, response);
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
