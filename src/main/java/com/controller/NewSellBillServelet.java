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
 * Servlet implementation class NewSellBillServelet
 */
@WebServlet("/NewSellBillServelet")
public class NewSellBillServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSellBillServelet() {
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
		String billNo=request.getParameter("billNo");
		System.out.println(billNo);
		String pDate=request.getParameter("pDate");
		System.out.println(pDate);
		String cName=request.getParameter("cName");
		System.out.println(cName);
		String pName=request.getParameter("pName");
		System.out.println(pName);
		String pPrice=request.getParameter("pPrice");
		System.out.println(pPrice);
		String pQuantity=request.getParameter("pQuantity");
		System.out.println(pQuantity);
		String pTotal=request.getParameter("pTotal");
		System.out.println(pTotal);
		
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sP.addNewSellBill(billNo, pDate, cName, pName, pPrice,pQuantity, pTotal);
			if(b) {
				System.out.println("Successful insertion ");
				response.sendRedirect("DashBord.jsp");
			}else {
				response.sendRedirect("NewSellBill.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
