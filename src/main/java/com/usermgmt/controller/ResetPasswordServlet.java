package com.usermgmt.controller;

import java.io.IOException;

import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        // Generate a new random password (you can implement your logic here)
        String newPassword = "newRandomPassword";

        // Update the user's password in the database
        User user = new User();
        user.setEmail(email);
        user.setPassword(newPassword);
        int status = UserDao.updatePasswordByEmail(user);

        if (status > 0) {
            // Send the new password to the user's email (not implemented here)
            // You should implement email sending functionality here

            // Forward to a success message JSP
            request.setAttribute("message", "Password reset successful. Check your email for the new password.");
            request.getRequestDispatcher("forgetPassword.jsp").forward(request, response);
        } else {
            // Forward to an error message JSP
            request.setAttribute("error", "Password reset failed. Email not found.");
            request.getRequestDispatcher("forgetPassword.jsp").forward(request, response);
        }
    }
}
