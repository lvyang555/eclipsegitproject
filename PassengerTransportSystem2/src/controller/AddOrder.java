package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Order;
import service.OrderService;
import serviceimpl.OrderServiceImpl;

/**
 * Servlet implementation class AddOrder
 */
public class AddOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int tid =Integer.parseInt(request.getParameter("id"));
		int uid=(int) request.getSession().getAttribute("uid");
	
		OrderService os =new OrderServiceImpl();
		Date date =new Date();
		SimpleDateFormat ft =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Order order =new Order(uid, tid, 1, ft.format(date));
		if(os.addOrder(order)==1) {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("购买成功");
			out.print("<br/>");
			out.print("3秒后自动跳转到用户页面");
			response.setHeader("refresh", "3;LoginSuccess.jsp");
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("购买失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到用户页面");
			response.setHeader("refresh", "3;LoginSuccess.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
