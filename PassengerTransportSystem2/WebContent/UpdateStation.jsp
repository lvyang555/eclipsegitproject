<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check_register(){
		if(document.myform.stationName.value==""|| document.myform.stationCode.value==""){
			alert("必须全部填写！");
			 return false;	
		}	
	}
</script>

</head>
<body>

<center>
 <h1>车站更新操作</h1>
  <hr>
   
	<form action="UpdateStation" method="post" onSubmit="return check_register()" name="myform">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
	<table border="0">
		
		<tr>
			<td>车站名&nbsp;：</td>
			<td><input type="text" name="stationName"/></td>
			
		</tr>
		<tr>
			<td>车站简称：</td>
			<td><input type="text" name="stationCode" /></td>
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