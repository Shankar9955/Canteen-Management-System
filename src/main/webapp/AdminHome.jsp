
<%@page import="com.cms.Database.UserLoginDB"%>
<%@page import="com.cms.entities.productData"%>
<%@page import="com.cms.Database.productDatabase"%>
<%@page import="com.cms.entities.CategoryData"%>
<%@page import="com.cms.Database.CategoryDatabase"%>
<%@page import="com.cms.entities.User"%>
<%@page import="java.util.List"%>
<%@page import="com.cms.connectionDB.ConnectionDataBase"%>
<%@page import="java.sql.ResultSet"%>
<%

    User user = (User) session.getAttribute("current-admin");
    if (user == null) {
        session.setAttribute("massage", "Sorry You are not logedin");
        response.sendRedirect("AdminLogin.jsp");
        return;
    }


%>
<%    UserLoginDB ud = new UserLoginDB(ConnectionDataBase.getConnection());
    List<User> ulist = ud.getUser();

    CategoryDatabase cd = new CategoryDatabase(ConnectionDataBase.getConnection());
    List<CategoryData> clist = cd.getCategory();

    productDatabase pd = new productDatabase(ConnectionDataBase.getConnection());
    List<productData> plist = pd.getProduct();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
        <%@include file="/includes/head.jsp"%>
    </head>
    <body>

        <%@include file="Navbar/adminNav.jsp" %>

        <div class="container admin">

            <!--First Row-->
            <%@include file="ValidationStatus/validation.jsp" %>
            <div class="row mt-3">

                <!--First Col-->
                <div class="col-md-4">
                    <!--First Box-->
                    <div class="card">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 100px;" class="img-fluid rounded-circle" src="images/icons/user.png" alt="">

                            </div>

                            <h1><%=ulist.size()%></h1>
                            <a href="User/userlist.jsp"> <h1 class="text-uppercase text-muted">Users</h1></a>
                        </div>
                    </div>


                </div> 

                <!--Second Col-->

                <div class="col-md-4">
                    <!--Second Box-->                    
                    <div class="card">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 100px;" class="img-fluid rounded-circle" src="images/icons/categories.png" alt="">

                            </div>

                            <h1><%=clist.size()%></h1>
                            <a href="CategoryList.jsp"><h1 class="text-uppercase text-muted">Category</h1></a>
                        </div>
                    </div>
                </div> 



                <!--Third Col-->

                <div class="col-md-4">
                    <!--Third Box-->                    
                    <div class="card">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 100px;" class="img-fluid rounded-circle" src="images/icons/product.png" alt="">

                            </div>

                            <h1><%=plist.size()%></h1>
                            <a href="ProductList.jsp"><h1 class="text-uppercase text-muted">Products</h1></a>
                        </div>
                    </div>
                </div> 


            </div>

            <!--Second Row-->

            <div class="row mt-3">
                <div class="col-md-4">
                    <div class="card" data-bs-toggle="modal" data-bs-target="#add-product-model">
                        <div class="card-body text-center" >
                            <div class="container">
                                <img style="max-width: 100px;" class="img-fluid" src="images/icons/addp.png" alt=""/>
                            </div>
                            <h3>Click here to add Product</h3>
                            <h1 class="text-uppercase text-muted">Add Product</h1>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card"  data-bs-toggle="modal" data-bs-target="#add-category-model">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 100px;" class="img-fluid" src="images/icons/addC.png" alt=""/>
                            </div>

                            <h3>Click here to add Categories</h3>
                            <h1 class="text-uppercase text-muted" style="text-size: 25px;" > Add Categories</h1>
                        </div>
                    </div>
                </div>

                <!--Third Col-->

                <div class="col-md-4">
                    <!--Third Box-->                    
                    <div class="card">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 100px;" class="img-fluid rounded-circle" src="images/icons/Orders.png" alt="">
                            </div>

                            <h1>12</h1>
                            <a href="UserOrders"><h1 class="text-uppercase text-muted">Orders</h1></a>
                        </div>
                    </div>
                </div> 


            </div>





            <!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--> 
            <!--Add Category Model-->
            <!--Stert Module-->

            <div class="modal fade" id="add-category-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Enter Product Details</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="AddCategories" method="post" enctype="multipart/form-data">

                                <div class="form-group">
                                    <input type="text" class="form-control" name="catTitle" placeholder="Enter Category Title" required>  
                                </div>
                                <div class="form-group mt-3">
                                    <textarea class="form-control" style="height:80px;" placeholder="Enter Category Description" name="cDesc" required></textarea>

                                </div> 
                                <div class="form-group mt-3">
                                    <label>Select picture of Product </label>
                                    <input type="file" class="form-control" name="cPic" required>  
                                </div>

                                <div class="container  mt-3 text-center">

                                    <button class="btn btn-outline-success">Add Category</button>
                                </div>

                            </form>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">Close</button>

                        </div>

                    </div>
                </div>
            </div>


            <!--End Category Model-->







            <!--Start Product Model-->


            <!-- Modal -->
            <div class="modal fade" id="add-product-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Enter Product Details</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="AddProduct" method="post" enctype="multipart/form-data">

                                <div class="form-group">
                                    <input type="text" class="form-control" name="proTitle" placeholder="Enter Product Title" required>  
                                </div>
                                <div class="form-group mt-3">
                                    <textarea class="form-control" style="height:80px;" placeholder="Enter Product Description" name="pDesc" required></textarea>

                                </div> 
                                <div class="form-group mt-3">
                                    <input type="number" class="form-control" name="pPice" placeholder="Enter Poduct Price" required>  
                                </div>
                                <div class="form-group mt-3">
                                    <input type="number" class="form-control" name="pQuantity" placeholder="Enter Product Quentity" required>  
                                </div>

                                <!--.......................................................-->




                                <div  class="form-group ">
                                    <select name="catId" class="form-control mt-3" >

                                        <%                                            for (CategoryData c : clist) {


                                        %>

                                        <option value="<%=c.getId()%>"><%= c.getTitle()%></option>

                                        <%
                                            }
                                        %>


                                    </select>

                                </div>



                                <div class="form-group mt-3">
                                    <label>Select picture of Product </label>
                                    <input type="file" class="form-control" name="pPic" required>  
                                </div>

                                <div class="container  mt-3 text-center">

                                    <button class="btn btn-outline-success">Add Product</button>
                                </div>

                            </form>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">Close</button>

                        </div>

                    </div>
                </div>
            </div>





            <!--End Product Model-->

            <%@include file="/includes/footer.jsp"%>
    </body>
</html>
