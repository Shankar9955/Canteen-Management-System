
<%@page import="com.cms.entities.User"%>
<%@page import="com.cms.helper.DescriptionHelper"%>
<%@page import="com.cms.entities.CategoryData"%>
<%@page import="com.cms.Database.CategoryDatabase"%>
<%@page import="java.util.List"%>
<%@page import="com.cms.entities.productData"%>
<%@page import="com.cms.Database.productDatabase"%>
<%@page import="com.cms.connectionDB.ConnectionDataBase"%>


<%

    User user = (User) session.getAttribute("user");
   
    
    if(user == null) {
        session.setAttribute("massage", "Sorry You are not logedin");
        response.sendRedirect("UserLogin.jsp");
        return;
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
          <%@include file="/includes/head.jsp"%>
        <title>Home</title>
    </head>
    <body>
       
        <%@include file="Navbar/UserNavbar.jsp"%>

        <div class="container-fluid px-0 top-bannerUser">
            <div class="container ">

                <h1>Like Mom's house</h1>
                <p>Give your Hunger a new Option</p>
             
            </div>            
        </div>


        <div class="categoryUser text-center">




            <%

                String cat = request.getParameter("CategoryData");

                productDatabase pd = new productDatabase(ConnectionDataBase.getConnection());
                List<productData> list = null;
                if (cat==null || cat.trim().equals("all")) {
                    list = pd.getProduct();
                } else {
                    String Cid = cat.trim();
                    list = pd.getpoductById(Cid);
                }

                CategoryDatabase cd = new CategoryDatabase(ConnectionDataBase.getConnection());
                List<CategoryData> cdlist = cd.getCategory();


            %>

            <!--Col1-->

            <a href="index.jsp?CategoryData=all"><h1>All Category</h1></a>

            <div class="container">
                <div class="row mt-5 mb-5">
                    <%                        for (CategoryData cda : cdlist) {

                    %>

                    <div class="col-lg-3  col-md-3 col-sm-3 col-10 d-block m-auto ">

                        <div class="card">
                            <div class="card-body">
                                <div class="container">

                                    <img src="images/Category/<%=cda.getImage()%>"  style="max-width :100% ; max-height: 100px;" alt=""/>

                                </div>
                                <h3 class="card-title"><%=cda.getTitle()%></h3>

                                <p class="card-text"><%=DescriptionHelper.getdesc3(cda.getDesc())%></p>
                                <a href="index.jsp?CategoryData=<%=cda.getId()%>">
                                    <button class="main-btn mt-2">Explore Now</button>
                                </a>
                            </div>
                        </div>

                    </div>
                    <%
                        }
                    %>

                </div>

            </div>

        </div>

        <section class="productsUser text-center">
            <h1>Products</h1>

            <div class="container">
                <div class="row mt-5 mb-5">
                    <%                         for (productData p : list) {
                    %>
                    <div class="col-sm-3">

                        <div class="card">
                            <div class="card-body">
                                <div class="container">
                                    <img src="images/Products/<%=p.getImage()%>" style="max-width :100% ; max-height: 100px;">   
                                </div>
                                <h3 class="card-title text-center"><%=p.getTitle()%></h3>

                                <p class="card-text text-center"><%=DescriptionHelper.getdesc3(p.getDescription())%></p>
                                 <h5 class="text-right"> &#8377 <%=p.getPrice()%></h5>
                               
                               <div class="mt-3 d-flex justify-content-between">
                                    <a href="AddCart?id=<%=p.getId()%>" class="btn btn-dark text-white">Add to Cart</a>
                                    <a href="" class="btn btn-primary text-white ml-2">Buy Now</a>
                                </div>

                            </div>
                        </div>

                    </div>
                    <%
                        }
                    %>

                </div>

            </div>

        </section>


 
    </body>
</html>
