<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>考勤签到</title>
		<style type="text/css">
			body {
				margin: 0;
				background: #eeeeee;			
			}
			.title{
				text-align: center;
				font-size: 3em;	
			}
			.body{
				text-align: left;
				margin-left: 42%;			
			}
			.btnclass{				
				text-align: center;
			}
			.btnclass .btn{
				width: 80px;
				height: 50px;
				font-size: 1.5em;
			}
		</style>
	</head>
<script>
	function link(){
	
		if(form1.checkdate.value == ''){
			alert('考勤日期不能为空！');
			return false;
		}
 
		form1.action="/gz/innerCheckinAdd.action";
		form1.submit();
	}
	
	</script>
	<body>
		<div class="title">
			<a>考勤补签申请<br></a>
		</div>
		<div class="body">
			<tr>
				<td>申请日期：</td>
				<td><input type="date" name="Request_Date"/></td>
			</tr><br />
			<tr>
				<td>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
				<td><input type="text" name="Staff_ID"/></td>
			</tr><br />
			<tr>
				<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
				<td><input type="text" name="Staff_Name"/></td>
			</tr><br />
			<tr>
				<td>考勤日期：</td>
				<td><input type="date" name="Attendance_Date"/></td>
			</tr><br />
			<tr>
				<td>考勤类型：</td>
				<td>					
					<select name="Attendance_Type"> 
            	 		<option value="">----请选择----</option>
           	 			<option value="正常">正常</option>
                		<option value="迟到">迟到</option>
                		<option value="早退">早退</option>
                		<option value="旷工">旷工</option>
                		<option value="出差">出差</option>
                		<option value="病假">病假</option>
                		<option value="事假">事假</option>
                		<option value="加班">加班</option>
                		<option value="假期">假期</option>
             	   </select>
				</td>
			</tr><br />
			<tr>
				<td>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</td><br />
				<td><textarea rows="8" cols="40"></textarea></td>
			</tr><br />
		</div>
		<div class="btnclass">
			<button class="btn">提交</button>
		</div>
	</body>
</html>
