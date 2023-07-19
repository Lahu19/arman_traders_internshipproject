
<%@page import="com.entity.CustomerEntity"%>
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
<title>Customer List</title>
</head>
<body>
	<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Customer List</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="DashBord.jsp">Home</a></li>
              <li class="breadcrumb-item active">Customer List</li>
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
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Customer List</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example2" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Sr. No.</th>
                    <th>Customer Name</th>
                    <th>Customer's Address</th>
                    <th>GST No.</th>
                    <th>Contact No.</th>
                    <th>Status</th>
                  </tr>
                  </thead>
                  <%
                  	try{
                  		ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
                  		List<CustomerEntity> li=sp.totalList();
                  		int i=0;
                  		for(CustomerEntity ce: li ){
                  			i++;
                  	
                  %>
                  <tbody>
					<tr>
					<td><%= ce.getId()%></td>
					<td><%=ce.getcName() %></td>
					<td><%= ce.getcAdd() %></td>
					<td><%= ce.getcGST() %></td>
					<td><%=ce.getcContact()%></td>
					<td>
                  <button type="submit" class="btn btn-primary"><a href="updateCustomerInfo.jsp?id=<%=ce.getId()%>" style="text-decoration: none; color:white;">Update</a></button>
                  <button type="submit" class="btn btn-danger "><a href="deleteCustomer?id=<%=ce.getId()%>" style="text-decoration: none; color:white;">Delete</a></button>
                	</td>
					</tr>
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