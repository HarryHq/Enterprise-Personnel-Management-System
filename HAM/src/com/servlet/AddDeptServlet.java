package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Department;
import com.service.DeptService;
import com.service.ErrorException;
import com.utils.CommonUtils;

/**
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService service = new DeptService();

		Department department = CommonUtils.toBean(request.getParameterMap(), Department.class);
		Map<String, String> errors = new HashMap<String, String>();

		if (department.getDid() == null || department.getDid().trim().isEmpty()) {
			errors.put("depid", "部门编号不能为空");
		}

		if (errors != null && errors.size() > 0) {
			/*
			 * 1、保存errors到request域 2、保存user到request域，为了回显 3、转发到register.jsp
			 */
			request.setAttribute("errors", errors);
			request.setAttribute("department", department);
			request.getRequestDispatcher("/admin/addDept.jsp").forward(request, response);
			return;
		}

		try {
			service.add(department);
			request.getRequestDispatcher("/ListDeptServlet").forward(request, response);
		} catch (ErrorException e) {
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("department", department);
			request.getRequestDispatcher("/admin/addDept.jsp").forward(request, response);
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
