package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarService;
import service.TripsService;
import serviceimpl.CarServiceImpl;
import serviceimpl.TripsServiceImpl;

/**
 * Servlet implementation class deleteCar
 */
public class DeleteCar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id= Integer.parseInt(request.getParameter("id"));
		TripsService ts =new TripsServiceImpl();
		CarService cs =new CarServiceImpl();
		
		if(cs.deleteCar(id)==1&&ts.deleteSome(id)==1) {
			request.getRequestDispatcher("ModelInfo.jsp").forward(request, response);
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("删除失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到查询页面");
			response.setHeader("refresh", "3;ModelInfo.jsp");
		}
				
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
