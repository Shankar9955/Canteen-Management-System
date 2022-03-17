<%-- 
    Document   : Register
    Created on : Aug 29, 2021, 3:27:16 PM
    Author     : Mr_Sah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
        <%@include file="/includes/head.jsp"%>
    </head>
    <body>




        <%@include file="/includes/navbar.jsp"%>

        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <%@ include file="ValidationStatus/validation.jsp"%>

                <div class="card-header text-center">Register Here</div>

                <div class="card-body">
                    <form action="UserVerify" method="post">

                        <div class="form-group">
                            <label>PRN No</label> 
                            <input type="text" name="prn" class="form-control" placeholder="Enter PRN">
                        </div>
                        <div class="form-group">
                            <label>Name</label> 
                            <input type="text" name="name" class="form-control" placeholder="Enter Name">
                        </div>
                        <div class="form-group mt-3">

                            <label>Branch  </label>&nbsp
                            <select name="branch">
                                <option>Select Banch</option>
                                <option>BCA</option>
                                <option>Computer Science</option>
                                <option>Mechinacle</option>
                                <option>Civil</option>
                                <option>Electrical</option>
                                <option>BBA</option>
                                <option>MBA</option>
                            </select>

                        </div>
                        <div class="form-group mt-3">
                            <label>Mobile No</label> 
                            <input type="text" name="mobile" class="form-control" placeholder="Enter Mobile Number">
                        </div>
                         <div class="form-group">
                            <label>Email</label> 
                            <input type="text" name="email" class="form-control" placeholder="Enter Email">
                        </div>
                        
                        <div class="form-group">
                            <label>Password</label> 
                            <input type="password" name="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
