 <%@page import="entity.Route"%>
<%@page import="serviceimpl.RouteServiceImpl"%>
<%@page import="service.RouteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check_register(){
		if(document.myform.routeName.value==""|| document.myform.price.value==""){
			alert("必须全部填写！");
			 return false;	
		}	
	}
</script>

</head>
<body>
<%
	RouteService rs =new RouteServiceImpl();
	int id=Integer.parseInt(request.getParameter("id"));
	Route route =rs.selectRoute(id);
%>
<center>
 <h1>车型更新操作</h1>
  <hr>
   
	<form action="UpdateRoute" method="post" onSubmit="return check_register()" name="myform">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
	<table border="0">
		
		<tr>
			<td>路线名：</td>
			<td><input type="text" name="routeName" value="<%=route.getRouteName() %>"/></td>
			
		</tr>
		<tr>
			<td>票&nbsp;价：</td>
			<td><input type="text" name="price" value="<%=route.getPrice() %>"/></td>
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