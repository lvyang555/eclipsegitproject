<%@page import="entity.Show"%>
<%@page import="entity.Trips"%>
<%@page import="serviceimpl.TripsServiceImpl"%>
<%@page import="service.TripsService"%>
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
<title>车型信息</title>
<script type="text/javascript">
	function purchase(id) {
		var flag = window.confirm("是否进行购买车票？");
		if (flag) {
			window.location.href = "AddOrder?id=" + id;
		}
	
	}
</script>
</head>
<body>
 <a href="LoginSuccess.jsp">返回</a>
<table align="center" border="0" width="1000px" cellspacing="0">
		<tr>
			<td align="center" style="font-family: '黑体'; font-size: 28px;">
				欢迎访问客运管理系统！
			</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		
	</table>

<table align="center" border="1" width="1000px" cellspacing="0">
		<tr>
			<th width="100px">车次</th>
			<th width="150px">路线名</th>
			<th width="120px">车型</th>
			<th width="100px">总票数</th>
			<th width="100px">已售数量</th>
			<th width="300px">发车时间</th>
			<th width="300px">到站时间</th>
			<th width="100px">状态</th>
			<th width="120px">操作</th>
			
			

		</tr>
		<%
		TripsService ts=new TripsServiceImpl();
		
		List<Trips> trips =(List<Trips>)request.getAttribute("trips");
		
			
			for (int i = 0; i <trips.size(); i++) {
				
				Show show =ts.tripChangeShow(trips.get(i));
		%>
		<tr>
			<td><%=show.getTripsName()%></td>
			<td><%=show.getRouteName()%></td>
			<td><%=show.getCarName()%></td>
			<td><%=show.getVotes()%></td>
			<td><%=show.getVotes_saled()%></td>
			<td><%=show.getStartTime()%></td>
			<td><%=show.getEndTime()%></td>
			<td><%=show.getStatues()%></td>
			
			<td>
				<a href="javascript:purchase(<%=show.getTid()%>)">购买</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	

</body>
</html>