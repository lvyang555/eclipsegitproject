<%@page import="entity.Driver"%>
<%@page import="entity.Route"%>
<%@page import="entity.Car"%>
<%@page import="java.util.List"%>
<%@page import="serviceimpl.RouteServiceImpl"%>
<%@page import="service.RouteService"%>
<%@page import="serviceimpl.CarServiceImpl"%>
<%@page import="service.CarService"%>
<%@page import="serviceimpl.DriverServiceImpl"%>
<%@page import="service.DriverService"%>
<%@page import="entity.Trips"%>
<%@page import="serviceimpl.TripsServiceImpl"%>
<%@page import="service.TripsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车票数据更新操作</title>
<script type="text/javascript">
	function check_register(){
		if(document.myform.tripsName.value==""|| document.myform.rid.value==""|| document.myform.mid.value==""||document.myform.votes.value==""
				||document.myform.votesSaled.value==""||document.myform.did.value==""||document.myform.startTime.value==""||document.myform.endTime.value==""
				||document.myform.status.value==""){
			alert("必须全部填写！");
			 return false;
		}	
	}
</script>
</head>
<body>
<%

CarService cs =new CarServiceImpl();
RouteService rs =new RouteServiceImpl();
DriverService ds =new DriverServiceImpl();

List<Car> cars =cs.selectAllCar();
List<Route> routes =rs.selectAll();
List<Driver> drivers =ds.selectAllDriver();

int size1=cars.size();
int size2 =routes.size();
int size3 =drivers.size();

%>


<center>
 <h1>车票数据录入操作</h1>
  <hr>

	<form action="AddTrips" method="post" onSubmit="return check_register()" name="myform">

	<table border="0">
		
		<tr>
			<td>车次:</td>
			<td><input type="text" name="tripsName"  value="例：D110" /></td>
			
		</tr>
		<tr>
			<td>路线:</td>
			<td><select name="rid">
			<%
			for(int i=0;i<size2;i++){
				%>
				<option value="<%=routes.get(i).getRid()%>"><%=routes.get(i).getRouteName()%></option>
				<%
			}
			%>
				</select>
	        	</td>
		</tr>
		<tr>
			<td>车种:</td>
				<td><select name="mid">
			<%
			for(int i=0;i<size1;i++){
				%>
				<option value="<%=cars.get(i).getMid()%>"><%=cars.get(i).getModelName()%></option>
				<%
			}
			%>
				</select>
	        	</td>
		</tr>
		<tr>
			<td>车票总数:</td>
			<td><input type="text" name="votes"/></td>
		</tr>
		<tr>
			<td>已售数量:</td>
			<td><input type="text" name="votesSaled" /></td>
		</tr>
		<tr>
			<td>司机:</td>
				<td><select name="did">
			<%
			for(int i=0;i<size3;i++){
				%>
				<option value="<%=drivers.get(i).getDid()%>"><%=drivers.get(i).getName()%></option>
				<%
			}
			%>
				</select>
	        	</td>
		</tr>
		<tr>
			<td>发车时间:</td>
			<td><input type="String" name="startTime" value="例：2020-01-28 19:01:05"/></td>
		</tr>
		<tr>
			<td>到站时间:</td>
			<td><input type="String" name="endTime" value="例：2020-01-28 19:01:05"/></td>
		</tr>
		<tr>
			<td>状态:</td>
			<td><input type="text" name="status" value=" 0或1"/></td>
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