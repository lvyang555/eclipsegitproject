package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TripsService;
import serviceimpl.TripsServiceImpl;

/**
 * Servlet implementation class DeleteTrips
 */
@WebServlet("/DeleteTrips")
public class DeleteTrips extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id =Integer.parseInt(request.getParameter("id"));
		TripsService ts =new TripsServiceImpl();
		if(ts.deleteTrips(id)==1) {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("ɾ���ɹ�");
			out.print("<br/>");
			out.print("3����Զ���ת����ѯҳ��");
			response.setHeader("refresh", "3;TripsInfo.jsp");
		}else {
			response.setContentType("text/html;cgarset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			out.print("ɾ��ʧ��");
			out.print("<br/>");
			out.print("3����Զ���ת����ѯҳ��");
			response.setHeader("refresh", "3;TripsInfo.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
