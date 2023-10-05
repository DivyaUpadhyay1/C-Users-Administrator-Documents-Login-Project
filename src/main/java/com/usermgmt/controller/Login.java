package com.usermgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.usermgmt.dao.UserDao;
import com.usermgmt.modal.User;

//
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//
@WebServlet("/ControllerServlet")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
           throws ServletException, IOException {  
       response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.print(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"/>");
        out.print("<body>\r\n"
        		+ "<div  style=\"border:  solid black; padding:5px;\">\r\n"
        		+ " <button type=\"button\" class=\"btn btn-secondary\"> <a href=\"index.jsp\">Login</a></button> \r\n"
        		+ "<button class=\"btn btn-warning\"> <a href=\"registration.jsp\">Registration</a></button> \r\n"
        		+ " <button class=\"btn btn-success\"><a href=\"view.jsp\">ViewUser</a></button> \r\n"
        		+ "<button class=\"btn btn-info\"> <a href='Logout'>Logout</a></button>\r\n"
        		+ "</div>");
          
       String name=request.getParameter("name");  
        String password=request.getParameter("password");            
        User bean=new User();  
        bean.setName(name);  
        bean.setPassword(password);  
      request.setAttribute("bean",bean);  
      
         
        boolean status=UserDao.isCheckLoginUser(bean); 
          
        if(status) {
        	
            
        	 HttpSession session=request.getSession();  
 	        session.setAttribute("name",name);   
 
//        	
//        	 request.setAttribute("<h1>success", "You are successfully logged in!</h1>");
        	
           	RequestDispatcher rd=request.getRequestDispatcher("welcom.jsp");  
               rd.forward(request, response); 
         }
         else {
        	 
        	 request.setAttribute("error", "<font color=red size=3>Login Failed!!<br>");
             
         	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
             rd.forward(request, response); 
         }
      
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
