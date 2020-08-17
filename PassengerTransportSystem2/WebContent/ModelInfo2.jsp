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

</head>
<body>
   
<table align="center" border="0" width="600px" cellspacing="0">
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
			<th width="120px">车编号</th>
			<th width="120px">车型</th>
			<th width="120px">车座位</th>
			<th width="120px">车数量</th>
		</tr>
		<%
		CarService cs =new CarServiceImpl();
		List<Car> cars =cs.selectAllCar();
			//--获取当前页号、设置页大小、获取总行数、计算总页数
			String str = (String) request.getParameter("page");
			if (str == null) {
				str = "0";
			}
			int pagesize = 10;//页面大小
			int recordCount = cars.size();//总行数
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
			<td><%=cars.get(i).getMid()%></td>
			<td><%=cars.get(i).getModelName()%></td>
			<td><%=cars.get(i).getSeatNum()%></td>
			<td><%=cars.get(i).getCarNum()%></td>
		

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
		<a href="ModelInfo2.jsp.jsp?page=1">第一页</a> <a
			href="ModelInfo2.jsp.jsp?page=<%=currentPage - 1%>">上一页</a>
		<%
			}
			if (currentPage < maxPage) {
		%>
		<a href="ModelInfo2.jsp?page=<%=currentPage + 1%>">下一页</a> <a
			href="ModelInfo2.jsp?page=<%=maxPage%>">最后一页&nbsp;</a>
		<%
			}
		%>
	</center>

</body>
</html>