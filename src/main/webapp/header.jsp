<!DOCTYPE html>
<html>
<head>
<title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: purple">
		<div>
                        <ul class="navbar-brand"><h1>User Management App</h1></ul>  
     
                    </div>
		<ul class="navbar-nav">
		
				<% String uri = request.getRequestURI();

String pageName = uri.substring(uri.lastIndexOf("/")+1);

         if(pageName.contains("/")){%>
				<li><button type="button" class="btn btn-danger"><a href="registration.jsp" id="registrationLink">Registration</a></button></li><br><br>
				<li><button type="button" class="btn btn-warning"><a href="Logout" id="logoutLink">Logout</a></li>
				<%}
         
         if(pageName.contains("index.jsp")){%>
				<li><button type="button" class="btn btn-warning"><a href="registration.jsp" id="registrationLink">Registration</a></button></li><br>
				<li><button type="button" class="btn btn-danger"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
				<%}
         
          if(pageName.contains("registration.jsp")){%>
				<li><button type="button" class="btn btn-danger"><a href="index.jsp" id="loginLink">Login</a></button></li><br>
				<li><button type="button" class="btn btn-success"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
				<%}
          if(pageName.contains("view.jsp")){%>
				<li><button type="button" class="btn btn-warning"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
				<%}
  
           if(pageName.contains("Logout")){%>
				<li><button type="button" class="btn btn-danger"><a href="index.jsp" id="loginLink">Login</a></button></li><br>
				<%}
           if(pageName.contains("welcom.jsp")){%>
				<li><button type="button" class="btn btn-warning"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
				<li><button type="button" class="btn btn-danger"><a href="view.jsp" id="viewLink">ViewUser</a></button></li><br>
				<li><button type="button" class="btn btn-warning"><a href="updatePassword.jsp" id="UpdatesLink">Updates Password</a></button></li><br>
				<%}
           if(pageName.contains("registrationwelcome.jsp")){%>
			<li><button type="button" class="btn btn-warning"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
			<li><button type="button" class="btn btn-danger"><a href="view.jsp" id="viewLink">ViewUser</a></button></li><br>
			<%}
           if(pageName.contains("delete.jsp")){%>
            <li><button type="button" class="btn btn-danger"><a href="index.jsp" id="loginLink">Login</a></button></li><br>
            <li><button type="button" class="btn btn-warning"><a href="registration.jsp" id="registrationLink">Registration</a></button></li><br>
			<li><button type="button" class="btn btn-warning"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
			
			<%}
           if(pageName.contains("Edit.jsp")){%>
			<li><button type="button" class="btn btn-warning"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
			<%}
           
           if(pageName.contains("forgetPassword.jsp")){%>
			<li><button type="button" class="btn btn-warning"><a href="Logout" id="logoutLink">Logout</a></button></li><br>
			<li><button type="button" class="btn btn-danger"><a href="index.jsp" id="loginLink">Login</a></button></li><br>
			<%}
           %>
           

			</ul>
		</nav>
	</header>

</body>
</html>











