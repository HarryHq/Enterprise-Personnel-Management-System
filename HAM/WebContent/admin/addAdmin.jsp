<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>添加管理员</legend>
	</fieldset>
	<!-- <h1>添加管理员</h1> -->
   <p style="color: red; font-weight: 900" >${errMsg }</p>
   <form class="layui-form" action="${pageContext.request.contextPath}/AddAdminServlet" method="post">
   				<div class="layui-form-item">
					<label class="layui-form-label">管理ID</label>
					<div class="layui-input-block">
					<input type="text" name="aid" lay-verify="required" placeholder="请输入管理ID" autocomplete="off" class="layui-input">
					</div>
				</div>    				
   				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
					<input type="text" name="aname" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
					</div>
				</div>    	   				
   				<div class="layui-form-item">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-block">
					<input type="text" name="apassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
					</div>
				</div>      				
   				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
					<input type="text" name="remark" placeholder="请输入备注" autocomplete="off" class="layui-input">
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