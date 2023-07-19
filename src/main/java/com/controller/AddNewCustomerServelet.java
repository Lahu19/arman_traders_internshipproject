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
 * Servlet implementation class AddNewCustomerServelet
 */
@WebServlet("/AddNewCustomerServelet")
public class AddNewCustomerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCustomerServelet() {
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
		String cName=request.getParameter("cName");
		System.out.println(cName);
		String cadd=request.getParameter("cadd");
		System.out.println(cadd);
		String cGST=request.getParameter("cGST");
		System.out.println(cGST);
		String ccontact=request.getParameter("ccontact");
		System.out.println(ccontact);
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sP.addNewCustomer(cName, cadd, cGST, ccontact);
			if(b) {
				System.out.println("Successful insertion ");
				response.sendRedirect("CustomerList.jsp");
			}else {
				response.sendRedirect("AddNewCustomer.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
