<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工入职</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-container">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>员工入职</legend>
	</fieldset>
   <!-- <h1>员工入职</h1> -->
   <p style="color: red; font-weight: 900" >${errMsg }</p>
   <form class="layui-form" action="${pageContext.request.contextPath}/AddStaffServlet" method="post">

  				<div class="layui-form-item">
				    <label class="layui-form-label">员工编号</label>
    				<div class="layui-input-block">
      				<input type="text" name="Staff_ID"  placeholder="请输入员工编号" autocomplete="off" class="layui-input"><p style="color: red; font-weight: 900" >${errors.staff_id }</p>
    				</div>
  				</div>
  				
   				 <div class="layui-form-item">
				    <label class="layui-form-label">姓名</label>
    				<div class="layui-input-block">
      				<input type="text" name="Staff_Name"  placeholder="请输入姓名" autocomplete="off" class="layui-input">
    				</div>
  				</div>
   				 <div class="layui-form-item">
				    <label class="layui-form-label">密码</label>
    				<div class="layui-input-block">
      				<input type="text" name="Password"  placeholder="请输入密码" autocomplete="off" class="layui-input">
    				</div>
  				</div> 				
   				 <div class="layui-form-item">
				    <label class="layui-form-label">性别</label>
    				<div class="layui-input-block">
      				<input type="text" name="Staff_Sex"  placeholder="请输入性别" autocomplete="off" class="layui-input">
    				</div>
  				</div> 	
  					
				 <div class="layui-form-item">
      				<label class="layui-form-label">生日</label>
    				<div class="layui-input-block">
        			<input type="text" name="Staff_Birthday"  onfocus="WdatePicker()"  placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      				</div>
    			</div>	
    					
   				 <div class="layui-form-item">
				    <label class="layui-form-label">民族</label>
    				<div class="layui-input-block">
      				<input type="text" name="Staff_Stirps"  placeholder="请输入民族" autocomplete="off" class="layui-input">
    				</div>
  				</div> 	
  				   				
   				<div class="layui-form-item">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_ID_number"  placeholder="请输入身份证号" autocomplete="off" class="layui-input">
					</div>
				</div>
				
   				<div class="layui-form-item">
					<label class="layui-form-label">籍贯</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Native_Place"  placeholder="请输入籍贯" autocomplete="off" class="layui-input">
					</div>
				</div>   				
   				<div class="layui-form-item">
					<label class="layui-form-label">学历</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Education"  placeholder="请输入学历" autocomplete="off" class="layui-input">
					</div>
				</div>  
	  
   				<div class="layui-form-item">
					<label class="layui-form-label">专业</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Major"  placeholder="请输入专业" autocomplete="off" class="layui-input">
					</div>
				</div> 
				    				
   				<div class="layui-form-item">
					<label class="layui-form-label">电话</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Tel"  placeholder="请输入电话" autocomplete="off" class="layui-input">
					</div>
				</div>    
				 		   				
   				<div class="layui-form-item">
					<label class="layui-form-label">邮件</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Email"  placeholder="请输入邮件" autocomplete="off" class="layui-input">
					</div>
				</div>  
				
   				<div class="layui-form-item">
					<label class="layui-form-label">部门</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Department"  placeholder="请输入部门" autocomplete="off" class="layui-input">
					</div>
				</div>   
				  				
   				<div class="layui-form-item">
					<label class="layui-form-label">职务</label>
					<div class="layui-input-block">
					<input type="text" name="Staff_Role" placeholder="请输入职务"  autocomplete="off" class="layui-input">
					</div>
				</div>  
				   				
				 <div class="layui-form-item">
      				<label class="layui-form-label">入职日期</label>
    				<div class="layui-input-block">
        			<input type="text" name="Work_HireDate" id="date" onfocus="WdatePicker()"  placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      				</div>
    			</div>  
    			   				
				<div class="layui-form-item" >
				    <label class="layui-form-label">用工形式</label>
				    <div class="layui-input-block">
					    <select name="Work_Type">
					        <option value=""></option>
					        <option value="正式合同工">正式合同工</option>
					        <option value="实习生">实习生</option>
					        <option value="兼职">兼职</option>
					        <option value="试用期合同工">试用期合同工</option>
					        <option value="外聘">外聘</option>
				    	</select>
				    </div>
				</div> 				  	
				  				
   				<div class="layui-form-item">
					<label class="layui-form-label">银行卡号</label>
					<div class="layui-input-block">
					<input type="text" name="Work_BankCard"  placeholder="请输入银行卡号" autocomplete="off" class="layui-input">
					</div>
				</div>        				
				 <div class="layui-form-item">
      				<label class="layui-form-label">合同开始</label>
    				<div class="layui-input-block">
        			<input type="text" name="Work_Begin" id="date" onfocus="WdatePicker()"  placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      				</div>
    			</div>   				
				 <div class="layui-form-item">
      				<label class="layui-form-label">合同结束</label>
    				<div class="layui-input-block">
        			<input type="text" name="Work_End" id="date" onfocus="WdatePicker()"  placeholder="2099-12-31" autocomplete="off" class="layui-input" value="2099-12-31">
      				</div>
    			</div>     				
				 <div class="layui-form-item">
      				<label class="layui-form-label">离职日期</label>
    				<div class="layui-input-block">
        			<input type="text" name="Work_TermDate" id="date" onfocus="WdatePicker()" placeholder="2099-12-31" autocomplete="off" class="layui-input" value="2099-12-31">
      				</div>
    			</div>     				
   				<div class="layui-form-item">
					<label class="layui-form-label">离职原因</label>
					<div class="layui-input-block">
					<input type="text" name="Work_TermReason"   placeholder="请输入离职原因" autocomplete="off" class="layui-input" value="在职">
					</div>
				</div>        				
   				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<input type="text" name="Remark"  placeholder="请输入备注" autocomplete="off" class="layui-input" value="在职"/>
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