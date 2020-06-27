<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="QueryUserByUidServlet" method="post">
		账号：<input type="text" name="uid"/><br>
		<input type="submit" value="根据账号查询"/>
		</form>
</body>
</html>