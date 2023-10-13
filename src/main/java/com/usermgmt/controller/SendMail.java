package com.usermgmt.controller;

    import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  
      
    
      
@WebServlet("/servlet/SendMail")   
    public class SendMail extends HttpServlet {  
    public void doGet(HttpServletRequest request,  
     HttpServletResponse response)  
        throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String to=request.getParameter("email");  
//        String subject=request.getParameter("subject");  
//        String msg=request.getParameter("msg"); 
        
              
        Mailer.send(to, "", "");  
        out.print("message has been sent successfully");  
        out.close();  
        }  
      
    }  
