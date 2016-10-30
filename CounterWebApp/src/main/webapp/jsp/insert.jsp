<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页</title>
</head>
<body>

<form action="/ITTest/user/add.html" method="post">
昵称：&nbsp&nbsp<input type="text" name="name"/><br/>
账号：&nbsp&nbsp<input type="text" name="account"/><br/>
密码：&nbsp&nbsp<input type="text" name="password"/><br/>
年龄：&nbsp&nbsp<input type="text" name="age"/><br/>
城市：&nbsp&nbsp<input type="text" name="city"/><br/>
性别：&nbsp&nbsp
男<input type="radio" name="sex" value="1"/>
女<input type="radio" name="sex" value="2"/><br/>
qq：&nbsp&nbsp&nbsp<input type="text" name="qqNumber"/><br/>
学校名称：<input type="text" name="schoolName"/><br/>
个性签名：<textarea name="signature" style="width:200px;height:80px;"></textarea><br/>
<input type="submit" value="提交" />
</form>


</body>
</html>