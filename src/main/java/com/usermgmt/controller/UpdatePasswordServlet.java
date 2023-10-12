package com.usermgmt.controller;




import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the user's current password, new password, and confirm password from the form
    	
    	        // Retrieve user input from the update password form
    	        String username = request.getParameter("name");
    	        String oldPassword = request.getParameter("oldPassword");
    	        String newPassword = request.getParameter("newPassword");

    	        // Create a User object with the provided name and old password 
    	        User user = new User();
    	        user.setName(username);
    	        user.setPassword(oldPassword);

    	        // Check if the user's old password is valid
    	        boolean isValidUser = UserDao.CheckLoginUser(user);

    	        if (isValidUser) {
    	            // Update the user's password with the new password
    	            user.setPassword(newPassword);
    	            int updateStatus = UserDao.updatePasswordByUsername(user);

    	            if (updateStatus > 0) {
    	                // Password update successful
    	            	
    	                response.sendRedirect("passwordUpdateSuccess.jsp");
    	                System.out.println(updateStatus);
    	            }}
   	           
    	         else {
    	        	// Invalid old password, redirect to an error page or display an error message
	            	 request.setAttribute("error3", "<font color=red size=3>Invalid old password!!!<br>");
	                 
 	              	RequestDispatcher rd=request.getRequestDispatcher("updatePassword.jsp");  
 	                  rd.forward(request, response); 
	            	
    	        	System.out.println("fggmbv1");
    	          
    	        }
    	    }
    }



