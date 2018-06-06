<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新员工信息</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body  class="layui-container">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>更新员工信息</legend>
	</fieldset>
   <p style="color: red; font-weight: 900" >${errMsg }</p>
   <form  class="layui-form" action="${pageContext.request.contextPath}/EditStaffServlet" method="post">
   		<div class="layui-form-item">
			<label class="layui-form-label">员工编号</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_ID" readonly="readonly" value="${staff.sid }"/><p style="color: red; font-weight: 900" >${errors.staff_id }</p>
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Name" value="${staff.sname }"/>
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Password" value="${staff.password }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Sex" value="${staff.sex }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">生日</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" onfocus="WdatePicker()" name="Staff_Birthday"value="${staff.birthday }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">民族</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Stirps"value="${staff.stirps }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">身份证号</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_ID_number"value="${staff.idNumber }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">籍贯</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Native_Place" value="${staff.nativePlace }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学历</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Education"value="${staff.education }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">专业</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Major"value="${staff.major }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Tel"value="${staff.cellphone }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮件</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Email"value="${staff.email }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">部门</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Department"value="${staff.department }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">职务</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Staff_Role"value="${staff.role }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">入职日期</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" onfocus="WdatePicker()" name="Work_HireDate"value="${staff.hireDate }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用工形式</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Work_Type"value="${staff.workType }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">银行卡号</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Work_BankCard"value="${staff.bankCard }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">合同开始</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" onfocus="WdatePicker()" name="Work_Begin"value="${staff.workBegin }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">合同结束</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" onfocus="WdatePicker()" name="Work_End"value="${staff.workEnd }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">离职日期</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" onfocus="WdatePicker()" name="Work_TermDate"value="${staff.termDate }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">离职原因</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Work_TermReason"value="${staff.termReason }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input class="layui-input" type="text" name="Remark"value="${staff._remark }"/>
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