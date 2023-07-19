<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="index.jsp" %>
<%@ include file="Navbar.jsp" %>
<body>
 <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="DashBord.jsp" class="brand-link">
      <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Arman Traders</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <a href="DashBord.jsp" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Dashboard
              </p>
            </a>
            </li>
          <li class="nav-item">
            <a href="AllStock.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                All Stock
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="DateWise.jsp" class="nav-link">
              <i class="nav-icon fas fa-server"></i>
              <p>
                Day wise summary
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
                Purchase Product
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right">4</span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="AddNewProduct.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Product</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="productList.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Product List</p>
                </a>
              </li>
            </ul>
            </li>
           <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-image"></i>
              <p>
                Sells Info
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right">3</span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="AddNewCustomer.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Customer</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="CustomerList.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Customer List </p>
                </a>
              </li>
              <li class="nav-item">
                <a href="NewSellBill.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Customer bills</p>
                </a>
              </li>
            </ul>
            </li>
            
             <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user-circle"></i>
              <p>
                Vender
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right">2</span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="AddNewSuppllier.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add new Supplier</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="SuppplierList.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Supplier List </p>
                </a>
              </li>
            </ul>
            </li>
                    
</ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>


</body>
</html>