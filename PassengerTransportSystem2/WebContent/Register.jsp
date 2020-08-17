<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check_register(){
		if(document.myform.uname.value==""|| document.myform.upwd.value==""|| document.myform.upwd2.value==""){
			alert("用户名、密码必须全部填写！");
			 return false;
			
		}
		if(document.myform.upwd.value.length < 6 || document.myform.upwd2.value.length < 6){
			alert("您的密码长度小于6！");
			 return false;
			
		}
		if(document.myform.upwd.value != document.myform.upwd2.value){
		   alert("您两次输入的密码不一致！");
		   return false;
		}	
	}
</script>
</head>
<body>
<center>
 <h1>注册操作</h1>
  <hr>

	<form action="AddUserServlet" method="post" onSubmit="return check_register()" name="myform">
	<table border="0">
		
		<tr>
			<td>用户名&nbsp;:</td>
			<td><input type="text" name="uname"/></td>
			
		</tr>
		<tr>
			<td>登录密码:</td>
			<td><input type="text" name="upwd" /></td>
		</tr>
		<tr>
			<td>确认密码:</td>
			<td><input type="text" name="upwd2" /></td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="提交" />
				<input type="reset" value="重置"/>
			</td>
			</tr>
	</table>
	</form>
</center>	

</body>
</html>