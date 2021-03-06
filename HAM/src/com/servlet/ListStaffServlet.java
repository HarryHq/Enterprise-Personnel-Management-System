package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.PageBean;
import com.entity.Staff;
import com.service.StaffService;

/**
 * Servlet implementation class ListStaffServlet
 */
@WebServlet("/ListStaffServlet")
public class ListStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListStaffServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = getPc(request); // 得到当前页
		int pageSize = 10; // 设定每行记录数

		StaffService service = new StaffService();
		PageBean<Staff> pageBean = service.listStaff(currentPage, pageSize);

		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/admin/listStaff.jsp").forward(request, response);
	}

	/**
	 * 获取当前页 currentPage
	 * 
	 * @param request
	 * @return
	 */
	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("currentPage");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
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
