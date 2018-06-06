<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>人事管理系统员工段</title>
 <%@ include file="../admin/include/layuiLink.jsp" %>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.staffSession }" >
		<%request.setAttribute("errMsg", "请先进行登录再进行后续操作哦！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		%>
	<%--  <c:redirect url="/index.jsp"/>		 --%>
	</c:when>
	<c:otherwise>
	
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">人事管理系统</div>
    <!-- 头部区域 -->
    <ul class="layui-nav layui-layout-left">
<!--       <li class="layui-nav-item"><a href="kqqd.jsp" target="content">考勤签到</a></li>
      <li class="layui-nav-item"><a href="salaryselect.jsp" target="content">工资明细查询</a></li> -->
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">员工：
          ${sessionScope.staffSession.sname}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="${pageContext.request.contextPath }/admin/editAdmin.jsp" target="content">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath }/LogoutServlet">注销</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
            <!-- 左侧导航区域  -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
         <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><i class="layui-icon">&#xe627;</i> 考勤管理</a>
          <dl class="layui-nav-child">
          	<!-- <dd><a href="javascript:;" target="content">考勤更改申请审批</a></dd> -->
            <dd><a href="kqqd.jsp" target="content">考勤签到</a></dd>
            <dd><a href="${pageContext.request.contextPath}/ListStaffAttenServlet?sid=${sessionScope.staffSession.sid}" target="content">我的签到</a></dd>
            <!-- <dd><a href="javascript:;" target="content">添加考勤</a></dd> -->
          </dl>
        </li>
         <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><i class="layui-icon">&#xe65e;</i> 工资管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/ListStaffSalaryServlet?sid=${sessionScope.staffSession.sid}" target="content">工资明细查询</a></dd>
            <!-- <dd><a href="javascript:;" target="content">工资修改</a></dd> -->
            <!-- <dd><a href="" target="content">工资计算定义</a></dd> -->
            <!-- <dd><a href="" target="content">工资表Excel导出</a></dd> -->
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
			<iframe class="iframe" name=content src="kqqd.jsp" width=100% height=820px  frameborder="no"></iframe>
		</div>	
	</div>
</div> 
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © Copyright 2018 by 黄一倚
  </div>
</div>

</c:otherwise>
</c:choose>

</body>
</html>