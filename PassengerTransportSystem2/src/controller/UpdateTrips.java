package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Trips;
import service.TripsService;
import serviceimpl.TripsServiceImpl;

/**
 * Servlet implementation class UpdateTrips
 */
@WebServlet("/UpdateTrips")
public class UpdateTrips extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int tid =Integer.parseInt(request.getParameter("id"));
		String tripsName =request.getParameter("tripsName");
		int rid =Integer.parseInt(request.getParameter("rid"));
		int mid =Integer.parseInt(request.getParameter("mid"));
		int votes =Integer.parseInt(request.getParameter("votes"));
		int votesSaled =Integer.parseInt(request.getParameter("votesSaled"));
		int did =Integer.parseInt(request.getParameter("did"));
		String startTime =request.getParameter("startTime");
		String endTime =request.getParameter("endTime");
		int status =Integer.parseInt(request.getParameter("status"));
		
		
		Trips trips =new Trips(tid, tripsName, rid, mid, votes, votesSaled, did, startTime, endTime, status);
		TripsService ts =new TripsServiceImpl();
		if(ts.updateOneTrips(trips)==1) {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("更新成功!");
			out.print("<br/>");
			out.print("3秒后自动跳转到查询页面");
			response.setHeader("refresh", "3;TripsInfo.jsp");
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("更新失败!");
			out.print("<br/>");
			out.print("3秒后自动跳转到更新页面");
			response.setHeader("refresh", "3;UpdateTrips.jsp?id="+tid);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
