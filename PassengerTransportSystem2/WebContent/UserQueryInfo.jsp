<%@page import="entity.Trips"%>
<%@page import="serviceimpl.TripsServiceImpl"%>
<%@page import="service.TripsService"%>
<%@page import="entity.Route"%>
<%@page import="serviceimpl.RouteServiceImpl"%>
<%@page import="service.RouteService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Car"%>
<%@page import="serviceimpl.CarServiceImpl"%>
<%@page import="service.CarService"%>
<%@page import="entity.Station"%>
<%@page import="java.util.List"%>
<%@page import="serviceimpl.StationServiceImpl"%>
<%@page import="service.StationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客运管理系统-登录页面</title>
</head>
<body>
<%
	CarService cs =new CarServiceImpl();
	TripsService ts =new TripsServiceImpl();
	StationService ss =new StationServiceImpl();
	RouteService rs =new RouteServiceImpl();
	List<Trips> trips =ts.selectAllTrips();
	List<Car> cars =cs.selectAllCar();
	List<Station> stas =ss.selectAll();
	List<Route> routes=rs.selectAll();
	int size=cars.size();
	int size2=stas.size();
	int size3=routes.size();
	int size4=trips.size();
	String name =(String)session.getAttribute("name");

%>
<center>

 <h1>用户票务查询操作</h1>
 <h2>用户：<%=name %></h2>
  <hr>
	<form action="UserQueryInfo" method="post">
	
	<table border="0">
		<tr>
			<td>出发地:</td>
			<td><select name="start">
			<%
			for(int i=0;i<size2;i++){
				%>
				<option value="<%=stas.get(i).getSid()%>"><%=stas.get(i).getStationName()%></option>
				<%
			}
			%>
				</select>
	        	</td>
		</tr>
		<tr>
			<td>目的地:</td>
			<td><select name="end">
			<%
			for(int i=0;i<size2;i++){
				%>
				<option value="<%=stas.get(i).getSid()%>"><%=stas.get(i).getStationName()%></option>
				<%
			}
			%>
				</select>
	        	</td>
		</tr>
		<tr>
			<td>车种:</td>
			<td><select name="carType">
			<%
			for(int i=0;i<size;i++){
				%>
				<option value="<%=cars.get(i).getMid()%>"><%=cars.get(i).getModelName()%></option>
				<%
			}
			%>
				</select>
	        	</td>
		</tr>
		<tr>
			<td>路线:</td>
			<td><select name="routeType">
			<%
			for(int i=0;i<size3;i++){
				%>
				<option value="<%=routes.get(i).getRid()%>"><%=routes.get(i).getRouteName()%></option>
				<%
			}
			%>
				</select>
	        	</td>
		</tr>
		
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="查询" />
				<input type="reset" value="重置" />
				<input type="button" value="返回" onclick="window.location.href='LoginSuccess.jsp'"/>
			</td>
			</tr>
	</table>
	
	</form>
	
</center>

</body>
</html>