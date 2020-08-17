package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Car;
import service.CarService;
import serviceimpl.CarServiceImpl;

/**
 * Servlet implementation class UpdateCar
 */
public class UpdateCar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id= Integer.parseInt(request.getParameter("id"));
		String modelName= request.getParameter("modelName");
		int seatNum=Integer.parseInt(request.getParameter("seatNum"));
		int carNum=Integer.parseInt(request.getParameter("carNum"));
		
		CarService cs =new CarServiceImpl();
		Car car =new Car(id,modelName,seatNum,carNum);
		if(cs.updateCar(car)==1) {
			request.getRequestDispatcher("ModelInfo.jsp").forward(request, response);
		}else {
			response.getWriter().print("¸üÐÂÊ§°Ü£¡");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
