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
 * Servlet implementation class UpdateStation
 */
public class UpdateStation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id= Integer.parseInt(request.getParameter("id"));
		StationService ss=new StationServiceImpl();
		String stationName =request.getParameter("stationName");
		String stationCode =request.getParameter("stationCode");
		
		Station sta  =new Station(id, stationName, stationCode);
		if(ss.updateStation(sta)==1) {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("更新成功");
			out.print("<br/>");
			out.print("3秒后自动跳转到更新页面");
			request.getRequestDispatcher("StationInfo.jsp").forward(request, response);
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("更新失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到更新页面");
			response.setHeader("refresh", "3;UpdateStation.jsp？id="+id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
