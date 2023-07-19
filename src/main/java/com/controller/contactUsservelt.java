package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.JDBCConnection;
import com.services.ServicesProvider;

/**
 * Servlet implementation class contactUsservelt
 */
@WebServlet("/contactUsservelt")
public class contactUsservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactUsservelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name=request.getParameter("name");
		System.out.println(name);
		String email=request.getParameter("email");
		System.out.println(email);
		String sub=request.getParameter("sub");
		System.out.println(sub);
		String message=request.getParameter("message");
		System.out.println(message);
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sP.insertcontactUs(name, email, sub, message);
			if(b) {
				System.out.println("Successful insertion ");
				response.sendRedirect("DashBord.jsp");
			}else {
				response.sendRedirect("ContactUs.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
