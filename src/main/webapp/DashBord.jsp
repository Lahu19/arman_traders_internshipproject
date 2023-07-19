<%@page import="com.entity.addNewTask"%>
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
<title>DashBord</title>
</head>
<body>
	 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
        <div class="row">
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-info">
              <div class="inner">
             <% 
             try{
             ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
             int id=sp.showProduct();
            	%> 
                <h3><%= id %></h3>
			<%}catch(Exception e){
				e.printStackTrace();
				}%>
		
                <p>Products</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag"></i>
              </div>
              <a href="productList.jsp" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-success">
              <div class="inner">
                 <% 
             try{
             ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
             int id=sp.showCustomer();
            	%> 
                <h3><%= id %></h3>
			<%}catch(Exception e){
				e.printStackTrace();
				}%>
		
                <p>New Customers</p>
              </div>
              <div class="icon">
              <i class="ion ion-person-add"></i>
              </div>
              <a href="CustomerList.jsp" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-warning">
              <div class="inner">
                <% 
             try{
             ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
             int id=sp.showSells();
            	%> 
                <h3><%= id %></h3>
			<%}catch(Exception e){
				e.printStackTrace();
				}%>

                <p>Sells per month</p>
              </div>
              <div class="icon">
                <i class="ion ion-stats-bars"></i>
              </div>
              <a href="DateWise.jsp" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-danger">
              <div class="inner">
                <% 
             try{
             ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
             int id=sp.showSupplier();
            	%> 
                <h3><%= id %></h3>
			<%}catch(Exception e){
				e.printStackTrace();
				}%>

                <p>New Vender</p>
              </div>
              <div class="icon">
                <i class="ion ion-person-add"></i>
              </div>
              <a href="SuppplierList.jsp" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
          <!-- Left col -->
          <section class="col-lg-7 connectedSortable">
            <!-- Custom tabs (Charts with tabs)-->
           <!-- /.card-header -->
              
            <!-- TO DO List -->
            <div class="card">
            <form>
              <div class="card-header">
                <h3 class="card-title">
                  <i class="ion ion-clipboard mr-1"></i>
                  To Do List
                </h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <ul class="todo-list" data-widget="todo-list">
                  <%
                  	try{
                  		ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
                  		List<addNewTask> li=sp.taskTotalList();
                  		int i=0;
                  		for(addNewTask ce: li ){
                  			i++;
                  	
                  %>
                  <li>
                    <span class="handle">
                      <i class="fas fa-ellipsis-v"></i>
                      <i class="fas fa-ellipsis-v"></i>
                    </span>
                    <span class="text"><%=ce.getAddtask() %></span>
                    <small class="badge badge-info"><i class="far fa-clock"></i><%=ce.getType() %></small>
                    <div class="tools">
                      <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i><a href="deleteaddedtask?pid=<%=ce.getId()%>" style="text-decoration: none; color:white;">Delete</a> </button>
                    </div>
                  </li>
                  	<%
                  		}
                  	}catch(Exception e){
                  		e.printStackTrace();
                  	}
%>
                </ul>
                
              </div>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                <button type="button" class="btn btn-primary float-right"><i class="fas fa-plus"></i><a href="AddnewTask.jsp" style="text-decoration: none; color:white;"> Add task</a></button>
              </div>
              </form>
            </div>
            
            <!-- /.card -->
          </section>
         
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
</body>
</html>