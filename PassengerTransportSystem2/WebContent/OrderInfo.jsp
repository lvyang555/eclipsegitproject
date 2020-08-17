<%@page import="entity.Show"%>
<%@page import="serviceimpl.TripsServiceImpl"%>
<%@page import="service.TripsService"%>
<%@page import="entity.Order"%>
<%@page import="serviceimpl.OrderServiceImpl"%>
<%@page import="service.OrderService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车型信息</title>
<script type="text/javascript">
	function update(id) {
		var flag = window.confirm("是否打印车票？");
		if (flag) {
			window.location.href = "UpdateOrder2?id=" + id;
		}
	}
	function del(id) {
		var flag = window.confirm("是否真的要退票？");
		if (flag) {
			window.location.href = "DeleteOrder?id=" + id;
		}
	}
</script>
</head>
<body>
<a href="LoginSuccess.jsp" align="right">返回</a>
<table align="center" border="0" width="850px" cellspacing="0">
		<tr>
			<td align="center" style="font-family: '黑体'; font-size: 28px;">
				欢迎访问客运管理系统！
			</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		
	</table>

<table align="center" border="1" width="800px" cellspacing="0">
		<tr>
			<th width="120px">用户名</th>
			<th width="120px">车次</th>
			<th width="120px">路线名</th>
			<th width="120px">车型</th>
			<th width="120px">购买时间</th>
			<th width="120px">车票打印状态</th>
			<th width="120px">操作</th>

		</tr>
		<%
		
		OrderService os =new OrderServiceImpl();
		List<Order> list =os.selectUserAll((int)session.getAttribute("uid"));
		TripsService ts =new TripsServiceImpl();
		String name =(String)session.getAttribute("name");
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				Show show=ts.selectTrips(list.get(i).getTid());
		%>
		<tr>
			<td><%=name%></td>
			<td><%=show.getTripsName()%></td>
			<td><%=show.getRouteName()%></td>
			<td><%=show.getCarName()%></td>
			<td><%=list.get(i).getTime()%></td>
			<td><%=(list.get(i).getStatues()==1? "未打印":"已打印")%></td>
			<td>
				<a href="javascript:update(<%=list.get(i).getOid()%>)">打印车票</a>
				<a href="javascript:del(<%=list.get(i).getOid()%>)">退票</a>
		</tr>
		<%
			}
			
		}
			
			
		%>
	</table>
	

</body>
</html>