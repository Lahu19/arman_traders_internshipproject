<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="Sidebar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new Task</title>
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
                <h3 class="card-title">Add new Task </h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="addNewTaskServelet" method="post">
                <div class="card-body">
                  <div class="form-group">
                    <label >Add New Task</label>
                    <input type="text" class="form-control" placeholder="Enter task details" name="addTask" required>
                  </div>
                  <div class="form-group">
                    <label>Type</label>
                    <input type="text" class="form-control"  placeholder="Enter Task Type" name="taskType" required>
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