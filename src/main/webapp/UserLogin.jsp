

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>

<link href="CSS/style1.css" rel="stylesheet" type="text/css" />
<%@include file="/includes/head.jsp"%>

<title>Login</title>
</head>
<body>

	<%@ include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5">

			<%@ include file="ValidationStatus/validation.jsp"%>

			<div class="card-header text-center">User Login</div>

			<div class="card-body">
				<form action="UserLogin" method="post">

					<div class="form-group">
						<label>PRN No</label> <input type="text" name="prn"
							class="form-control" placeholder="Enter Prn No">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
						<a href="Register.jsp" class="btn btn-dark text-white">Register
							Here</a>
					</div>
				</form>
			</div>
		</div>
	</div>



	<%@include file="/includes/footer.jsp"%>
</body>
</html>