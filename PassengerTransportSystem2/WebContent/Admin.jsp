<%@page import="util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body  >

<%

	request.setCharacterEncoding("utf-8");
	if(request.getParameter("id")!=null){
		int id=Integer.parseInt(request.getParameter("id"));
		
		try{
			if(id==1){
				new DBUtil().backup();
			}else if(id==-1){
				new DBUtil().restore();
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
%>
<a href="ModelInfo.jsp" target="context">车型信息</a><br/>
<a href="ModelInfoInsert.jsp" target="context">车型信息录入</a><br/>
<a href="RouteInfo.jsp" target="context">路线信息</a><br/>
<a href="RouteInfoInsert.jsp" target="context">路线信息录入</a><br/>
<a href="DriverInfo.jsp" target="context">驾驶员信息</a><br/>
<a href="DriverInfoInsert.jsp" target="context">驾驶员信息录入</a><br/>
<a href="TripsInfo.jsp" target="context">票务信息</a><br/>
<a href="TripsInfoInsert.jsp" target="context">票务信息录入</a><br/>
<a href="StationInfo.jsp" target="context">车站信息</a><br/>
<a href="StationInfoInsert.jsp" target="context">车站信息录入</a><br/>
<a href="Admin.jsp?id=1">数据库备份</a><br/>
<a href="Admin.jsp?id=-1">数据库恢复</a><br/>
<a href="AdministratorLogin.jsp">返回上一级</a><br/>
</body>
</html>