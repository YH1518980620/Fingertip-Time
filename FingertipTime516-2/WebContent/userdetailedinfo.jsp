<%@page import="org.user.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		
			User user=(User)request.getAttribute("resultuser");
		%>
		<form action="UpdateUserServlet">
			账号：<input type="text" name="uid" value="<%=user.getUid()%>" readonly="readonly"><br>
			用户名：<input type="text" name="uname" value="<%=user.getUname()%>"><br>
			密码：<input type="password" name="upwd" value="<%=user.getUpwd()%>"><br>
			性别：<input type="text" name="usex" value="<%=user.getUsex()%>"><br>
			<input type="submit" value="更改"><br>
		</form>
</body>
</html>