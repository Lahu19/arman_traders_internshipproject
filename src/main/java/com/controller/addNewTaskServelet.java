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
 * Servlet implementation class addNewTaskServelet
 */
@WebServlet("/addNewTaskServelet")
public class addNewTaskServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewTaskServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String addTask=request.getParameter("addTask");
		System.out.println(addTask);
		String taskType=request.getParameter("taskType");
		System.out.println(taskType);
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sP.addNewtask(addTask,taskType);
			if(b) {
				System.out.println("Successful insertion ");
				response.sendRedirect("DashBord.jsp");
			}else {
				response.sendRedirect("AddnewTask.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
