package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Station;
import service.StationService;
import serviceimpl.StationServiceImpl;

/**
 * Servlet implementation class AddStationServlet
 */
public class AddStationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;cgarset=UTF-8");
		response.setCharacterEncoding("utf-8");
		StationService ss =new StationServiceImpl();
		String stationName =request.getParameter("stationName");
		String stationCode =request.getParameter("stationCode");
		
		Station st =new Station(stationName, stationCode);
		if(ss.insertStation(st)==1) {
			PrintWriter out=response.getWriter();
			out.print("录入成功!");
			out.print("<br/>");
			out.print("3秒后自动跳转到主页面");
			response.setHeader("refresh", "3;StationInfo.jsp");
		}else {
			PrintWriter out=response.getWriter();
			out.print("录入失败!");
			out.print("<br/>");
			out.print("2秒后自动跳转到录入页面");
			response.setHeader("refresh", "3;StationInfoInsert.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
