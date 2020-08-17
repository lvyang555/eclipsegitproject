package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.UserService;
import serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService us=new UserServiceImpl();
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		HttpSession session = request.getSession();
		User user =us.login(name, pwd);
		if(user!=null){//µÇÂ¼ÑéÖ¤
			session.setAttribute("uid", user.getUid());
			session.setAttribute("name",name);
			session.setAttribute("pwd",pwd );
			session.setMaxInactiveInterval(200);
			  
			  request.getRequestDispatcher("LoginSuccess.jsp?uname="+name).forward(request, response);
			  
				
			}else{              //µÇÂ¼Ê§°Ü£¬Ìø×ªµ½Ê§°ÜÒ³
				response.setContentType("text/html;cgarset=UTF-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.print("µÇÂ¼Ê§°Ü");
				out.print("<br/>");
				out.print("3Ãëºó×Ô¶¯Ìø×ªµ½µÇÂ¼Ò³Ãæ");
				response.setHeader("refresh", "3;UserLogin.jsp");
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
