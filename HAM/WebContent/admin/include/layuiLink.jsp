<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/layui/css/layui.css'></c:url>" />
  <script src="<c:url value='/layui/layui.js'></c:url>"></script> 
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
}); 
</script>
<script type="text/javascript" defer="defer" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>

</body>
</html>