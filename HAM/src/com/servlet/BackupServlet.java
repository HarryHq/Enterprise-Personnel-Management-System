package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Backup;
import com.utils.ResultSetToExcel;

/**
 * Servlet implementation class BackupServlet
 */
@WebServlet("/BackupServlet")
public class BackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		if (name.equals("backup")) {
			Backup.backup();
			String msString = "数据库备份成功，请到" + ResultSetToExcel.path + "目录下查看！";
			request.setAttribute("msg", msString);
			request.getRequestDispatcher("/admin/databaseBackup.jsp").forward(request, response);
		}
		/*
		 * 生成工资报表
		 */
		if (name.equals("restore")) {
			Backup.restore("ham");
			String msString = "数据库还原成功，请到" + ResultSetToExcel.path + "目录下查看！";
			request.setAttribute("msg", msString);
			request.getRequestDispatcher("/admin/databaseBackup.jsp").forward(request, response);
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
