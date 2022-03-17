package com.cms.servlet;

import com.cms.Database.CategoryDatabase;
import com.cms.connectionDB.ConnectionDataBase;
import com.cms.entities.CategoryData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddCategories
 */
public class AddCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategories() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String title = request.getParameter("catTitle");
        String desc = request.getParameter("cDesc");
        Part part = request.getPart("cPic");
        
        String image = part.getSubmittedFileName();
       

        CategoryData CateData = new CategoryData(title, desc, image);

        CategoryDatabase CatDatabase = new CategoryDatabase(ConnectionDataBase.getConnection());

        String path = request.getRealPath("images") + File.separator + "Category" + File.separator + image;
           
        FileOutputStream fos = new FileOutputStream(path);

        InputStream is = part.getInputStream();

//        Reading Data
        byte[] data = new byte[is.available()];
        is.read(data);

//        Writing Data
        fos.write(data);
        
          fos.close();

        HttpSession Hs = request.getSession();

        try {

            if (CatDatabase.catData(CateData)) {
                Hs.setAttribute("massage", "Successful");
                response.sendRedirect("AdminHome.jsp");
            } else {
                out.println("Sorry13");
            }

        } catch (Exception ex) {
            out.println("Error     " + ex);
        }
		
	}

}
