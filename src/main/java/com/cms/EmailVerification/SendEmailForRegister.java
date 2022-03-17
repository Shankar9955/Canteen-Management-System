package com.cms.EmailVerification;

import java.util.Random;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cms.entities.User;

public class SendEmailForRegister {

	// generate vrification code
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	public boolean sendEmail(User user) {
		boolean test = false;

		String toEmail = user.getEmail();
		final String fromEmail = "sandipuniversitycanteen@gmail.com";
		final String password = "Sandip@123";

		try {

			String host = "smtp.gmail.com";
			String port = "465";
			Properties pr = new Properties();
			pr.put("mail.smtp.host", host);
			pr.put("mail.smtp.port", port);
			pr.put("mail.smtp.auth", "true");
			pr.put("mail.smtp.socketFactory.port", port);
			pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			try {
				// set email message details
				Message mess = new MimeMessage(session);
				System.out.println("s1");
				// set from email address
				mess.setFrom(new InternetAddress(fromEmail));
				System.out.println("s2");
				// set to email address or destination email address

				mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				System.out.println("s3");
				// set email subject
				mess.setSubject("User Email Verification");
				System.out.println("s4");
				// set message text
				mess.setText("Registered successfully.Please verify your account using this code: " + user.getVcode());
				// send the message
				System.out.println("s5");
				Transport.send(mess);
				System.out.println("s6");
				test = true;
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return test;
	}
}
