<%@page import="com.cms.Database.productDatabase"%>
<%@page import="com.cms.connectionDB.ConnectionDataBase"%>
<%@page import="java.util.List"%>
<%@page import="com.cms.entities.Cart"%>
<%@page import="java.util.ArrayList"%>
<%
    
   
    User user = (User) session.getAttribute("user");

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        productDatabase pd = new productDatabase(ConnectionDataBase.getConnection());
        cartProduct = pd.getCartProduct(cart_list);
        int total = pd.getTotalPrice(cart_list);
        request.setAttribute("cart_list", cart_list);
        request.setAttribute("total", total);

    }

%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/style1.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <%@include file="includes/head.jsp"%>
        <%@include file="includes/footer.jsp"%>
        <title>Cart</title>
    </head>
    <body>
        <%@include file="Navbar/UserNavbar.jsp"%>

        <div class="container">
            <div class="d-flex py-3">
                <h3>Total Price :&#8377 ${(total>0)?total:0}</h3> <br>
                <a href="Order/orderForm.jsp" class="btn btn-primary btn-sm">Check Out</a>
                
            </div>
            <table class="table table-loghy mt-4">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Buy Now</th>
                        <th scope="col">Cancel</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (cart_list != null) {
                            for (Cart c : cartProduct) {
                                
                    %>

                    <tr>
                        <td><%=c.getTitle()%></td>
                        <td><%=c.getPrice()%></td>
                        <td>
                            <form action="" method="post" class="form-inline" >
                                <input type="hidden" name="id" value="<%=c.getId()%>" class="form-input">
                                <input type="hidden" name="prn" value="<%=user.getPrn()%>" class="form-input">
                                <div class="form-group d-flex justify-content-between ">
                                    <a class="btn btn-sm btn-incr" href="Quantity_Inc_Dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"> </i></a>
                                    <input class="fom-center w-50" type="text" name="quantity" value="<%=c.getQuantity()%>" readonly>
                                    <a class="btn btn-sm btn-decre" href="Quantity_Inc_Dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"> </i></a>
                                </div>
                                <a href="Order/orderForm.jsp" class="btn btn-primary btn-sm">Buy Now</a>
                             
                            </form>
                        </td>
                        <td><a href="RemoveFromCart?id=<%=c.getId()%>" class="btn btn-sm btn-danger text-white">Remove</a></td>
                    </tr>


                    <%
                            }
                        }

                    %>
                </tbody>

            </table>
        </div>
                
                          
               
    </body>
</html>
