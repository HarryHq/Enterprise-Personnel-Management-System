<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成报表</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-container">
		<fieldset class="layui-elem-field layui-field-title">
  			<legend>生成报表</legend>
		</fieldset>
     <div style="padding: 20px; background-color: #F2F2F2;">
			  <div class="layui-row layui-col-space15">
			    <div class="layui-col-md12">
			      <div class="layui-card">
			      	<div class="layui-card-header">
			     		<a href="${pageContext.request.contextPath}/CreateExcelServlet?name=atten"><button class="layui-btn">生成考勤报表</button></a>
			     		<a href="${pageContext.request.contextPath}/CreateExcelServlet?name=salary"><button class="layui-btn">生成工资报表</button></a>
			      	</div>
			        <div class="layui-card-body">
			        	<h2>${msg}</h2>
			        </div>
			      </div>
			    </div>
			  </div>
		</div>

</body>
</html>