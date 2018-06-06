<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>考勤签到</title>
		<style type="text/css">
			body {
				margin: 0;
				background: #eeeeee;			
			}
			.title{
				text-align: center;
				font-size: 3em;	
			}
			.body{
				text-align: center;			
			}
			.body .btn{
				margin: 80px;
				width: 400px;
				height: 200px;
				font-size: 3em;
			}
		</style>
		<%@ include file="../admin/include/layuiLink.jsp" %>
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title">
  			<legend>考勤签到</legend>
		</fieldset>
<!-- 		<div class="title">
			<a>考勤签到<br></a>
		</div> -->
		<div class="body">
		<c:if test="${sessionScope.staffSession.state == 'out' }">
				<a href="${pageContext.request.contextPath}/PounchClorkServlet?clork=in&sid=${sessionScope.staffSession.sid}&sname=${sessionScope.staffSession.sname}"><button class="btn">上班打卡</button></a>
				</c:if>
				<c:if test="${sessionScope.staffSession.state == 'on' }">
				<a href="${pageContext.request.contextPath}/PounchClorkServlet?clork=out&sid=${sessionScope.staffSession.sid}&sname=${sessionScope.staffSession.sname}"><button class="btn">下班打卡</button></a>
		</c:if>
		</div>
	</body>
</html>
