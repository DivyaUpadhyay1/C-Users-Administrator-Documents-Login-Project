package com.usermgmt.controller;

import java.io.IOException;

import com.usermgmt.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        int status= UserDao.delete(id);
System.out.println("gfy"+status);
        
        // Redirect to delete.jsp
        if(status>0){  
        	System.out.println("status"+ status);
       request.getRequestDispatcher("delete.jsp").forward(request, response);
  //      response.sendRedirect("delete.jsp");
    }
        
}
}