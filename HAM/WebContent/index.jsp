<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>首页登录</title>
		<%@ include file="./admin/include/layuiLink.jsp" %>
		<style type="text/css">
			body {
				margin: 0;
				background: #eeeeee;			
			}
			
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
				width: 400px;
			}
			
			.login_body{
				position: relative;
				padding-top: 130px;
				padding-bottom: 180px;
				padding-left: 500px;
			}
			.login_body .login{
				position: relative;
				float: left;
				text-align: center;
			}
			
			.login_body .login .text {
				font-family:"Microsoft Yahei";
				font-size: 1em;
				padding-top: 250px;
			}
			
			.foot{
				position: relative;
				background: #e0e0e0;
				width: 100%;
				padding-top: 5px;
				padding-bottom: 5px;
				overflow: hidden;
				text-align: left;	
				margin-top: 100px;
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
				font-family: "Microsoft Yahei";
				font-size: 1em;
			}
			.foot .boundary .foot_Right .contact p{
				line-height:22px
			}
		</style>
	</head>

	<body>
		<div class="head_wrap">	
			<div class="head">
				<h1 style="color: white;">欢迎使用人事管理系统</h1>
			</div>
		</div>
	
		<div class="login_body">
			<div class="login">	
			<p style="color: red; font-weight: 900" >${errMsg }</p>
			<form class="layui-form" method="post" action="${pageContext.request.contextPath }/LoginServlet">	
						    	
					<div class="layui-form-item" >
				    <label class="layui-form-label">我是</label>
				    <div class="layui-input-block">
					    <select name="identify">
					        <option value=""></option>
					        <option value="staff">员工</option>
						    <option value="admin">管理员</option>
				    	</select>
				    </div>
				</div> 		
				    <div class="layui-form-item">
						<label class="layui-form-label">用户ID</label>
						<div class="layui-input-block">
								<input class="layui-input" type="text" name="username" value="${staff.sid }" />
						</div>
					</div>  
				    <div class="layui-form-item">
						<label class="layui-form-label">用户密码</label>
						<div class="layui-input-block">
								<input class="layui-input" type="password" name="password" value="${staff.password }" />
						</div>
					</div> 
					 
					<div class="layui-form-item">
						<div class="layui-input-block">
						 <div class="layui-btn-group ">
						    <button class="layui-btn"  lay-submit="" >提交</button>
						    <button class="layui-btn " type="reset" class="layui-btn  layui-btn-danger">重置</button>
						  </div>
				   </div>
			   </div>       		
						
				</form>
			</div>
		</div>
		
		<div class="foot">
		
			<div class="boundary">
				<div class="foot_Left">
					<div class="contact_logo">
						<img src="images/footer_logo.png" alt="LOGO">
					</div>
					
				</div>
				<div class="line"></div>
				<div class="foot_Right">
					<div class="contact">
							<p>HAM | 上海第二工业大学</p>
							<p>POWER BY 黄一倚</p>
							<p>TEL : 12345678</p>
							<p>Email : sspu@example.com</p>
					</div>
				</div>
			</div>
		</div>
		  <script>
	//Demo
	layui.use('form', function(){
	  var form = layui.form;
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	});
</script>
	</body>
</html>
