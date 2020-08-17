package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Car;
import service.CarService;
import serviceimpl.CarServiceImpl;

/**
 * Servlet implementation class AddCar
 */
public class AddCar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		CarService cs =new CarServiceImpl();
		String modelName =request.getParameter("modelName");
		int seatNum =Integer.valueOf(request.getParameter("seatNum"));
		int carNum =Integer.valueOf(request.getParameter("carNum"));
		Car car =new Car(modelName, seatNum, carNum);
		
		if(cs.addCar(car)==1) {
			response.sendRedirect("ModelInfo.jsp");
		}else{
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("录入失败!");
			out.print("<br/>");
			out.print("3秒后自动跳转到录入页面");
			response.setHeader("refresh", "3;ModelInfoInsert.jsp");
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
