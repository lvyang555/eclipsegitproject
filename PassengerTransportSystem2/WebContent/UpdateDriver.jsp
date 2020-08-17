<%@page import="entity.Driver"%>
<%@page import="serviceimpl.DriverServiceImpl"%>
<%@page import="service.DriverService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>司机信息修改</title>
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
<%

	DriverService ds =new DriverServiceImpl();
	int did =Integer.parseInt(request.getParameter("id"));
	Driver driver=ds.selectDriver(did);
	


%>

<center>
 <h1>司机信息修改</h1>
  <hr>

	<form action="UpdateDriver" method="post" onSubmit="return check_register()" name="myform">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
	<table border="0">
		
		<tr>
			<td>司机姓名:</td>
			<td><input type="text" name="name" value="<%=driver.getName() %>"/></td>
			
		</tr>
		<tr>
			<td>司机手机:</td>
			<td><input type="text" name="phone" value="<%=driver.getPhone() %>"/></td>
		</tr>
		<tr>
			<td>司机年龄:</td>
			<td><input type="text" name="age" value="<%=driver.getAge() %>"/></td>
		</tr>
		<tr>
			<td>司机简称:</td>
			<td><input type="text" name="driverCode" value="<%=driver.getDirverCode()%>"/></td>
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