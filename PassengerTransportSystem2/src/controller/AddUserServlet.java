package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;
import serviceimpl.UserServiceImpl;


/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		UserService us=new UserServiceImpl();
		String name=new String(request.getParameter("uname").getBytes("iso-8859-1"),"utf-8");
		String pwd=new String(request.getParameter("upwd").getBytes("iso-8859-1"),"utf-8");
		User user=new User(name,pwd);
		if(us.register(user)==1){
			response.sendRedirect("UserLogin.jsp");
		}else{
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("用户名已被注册，注册失败");
			out.print("<br/>");
			out.print("3秒后自动跳转到注册页面");
			response.setHeader("refresh", "3;Register.jsp");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
