<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页</title>
</head>
<body>

<form action="/ITTest/user/update.html" method="post">
<input type="hidden" name="ID" value="${user.ID}" />
昵称：&nbsp&nbsp<input type="text" name="name" value="${user.name}"/><br/>
账号：&nbsp&nbsp<input type="text" name="account" value="${user.account}"/><br/>
密码：&nbsp&nbsp<input type="text" name="password" value="${user.password}"/><br/>
年龄：&nbsp&nbsp<input type="text" name="age" value="${user.age}"/><br/>
城市：&nbsp&nbsp<input type="text" name="city" value="${user.city}"/><br/>
性别：
男<input type="radio" name="sex" value="1"/>
女<input type="radio" name="sex" value="2"/><br/>
qq：&nbsp&nbsp&nbsp<input type="text" name="qqNumber" value="${user.qqNumber}"/><br/>
学校名称：<input type="text" name="schoolName" value="${user.schoolName}"/><br/>
个性签名：<textarea name="signature" style="width:200px;height:80px;">${user.signature}</textarea><br/>
<input type="submit" value="提交" />
</form>


</body>
</html>