<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤查询</title>
<%@ include file="/admin/include/layuiLink.jsp" %>
</head>
<body class="layui-fluid">	

<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>员工编号</th>
      <th>员工姓名</th>
      <th>上/下班时间标准</th>
	  <th>状态</th>
	  <th>打卡时间</th>
	  <th>更新时间</th>
	  <th>备注</th>
	  <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  	<c:forEach items="${requestScope.pageBean.beanList}" var="atten">
		<tr>
			    <td>${atten.sid}</td>
				<td>${atten.sname}</td>
				<td>${atten.clorktime}</td>
				<td>${atten.state}</td>
				<td>${atten.time}</td>
				<td>${atten.updateTime}</td>
				<td>${atten.remark}</td>
				<td>
					<a href="${pageContext.request.contextPath}/SupplementServlet?id=${atten.id}&sid=${atten.sid}"><button class="layui-btn layui-btn-sm">申请补签</button></a>
				</td>				
		</tr>
	</c:forEach>		
   </tbody>		
   </table>
   <center>
	  <div class="layui-btn-group ">
	  	  <button class="layui-btn">
	        	第${pageBean.currentPage }页 /共${pageBean.totalPages}页
	      </button>
		  
		  	<a href="${pageContext.request.contextPath}/ListStaffAttenServlet?currentPage=1&sid=${sessionScope.staffSession.sid}"><button class="layui-btn">首页 </button></a>
		 
		  <c:if test="${pageBean.currentPage>1}">
				<a class="layui-btn"  href="${pageContext.request.contextPath}/ListStaffAttenServlet?currentPage=${pageBean.currentPage-1}&sid=${sessionScope.staffSession.sid}"><button class="layui-btn">上一页</button></a>
		  </c:if>
		  <c:if test="${pageBean.currentPage<pageBean.totalPages}">
				<a class="layui-btn" href="${pageContext.request.contextPath}/ListStaffAttenServlet?currentPage=${pageBean.currentPage+1}&sid=${sessionScope.staffSession.sid}"><button class="layui-btn">下一页</button></a>
		  </c:if>
		  <a href="${pageContext.request.contextPath}/ListStaffAttenServlet?currentPage=${pageBean.totalPages}&sid=${sessionScope.staffSession.sid}"><button class="layui-btn">尾页</button></a>
	  </div>
  </center>
</body>
</html>