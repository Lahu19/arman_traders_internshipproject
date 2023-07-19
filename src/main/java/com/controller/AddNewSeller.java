package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.JDBCConnection;
import com.entity.sellerEntity;
import com.services.ServicesProvider;

/**
 * Servlet implementation class AddNewSeller
 */
@WebServlet("/AddNewSeller")
public class AddNewSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewSeller() {
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
		String sName=request.getParameter("sName");
		System.out.println(sName);
		String sAdd=request.getParameter("sAdd");
		System.out.println(sAdd);
		String sGST=request.getParameter("sGST");
		System.out.println(sGST);
		String sContact=request.getParameter("sContact");
		System.out.println(sContact);
		sellerEntity se=new sellerEntity();
		se.setsName(sName);
		se.setsAdd(sAdd);
		se.setsGST(sGST);
		se.setsContact(sContact);
		
		try {
			ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sp.addNewSeller(se);
			if(b) {
				response.sendRedirect("SuppplierList.jsp");
			}else {
				response.sendRedirect("AddNewSuppllier.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
