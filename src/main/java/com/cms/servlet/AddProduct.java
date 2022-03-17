package com.cms.servlet;

import com.cms.Database.productDatabase;
import com.cms.connectionDB.ConnectionDataBase;
import com.cms.entities.productData;
import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

        String title = request.getParameter("proTitle");
        String description = request.getParameter("pDesc");
        int price = Integer.parseInt(request.getParameter("pPice"));

       
        
        Part part = request.getPart("pPic");
        
        String image = part.getSubmittedFileName();
        String Cid = request.getParameter("catId");

        productData ProD = new productData(title, description, price,image,Cid);

        productDatabase CatDatabase = new productDatabase(ConnectionDataBase.getConnection());

//        Find Image Path
        String path = request.getRealPath("images")+File.separator +"Products" + File.separator + image;
        System.out.println(path);

        FileOutputStream fos = new FileOutputStream(path);
//
        InputStream is = part.getInputStream();

//        Reading Data
        byte[] data = new byte[is.available()];
        is.read(data);

//        Writing Data
        fos.write(data);
//
        fos.close();

        HttpSession Hs = request.getSession();

        try {

            if (CatDatabase.Product(ProD)) {
                
                Hs.setAttribute("massage", "Successful");
                response.sendRedirect("AdminHome.jsp");
            } else {
            	Hs.setAttribute("massage", "Not Add");
                response.sendRedirect("AdminHome.jsp");
            }

        } catch (SQLException ex) {
        	System.out.println("Error     " + ex);
        }
		
	}

}
