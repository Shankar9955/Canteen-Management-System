<%@page import="java.util.List"%>
<%@page import="com.cms.Database.CategoryDatabase"%>
<%@page import="com.cms.entities.CategoryData"%>
<%@page import="com.cms.connectionDB.ConnectionDataBase"%>
<%

    CategoryDatabase cd = new CategoryDatabase(ConnectionDataBase.getConnection());
    List<CategoryData> list = cd.getCategory();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Style.css" rel="stylesheet" type="text/css"/>
        <%@include file="includes/head.jsp" %>
        <%@include file="includes/footer.jsp" %>
        <title>Category List</title>
    </head>
    <body>

        <div class="container">
            <table class="table table-loghy mt-4">
                <thead>
                    <tr>
                        <th scope="col" aria-label="Search">Name</th>
                        <th scope="col">Description</th>

                    </tr>
                </thead>

                <tbody>
                    <%                    for (CategoryData c : list) {

                    %>

                    <tr>
                        <td><%=c.getTitle()%></td>
                        <td><%=c.getDesc()%></td>

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
