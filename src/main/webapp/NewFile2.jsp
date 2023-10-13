<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.usermgmt.modal.User" %>
<%@ page import="com.usermgmt.dao.UserDao" %>
<jsp:include page="header.jsp"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Update Employee</h1>
        <%
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            User user = UserDao.getEmployeeById(id); // Fetch the user by ID
        %>

        <form action="EditServlet2" method="post">
            <input type="hidden" name="id" value="<%= user.getId() %>">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= user.getName() %>">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="<%= user.getPassword() %>">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= user.getEmail() %>">
            </div>
            <div class="form-group">
                <label for="country">Country:</label>
                <select class="form-control" id="country" name="country">
                    <option>India</option>
                    <option>USA</option>
                    <option>UK</option>
                    <option>Other</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Edit & Save</button>
        </form>
    </div>

    <!-- Include Bootstrap JS (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
<%@ include file="footer.jsp" %>
</html>
