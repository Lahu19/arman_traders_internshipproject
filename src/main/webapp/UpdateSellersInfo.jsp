<%@page import="com.entity.sellerEntity"%>

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
<title>Update Sellers Info</title>
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
                <h3 class="card-title">Edit Seller's Info </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="updateSellersInfoServelet" method="post">
                <div class="card-body">
               	 <% try{
                    	String id=request.getParameter("id");
                    ServicesProvider sP=new ServicesProvider(JDBCConnection.getconnection());
                   List<sellerEntity> lI=sP.popupSeller(id);

                      for(sellerEntity obj: lI){
                      %>
                      <div class="form-group">
                    <label >Seller's ID</label>
                    <input type="text" class="form-control" value="<%=obj.getId() %>"  name="id" required>
                  </div>
                  <div class="form-group">
                    <label >Seller's Name</label>
                    <input type="text" class="form-control" value="<%=obj.getsName() %>"  name="sName" required>
                  </div>
                   <div class="form-group">
                    <label >Seller's Address</label>
                    <input type="text" class="form-control" value="<%= obj.getsAdd() %>" name="sAddress"required>
                  </div>
                  <div class="form-group">
                    <label>Sellers GST NO.</label>
                    <input type="text" class="form-control" value="<%= obj.getsGST() %>"  name="sGST" required>
                  </div>
                <div class="form-group">
                    <label >Contact No.</label>
                    <input type="text" class="form-control" value="<%=obj.getsContact() %>"   name="sContact"required>
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