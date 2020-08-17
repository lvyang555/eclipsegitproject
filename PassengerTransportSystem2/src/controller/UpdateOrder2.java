package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Order;
import service.OrderService;
import serviceimpl.OrderServiceImpl;

/**
 * Servlet implementation class UpdateOrder
 */
@WebServlet("/UpdateOrder2")
public class UpdateOrder2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id =Integer.parseInt(request.getParameter("id"));
		OrderService os =new OrderServiceImpl();
		if(os.UpdateOrder(id)==1) {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("打印成功！");
			out.print("<br/>");
			out.print("3秒后自动跳转到主页面");
		    response.setHeader("refresh", "3;OrderInfo.jsp");
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("出票失败！");
			out.print("<br/>");
			out.print("3秒后自动跳转到用户页面");
			response.setHeader("refresh", "3;OrderInfo.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
