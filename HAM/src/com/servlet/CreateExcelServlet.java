package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.ResultSetToExcel;

/**
 * Servlet implementation class CreateExcelServlet
 */
@WebServlet("/CreateExcelServlet")
public class CreateExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		/*
		 * 生成考勤报表
		 */
		if (name.equals("atten")) {
			String fileName = "员工考勤情况";// 文件名，不带路径，不带.xls后缀
			String[] coloumItems = { "行号", "员工编号", "员工姓名", "上班时间", "状态", "打卡时间", "更新时间", "备注", "操作" };
			String sql = "SELECT * FROM attendance";
			// 开始写表格
			ResultSetToExcel.writeExcel(fileName, coloumItems, sql);
			String msString = "报表已成功导出，请到" + ResultSetToExcel.path + "目录下查看！";
			request.setAttribute("msg", msString);
			request.getRequestDispatcher("/admin/createExcel.jsp").forward(request, response);
		}
		/*
		 * 生成工资报表
		 */
		if (name.equals("salary")) {
			String fileName = "员工工资报表";// 文件名，不带路径，不带.xls后缀
			String[] coloumItems = { "行号", "员工编号", "员工姓名", "本次工资年份", "本次工资月份", "基本薪资", "加班补贴", "奖金", "交通补贴", "餐补",
					"出差补贴", "浮动工资", "应发工资", "缺勤扣款", "罚金", "个人所得税", "住房公积金", "养老保险", "失业保险", "医疗保险", "工伤保险", "生育保险",
					"实际扣款合计", "实发工资", "备注" };
			String sql = "SELECT * FROM salary";
			// 开始写表格
			ResultSetToExcel.writeExcel(fileName, coloumItems, sql);
			String msString = "报表已成功导出，请到" + ResultSetToExcel.path + "目录下查看！";
			request.setAttribute("msg", msString);
			request.getRequestDispatcher("/admin/createExcel.jsp").forward(request, response);
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
