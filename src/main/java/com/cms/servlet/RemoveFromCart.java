package com.cms.servlet;

import com.cms.entities.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String id = request.getParameter("id");
         
         if(id!=null){
             ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
             if(cart_list != null){
                 for(Cart c: cart_list){
                     if(c.getId() == Integer.parseInt(id)){
                         cart_list.remove(cart_list.indexOf(c));
                         break;
                     }
                 }
                 response.sendRedirect("Cart.jsp");
             }
         }
         else{
             response.sendRedirect("Cart.jsp");
         }
     }
		
	}

