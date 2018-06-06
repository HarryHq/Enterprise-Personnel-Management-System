<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库备份与还原</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-container">
		<fieldset class="layui-elem-field layui-field-title">
  			<legend>系统备份与还原</legend>
		</fieldset>
     		<a href="${pageContext.request.contextPath}/BackupServlet?name=backup"><button class="layui-btn">备份数据库</button></a>
     		<a href="${pageContext.request.contextPath}/BackupServlet?name=restore"><button class="layui-btn">还原数据库</button></a>
     <div style="padding: 20px; background-color: #F2F2F2;">
			  <div class="layui-row layui-col-space15">
			    <div class="layui-col-md12">
			      <div class="layui-card">
			        <div class="layui-card-header">还原说明</div>
			        <div class="layui-card-body">
			        	<p>请把要还原的文件命名为：backup.sql，并把文件存放在 C:/data_copy/ 目录下</p>
			        	<h1>${msg}</h1>
			        </div>
			      </div>
			    </div>
			  </div>
		</div>
</body>
</html>