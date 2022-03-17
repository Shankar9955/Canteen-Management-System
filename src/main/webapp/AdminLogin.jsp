
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
        <%@include file="/includes/head.jsp"%>
    </head>
    <body>
      <%@include file="/includes/navbar.jsp"%>

	<div class="container admin">
		<div class="card w-50 mx-auto my-5">
                    <%@ include file="ValidationStatus/adminvalidation.jsp"%>
			<div class="card-header  text-center">Admin Login</div>
                       
			<div class="card-body">
				<form action="adminLogin" method="post">
                                    
					<div class="form-group">
						<label>Admin ID</label> 
						<input type="text" name="adminId" class="form-control" placeholder="Enter Your ID">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
    </body>
</html>
