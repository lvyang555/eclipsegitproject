package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Trips;
import service.TripsService;
import serviceimpl.TripsServiceImpl;

/**
 * Servlet implementation class UserQueryInfo
 */
public class UserQueryInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int start =Integer.parseInt(request.getParameter("start"));
		int end =Integer.parseInt(request.getParameter("end"));
		int carType=Integer.parseInt(request.getParameter("carType"));
		int routeType=Integer.parseInt(request.getParameter("routeType"));
		
		
		TripsService ts =new TripsServiceImpl();
		List<Trips> trips=new ArrayList<Trips>();
		if(ts.selectSome(start, end, routeType)) {
			trips=ts.querySomeTrips(carType, routeType);
			request.setAttribute("trips", trips);
			request.getRequestDispatcher("UserQueryResult.jsp").forward(request, response);	
			
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("查询失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到查询页面");
			response.setHeader("refresh", "3;UserQueryInfo.jsp");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
