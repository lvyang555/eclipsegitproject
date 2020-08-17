<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>客运管理系统-登录页面</title>
</head>
<body>
<center>
 <h1>登录操作</h1>
  <hr>
	<form action="LoginServlet" method="post">
	
	<table border="0">
		
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="uname"/></td>
			
		</tr>
		<tr>
			<td>密&nbsp;码:</td>
			<td><input type="password" name="upwd" /></td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="登录" />
				<input type="reset" value="注册" onclick="window.location.href='Register.jsp'"/>
			</td>
			</tr>
	</table>
	
	</form>
	
</center>

</body>
</html>