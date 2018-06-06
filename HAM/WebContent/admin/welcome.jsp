<%@ page language="java" import="java.util.* " pageEncoding="UTF-8" import="com.utils.SystemInfo"%>
<html>
	<head>
		<meta charset="{CHARSET}">
		<title>welcome</title>
		<style type="text/css">
			body {
				margin: 0;
				background: #eeeeee;			
			}
			.title{
				text-align: center;
				font-size: 3em;	
			}
		</style>
		<%@ include file="./include/layuiLink.jsp" %>
		<% SystemInfo sys=SystemInfo.getInstance(); %>
	</head>
	<body class="layui-container">
		<div class="title" style="padding: 15px;">
			<a>欢迎使用人事管理系统<br></a>
		</div>	
		<div style="padding: 20px; background-color: #F2F2F2;">
			  <div class="layui-row layui-col-space15">
			    <div class="layui-col-md6">
			      <div class="layui-card">
			        <div class="layui-card-header">当前管理员</div>
			        <div class="layui-card-body">
			        	 <h1>${sessionScope.adSession.aname}</h1>
			        </div>
			      </div>
			    </div>
			    <div class="layui-col-md6">
			      <div class="layui-card">
			        <div class="layui-card-header">当前时间</div>
			        <div class="layui-card-body">
			        	<h1>
			        		<div id="timeShow" ></div>
			        	</h1>
			        </div>
			      </div>
			    </div>
			    <div class="layui-col-md12">
			      <div class="layui-card">
			        <div class="layui-card-header">当前系统运行环境信息</div>
			        <div class="layui-card-body">
			        	 <table class="layui-table">
							    <colgroup>
							      <col width="250">
							      <col>
							    </colgroup>
							    <tbody>
							      <tr>
							        <td>计算机名称</td>
							        <td><%=sys.getSystemName() %></td>
							      </tr>
							       <tr>
							        <td>IP地址</td>
							        <td><%=sys.getIP() %></td>
							      </tr>
							       <tr>
							        <td>Mac地址</td>
							        <td><%=sys.getMac() %></td>
							      </tr>
							       <tr>
							        <td>服务器版本</td>
							        <td>Apache Tomcat v8.5</td>
							      </tr>
							      <tr>
							        <td>java运行版本</td>
							        <td>jdk<%=sys.getJavaVersion() %></td>
							      </tr>
							      <tr>
							        <td>数据库版本</td>
							        <td>5.5.56 MySQL Community Server (GPL)</td>
							      </tr>
							    </tbody>
						  </table>
			        </div>
			      </div>
			    </div>
			  </div>
		</div>
		
	<script type="text/javascript">
     var t = null;
    t = setTimeout(time,1000);//开始执行
    function time()
    {
        clearTimeout(t);//清除定时器
        dt = new Date();
		var y=dt.getYear()+1900;
		var mm=dt.getMonth()+1;
		var d=dt.getDate();
		var weekday=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
		var day=dt.getDay();
       	var h=dt.getHours();
       	var m=dt.getMinutes();
       	var s=dt.getSeconds();
		if(h<10){h="0"+h;}
		if(m<10){m="0"+m;}
		if(s<10){s="0"+s;}
       	 document.getElementById("timeShow").innerHTML = y+"年"+mm+"月"+d+"日"+" "
       	 +weekday[day]+" "+h+":"+m+":"+s+"";
       	t = setTimeout(time,1000); //设定定时器，循环执行           
    }
  </script>
	</body>
</html>
