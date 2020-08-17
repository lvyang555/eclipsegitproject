<%@page import="java.util.Map"%>
<%@page import="serviceimpl.RouteStationServiceImpl"%>
<%@page import="service.RouteStationService"%>
<%@page import="entity.RouteStation"%>
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
<title>Insert title here</title>


</head>
<body>
<table align="center" border="0" width="480px" cellspacing="0">
		<tr>
			<td align="center" style="font-family: '黑体'; font-size: 28px;">
				欢迎访问客运管理系统！
			</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		
	</table>

<table align="center" border="1" width="480px" cellspacing="0">
		<tr>
			<th width="120px">路线名称</th>
			<th width="120px">车型</th>
			<th width="120px">路线上车数</th>

		</tr>
		<%
		RouteStationService rss =new RouteStationServiceImpl();
		Map<String,Integer> map=rss.selectNumber();
		
		
		
		
		
		
			for(Map.Entry<String,Integer> entry:map.entrySet()){
				String [] name=entry.getKey().split("#");	
		%>
		<tr>
			<td><%=name[0]%></td>
			<td><%=name[1]%></td>
			<td><%=entry.getValue()%></td>
		</tr>
		<%
			}
		%>
	</table>
	


</body>
</html>