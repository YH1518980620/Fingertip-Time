<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.user.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1px">
			<tr>
				<th>账号</th>
		   		<th>用户名</th>
				<th>密码</th>
				<th>性别</th>
			</tr>	
			<%
				List<User> users=(List<User>)request.getAttribute("list");
				for(User user:users){
			%>	
					<tr>
						<td><a href="QueryUserByUidServlet?uid=<%=user.getUid()%>"><%=user.getUid()%> </td>
						<td><%=user.getUname() %></td>
						<td><%=user.getUpwd() %></td>
						<td><%=user.getUsex() %></td>
						<td><a href="DeleteUserServlet?uid=<%=user.getUid()%>&upwd=<%=user.getUpwd()%>">删除</a>
					</tr>
			<%		
				}
			%>
		</table>
</body>
</html>