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
 * Servlet implementation class UpdateCustmoerServelet
 */
@WebServlet("/UpdateCustmoerServelet")
public class UpdateCustmoerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustmoerServelet() {
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
		String id=request.getParameter("id");
		System.out.println(id);
		String cName=request.getParameter("cName");
		System.out.println(cName);
		String cAddress=request.getParameter("cAddress");
		System.out.println(cAddress);
		String cGST=request.getParameter("cGST");
		System.out.println(cGST);
		String cContact=request.getParameter("cContact");
		System.out.println(cContact);
		
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sP.UpdateCustomer(cName, cAddress, cGST, cContact, id);
			if(b) {
				System.out.println("Successful Customer info Updation ");
				response.sendRedirect("CustomerList.jsp");
			}else {
				response.sendRedirect("updateCustomerInfo.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	}


