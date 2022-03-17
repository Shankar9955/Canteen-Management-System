<%@page import="com.cms.entities.User"%>
<%

    User user1 = (User) session.getAttribute("current-admin");
    

%>

<nav class="navbar navbar-expand-lg navbar-light navbar-st">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Sandip University Canteen</a>


            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
               
                <li class="nav-item"><a class="nav-link" href="#"><%= user1.getName() %></a></li>
               
                <li class="nav-item"><a class="nav-link" href="adminLogout">Logout</a></li>
                <!--<a href="../AdminLogin.jsp"></a>-->

            </ul>
        </div>
    
</nav>