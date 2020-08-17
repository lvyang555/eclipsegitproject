package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Route;
import service.RouteService;
import serviceimpl.RouteServiceImpl;

/**
 * Servlet implementation class UpdateRoute
 */
public class UpdateRoute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id= Integer.parseInt(request.getParameter("id"));
		RouteService rs =new RouteServiceImpl();
		String routeName= request.getParameter("routeName");
		int price =Integer.parseInt(request.getParameter("price"));
		
		Route route =new Route(id,routeName, price);
		if(rs.updateRoute(route)==1) {
			request.getRequestDispatcher("RouteInfo.jsp").forward(request, response);
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("删除失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到查询页面");
			response.setHeader("refresh", "3;UpdateRoute.jsp？id="+id);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
