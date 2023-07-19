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
 * Servlet implementation class updateSellersInfoServelet
 */
@WebServlet("/updateSellersInfoServelet")
public class updateSellersInfoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSellersInfoServelet() {
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
		String id=request.getParameter("id");
		System.out.println(id);
		String sName=request.getParameter("sName");
		System.out.println(sName);
		String sAddress=request.getParameter("sAddress");
		System.out.println(sAddress);
		String sGST=request.getParameter("sGST");
		System.out.println(sGST);
		String sContact=request.getParameter("sContact");
		System.out.println(sContact);
		
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			boolean b=sP.UpdateSeller(sName, sAddress, sGST, sContact, id);
			if(b) {
				System.out.println("Successful Customer info Updation ");
				response.sendRedirect("SuppplierList.jsp");
			}else {
				response.sendRedirect("UpdateSellersInfo.jsp");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
