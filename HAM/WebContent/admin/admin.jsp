<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>后台管理系统</title>
 <%@ include file="./include/layuiLink.jsp" %>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.adSession }" >
	<%request.setAttribute("errMsg", "请先进行登录再进行后续操作哦！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		%>
		<%-- <c:redirect url="/index.jsp"/> --%>
	</c:when>
	<c:otherwise>	
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">人事管理系统</div>
    <!-- 头部区域 -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="welcome.jsp" target="content">欢迎界面</a></li>
    </ul>
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">管理员：
          ${sessionScope.adSession.aname}
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
        <li class="layui-nav-item">
          <a class="" href="javascript:;"><i class="layui-icon layui-icon-user"></i> 员工管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/admin/addStaff.jsp" target="content">员工入职</a></dd>
<%--             <dd><a href="${pageContext.request.contextPath }/admin/resignStaff.jsp" target="content">老员工离职</a></dd> --%>
            <dd><a href="${pageContext.request.contextPath }/ListStaffServlet" target="content">所有员工</a></dd>
            <dd><a href="${pageContext.request.contextPath }/admin/queryStaff.jsp" target="content">查询员工</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;"><i class="layui-icon">&#xe627;</i> 部门管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/admin/addDept.jsp" target="content">添加部门</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ListDeptServlet" target="content">所有部门</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;"><i class="layui-icon">&#xe627;</i> 考勤管理</a>
          <dl class="layui-nav-child">
          	<!-- <dd><a href="javascript:;" target="content">考勤更改申请审批</a></dd> -->
            <dd><a href="${pageContext.request.contextPath }/ListAttenServlet" target="content">考勤查询/更改</a></dd>
            <dd><a href="${pageContext.request.contextPath }/AttenVerifyServlet" target="content">补签审核</a></dd>
            <!-- <dd><a href="javascript:;" target="content">添加考勤</a></dd> -->
          </dl>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;"><i class="layui-icon">&#xe65e;</i> 工资管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/querySalaryServlet"target="content">工资明细查询/修改</a></dd>
            <!-- <dd><a href="javascript:;" target="content">工资修改</a></dd> -->
            <!-- <dd><a href="" target="content">工资计算定义</a></dd> -->
            <!-- <dd><a href="" target="content">工资表Excel导出</a></dd> -->
          </dl>
        </li>
        
          <li class="layui-nav-item">
          <a href="javascript:;"><i class="layui-icon">&#xe65e;</i>报表管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/admin/createExcel.jsp"target="content">生成报表</a></dd>
            <!-- <dd><a href="javascript:;" target="content">工资修改</a></dd> -->
            <!-- <dd><a href="" target="content">工资计算定义</a></dd> -->
            <!-- <dd><a href="" target="content">工资表Excel导出</a></dd> -->
          </dl>
        </li>
        
         <li class="layui-nav-item">
          <a href="javascript:;"><i class="layui-icon layui-icon-set"></i> 系统管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/admin/addAdmin.jsp" target="content">添加管理员</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ListAdminServlet" target="content">管理员查询/修改</a></dd>
            <dd><a href="${pageContext.request.contextPath }/admin/databaseBackup.jsp" target="content">数据库备份/恢复</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
<!-- 	<div >
    	<iframe class="iframe" name=content src="welcome.jsp" width=100% height=800px frameborder="no"></iframe>
    </div> -->
    			<div class="layui-row layui-col-space15">
				<div class="layui-col-md9">
					<iframe class="iframe" name=content src="welcome.jsp" width=100% height=800px frameborder="no"></iframe>
				</div>

				<div class="layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">快捷方式</div>
						<div class="layui-card-body">
							<div class="layui-carousel layadmin-carousel layadmin-shortcut">
								<div class="carousel-item">
									<ul class="layui-row layui-col-space10">
									
										<li class="layui-col-xs3">
											<a href="${pageContext.request.contextPath }/admin/addStaff.jsp" target="content"> 
												<i class="layui-icon layui-icon-user"></i>
												<cite>员工入职</cite> 
											</a>
										</li>
										
										<li class="layui-col-xs3">
											<a href="${pageContext.request.contextPath }/admin/queryStaff.jsp" target="content">
												<i class="layui-icon">&#xe612;</i> 
												<cite>查询员工</cite>
											</a>
										</li>
										 
										<li class="layui-col-xs3">
											<a href="${pageContext.request.contextPath }/ListAttenServlet" target="content">
											    <i class="layui-icon">&#xe627;</i>
											    <cite>考勤查询</cite>
											</a>
										</li>
										
										<li class="layui-col-xs3">
											<a href="${pageContext.request.contextPath }/querySalaryServlet"target="content" target="content">
												<i class="layui-icon">&#xe65e;</i> 
												<cite>工资明细</cite>												
											</a>
										</li>		
									</ul>
								</div>
							</div>

						</div>
					</div>

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