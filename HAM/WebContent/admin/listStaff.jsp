<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有员工</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body>
<h1>所有员工</h1>
	<table  class="layui-table">
		<thead>
			<tr>
				<td>员工编号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>生日</td>
				<td>民族</td>
				<td>身份证</td>
				<td>籍贯</td>				
				<td>学历</td>
				<td>专业</td>
				<td>手机号</td>
				<td>邮箱</td>
				<td>部门</td>
				<td>职务</td>
				<td>入职日期</td>
				<td>用工形式</td>
				<td>银行卡号</td>
				<td>合同开始</td>
				<td>合同结束</td>
				<td>离职日期</td>
				<td>离职原因</td>
				<td>备注</td>
				<td>操作</td>				
			</tr>
		</thead>
	<c:forEach items="${requestScope.pageBean.beanList}" var="staff">
		<tr>
			    <td>${staff.sid}</td>
				<td>${staff.sname}</td>
				<td>${staff.password}</td>
				<td>${staff.sex}</td>
				<td>${staff.birthday}</td>
				<td>${staff.stirps}</td>
				<td>${staff.idNumber}</td>
				<td>${staff.nativePlace}</td>
				<td>${staff.education}</td>
				<td>${staff.major}</td>
				<td>${staff.cellphone}</td>
				<td>${staff.email}</td>
				<td>${staff.department}</td>
				<td>${staff.role}</td>
				<td>${staff.hireDate}</td>
				<td>${staff.workType}</td>
				<td>${staff.bankCard}</td>
				<td>${staff.workBegin}</td>
				<td>${staff.workEnd}</td>
				<td>${staff.termDate}</td>
				<td>${staff.termReason}</td>
				<td>${staff._remark}</td>
				<td><a href="${pageContext.request.contextPath}/PreEditServlet?sid=${staff.sid}"><button class="layui-btn layui-btn-sm">编辑</button></a>
					<a href="${pageContext.request.contextPath}/DleteStaffServlet?sid=${staff.sid}"><button class="layui-btn layui-btn-sm">删除</button></a>
				</td>				
		</tr>
		</c:forEach>
	</table>
		<center>
			<button class="layui-btn">
			第${pageBean.currentPage }页 /共${pageBean.totalPages}页
			</button>
			<a href="${pageContext.request.contextPath}/ListStaffServlet?currentPage=1"><button class="layui-btn">首页</button></a>
			<c:if test="${pageBean.currentPage>1}">
				<a href="${pageContext.request.contextPath}/ListStaffServlet?currentPage=${pageBean.currentPage-1}"><button class="layui-btn">上一页</button></a>
			</c:if>
			<c:if test="${pageBean.currentPage<pageBean.totalPages}">
				<a href="${pageContext.request.contextPath}/ListStaffServlet?currentPage=${pageBean.currentPage+1}"><button class="layui-btn">下一页</button></a>
			</c:if>
			<a href="${pageContext.request.contextPath}/ListStaffServlet?currentPage=${pageBean.totalPages}"><button class="layui-btn">尾页</button></a>		
		</center>

</body>
</html>