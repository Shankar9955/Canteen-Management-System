package com.cms.Login;
import com.cms.Database.UserLoginDB;

import com.cms.connectionDB.ConnectionDataBase;
import com.cms.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
//        Featching Values from form

        String prn = request.getParameter("prn");
        String password = request.getParameter("password");

        try {
            
//            Database Connection

           UserLoginDB Ulogin = new UserLoginDB(ConnectionDataBase.getConnection());
           
            User user = Ulogin.login(prn, password);
             HttpSession session = request.getSession();
            
             if(user!=null){
               
                session.setAttribute("user", user);
               
                response.sendRedirect("UserHome.jsp");
            }else{
                
                session.setAttribute("massage", "Invalid User ID and Password");
                response.sendRedirect("UserLogin.jsp");
            }
            
        
        } catch (Exception e) {
            out.println("Error...." + e.getMessage());
        }
    }

}
