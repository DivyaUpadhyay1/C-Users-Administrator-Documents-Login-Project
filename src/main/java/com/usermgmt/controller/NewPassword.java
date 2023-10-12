package com.usermgmt.controller;

import java.io.IOException;

import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    String uName = request.getParameter("name");
	    String newPassword = request.getParameter("password");
	    String confPassword = request.getParameter("confPassword");
	    RequestDispatcher dispatcher = null;

	    if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
	        // Create a User object or fetch it from your UserDao using uName
	        // Assuming you have a User class with appropriate properties
	        User user = new User();
	        user.setName(uName);
	        user.setPassword(newPassword);

	        // Call the updatePasswordByEmail method to update the password
	        int updateStatus = UserDao.updatePasswordByName(user);

	        if (updateStatus > 0) {
	            request.setAttribute("status1", "resetSuccess");
	            dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
	        } else {
	            request.setAttribute("status", "resetFailed");
	            dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
	        }
	    } else {
	        // Passwords don't match
	        request.setAttribute("status", "resetFailed");
	        dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
	    }
	    
	    dispatcher.forward(request, response);
	}

	}


