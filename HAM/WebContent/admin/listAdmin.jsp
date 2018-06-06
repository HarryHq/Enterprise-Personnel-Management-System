<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有管理员</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>所有管理员</legend>
	</fieldset>
<table  class="layui-table">
		<thead>
			<tr>
				<td>管理编号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>备注</td>
				<td>操作</td>				
			</tr>
		</thead>
	<c:forEach items="${requestScope.list}" var="admin">
		<tr>
			    <td>${admin.aid}</td>
				<td>${admin.aname}</td>
				<td>${admin.apassword}</td>
				<td>${admin.remark}</td>
				<td><a href="${pageContext.request.contextPath}/PreEditAdServlet?aid=${admin.aid}"><button class="layui-btn layui-btn-sm">编辑</button></a>
					<a href="${pageContext.request.contextPath}/DelAdServlet?aid=${admin.aid}"><button class="layui-btn layui-btn-sm">删除</button></a>
				</td>				
		</tr>
		</c:forEach>
</table>

</body>
</html>