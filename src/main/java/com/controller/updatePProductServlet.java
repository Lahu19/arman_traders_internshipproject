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
 * Servlet implementation class updatePProductServlet
 */
@WebServlet("/updatePProductServlet")
public class updatePProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePProductServlet() {
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
		String pName=request.getParameter("pName");
		System.out.println(pName);
		String pQuantity=request.getParameter("pQuantity");
		System.out.println(pQuantity);
		String pHSN=request.getParameter("pHSN");
		System.out.println(pHSN);
		String pDate=request.getParameter("pDate");
		System.out.println(pDate);
		String pMRP=request.getParameter("pMRP");
		System.out.println(pMRP);
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sP.UpdateProduct(pName, pQuantity, pDate, pHSN, pMRP, id);
			if(b) {
				System.out.println("Successful Updation ");
				response.sendRedirect("productList.jsp");
			}else {
				response.sendRedirect("updateProductInfo.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
