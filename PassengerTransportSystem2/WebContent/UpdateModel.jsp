<%@page import="entity.Car"%>
<%@page import="serviceimpl.CarServiceImpl"%>
<%@page import="service.CarService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车型更新操作</title>
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
	CarService cs =new CarServiceImpl();
	int id=Integer.parseInt(request.getParameter("id"));
	Car car =cs.selectCat(id);
%>

<center>
 <h1>车型更新操作</h1>
  <hr>

	<form action="UpdateCar" method="post" onSubmit="return check_register()" name="myform">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
	<table border="0">
		
		<tr>
			<td>车型:</td>
			<td><input type="text" name="modelName" value="<%=car.getModelName()%>"/></td>
			
		</tr>
		<tr>
			<td>车座:</td>
			<td><input type="text" name="seatNum" value="<%=car.getSeatNum()%>" /></td>
		</tr>
		<tr>
			<td>数量:</td>
			<td><input type="text" name="carNum" value="<%=car.getCarNum()%>"/></td>
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