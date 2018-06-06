<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加部门</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>添加部门</legend>
	</fieldset>
	<!-- <h1>添加部门</h1> -->
   <p style="color: red; font-weight: 900" >${errMsg }</p>
   <form class="layui-form" action="${pageContext.request.contextPath}/AddDeptServlet" method="post">
  				<div class="layui-form-item">
				    <label class="layui-form-label">部门编号</label>
    				<div class="layui-input-block">
      				<input type="text" name="did" lay-verify="required" placeholder="请输入部门编号" autocomplete="off" class="layui-input">
    				</div>
  				</div>   				
  				<div class="layui-form-item">
				    <label class="layui-form-label">部门名称</label>
    				<div class="layui-input-block">
      				<input type="text" name="dname" lay-verify="required" placeholder="请输入部门名称" autocomplete="off" class="layui-input">
    				</div>
  				</div>     				
  				<div class="layui-form-item">
				    <label class="layui-form-label">部门经理</label>
    				<div class="layui-input-block">
      				<input type="text" name="dmanager" lay-verify="required" placeholder="请输入部门经理" autocomplete="off" class="layui-input">
    				</div>
  				</div>     	   			
  				<div class="layui-form-item">
				    <label class="layui-form-label">经理电话</label>
    				<div class="layui-input-block">
      				<input type="text" name="dmPhone" lay-verify="required" placeholder="请输入经理电话" autocomplete="off" class="layui-input">
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