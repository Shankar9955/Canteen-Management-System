package com.cms.servlet;

import com.cms.entities.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class AddCart
 */
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        ArrayList<Cart> cartlist = new ArrayList<Cart>();
        
        int id =Integer.parseInt(request.getParameter("id"));
        Cart cm = new Cart();
        cm.setId(id);
        cm.setQuantity(1);
       
        HttpSession session = request.getSession();
     
        ArrayList<Cart> Cart_list = (ArrayList)session.getAttribute("cart-list");
        
//        out.println("Created Successfully");
        if(Cart_list == null){
            cartlist.add(cm);
            session.setAttribute("cart-list", cartlist);
            response.sendRedirect("UserHome.jsp");
            
        }else{
            cartlist = Cart_list;
            boolean exist=false;
            for(Cart c: Cart_list){
                if(c.getId() == id){
                    exist=true;
                    System.out.println("<h3 style='color:crimson; text-align:center'>Product Exit.<a href='Cart.jsp'>Go to Cart Page</a></h3>");
                }                   
            }
            if(!exist){
                cartlist.add(cm);
                response.sendRedirect("UserHome.jsp");
                
            }
            
            
        }
		
	}

}
