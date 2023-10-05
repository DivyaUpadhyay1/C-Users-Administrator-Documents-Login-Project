<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:include page="header.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
 <style>.blue {
            color: blue;
        }
        .blue {
            color: red;
        }
        
        
        </style>
        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"/>
</head>
<body>

<h1><Center><p class="red">Login Successfull</p>
<br><p class="blue">Welcome</p>

<%

 
String name=(String)session.getAttribute("name");  
out.print("Hello "+name);

%>

</br></br>
</Center>
</h1>



     

<%if(request.getAttribute("success")!=null){
	out.print(request.getAttribute("success"));}
	%>
	
</body>
 <%@ include file="footer.jsp" %>
</html>