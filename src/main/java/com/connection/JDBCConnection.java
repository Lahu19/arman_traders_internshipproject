package com.connection;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class JDBCConnection {
public static Connection con;
	
	public static Connection getconnection() {
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/armantraders","root","");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return con;
	}
}
