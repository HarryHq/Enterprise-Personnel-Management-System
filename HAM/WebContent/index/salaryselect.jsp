<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>员工工资查询/修改</title>
		<style type="text/css">
			body {
				margin: 0;
				background: #eeeeee;			
			}
			.btn{
				text-align: center;
			}
		</style>
		<%@ include file="../admin/include/layuiLink.jsp" %>
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title">
  			<legend>工资明细查询</legend>
		</fieldset>
<%@ page import="java.sql.*"%>
<%--查询表中指定员工号的数据--%>
<%!public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	//指定数据库服务器地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/ham";
	//指定用户名
	public static final String DBUSER = "root";
	//指定密码
	public static final String DBPASS = "1234";
	%>
	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	%>
	<%
	try	{
	%>
	<%
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		String sql = "SELECT * FROM salary WHERE Staff_ID ='000001'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
	%>
		<table id="subtree1" style="display: ;" width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="80%" border="0" align="center" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20"></td>
						</tr>
						<tr>
							<td height="20">
								<table width="100%" border="0" cellspacing="1" cellpadding="4" class="newfont03">
								<tr>
										<th height="22" colspan="11" align="center" style="font-size: 30px">工资明细表</th>
								</tr>
								<%
									while (rs.next()){
									String Staff_ID = rs.getString(2);
									String Staff_Name = rs.getString(3);
									double Basic_Salary = rs.getDouble(6);
									double Overtime_Pay = rs.getDouble(7);
									double Bonus = rs.getDouble(8);
									double Traffic_Allowance = rs.getDouble(9);
									double Meal_Allowance = rs.getDouble(10);
									double Business_Travel_Allowance = rs.getDouble(11);
									double Monthly_Supplement_Salary = rs.getDouble(12);
									double Salary_Should_Pay = rs.getDouble(13);
									double Absence = rs.getDouble(14);
									double Forfeit = rs.getDouble(15);
									double Individual_Income_Tax = rs.getDouble(16);
									double House_Accumulation_Fund = rs.getDouble(17);
									double Endowment_Insurance = rs.getDouble(18);
									double Unemployment_Insurance = rs.getDouble(19);
									double Medical_Insurance = rs.getDouble(20);
									double Injury_Insurance = rs.getDouble(21);
									double Childbirth_Insurance = rs.getDouble(22);
									double Cut_Payment_Summation = rs.getDouble(23);
									double Actual_Salary = rs.getDouble(24);									
									%>
									<tr bgcolor="greenyellow">
										<td width="10%" align="center" height="50">工号</td>
										<td width="10%"align="center">姓名</td>
                						<td width="9%" align="center">基础工资</td>
                						<td width="9%" align="center">加班工资</td>
                						<td width="9%" align="center">奖金</td>
                						<td width="9%" align="center">交通补助</td>
                						<td width="9%" align="center">餐费补助</td>
                						<td width="9%" align="center">出差补助</td>
                						<td width="9%" align="center">补发工资</td>
                						<td width="9%" align="center">应发工资</td>
        							</tr>
        					       	<tr bgcolor="#FFFFFF">
				  						<td height="30" align="center"><%=Staff_ID%></td>
               						    <td align="center"><%=Staff_Name%></td>
               					    	<td align="center"><%=Basic_Salary%></td>
              					    	<td align="center"><%=Overtime_Pay%></td>
              					    	<td align="center"><%=Bonus%></td>
              					    	<td align="center"><%=Traffic_Allowance%></td>
              					    	<td align="center"><%=Meal_Allowance%></td>
              					    	<td align="center"><%=Business_Travel_Allowance%></td>
              					    	<td align="center"><%=Monthly_Supplement_Salary%></td>
              					    	<td align="center"><%=Salary_Should_Pay%></td>										
               					   	</tr>
									<tr bgcolor="orange">
                						<td align="center" height="50">缺勤扣款</td>
                						<td align="center">罚金</td>
                						<td align="center">个人所得税</td>
                						<td align="center">住房公积金</td>
                						<td align="center">养老保险</td>
                						<td align="center">失业保险</td>
                						<td align="center">医疗保险</td>
                						<td align="center">工伤保险<br>(个人缴纳部分)</td>
                						<td align="center">生育保险<br>(个人缴纳部分)</td>
                						<td align="center">扣款合计</td>                					
        							</tr>        							
        							<tr bgcolor="#FFFFFF">
				  						<td height="30" align="center"><%=Absence%></td>
               						    <td align="center"><%=Forfeit%></td>
               						    <td align="center"><%=Individual_Income_Tax%></td>               						    
               						    <td align="center"><%=House_Accumulation_Fund%></td>
               						    <td align="center"><%=Endowment_Insurance%></td>
               						    <td align="center"><%=Unemployment_Insurance%></td>
               						    <td align="center"><%=Medical_Insurance%></td>
               						    <td align="center"><%=Injury_Insurance%></td>
               						    <td align="center"><%=Childbirth_Insurance%></td>
               						    <td align="center"><%=Cut_Payment_Summation%></td>											
               					   	</tr>
           					    	<tr bgcolor="#AAAAAA">
           					    		<td align="center">实发工资</td>
        							</tr>
   							        <tr bgcolor="#FFFFFF">
				  						<td height="30" align="center"><%=Actual_Salary%></td>											
               					   	</tr>
               					   	<%
               					   		}
               					   	%>
								</table>
								<%
									} catch (Exception e){
									System.out.println(e);								
									} finally {
								%>
								<%
 									if(rs != null)rs.close() ;
 									if(pstmt != null)pstmt.close() ;
									if(conn != null)conn.close() ;  
								%>
								<%
									}
								%>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
