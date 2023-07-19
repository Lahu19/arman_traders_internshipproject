<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="Sidebar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add New Customer</title>
</head>
<body>
<div class="content-wrapper">
     		 <section class="content">
      <div class="container-fluid" style="margin-top:2%;">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Add new Customer </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="AddNewCustomerServelet" method="post">
                <div class="card-body">
                <div class="row">
                 <div class="col-sm-6">
                  <div class="form-group">
                    <label >Customer Name</label>
                    <input type="text" class="form-control" placeholder="Enter Customer name" name="cName">
                  </div>
                  </div>
                   <div class="col-sm-6">
                  <div class="form-group">
                    <label >Customer's Address</label>
                    <input type="text" class="form-control"  placeholder="Enter address" name="cadd">
                  </div>
                  </div>
                  </div>
                  <div class="row">
                  <div class="col-sm-6">
                 <div class="form-group">
                    <label >GST NO.</label>
                    <input type="text" class="form-control" placeholder="GST NO." name="cGST">
                  </div>
                 </div>
                 <div class="col-sm-6">
                 <div class="form-group">
                    <label >Contact No.</label>
                    <input type="text" class="form-control"  placeholder="Contact No." name="ccontact">
                  </div>
                 </div>
                 </div>
                  
                </div>
                <div class="card-footer">
                  <button type="submit" style="margin:.5%;"class="btn btn-primary">Save</button>
                  <button type="reset" style="margin:.5%;" class="btn btn-danger ">Cancel</button>
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