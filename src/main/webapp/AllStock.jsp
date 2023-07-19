
<%@page import="com.entity.purchaseProduct"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.JDBCConnection"%>
<%@page import="com.services.ServicesProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="Sidebar.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Stock</title>
</head>
<body>
	<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Stock</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="DashBord.jsp">Home</a></li>
              <li class="breadcrumb-item active">Stock</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card card-warning">
              <div class="card-header ">
                <h3 class="card-title">Available Stock</h3> 
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example2" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Sr. No.</th>
                    <th>Product Name</th>
                    <th>Available Quantity</th>
                    <th>HSN</th>
                   
                  </tr>
                  </thead>
                  <%
                  	try{
                  		ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
                  		List<purchaseProduct> li=sp.purchaseTotalList();
                  		int i=0;
                  		for(purchaseProduct ce: li ){
                  			i++;
                  			int a=sp.showAvilable(ce.getpName());
                  			String str=ce.getpQuantity();
                  			int b=Integer.parseInt(str);  
                  			int av=b-a;
                  			if(b-a<0){
                  				av=0;
                  			}
                  %>
                  <tbody >
					<% if(av>=0 && av<=10){
						
					%>
					<tr style="background-color: #e01d1d; color:white">
					<td><%= ce.getId() %>
					<td><%= ce.getpName()%></td>
					<td><%= av %></td>
					<td><%= ce.getpHSN() %></td>
					</tr>
					<% } else { %>
						
						<tr >
						<td><%= ce.getId() %>
						<td><%= ce.getpName()%></td>
						<td><%= b-a %></td>
						<td><%= ce.getpHSN() %></td>
						</tr>
						<%} %>
				</tbody>
				<%
                  		}
                  	}catch(Exception e){
                  		e.printStackTrace();
                  	}
%>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  
<%@ include file="footer.jsp" %>
</body>
</html>