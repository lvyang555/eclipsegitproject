package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Route;
import entity.RouteStation;
import service.RouteService;
import service.RouteStationService;
import serviceimpl.RouteServiceImpl;
import serviceimpl.RouteStationServiceImpl;

/**
 * Servlet implementation class AddRouteServlet
 */
public class AddRouteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;cgarset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		
		RouteService rs =new RouteServiceImpl();
		
		String routeName =request.getParameter("Routename");
		int price =Integer.parseInt(request.getParameter("Price"));
		String[] stations =request.getParameterValues("stas");
		RouteStationService rss=new RouteStationServiceImpl();
		Route rt =new Route(routeName, price);
		
		boolean flag=true;
		if(rs.insertRoute(rt)==1) {
			
			
		}else {
			flag=false;
			PrintWriter out=response.getWriter();
			out.print("录入失败!");
			out.print("<br/>");
			out.print("2秒后自动跳转到录入页面");
			response.setHeader("refresh", "3;RouteInfoInsert.jsp");
		}
		
		if(flag) {
			rt=rs.selectone(rt);
			List<RouteStation> routeStations = new ArrayList<RouteStation>();
			for(int i=0;i<stations.length;i++) {
			RouteStation routeStation =new RouteStation(rt.getRid(), Integer.parseInt(stations[i]));
			routeStations.add(routeStation);
			}
			if(rss.AddSomeRouteStation(routeStations)==1) {
				PrintWriter out=response.getWriter();
				out.print("录入成功!");
				out.print("<br/>");
				out.print("3秒后自动跳转到主页面");
				response.setHeader("refresh", "3;RouteInfo.jsp");
			}else {
				PrintWriter out=response.getWriter();
				out.print("录入失败!");
				out.print("<br/>");
				out.print("2秒后自动跳转到录入页面");
				response.setHeader("refresh", "3;RouteInfoInsert.jsp");
			}
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
