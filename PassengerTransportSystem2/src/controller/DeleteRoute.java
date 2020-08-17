package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Route;
import service.RouteService;
import service.RouteStationService;
import serviceimpl.RouteServiceImpl;
import serviceimpl.RouteStationServiceImpl;

/**
 * Servlet implementation class DeleteRoute
 */
public class DeleteRoute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		RouteService rs =new RouteServiceImpl();
		RouteStationService rss=new RouteStationServiceImpl();
		if(rss.deleteRoute(id)==1&&rs.deleteRoute(id)==1) {
			
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("删除成功");
			out.print("<br/>");
			out.print("3秒后自动跳转到查询页面");
			response.setHeader("refresh", "3;RouteInfo.jsp");
			request.getRequestDispatcher("RouteInfo.jsp").forward(request, response);
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("删除失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到查询页面");
			response.setHeader("refresh", "3;RouteInfo.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
