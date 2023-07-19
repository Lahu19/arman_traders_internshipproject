<%@page import="com.entity.soldProduct"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.JDBCConnection"%>
<%@page import="com.services.ServicesProvider"%>
<%@page import="com.entity.purchaseProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="Sidebar.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P&S List</title>
</head>
<body >
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Sells Details</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="DashBord.jsp">Home</a></li>
              <li class="breadcrumb-item active">Sells List</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
<section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-12">
            <div class="card card-warning">
              <div class="card-header ">
                <h3 class="card-title">Sells Details</h3> 
      		</div>
            <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                  	<th>Sell bill No.</th>
                    <th>Sell Date</th>
                    <th>Product Name</th>
                    <th>Product Quantity</th>
                  </tr>
                  </thead>
               <tbody>
                   <%
                  	try{
                  		String pDate=request.getParameter("pDate");
                  		ServicesProvider spp=new ServicesProvider(JDBCConnection.getconnection());
                  		List<soldProduct> li=spp.checkSell(pDate);
                  		int j=0;
                  		for( soldProduct obj :li  ){
                  			j++;
                  %>
                  <tr>
                    <th><%=obj.getId() %></th>
                    <th><%= obj.getSpDate() %></th>
                    <th><%= obj.getpName() %>
                    <th><%= obj.getpQuantity() %></th>
                  </tr>
                        <%}
                  		} catch(Exception e){
                  			e.printStackTrace();
                  		}%>
               </tbody>      
                </table>
              </div>      
            </div>
          </div>
                
  
        </div>
      </div>
    </section>
  </div>
  <script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });

  document.getElementById("search-button").addEventListener("click", function() {
  var searchInput = document.getElementById("search-input").value;
  search(searchInput);
});

function search(searchTerm) {
  var searchResultsContainer = document.getElementById("search-results");
  searchResultsContainer.innerHTML = "";
}


</script>
<%@ include file="footer.jsp" %>
</body>
</html>
   