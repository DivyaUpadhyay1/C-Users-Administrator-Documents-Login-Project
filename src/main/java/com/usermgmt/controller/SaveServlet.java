package com.usermgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SaveServlet") 
public class SaveServlet  extends HttpServlet {   

	
	 
	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	          
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        
	          
        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String email=request.getParameter("email");  
	        String country=request.getParameter("country"); 
	        

	       
	          
	       User e=new User();  
	        e.setName(name);  
	        e.setPassword(password);  
	        e.setEmail(email);  
	        e.setCountry(country);  
	       
	          
	        int status=UserDao.save(e);
	       	        
	        if(status>0){ 
	        	
	        	 
	  
	         	
//	         	 request.setAttribute("record", "<h1>Record saved successfully!Hellow</h1>");
	         	
	            	RequestDispatcher rd=request.getRequestDispatcher("registrationwelcome.jsp");  
	                rd.forward(request, response); 
	            
//	            out.print("<h1><p>Record saved successfully!Hellow </p>"+name+"</h1>");
//	            
//		        
//	            
//	            out.print(" <button type=\"button\" class=\"btn btn-warning\"><a href=\"view.jsp\">view employees</a></button> ");
	           
	        }else{  
	            out.println("Sorry! unable to save record ");
	            response.sendRedirect("registration.jsp");
	        }  
	          
	        out.close();  
	    }  
	  
	}  

