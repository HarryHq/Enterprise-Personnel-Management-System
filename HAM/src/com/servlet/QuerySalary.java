package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.PageBean;
import com.entity.Salary;
import com.service.SalaryService;

/**
 * 查询员工的工资
 *
 */
@WebServlet("/querySalaryServlet")
public class QuerySalary extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SalaryService salaryService = new SalaryService();
		PageBean<Salary> pageBean = salaryService.querySalary(getPc(req), 10);
		req.setAttribute("pageBean", pageBean);
		// System.out.println(pageBean.getBeanList().size());
		req.getRequestDispatcher("/admin/querySalary.jsp").forward(req, resp);
	}

	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("currentPage");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
