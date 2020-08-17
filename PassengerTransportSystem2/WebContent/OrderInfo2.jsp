<%@page import="serviceimpl.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@page import="entity.User"%>
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
			window.location.href = "UpdateOrder?id=" + id;
		}
	}
</script>
</head>
<body>
   
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
		List<Order> list =os.selectAllOrder();
		TripsService ts =new TripsServiceImpl();
		UserService us =new UserServiceImpl();
		
			//--获取当前页号、设置页大小、获取总行数、计算总页数
			String str = (String) request.getParameter("page");
			if (str == null) {
				str = "0";
			}
			int pagesize = 10;//页面大小
			int recordCount = list.size();//总行数
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
				Show show=ts.selectTrips(list.get(i).getTid());
				User user=us.selectUser(list.get(i).getUid());
		%>
		<tr>
			<td><%=user.getUsername()%></td>
			<td><%=show.getTripsName()%></td>
			<td><%=show.getRouteName()%></td>
			<td><%=show.getCarName()%></td>
			<td><%=list.get(i).getTime()%></td>
			<td><%=(list.get(i).getStatues()==1? "未打印":"已打印")%></td>
			<td>
				<a href="javascript:update(<%=list.get(i).getOid()%>)">打印车票</a>
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
		<a href="OrderInfo2.jsp?page=1">第一页</a> <a
			href="OrderInfo2.jsp?page=<%=currentPage - 1%>">上一页</a>
		<%
			}
			if (currentPage < maxPage) {
		%>
		<a href="OrderInfo2.jsp?page=<%=currentPage + 1%>">下一页</a> <a
			href="OrderInfo2.jsp?page=<%=maxPage%>">最后一页&nbsp;</a>
		<%
			}
		%>
	</center>

</body>
</html>