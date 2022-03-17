<%@page import="com.cms.Database.UserLoginDB"%>
<%@page import="java.util.List"%>
<%@page import="com.cms.entities.User"%>
<%@page import="com.cms.connectionDB.ConnectionDataBase"%>
<%

    UserLoginDB ud = new UserLoginDB(ConnectionDataBase.getConnection());
    List<User> ulist = ud.getUser();

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../includes/footer.jsp" %>
        <%@include file="../includes/head.jsp" %>
        <title>User LIst</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light justify-content-between">
            <a class="navbar-brand">User List</a>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" >
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </nav>

        <div class="container">
            <table class="table table-loghy mt-4">
                
                <!--Table Head-->
                
                <thead>
                    <tr>
                        <th scope="col" aria-label="Search">Prn</th>
                        <th scope="col">Name</th>
                        <th scope="col">Branch</th>
                        <th scope="col">Mobile Number</th>
                        <th scope="col">Email Id</th>
                    </tr>
                </thead>
                
                <!--Table Body-->

                <tbody>
                    <%                    for (User u : ulist) {

                    %>

                    <tr>
                        <td><%=u.getPrn()%></td>
                        <td><%=u.getName()%></td>
                        <td><%=u.getBranch()%></td>
                        <td><%=u.getMobile()%></td>
                        <td><%=u.getEmail()%></td>



                    </tr>


                    <%
                        }


                    %>
                </tbody>

            </table>

        </div>

                <!--Button for go to Admin Home Page-->
                
        <div class="container">
            <a href="../AdminHome.jsp"><button type="submit" class="btn btn-primary">Go to Admin Home Page</button></a>
          
        </div>
    </body>
</html>
