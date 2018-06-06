<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息查询</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>查询员工</legend>
	</fieldset>
	<!-- <h1>查询员工</h1> -->
	<form class="layui-form" action="${pageContext.request.contextPath}/QueryStaffServlet" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">员工编号</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_ID" lay-verify="title" autocomplete="off" placeholder="请输入员工编号" class="layui-input">
					</div>
				</div>   				
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Name" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Sex" lay-verify="title" autocomplete="off" placeholder="请输入性别" class="layui-input">
					</div>
				</div>       				
				<div class="layui-form-item">
					<label class="layui-form-label">电话</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Tel" lay-verify="title" autocomplete="off" placeholder="请输入电话" class="layui-input">
					</div>
				</div>     				
				<div class="layui-form-item">
					<label class="layui-form-label">邮件</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Email" lay-verify="title" autocomplete="off" placeholder="请输入邮件" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
					 <div class="layui-btn-group ">
					    <button class="layui-btn"  lay-submit="" >提交</button>
					    <button class="layui-btn " type="reset" class="layui-btn layui-btn-primary">重置</button>
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