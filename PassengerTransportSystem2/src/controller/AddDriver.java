package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Driver;
import service.DriverService;
import serviceimpl.DriverServiceImpl;

/**
 * Servlet implementation class AddDriver
 */
public class AddDriver extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		DriverService ds =new DriverServiceImpl();
		String name =request.getParameter("name");
		String phone =request.getParameter("age");
		int age =Integer.valueOf(request.getParameter("age"));
		String driverCode =request.getParameter("driverCode");
		
		Driver driver =new Driver( name, phone, age, driverCode);
		if(ds.addDriver(driver)==1) {
			request.getRequestDispatcher("DriverInfo.jsp").forward(request, response);
		}else {
			response.getWriter().print("ÃÌº” ß∞‹£°");
			response.setHeader("refresh", "3;DriverInfo.jsp£ø");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
