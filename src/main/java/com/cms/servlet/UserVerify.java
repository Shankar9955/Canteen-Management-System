package com.cms.servlet;

import com.cms.EmailVerification.SendEmailForRegister;
import com.cms.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String prn = request.getParameter("prn");
        String name = request.getParameter("name");
        String branch = request.getParameter("branch");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //create instance object of the SendEmail Class
        SendEmailForRegister sm = new SendEmailForRegister();
     
        //get the 6-digit code
        String code = sm.getRandom();
        System.out.println(code);
        //craete new user using all information
        User user = new User(prn, name, branch, mobile, email, password,code);
        
        //call the send email method
//        boolean test = sm.sendEmail( user);
        
        if(sm.sendEmail(user)){
             HttpSession session = request.getSession();
            session.setAttribute("authcode", user);
            response.sendRedirect("RegistrationVerifyOTP.jsp");
        }else{
            System.out.println("OTP Does Not Send");
        }
        
	}

}
