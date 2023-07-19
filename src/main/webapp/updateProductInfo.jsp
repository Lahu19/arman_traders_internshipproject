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
<title>Add new Product</title>
</head>
<body>
<div class="content-wrapper">
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-6">
            <!-- general form elements -->
            <div class="card card-warning" style="margin:2%;">
              <div class="card-header">
                <h3 class="card-title">Edit Product Info </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="updatePProductServlet" method="post">
                <div class="card-body">
               	 <% try{
                    	String id=request.getParameter("id");
                    ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
                   List<purchaseProduct> lI=sP.popupProduct(id);

                      for(purchaseProduct obj: lI){
                      %>
                      <div class="form-group">
                    <label >Product ID</label>
                    <input type="text" class="form-control" value="<%=obj.getId() %>"  name="id" required>
                  </div>
                  <div class="form-group">
                    <label >Product Name</label>
                    <input type="text" class="form-control" value="<%=obj.getpName() %>"  name="pName" required>
                  </div>
                   <div class="form-group">
                    <label >Product Quantity</label>
                    <input type="text" class="form-control" value="<%= obj.getpQuantity() %>" name="pQuantity"required>
                  </div>
                  <div class="form-group">
                    <label>HSN</label>
                    <input type="text" class="form-control" value="<%= obj.getpHSN() %>"  name="pHSN" required>
                  </div>
                <div class="form-group">
                    <label >Purchase Date</label>
                    <input type="text" class="form-control" value="<%=obj.getpDate() %>"   name="pDate"required>
                  </div>
                 <div class="form-group">
                    <label >MRP</label>
                    <input type="text" class="form-control"  value="<%= obj.getpMRP() %>" name="pMRP" required>
                  </div>
                 
                   <% } }catch(Exception e){ e.printStackTrace(); } %>
                </div>
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Save</button>
                  <button type="reset" class="btn btn-danger ">Cancel</button>
                </div>
              </form>
            </div>
            <!-- /.card -->

            <!-- general form elements -->
          
          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
       
           
        </div>
    <%@ include file="footer.jsp" %>
</body>
</html>