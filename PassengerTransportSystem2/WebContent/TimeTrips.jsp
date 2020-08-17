<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Order"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="entity.Car"%>
<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page import="serviceimpl.CarServiceImpl"%>
<%@page import="service.CarService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>售卖信息</title>

</head>
<body>
   
<table align="center" border="0" width="750px" cellspacing="0">
		<tr>
			<td align="center" style="font-family: '黑体'; font-size: 28px;">
				欢迎访问客运管理系统！
			</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		
	</table>

<table align="center" border="1" width="600px" cellspacing="0">
		<tr>
			<th width="120px">开始时间</th>
			<th width="120px">结束时间</th>
			<th width="120px">出售票数</th>


		</tr>
		<%
		Connection conn =DBUtil.getConnection();
		CallableStatement proc =null;
		
		ResultSet rs =null;
		Map<String,Integer>  map =new HashMap<>();
		
		try {
			proc=conn.prepareCall("{call times()}");
			rs=proc.executeQuery();
			while(rs.next()) {
				
				map.put(rs.getString("start_time")+"#"+rs.getString("end_time"), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs.close();
			proc.close();
			conn.close();
		}
		
		
		for(Map.Entry<String,Integer> entry: map.entrySet()){
			String [] time =entry.getKey().split("#");
			%>
			<tr>
				<td><%=time[0]%></td>
				<td><%=time[1]%></td>
				<td><%=entry.getValue()%></td>
			</tr>
			<%
		}

			%>
			
			
			
</table>
	

</body>
</html>