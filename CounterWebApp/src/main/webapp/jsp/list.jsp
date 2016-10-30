<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表页</title>
</head>
<body>
<a href="/ITTest/user/goadd.html">添加</a>

<a href="/ITTest/user/getCounts.html">总记录条数</a>
这是列表页
<table border="1" width="100%">
	<tr>
		<td>id</td>
		<td>昵称</td>
		<td>性别</td>
		<td>年龄</td>
		<td>qq号</td>
		<td>毕业院校</td>
		<td>现居城市</td>
		<td>个性签名</td>
		<td>账号</td>
		<td>密码</td>
		<td>创建时间</td>
		<td>修改时间</td>
		<td>操作</td>
	</tr>

<c:forEach var="user" items="${lu}">
	<tr>
		<td>${user.ID}</td>
		<td>${user.name}</td>
		<td>
		<c:if test="${user.sex==1}">男</c:if>
		<c:if test="${user.sex==2}">女</c:if>
		</td>
		<td>${user.age}</td>
		<td>${user.qqNumber}</td>
		<td>${user.schoolName}</td>
		<td>${user.city}</td>
		<td>${user.signature}</td>
		<td>${user.account}</td>
		<td>${user.password}</td>
		<td>
			<fmt:formatDate type="date" value="${user.create_at}" dateStyle="default"/>
		</td>
		<td>
			<fmt:formatDate type="date" value="${user.update_at}" dateStyle="default"/>
		</td>
		<td>
		<a href="/ITTest/user/goupdate/${user.ID}/.html">修改</a>
		<a href="/ITTest/user/delete/${user.ID}/.html">删除</a>
		<a href="/ITTest/user/detail/${user.ID}/.html">详细</a>
		
		</td>
	</tr>
</c:forEach>	
</table>
</body>
</html>