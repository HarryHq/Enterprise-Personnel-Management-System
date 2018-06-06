<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>补签审核</title>
<%@ include file="/admin/include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">
	<table  class="layui-table">
		<thead>
			<tr>
				<td>员工编号</td>
				<td>员工姓名</td>
				<td>上班时间</td>
				<td>状态</td>
				<td>打卡时间</td>
				<td>更新时间</td>
				<td>备注</td>
				<td>操作</td>			
			</tr>
		</thead>
	<c:forEach items="${requestScope.list}" var="atten">
		<tr>
			    <td>${atten.sid}</td>
				<td>${atten.sname}</td>
				<td>${atten.clorktime}</td>
				<td>${atten.state}</td>
				<td>${atten.time}</td>
				<td>${atten.updateTime}</td>
				<td>${atten.remark}</td>
				<td><a href="${pageContext.request.contextPath}/PreEditAttenServlet?id=${atten.id}"><button class="layui-btn layui-btn-sm">编辑</button></a>
				</td>				
		</tr>
		</c:forEach>
</table>
	

</body>
</html>