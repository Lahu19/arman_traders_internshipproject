package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.JDBCConnection;
import com.entity.soldProduct;
import com.services.ServicesProvider;

/**
 * Servlet implementation class DateWiseSellsservelet
 */
@WebServlet("/DateWiseSellsservelet")
public class DateWiseSellsservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateWiseSellsservelet() {
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
		String pDate=request.getParameter("pDate");
		System.out.println(pDate);
		try {
			ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
			List<soldProduct> li = sP.checkSell(pDate);
			boolean b=li.isEmpty();
			if(b!=true) {
			response.sendRedirect("DateWiseSells.jsp?pDate="+pDate);
			}else {
				response.sendRedirect("recordnotFound.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
