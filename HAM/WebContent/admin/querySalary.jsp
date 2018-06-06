<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>工资明细的查询与修改</title>
<%@ include file="/admin/include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">
	<table  class="layui-table">
		<thead>
			<tr>
				<td>序号</td>
				<td>员工ID</td>
				<td>员工姓名</td>	
				<td>本次工资年份</td>
				<td>本次工资月份</td>	
				<td>基本薪资</td>	
				<td>加班补贴</td>	
				<td>奖金</td>	
				<td>交通补贴</td>	
				<td>餐补</td>	
				<td>出差补贴</td>	
				<td>浮动工资</td>	
				<td>应发工资</td>	
				<td>缺勤扣款</td>	
				<td>罚金</td>	
				<td>个人所得税</td>	
				<td>住房公积金</td>	
				<td>养老保险</td>	
				<td>失业保险</td>	
				<td>医疗保险</td>	
				<td>工伤保险</td>	
				<td>生育保险</td>	
				<td>实际扣款合计</td>	
				<td>实发工资</td>	
				<td>备注</td>	
				<td>操作</td>		
			</tr>
		</thead>
	<c:forEach items="${requestScope.pageBean.beanList}" var="salary">
		<tr>
			    <td>${salary.id}</td>
				<td>${salary.staffId}</td>
				<td>${salary.staffName}</td>
				<td>${salary.salary_year}</td>
				<td>${salary.salary_month}</td>
 				<td>${salary.basic_salary}</td>
				<td>${salary.overtime_pay}</td>
				<td>${salary.bonus}</td>
				<td>${salary.traffic_Allowance}</td>
				<td>${salary.meal_Allowance}</td>
				<td>${salary.business_Travel_Allowance}</td>
				<td>${salary.monthly_Supplement_Salary}</td>
				<td>${salary.salary_Should_Pay}</td>
				<td>${salary.absence}</td>
				<td>${salary.forfeit}</td>
				<td>${salary.individual_Income_Tax}</td>
				<td>${salary.house_Accumulation_Fund}</td>
				<td>${salary.endowment_Insurance}</td>
				<td>${salary.unemployment_Insurance}</td>
				<td>${salary.medical_Insurance}</td>
				<td>${salary.injury_Insurance}</td>
				<td>${salary.childbirth_Insurance}</td>
				<td>${salary.cut_Payment_Summation}</td>
				<td>${salary.actual_Salary}</td>
				<td>${salary.remark}</td>
				<td><a href="${pageContext.request.contextPath}/PreEditSalryServlet?id=${salary.id}"><button class="layui-btn layui-btn-sm">编辑</button></a></td>				
		</tr>
	</c:forEach>
</table>
		<center>
			<button class="layui-btn">
				第${pageBean.currentPage }页 /共${pageBean.totalPages}页
			</button>
			<a href="${pageContext.request.contextPath}/querySalaryServlet?currentPage=1"><button class="layui-btn">首页</button></a>
			<c:if test="${pageBean.currentPage>1}">
				<a href="${pageContext.request.contextPath}/querySalaryServlet?currentPage=${pageBean.currentPage-1}"><button class="layui-btn">上一页</button></a>
			</c:if>
			<c:if test="${pageBean.currentPage<pageBean.totalPages}">
				<a href="${pageContext.request.contextPath}/querySalaryServlet?currentPage=${pageBean.currentPage+1}"><button class="layui-btn">下一页</button></a>
			</c:if>
			<a href="${pageContext.request.contextPath}/querySalaryServlet?currentPage=${pageBean.totalPages}"><button class="layui-btn">尾页</button></a>		
		</center>

</body>
</html>