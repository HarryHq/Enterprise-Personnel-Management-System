<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>前台页面</title>
		<style type="text/css">
			body {
				margin: 0;
				background: #eeeeee;			
			}
			/*头部style*/
			.head{				
				width: 100%;
				height: 75px;
				background: black;
				opacity: 0.75;
				position: relative;				
				text-align: center;
				padding-top: 15px;
				padding-bottom: 10px;
			}
			.logo{
				width: 300px;
			}
			.bar{
				position: absolute;
				width: 100%;
				bottom: 5px;
				font-family:"微软雅黑";				
			}
			.nav{
				width: 80%;
				margin: 0 auto 0 auto;
				margin:auto;
				min-width: 500px;
			}
			.nav a:hover{
				color: white;
			}
			.nav a{
				color: darkgray;
				margin: 5%;
				text-decoration: none;	
			}			
			.boundary{
				max-width: 65%;
				min-width: 800px;
				margin: 0 auto;
			}
			/*中部信息*/
			.iframe{
				width: 100%;
				height: 100%;
			}
			
			/*底部信息*/
			.foot{
				position: relative;
				background: #e0e0e0;
				width: 100%;
				padding-top: 10px;
				padding-bottom: 10px;
				overflow: hidden;
				text-align: left;				
			}
			.foot .boundary .foot_Left{
				position: relative;
				height: 100px;
				margin-top: 10px;
				margin-bottom: 10px;
				margin-left: calc(50% - 220px);
				margin-right: 5px;
				float: left;
			}
			.foot .boundary .line{
				position: relative;
				width: 2px;
				height: 120px;
				background: #bbbbbb;
				float: left;
			}
			.foot .boundary .foot_Right{
				margin-left: 10px;
				position: relative;
				float:left;
			}
			.foot .boundary .foot_Right .contact{
				position: relative;
				text-shadow: 1px 1px 1px white;
				color: #666666;
				font-family: "微软雅黑";
				font-size: 0.8em;
			}
			.foot .boundary .foot_Right .contact p{
				line-height:12px
			}
		</style>
	</head>

	<body>
	<c:choose>
		<c:when test="${empty sessionScope.staffSession }" >
			请先<h1><a href="${pageContext.request.contextPath }/index.jsp">登录</a></h1>，谢谢配合
		</c:when>
	<c:otherwise>
		<!--头部导航栏-->
		<div class="head_wrap">	
			<div class="head">
			<div class="logo">人事管理系统</div>
				<div class="bar">
					<div class="nav">
						<a href=kqqd.jsp target=content>考勤签到</a>
						<a href=salaryselect.jsp target=content>查询工资明细</a>
						<a href="kqbqsq.jsp" target=content>考勤补签申请</a>
					</div>
				</div>
			</div>
		</div>
		<!-- 中部 -->
		<div>
			<a>工号：${sessionScope.staffSession.sid}</a>
			<a></a>
			<a>&nbsp;&nbsp;&nbsp;</a>
			<a>姓名：${sessionScope.staffSession.sname}</a>
			<a></a>				
		</div>
		<iframe class="iframe" name=content frameborder="0" src="kqqd.jsp"></iframe>
		<!--底部-->
		<div class="foot">
			<div class="boundary">
				<div class="foot_Left">
					<div class="contact_logo">
						<img src="images/footer_logo.png" alt="图片加载失败">
					</div>
				</div>
				<div class="line"></div>
				<div class="foot_Right">
					<div class="contact">
							<p>HAM | 工资管理系统</p>
							<p>上海市浦东新区金海路2360号</p>
							<p>TEL : 12345678</p>
							<p>Email : sspu@example.com</p>
					</div>
				</div>
			</div>
		</div>
		</c:otherwise>
</c:choose>
	</body>
</html>
