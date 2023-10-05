<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.usermgmt.modal.User" %>
<%@ page import="com.usermgmt.dao.UserDao" %>
<jsp:include page="header.jsp"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
    <h1>Update Employee</h1>
    <%
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        User user = UserDao.getEmployeeById(id); // Fetch the user by ID
    %>

    <form action="EditServlet2" method="post">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="<%= user.getName() %>"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="<%= user.getPassword() %>"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="<%= user.getEmail() %>"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>
                    <select name="country" style="width:150px">
                        <option>India</option>
                        <option>USA</option>
                        <option>UK</option>
                        <option>Other</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Edit & Save">
                </td>
            </tr>
        </table>
    </form>
</body>
<%@ include file="footer.jsp" %>
</html>
