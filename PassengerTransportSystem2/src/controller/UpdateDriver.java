package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Driver;
import service.DriverService;
import serviceimpl.DriverServiceImpl;

/**
 * Servlet implementation class UpdateDriver
 */
public class UpdateDriver extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		DriverService ds =new DriverServiceImpl();
		int did =Integer.parseInt(request.getParameter("id"));
		String name =request.getParameter("name");
		String phone =request.getParameter("age");
		int age =Integer.parseInt(request.getParameter("age"));
		String driverCode =request.getParameter("driverCode");
		
		Driver driver =new Driver(did, name, phone, age, driverCode);
		if(ds.updateDriver(driver)==1) {
			request.getRequestDispatcher("DriverInfo.jsp").forward(request, response);
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("更新失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到查询页面");
			response.setHeader("refresh", "3;DriverInfo.jsp？id="+did);
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
