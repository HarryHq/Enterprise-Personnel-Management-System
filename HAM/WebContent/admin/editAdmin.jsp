<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询管理员</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-container">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>更新管理员</legend>
	</fieldset>
	 <form  class="layui-form" action="${pageContext.request.contextPath}/EditAdminServlet" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">管理ID</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="aid" value="${admin.aid }"/><p style="color: red; font-weight: 900" >${errors.adid }</p>
					</div>
				</div> 
   				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="aname" value="${admin.aname }"/>
					</div>
				</div> 
   				<div class="layui-form-item">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="apassword" value="${admin.apassword }"/>
					</div>
				</div> 
   				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="remark"value="${admin.remark }"/>
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