package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Administrator;
import com.service.AdminException;
import com.service.AdminService;
import com.utils.CommonUtils;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService adminService = new AdminService();

		Administrator admin = CommonUtils.toBean(request.getParameterMap(), Administrator.class);

		Map<String, String> errors = new HashMap<String, String>();

		if (admin.getAid() == null || admin.getAid().trim().isEmpty()) {
			errors.put("adId", "管理编号不能为空");
		}

		if (errors != null && errors.size() > 0) {
			/*
			 * 1、保存errors到request域 2、保存user到request域，为了回显 3、转发到register.jsp
			 */
			request.setAttribute("errors", errors);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/addAdmin.jsp").forward(request, response);
			return;
		}

		try {
			adminService.add(admin);
			request.getRequestDispatcher("/ListAdminServlet").forward(request, response);
		} catch (AdminException e) {
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/addAdmin.jsp").forward(request, response);
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
