package com.usermgmt.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgetPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        // Check if the email exists in the database
        User user = new User();
        user.setEmail(email);
        if (UserDao.isUserExists(user)) {
            // Generate a temporary password
            String temporaryPassword = generateTemporaryPassword();
            
            // Update the user's password in the database
            user.setPassword(temporaryPassword);
            int updateStatus = UserDao.updatePasswordByEmail(user);

            if (updateStatus > 0) {
                // Send an email with the temporary password
                sendResetEmail(email, temporaryPassword);

                response.getWriter().println("Password reset link sent to your email address.");
            } else {
                response.getWriter().println("Failed to reset the password.");
            }
        } else {
            response.getWriter().println("Email not found in our records.");
        }
    }

    // Method to generate a temporary password
    private String generateTemporaryPassword() {
        // You can generate a temporary password as per your requirements
        // For example, generate a random password or a predefined one.
        return "temporaryPassword123";
    }

    private Session getSession() {
        
//    	String host = "localhost";
        String username = "arishidivya@gmail.com";
        //Enter your Gmail password
        String password = "bkeo jsui zufa szyx";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");

        return Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
    // Method to send an email
    private void sendResetEmail(String recipientEmail, String temporaryPassword) {
        final String username = "arishidivya@gmail.com";
        final String password = "bkeo jsui zufa szyx";

        String subject = "Password Reset";
        String body = "Your temporary password is: " + temporaryPassword;

       // Properties props =  System.getProperties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
////        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.host", "192.168.29.1");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.ssl.enable", "true");
//        Properties prop = new Properties();
//        prop.put("mail.smtp.auth", true);
//        prop.put("mail.smtp.starttls.enable", "true");
//        prop.put("mail.smtp.host", host);
//        prop.put("mail.smtp.port", 587);
//        prop.put("mail.smtp.ssl.trust", host);
//        
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "25");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		/*
		 * Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		 * protected PasswordAuthentication getPasswordAuthentication() { return new
		 * PasswordAuthentication(username, password); } });
		 */
        Session session = getSession();
        try {
			
			 Message message = new MimeMessage(session); message.setFrom(new
			  InternetAddress(username)); message.setRecipients(Message.RecipientType.TO,
			  InternetAddress.parse(recipientEmail)); message.setSubject(subject);
			  message.setText(body);
			  
			   Transport.send(message); Transport tr = session.getTransport("smtp");
			 tr.connect("smtp.gmail.com", 465, username, password); message.saveChanges();
			  tr.sendMessage(message, message.getAllRecipients()); tr.close();
			 
        	
//        	getSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
