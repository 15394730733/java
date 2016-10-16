<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.atg.com/taglibs/json"  prefix="json" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
这是详情页
<json:object>
	<json:property name="id" value="${user.ID}"/>
	<json:property name="age" value="${user.age}"/>
	<json:property name="create_at" value="${user.create_at}"/>
	<json:property name="update_at" value="${user.update_at}" />
	<json:property name="sex" value="${user.sex}"/>
	<json:property name="qqNum" value="${user.qqNumber}"/>
	<json:property name="schoolName" value="${user.schoolName}"/>
	<json:property name="name" value="${user.name}"/>
	<json:property name="signature" value="${user.signature}" />
	<json:property name="imageUrl"  value="${user.imageUrl}"/>
	<json:property name="account" value="${user.account}"/>
	<json:property name="password" value="${user.password}"/>
</json:object> 

</body>
</html>