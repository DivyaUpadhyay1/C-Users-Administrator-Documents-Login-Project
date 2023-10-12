//package com.usermgmt.controller;
//
//import java.io.IOException;
//
//import com.usermgmt.dao.UserDao;
//import com.usermgmt.modal.User;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/resetPassword")
//public class ResetPasswordServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String token = request.getParameter("token");
//        String newPassword = request.getParameter("newPassword");
//        String confirmPassword = request.getParameter("confirmPassword");
//        
//        // Validate the token and check its expiration
//        String email = validatePasswordResetToken(token);
//        
//        if (email != null) {
//            if (newPassword.equals(confirmPassword)) {
//                // Update the user's password
//                User user = new User();
//                user.setEmail(email);
//                user.setPassword(newPassword);
//                UserDao.updatePasswordByEmail(user);
//                
//                // Clear the token and expiration time
//                UserDao.clearPasswordResetToken(email);
//                
//                request.setAttribute("message", "Password reset successful.");
//            } else {
//                request.setAttribute("message", "Passwords do not match.");
//            }
//        } else {
//            request.setAttribute("message", "Invalid or expired token.");
//        }
//        
//        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
//    }
//    
//    // Validate the token and retrieve the user's email
//    private String validatePasswordResetToken(String token) {
//        // Implement token validation and return the associated email
//        return UserDao.validatePasswordResetToken(token);
//    }
//}
