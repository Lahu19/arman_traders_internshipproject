<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="Sidebar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add New Seller</title>
</head>
<body>
<div class="content-wrapper">
     		 <section class="content">
      <div class="container-fluid" style="margin:2%;">
        <div class="row">
          <!-- left column -->
          <div class="col-md-6">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Add new Vendor </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="AddNewSeller" method="post">
                <div class="card-body">
                  <div class="form-group">
                    <label >Vendor Name</label>
                    <input type="text" class="form-control" placeholder="Enter vendor's name" name="sName">
                  </div>
                  <div class="form-group">
                    <label >Vendors's Address</label>
                    <input type="text" class="form-control"  placeholder="Enter address" name="sAdd">
                  </div>
                 <div class="form-group">
                    <label >GST NO.</label>
                    <input type="text" class="form-control" placeholder="GST NO." name="sGST">
                  </div>
                 
                 <div class="form-group">
                    <label >Contact No.</label>
                    <input type="text" class="form-control"  placeholder="Contact No." name="sContact">
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
    <%@ include file="footer.jsp" %>
</body>
</html>