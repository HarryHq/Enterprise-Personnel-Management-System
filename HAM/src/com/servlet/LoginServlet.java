package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Administrator;
import com.entity.Staff;
import com.service.AdminException;
import com.service.AdminService;
import com.service.StaffException;
import com.service.StaffService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identify = request.getParameter("identify");
		request.getSession().invalidate();

		/*
		 * 管理员登录处理
		 */
		if (identify.equals("admin")) {
			Administrator ad = new Administrator();
			ad.setAid(request.getParameter("username"));
			ad.setApassword(request.getParameter("password"));
			AdminService service = new AdminService();
			try {
				Administrator admin = service.login(ad);
				request.getSession().setAttribute("adSession", admin);
				response.sendRedirect(request.getContextPath() + "/admin/admin.jsp");
			} catch (AdminException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.setAttribute("ad", ad);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		/*
		 * 员工登录处理
		 */
		if (identify.equals("staff")) {
			Staff staff = new Staff();
			staff.setSid(request.getParameter("username"));
			staff.setPassword(request.getParameter("password"));
			StaffService service = new StaffService();
			try {
				Staff staff2 = service.login(staff);
				request.getSession().setAttribute("staffSession", staff2);
				response.sendRedirect(request.getContextPath() + "/index/home.jsp");
			} catch (StaffException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.setAttribute("staff", staff);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}

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
