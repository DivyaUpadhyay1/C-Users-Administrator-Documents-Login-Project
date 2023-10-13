package com.usermgmt.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.usermgmt.dao.TokenDao;
import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.Token;
import com.usermgmt.modal.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//Import necessary packages

@WebServlet("/forgotpassword")
public class ForgetPassword1 extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

     String email = request.getParameter("email");
     RequestDispatcher dispatcher = null;
     
     
     HttpSession mySession = request.getSession();
     
     User e = new User();
     e.setEmail(email);

     if (UserDao.isUserExists(e)) {
         // Generate a random token
         String token = generateRandomToken();
         String to = email;
         
         // Calculate the expiration time (1 hour from the current time)
//         Date expirationDate = new Date(System.currentTimeMillis() + 3600000); // 3600000 milliseconds = 1 hour

         // Save the token in the database
         Token tokenObject = new Token();
         tokenObject.setEmail(email);
         tokenObject.setToken(token);
         TokenDao.saveToken(tokenObject);

         // Send the token to the user (via email or any other method)
         
         // Change accordingly
         // Get the session object
        
         Properties props = new Properties();
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.socketFactory.port", "465");
         props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.port", "465");
         Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication("arishidivya@gmail.com", "bkeo jsui zufa szyx"); // Put your email
                                                                                                     // id and
                                                                                                     // password here
             }
         });
         // Compose message
         try {
             MimeMessage message = new MimeMessage(session);
             message.setFrom(new InternetAddress(email)); // Change accordingly
             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
             message.setSubject("Hello");
             message.setText("Your Token is: " + token);
             // Send message
             Transport.send(message);
             System.out.println("Message sent successfully");
         } catch (MessagingException e1) {
             throw new RuntimeException(e1);
         }
         dispatcher = request.getRequestDispatcher("EnterToken.jsp");
         request.setAttribute("message", "Token is sent to your email id");
         mySession.setAttribute("token", token);
         mySession.setAttribute("email", email);
         dispatcher.forward(request, response);

         dispatcher = request.getRequestDispatcher("EnterToken.jsp");
         request.setAttribute("message", "A token has been sent to your email.");
         dispatcher.forward(request, response);
     } else {
         response.getWriter().println("Email not found in our records.");
     }
 }

 private String generateRandomToken() {
	 
     // Generate a random token as per your requirements
     // You can use a library or algorithm to create a secure token
     // For example:
     Random rand = new Random();
     String token = Integer.toString(rand.nextInt(1000000));
     return token;

 }
}
