<%@page import="com.entity.purchaseProduct"%>
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
<title>New Customer Bill</title>
</head>
<body>
<div class="content-wrapper">
     		 <section class="content">
      <div class="container-fluid" style="margin-top:1% ">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Add new Bill </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="NewSellBillServelet" method="post">
                <div class="card-body">
                
                <div class="row">
                    <div class="col-sm-6">
                  <div class="form-group">
                    <label >GST NO.</label>
                    <input type="text" class="form-control" placeholder="Enter GST no." name="billNo" required>
                  </div>
                  </div>
                  <div class="col-sm-6">
                   <div class="form-group">
                    <label >Bill  Date</label>
                    <input type="date" class="form-control"  placeholder="Billl Date"  name="pDate"required>
                  </div>
                  </div>
                  </div>
                   <div class="row">
                    <div class="col-sm-6">
                      <!-- select -->
                     
                      <div class="form-group">
                        <label>Select Customer Name</label>
                        <select class="form-control" name="cName">
                         <%
                  	try{
                  		ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
                  		List<CustomerEntity> li=sp.totalList();
                  		int j=0;
                  		for(CustomerEntity ce:li  ){
                  			j++;
                  %>
                          <option><%=ce.getcName() %></option>
                          
                        <%}
                  		} catch(Exception e){
                  			e.printStackTrace();
                  		}%>
                  		</select>
                      </div>
                    </div>
                   
                    <div class="col-sm-6">
                      <!-- select -->
                      <div class="form-group">
                        <label >Select Product Name</label>
                       <select class="form-control"  id="myDropdown" onchange="getSelectValues()" name="pName">
                         <%
                  	try{
                  		ServicesProvider sp=new ServicesProvider(JDBCConnection.getconnection());
                  		List<purchaseProduct> li=sp.purchaseTotalList();
                  		int i=0;
           
                  		for(purchaseProduct pp:li  ){
                  			i++;
                  %>
                          <%-- <option value=<%= pp.getpMRP() %>><%=pp.getpName()%></option> --%>
                          <option ><%=pp.getpName()%></option>
                          
                        <%}
                  		} catch(Exception e){
                  			e.printStackTrace();
                  		}%>
                  		
                        </select>
                      </div>
                    </div>
                    </div>
                    
                   <div class="row">
                    <div class="col-sm-6"> 
                 <div class="form-group">
                    <label >Product Price</label>
                  <input type="text" class="form-control" id="demo" name="pPrice" > 
                 <!--  <p class="form-control" id="demo"></p> -->
                 </div>
                 </div>
                 <div class="col-sm-6">
                 <div class="form-group">
                    <label  >Product Quantity</label>
                    <input type="text" id="pQ" class="form-control" placeholder="Product Quantity" name="pQuantity"required>
                  </div>
                  </div>
                  </div>
                  
                 <div class="form-group">
                    <label >Total</label>
                    <input type="text" class="form-control" name="pTotal" id="toto"  readonly="readonly">
                  </div>
                  
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
    <script>
    function getSelectValues() {
        var dropdown = document.getElementById("price").value;
        //var selectedIndex = dropdown.selectedIndex;
        document.getElementById("demo").innerHTML = dropdown;
      } 
   
    $(document).ready(function(){
    	$("#pQ,#demo").keyup(function(){
    		var total=0;
    		var x=Number($("#pQ").val());
    		var y=Number($("#demo").val());
    		var total=x*y;
    		$("#toto").val(total);
    	}) ;
    });
      
    </script>
    <%@ include file="footer.jsp" %>
</body>
</html>