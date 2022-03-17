<%@page import="com.cms.entities.User"%>
<%

    User use = (User) session.getAttribute("user");
   
%>


<nav class="navbar navbar-expand-md navbar-st">


    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Sandip University Canteen</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar"
                aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon" style="background-color: red;"></span>
        </button>
        <div class="collapse navbar-collapse text-center" id="navbar">
            <ul class="navbar-nav ml-auto ">
                <li class="nav-item"><a class="nav-link" href="UserHome.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="Cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span> </a></li>


                <li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><%= use.getName() %></a></li>
                <li class="nav-item"><a class="nav-link" href="UserLog">Logout</a></li>


            </ul>

        </div>

    </div>

</nav>

