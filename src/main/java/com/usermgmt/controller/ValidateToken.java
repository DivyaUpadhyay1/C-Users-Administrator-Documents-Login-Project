package com.usermgmt.controller;

import com.usermgmt.controller.*;
import java.io.IOException;

import java.sql.Date;

import com.usermgmt.dao.TokenDao;
import com.usermgmt.modal.Token;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ValidateToken")
public class ValidateToken extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String token = request.getParameter("token");
        Token tokenObject = TokenDao.getToken(email, token);

        RequestDispatcher dispatcher = null;

        if (tokenObject != null ) {
            // Token is valid
            request.setAttribute("email", email);
            request.setAttribute("status", "success");
            dispatcher = request.getRequestDispatcher("newPassword.jsp");
        } else {
            // Token is invalid or expired
            request.setAttribute("message", "Invalid or expired token");
            dispatcher = request.getRequestDispatcher("EnterToken.jsp");
        }

        dispatcher.forward(request, response);
    }
}
