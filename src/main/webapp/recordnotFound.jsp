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

 <div class="content-wrapper" >
    
    <section class="content">
      <div class="error-page">
        <h2 class="headline text-warning">404</h2>

        <div class="error-content">
          <h3><i class="fas fa-exclamation-triangle text-warning"></i> Oops! Record not found.</h3>

          <p>
            We could not find the Record you were looking for.
            Meanwhile, you may <br>
            <a href="DashBord.jsp" style="text-align: center;">return to Dashboard</a>
             <h3 style="width: 100%; text-align: center; border-bottom: 1px solid #000; line-height: 0.1em; margin: 10px 0 20px; "><span style="background:#f4f6f9; padding:0 10px; ">or</span> <h3></h3>
             <a href="DateWise.jsp" style="text-align: center;">return to Back</a>
          </p>

          
        </div>
        <!-- /.error-content -->
      </div>
      <!-- /.error-page -->
    </section>
    <!-- /.content -->
  </div>
 
    <%@ include file="footer.jsp" %>
</body>
</html>