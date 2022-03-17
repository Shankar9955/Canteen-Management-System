package com.cms.Login;

import com.cms.Database.AdminDatabase;
import com.cms.Database.UserLoginDB;
import com.cms.connectionDB.ConnectionDataBase;
import com.cms.entities.User;
import com.cms.entities.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class adminLogin
 */
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogin() {
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
            
            
            String id = request.getParameter("adminId");
            String password = request.getParameter("password");
           
            AdminDatabase adminDatabase= new AdminDatabase(ConnectionDataBase.getConnection());
            
            admin ad = adminDatabase.login(id, password);
            
             System.out.println(ad.getId());
             HttpSession session = request.getSession();
            if(ad!=null){
               
                session.setAttribute("current-admin", ad);
             
                response.sendRedirect("AdminHome.jsp");
            }else{
              
                session.setAttribute("massage", "Invalid Admin ID and Password");
                response.sendRedirect("AdminLogin.jsp");
            }
  
        }

}
