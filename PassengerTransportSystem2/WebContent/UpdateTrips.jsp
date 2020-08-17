<%@page import="entity.Trips"%>
<%@page import="serviceimpl.TripsServiceImpl"%>
<%@page import="service.TripsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车票数据更新操作</title>
<script type="text/javascript">
	function check_register(){
		if(document.myform.tripsName.value==""|| document.myform.rid.value==""|| document.myform.mid.value==""||document.myform.votes.value==""
				||document.myform.votesSaled.value==""||document.myform.did.value==""||document.myform.startTime.value==""||document.myform.endTime.value==""
				||document.myform.status.value==""){
			alert("必须全部填写！");
			 return false;
		}	
	}
</script>
</head>
<body>
<%
	TripsService ts =new TripsServiceImpl();
	int tid= Integer.parseInt(request.getParameter("id"));
	Trips trips =ts.selectOneTrips(tid);
%>

<center>
 <h1>车票数据更新操作</h1>
  <hr>

	<form action="UpdateTrips" method="post" onSubmit="return check_register()" name="myform">
	<input type="hidden" name="id" value="<%=tid %>">
	<table border="0">
		
		<tr>
			<td>车次:</td>
			<td><input type="text" name="tripsName" value="<%=trips.getTripsName() %>" /></td>
			
		</tr>
		<tr>
			<td>路线编号:</td>
			<td><input type="text" name="rid" value="<%=trips.getRid() %>"  /></td>
		</tr>
		<tr>
			<td>车种编号:</td>
			<td><input type="text" name="mid" value="<%=trips.getMid() %>"/></td>
		</tr>
		<tr>
			<td>车票总数:</td>
			<td><input type="text" name="votes" value="<%=trips.getVotes() %>"/></td>
		</tr>
		<tr>
			<td>已售数量:</td>
			<td><input type="text" name="votesSaled" value="<%=trips.getVotesSaled() %>"/></td>
		</tr>
		<tr>
			<td>司机编号:</td>
			<td><input type="text" name="did" value="<%=trips.getDid()%>"/></td>
		</tr>
		<tr>
			<td>发车时间:</td>
			<td><input type="text" name="startTime" value="<%=trips.getStartTime() %>"/></td>
		</tr>
		<tr>
			<td>到站时间:</td>
			<td><input type="text" name="endTime" value="<%=trips.getEndTime() %>"/></td>
		</tr>
		<tr>
			<td>状态:</td>
			<td><input type="text" name="status" value="<%=trips.getStatus() %>"/></td>
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