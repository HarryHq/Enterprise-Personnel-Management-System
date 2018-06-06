<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有部门</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>所有部门</legend>
	</fieldset>
<!-- <h1>所有部门</h1> -->
<table  class="layui-table">
		<thead>
			<tr>
			<td>部门编号</td>
				<td>部门名称</td>
				<td>部门经理</td>
				<td>经理电话</td>
				<td>备注</td>
				<td>操作</td>	
								
			</tr>
		</thead>
	<c:forEach items="${requestScope.list}" var="dept">
		<tr>
			    <td>${dept.did}</td>
				<td>${dept.dname}</td>
				<td>${dept.dmanager}</td>
				<td>${dept.dmPhone}</td>
				<td>${dept.remark}</td>
				<td><a href="${pageContext.request.contextPath}/PreEditDeptServlet?did=${dept.did}"><button class="layui-btn layui-btn-sm">编辑</button></a>
					<a href="${pageContext.request.contextPath}/DelDeptServlet?did=${dept.did}"><button class="layui-btn layui-btn-sm">删除</button></a>
				</td>				
		</tr>
		</c:forEach>
</table>

</body>
</html>