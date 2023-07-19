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
      <div class="container-fluid" style="margin-top:2%;">
        <div class="row">
          <!-- left column -->
          <div class="col-md-6">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Find Purchase Product on the date </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="DatewisePurchaseServelet" method="post">
                <div class="card-body">
                 <div class="form-group">
                    <label >Purchase Date</label>
                    <input type="date" class="form-control"  placeholder="Purchase Date"  name="pDate"required>
                  </div>
                  
                </div>
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Find</button>
                  <button type="reset" class="btn btn-danger ">Cancel</button>
                </div>
              </form>
            </div>
          
          </div>
          <div class="col-md-6">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Find sold Product on the date </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="DateWiseSellsservelet" method="post">
                <div class="card-body">
                 <div class="form-group">
                    <label >Sold Date</label>
                    <input type="date" class="form-control"  placeholder="Purchase Date"  name="pDate"required>
                  </div>
                  
                </div>
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Find</button>
                  <button type="reset" class="btn btn-danger ">Cancel</button>
                </div>
              </form>
            </div>
          
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