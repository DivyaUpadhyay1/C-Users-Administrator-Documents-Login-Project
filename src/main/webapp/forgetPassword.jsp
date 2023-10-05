<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forget Password</title>
    <!-- Add Bootstrap CSS link here -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Forget Password</h1>
        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <form action="ResetPasswordServlet" method="post">
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Reset Password</button>
                </form>
            </div>
        </div>
        
        <% if(request.getAttribute("message")!=null) { %>
        <div class="alert alert-success mt-4">
            <%= request.getAttribute("message") %>
        </div>
        <% } %>
        
        <% if(request.getAttribute("error")!=null) { %>
        <div class="alert alert-danger mt-4">
            <%= request.getAttribute("error") %>
        </div>
        <% } %>
    </div>

    <!-- Add Bootstrap JS and jQuery scripts here -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<%@ include file="footer.jsp" %>
</html>
