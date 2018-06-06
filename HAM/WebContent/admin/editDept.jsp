<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑部门</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-container">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>更新部门</legend>
	</fieldset>
	<p style="color: red; font-weight: 900" >${errMsg }</p>
   <form  class="layui-form" action="${pageContext.request.contextPath}/EditDeptServlet" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">部门编号</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="did" readonly="readonly" value="${requestScope.dept.did }"/><p style="color: red; font-weight: 900" >${errors.adid }</p>
					</div>
				</div>      			
   				<div class="layui-form-item">
					<label class="layui-form-label">部门名称</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="dname" lay-verify="required" value="${requestScope.dept.dname }"/>
					</div>
				</div>   
   				<div class="layui-form-item">
					<label class="layui-form-label">部门经理</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="dmanager" lay-verify="required" value="${requestScope.dept.dmanager }"/>
					</div>
				</div>   
   				<div class="layui-form-item">
					<label class="layui-form-label">经理电话</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="dmPhone" lay-verify="required" value="${requestScope.dept.dmPhone }"/>
					</div>
				</div>   
   				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="remark"value="${requestScope.dept.remark }"/>
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