package com.usermgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")  
public class EditServlet2  extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		String sid=req.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=req.getParameter("name");  
        String password=req.getParameter("password");  
        String email=req.getParameter("email");  
        String country=req.getParameter("country");  
          
        User e=new User();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=UserDao.update(e);  
        if(status>0){  
            resp.sendRedirect("view.jsp");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
	}

