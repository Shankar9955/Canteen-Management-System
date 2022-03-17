package com.cms.servlet;

import com.cms.entities.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quantity_Inc_Dec
 */
public class Quantity_Inc_Dec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quantity_Inc_Dec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String action = request.getParameter("action");
        int id =Integer.parseInt(request.getParameter("id"));
        
        ArrayList<Cart> cart_list =(ArrayList<Cart>) request.getSession().getAttribute("cart-list");
       
        if(action != null && id>1){                
            if(action.equals("inc")){
                for(Cart c : cart_list){
                    if(c.getId()== id){
                        int quantity = c.getQuantity();
                        quantity++;
                        c.setQuantity(quantity);
                        response.sendRedirect("Cart.jsp");
                    }
                }
                
            }
            if(action.equals("dec")){
                for(Cart c : cart_list){
                    if(c.getId()== id && c.getQuantity()>1){
                        int quantity = c.getQuantity();
                        quantity--;
                        c.setQuantity(quantity);
                       break;
                    }
                }
                 response.sendRedirect("Cart.jsp");
                
            }
    }else{
             response.sendRedirect("Cart.jsp");
        }
		
	}

}
