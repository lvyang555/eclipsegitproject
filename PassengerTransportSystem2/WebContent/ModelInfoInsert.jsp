<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check_register(){
		if(document.myform.modelName.value==""|| document.myform.seatName.value==""|| document.myform.carNum.value==""){
			alert("必须全部填写！");
			 return false;
		}	
	}
</script>
</head>
<body>
<center>
 <h1>车型录入操作</h1>
  <hr>

	<form action="AddCar" method="post" onSubmit="return check_register()" name="myform">
	<table border="0">
		
		<tr>
			<td>车型:</td>
			<td><input type="text" name="modelName"/></td>
			
		</tr>
		<tr>
			<td>车座:</td>
			<td><input type="text" name="seatNum" /></td>
		</tr>
		<tr>
			<td>数量:</td>
			<td><input type="text" name="carNum" /></td>
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