<%@page import="serviceimpl.TripsServiceImpl"%>
<%@page import="service.TripsService"%>
<%@page import="entity.Trips"%>
<%@page import="entity.Route"%>
<%@page import="serviceimpl.RouteServiceImpl"%>
<%@page import="service.RouteService"%>
<%@page import="java.util.List"%>
<%@page import="serviceimpl.CarServiceImpl"%>
<%@page import="service.CarService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>路线信息</title>
<script type="text/javascript">
	function del(id) {
		var flag = window.confirm("是否真的要删除？");
		if (flag) {
			window.location.href = "DeleteTrips?id=" + id;
		}
	}
	function update(id) {
		window.location.href = "UpdateTrips.jsp?id=" + id ;
	}
</script>
</head>
<body>
   
<table align="center" border="0" width="1100px" cellspacing="0">
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
			<th width="120px">车次</th>
			<th width="120px">路线编号</th>
			<th width="120px">车种编号</th>
			<th width="120px">车票总数</th>
			<th width="120px">已售数量</th>
			<th width="120px">司机编号</th>
			<th width="120px">发车时间</th>
			<th width="120px">到站时间</th>
			<th width="120px">状态</th>
			<th width="120px">操作</th>

		</tr>
		<%
		TripsService ts =new TripsServiceImpl();
		List<Trips> trips =ts.selectAllTrips();
		
	
			//--获取当前页号、设置页大小、获取总行数、计算总页数
			String str = (String) request.getParameter("page");
			if (str == null) {
				str = "0";
			}
			int pagesize = 10;//页面大小
			int recordCount = trips.size();//总行数
			int maxPage = 0;
			int currentPageSize = pagesize;
			maxPage = (recordCount % pagesize == 0) ? (recordCount / pagesize) : (recordCount / pagesize + 1);//总页数
			int currentPage = Integer.parseInt(str);
			if (currentPage < 1) {//处理特殊当前页号
				currentPage = 1;
			} else {
				if (currentPage > maxPage) {
					currentPage = maxPage;
				}
			}
			if (currentPage == maxPage) {
				currentPageSize = recordCount - pagesize * (currentPage - 1);
			}
			for (int i = (currentPage - 1) * pagesize; i < currentPageSize + (currentPage - 1) * pagesize; i++) {
		%>
		<tr>
			<td><%=trips.get(i).getTripsName()%></td>
			<td><%=trips.get(i).getRid()%></td>
			<td><%=trips.get(i).getMid()%></td>
			<td><%=trips.get(i).getVotes()%></td>
			<td><%=trips.get(i).getVotesSaled()%></td>
			<td><%=trips.get(i).getDid()%></td>
			<td><%=trips.get(i).getStartTime()%></td>
			<td><%=trips.get(i).getEndTime()%></td>
			<td><%=trips.get(i).getStatus()%></td>
	
			<td>
				<a href="javascript:update(<%=trips.get(i).getTid()%>)">修改</a>
				<a href="javascript:del(<%=trips.get(i).getTid()%>)">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<center>
		当前页数：[<%=currentPage%>/<%=maxPage%>]&nbsp;
		<%
			//--显示页面导航--
			if (currentPage > 1) {
		%>
		<a href="TripsInfo.jsp?page=1">第一页</a> <a
			href="TripsInfo.jsp?page=<%=currentPage - 1%>">上一页</a>
		<%
			}
			if (currentPage < maxPage) {
		%>
		<a href="TripsInfo.jsp?page=<%=currentPage + 1%>">下一页</a> <a
			href="TripsInfo.jsp?page=<%=maxPage%>">最后一页&nbsp;</a>
		<%
			}
		%>
	</center>

</body>
</html>