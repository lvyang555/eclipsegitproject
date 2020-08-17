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
<script type="text/javascript">
	function del(id) {
		var flag = window.confirm("是否真的要删除？");
		if (flag) {
			window.location.href = "DeleteStation?id=" + id;
		}
	}
	function update(id) {
		window.location.href = "UpdateStation.jsp?id=" + id ;
	}
	
</script>

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
			<th width="120px">车站编号</th>
			<th width="120px">车站名称</th>
			<th width="120px">车站简称</th>
			<th width="120px">操作</th>
		</tr>
		<%
		StationService ss=new StationServiceImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		List<Station> stations=ss.selectSomeStations(id);
			for (int i = 0;i<stations.size(); i++) {
		%>
		<tr>
			<td><%=stations.get(i).getSid()%></td>
			<td><%=stations.get(i).getStationName()%></td>
			<td><%=stations.get(i).getStationCode()%></td>
	
			<td>
				<a href="javascript:update(<%=stations.get(i).getSid()%>)">修改</a>
				<a href="javascript:del(<%=stations.get(i).getSid()%>)">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>


</body>
</html>