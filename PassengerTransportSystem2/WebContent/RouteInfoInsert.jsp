<%@page import="java.util.List"%>
<%@page import="serviceimpl.StationServiceImpl"%>
<%@page import="service.StationService"%>
<%@page import="entity.Station"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check_register(){
		if(document.myform.Routename.value==""|| document.myform.Price.value==""){
			alert("必须全部填写！");
			 return false;
		}
	}
</script>
</head>
<body>
<%
		StationService ss=new StationServiceImpl();
		List<Station> stas=ss.selectAll();
		int size=stas.size();

%>



<center>
 <h1>路线信息录入</h1>
  <hr>

	<form action="AddRouteServlet" method="post" onSubmit="return check_register()" name="myform">
	<table border="0">
		
		<tr>
			<td>路线名称:</td>
			<td><input type="text" name="Routename"/></td>
			
		</tr>
		<tr>
			<td>价&nbsp;&nbsp;格&nbsp;&nbsp;:</td>
			<td><input type="text" name="Price" /></td>
		</tr>
		<tr>
			<td>路线所包含站信息：</td><br/>
		
		<td>
		<%
		    for(int i=0;i<size;i++){
		    	%>
		    	<input type="checkbox" name="stas" value="<%=stas.get(i).getSid()%>"/><%=stas.get(i).getStationName()%><br/>
		    	<% 	
		    }
		%>	
		</td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="提交" />
				<input type="reset" value="重置"/>
			</td>
			</tr>
	</table>
	</form>
</center>	

</body>
</html>