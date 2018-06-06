<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新考勤</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-container">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>更新考勤</legend>
	</fieldset>
	<p style="color: red; font-weight: 900" >${errMsg }</p>
   <form  class="layui-form" action="${pageContext.request.contextPath}/EditAttenServlet" method="post">
   				<input type="text" name="id" readonly="readonly" hidden="hidden" value="${requestScope.atten.id }"/>
   				<div class="layui-form-item">
					<label class="layui-form-label">员工编号</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="sid" readonly="readonly" value="${requestScope.atten.sid }"/><p style="color: red; font-weight: 900" >${errors.adid }</p>
					</div>
				</div>  
   				<div class="layui-form-item">
					<label class="layui-form-label">员工姓名</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="sname" value="${requestScope.atten.sname }"/>
					</div>
				</div>  
   				<div class="layui-form-item">
					<label class="layui-form-label">上班时间</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="clorktime" value="${requestScope.atten.clorktime }"/>
					</div>
				</div>  
   				<div class="layui-form-item">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="state" value="${requestScope.atten.state }"/>
					</div>
				</div>  
   				<div class="layui-form-item">
					<label class="layui-form-label">打卡时间</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="time" value="${requestScope.atten.time }"/>
					</div>
				</div>  
   				<div class="layui-form-item">
					<label class="layui-form-label">更新时间</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="updateTime" value="${requestScope.atten.updateTime }"/>
					</div>
				</div>  
   				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="remark"value="${requestScope.atten.remark }"/>
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