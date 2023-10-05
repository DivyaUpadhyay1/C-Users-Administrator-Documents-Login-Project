<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.usermgmt.dao.UserDao" %>
<%@ page import="com.usermgmt.modal.User" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employees List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="header.jsp"/>
    
    <div class="container">
        <h1>Employees List</h1>

        <%
            int currentPage = 1; // Current page number
            int recordsPerPage = 5; // Number of records per page

            // Get the current page number from the request parameter
            String pageParam = request.getParameter("page");
            if (pageParam != null && !pageParam.isEmpty()) {
                currentPage = Integer.parseInt(pageParam);
            }

            // Get a sublist of employees based on the current page
            List<User> list = UserDao.getEmployeesByPage(currentPage, recordsPerPage);

            out.print("<table class=\"table table-striped table-dark\">");
            // ... (your table headers)
             out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
        
            for (User e : list) {
                out.print("<tr>");
                out.print("<td>" + e.getId() + "</td>");
                out.print("<td>" + e.getName() + "</td>");
                out.print("<td>" + e.getPassword() + "</td>");
                out.print("<td>" + e.getEmail() + "</td>");
                out.print("<td>" + e.getCountry() + "</td>");
                
                out.print("<td><a href='Edit.jsp?id=" + e.getId() + "'>edit</a></td>");
                out.print("<td><a href='view.jsp?id=deleteButton" + e.getId() + "' onclick='confirmDelete(" + e.getId() + ")'>delete</a></td>");
                out.print("</tr>");
            }

            out.print("</tbody>");
            out.print("</table>");

            // Calculate total pages based on the total number of records
            int totalRecords = UserDao.getTotalEmployees();
            int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

            // Display pagination links
            out.print("<ul class=\"pagination\">");
            for (int i = 1; i <= totalPages; i++) {
                if (i == currentPage) {
                    out.print("<li class=\"page-item active\"><span class=\"page-link\">" + i + "</span></li>");
                } else {
                    out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"?page=" + i + "\">" + i + "</a></li>");
                }
            }
            out.print("</ul>");
        %>
        
        <!-- Your JavaScript code here -->
        <script>
            function confirmDelete(userId) {
                if (confirm("Are you sure you want to delete this record?")) {
                    // Redirect to the delete servlet if the user confirms
                   // window.location.href = "DeleteServlet?id=" + userId;
                    window.open('DeleteServlet?id='+ userId);
                }
            }
        </script>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.0/js/bootstrap.min.js"></script>
</body>
<%@ include file="footer.jsp" %>
</html>
