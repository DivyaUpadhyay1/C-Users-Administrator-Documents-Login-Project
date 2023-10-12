<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="servlet/SendMail">  
To:<input type="text" name="to"/><br/>  
Subject:<input type="text" name="subject"><br/>  
Text:<textarea rows="10" cols="70" name="msg"></textarea><br/>  
<input type="submit" value="send"/>  
</form>  
</body>
</html>