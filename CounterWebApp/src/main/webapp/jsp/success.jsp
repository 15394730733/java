<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功页</title>
<script>  
function jumpurl(){  
  location='http://localhost:8080/ITTest/user/getlist.html';  
}  
setTimeout('jumpurl()',3000);  
</script>
</head>
<body>
这是成功页,${success},3s后会跳转到列表页面
${listNum}
</body>
</html>