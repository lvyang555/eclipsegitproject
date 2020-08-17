<%@page import="serviceimpl.UserServiceImpl"%>
<%@page import="service.UserService"%>
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
		UserService us =new UserServiceImpl();
		String name=(String)session.getAttribute("name");


%>
<center>
		<h1>用户登录成功-客运系统</h1>
		<hr>
		<h2>
			欢迎<font color="red"> <%=name%>
			</font>光临！
		</h2>

		<input type="button" value="查询票务信息"
			onclick="window.location.href='UserQueryInfo.jsp'" /> 
		<input type="button" value="订单查询"
			 onclick="window.location.href='OrderInfo.jsp'" />
		<input type="button" value="返回"
		 onclick="window.location.href='UserLogin.jsp'" />
	</center>
	

</body>
</html>