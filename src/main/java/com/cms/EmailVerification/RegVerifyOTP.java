package com.cms.EmailVerification;

import com.cms.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class RegVerifyOTP
 */
public class RegVerifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegVerifyOTP() {
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

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("authcode");

        String code = request.getParameter("authcode");

        if (code.equals(user.getVcode())) {

            try {
                Connection con;
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Rshankar", "radhe");
                out.println("Connected...");

                String query = "insert into Student (Prn,name,branch,mobile,email,password) values(?,?,?,?,?,?)";
                PreparedStatement pt = con.prepareStatement(query);

                pt.setString(1, user.getPrn());
                pt.setString(2, user.getName());
                pt.setString(3, user.getBranch());
                pt.setString(4, user.getMobile());
                pt.setString(5, user.getEmail());
                pt.setString(6, user.getPassword());

                pt.executeUpdate();

                RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
                rd.forward(request, response);

            } catch (Exception e) {
                out.println("Error...." + e.getMessage());

            }

        } else {
            out.println("Incorrect verification code");
        }

    }
}
