<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑工资</title>
<%@ include file="./include/layuiLink.jsp" %>
</head>
<body class="layui-container">
	<fieldset class="layui-elem-field layui-field-title">
  		<legend>更新工资</legend>
	</fieldset>
	<form  class="layui-form" action="${pageContext.request.contextPath}/EditSalaryServlet" method="post">
				<input type="text" hidden="hidden" name="id" value="${salary.id }"/>
				<div class="layui-form-item">
					<label class="layui-form-label">员工ID</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="staffId" value="${salary.staffId }"/><p style="color: red; font-weight: 900" >${errors.adid }</p>
					</div>
				</div> 
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="staffName" value="${salary.staffName }"/>
					</div>
				</div> 
				<div class="layui-form-item">
					<label class="layui-form-label">本次工资年份</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="salary_year" value="${salary.salary_year }"/>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">本次工资月份</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="salary_month"value="${salary.salary_month }"/>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">基本薪资</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="basic_salary"value="${salary.basic_salary }"/>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">加班补贴</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="overtime_pay"value="${salary.overtime_pay }"/>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">奖金</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="bonus"value="${salary.bonus }"/>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">交通补贴</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="traffic_Allowance"value="${salary.traffic_Allowance }"/>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">餐补</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="meal_Allowance"value="${salary.meal_Allowance }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">出差补贴</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="business_Travel_Allowance"value="${salary.business_Travel_Allowance }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">浮动工资</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="monthly_Supplement_Salary"value="${salary.monthly_Supplement_Salary }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">应发工资</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="salary_Should_Pay"value="${salary.salary_Should_Pay }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">缺勤扣款</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="absence"value="${salary.absence }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">罚金</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="forfeit"value="${salary.forfeit }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">个人所得税</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="individual_Income_Tax"value="${salary.individual_Income_Tax }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">住房公积金</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="house_Accumulation_Fund"value="${salary.house_Accumulation_Fund }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">养老保险</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="endowment_Insurance"value="${salary.endowment_Insurance }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">失业保险</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="unemployment_Insurance"value="${salary.unemployment_Insurance }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">医疗保险</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="medical_Insurance"value="${salary.medical_Insurance }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">工伤保险</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="injury_Insurance"value="${salary.medical_Insurance }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">生育保险</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="childbirth_Insurance"value="${salary.childbirth_Insurance }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">实际扣款合计</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="cut_Payment_Summation"value="${salary.cut_Payment_Summation }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">实发工资</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="actual_Salary"value="${salary.actual_Salary }"/>
					</div>
				</div>
   				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<input class="layui-input" type="text" name="remark"value="${salary.remark }"/>
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