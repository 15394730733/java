<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页</title>
</head>
<body>

<form action="/user/update" method="post">
昵称：<input type="text" name="name" value="${user.name}"/><br/>
账号：<input type="text" name="account" value="${user.account}"/><br/>
密码：<input type="text" name="password" value="${user.password}"/><br/>
年龄：<input type="text" name="age" value="${user.age}"/><br/>
性别：
男<input type="radio" name="sex" value="1"/>
女<input type="radio" name="sex" value="2"/><br/>
qq：<input type="text" name="qqNumber" value="${user.qqNumber}"/><br/>
学校名称：<input type="text" name="schoolName" value="${user.schoolName}"/><br/>
个性签名：<input type="text" name="signature" value="${user.signature}" /><br/>

</form>


</body>
</html>