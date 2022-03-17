<%-- 
    Document   : RegistrationVerifyOTP
    Created on : Sep 18, 2021, 7:26:56 PM
    Author     : Mr_Sah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
        <%@include file="/includes/head.jsp"%>
        <%@include file="/includes/footer.jsp"%>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container ">

            <div class="card w-50 mx-auto my-5">

                <div class="card-header  text-center">Verify Your OTP</div>

                <div class="card-body">

                    <form action="RegVerifyOTP" method="post">
                        <!--<input type="text" name="authcode" >-->
                        <!--<input type="submit" value="verify">-->

                        <div class="form-group">
                            <label>Enter OTP</label> 
                            <input type="text" name="authcode" class="form-control" placeholder="Enter OTP">
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">verify</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
