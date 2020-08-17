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
		if(user!=null){//��¼��֤
			session.setAttribute("uid", user.getUid());
			session.setAttribute("name",name);
			session.setAttribute("pwd",pwd );
			session.setMaxInactiveInterval(200);
			  
			  request.getRequestDispatcher("LoginSuccess.jsp?uname="+name).forward(request, response);
			  
				
			}else{              //��¼ʧ�ܣ���ת��ʧ��ҳ
				response.setContentType("text/html;cgarset=UTF-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.print("��¼ʧ��");
				out.print("<br/>");
				out.print("3����Զ���ת����¼ҳ��");
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
