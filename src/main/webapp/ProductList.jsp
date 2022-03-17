<%@page import="java.util.List"%>
<%@page import="com.cms.entities.productData"%>
<%@page import="com.cms.Database.productDatabase"%>
<%@page import="com.cms.connectionDB.ConnectionDataBase"%>
<%
    productDatabase pd = new productDatabase(ConnectionDataBase.getConnection());
    List<productData> plist = pd.getProduct();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
        <%@include file="includes/head.jsp" %>
        <%@include file="includes/footer.jsp" %>

        <title>JSP Page</title>
    </head>
    <body>

        <div class="container">
            <table class="table table-loghy mt-4">
                <thead>
                    <tr>
                        <th scope="col" aria-label="Search">Product Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Price</th>

                    </tr>
                </thead>

                <tbody>
                    <%                    for (productData p : plist) {

                    %>

                    <tr>
                        <td><%=p.getId()%></td>
                        <td><%=p.getTitle()%></td>
                        <td><%=p.getDescription()%></td>
                        <td><%=p.getPrice()%></td>

                    </tr>


                    <%
                        }


                    %>
                </tbody>

            </table>

        </div>

        <div class="container">

            <a href="AdminHome.jsp"><button type="submit" class="btn btn-primary">Go to Admin Home Page</button></a>
        </div>


    </body>
</html>
