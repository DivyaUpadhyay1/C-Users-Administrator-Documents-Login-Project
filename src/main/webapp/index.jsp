
	 <jsp:include page="header.jsp"/>
	
<! DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<style>
.gradient-custom-2 {
	/* fallback for old browsers */
	background: #fccb90;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
}

@media ( min-width : 768px) {
	.gradient-form {
		height: 105vh !important;
	}
}

@media ( min-width : 769px) {
	.gradient-custom-2 {
		border-top-right-radius: .3rem;
		border-bottom-right-radius: .3rem;
	}
}
</style>
<body>
	<section class="h-100 gradient-form" style="background-color: #eee;">
		<div class="container py-1 h-40">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black">
						<div class="row g-0">
							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">

									<div class="text-center">

										<img
											src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
											style="width: 185px;" alt="logo">
										<h4 class="mt-1 mb-5 pb-1">We are The Arishi Team</h4>
									</div>

									<form action="ControllerServlet" method="post">
										<p>Please login to your account</p>

										<div class="form-group required">
											<lSabel for="name"> Enter your Name </lSabel>
											<input type="text" id="name" required="" name="name" value="">
										</div>
										<div class="form-group required">
											<label class="d-flex flex-row align-items-center"
												for="password"> Enter your Password <a
												class="ml-auto border-link small-xl" href="forgetPassword.jsp"> Forget
													Password? </a>
											</label> <input type="password" class="form-control" required=""
												id="password" name="password" value="">
										</div>

										<div class="text-center pt-1 mb-5 pb-1">
											<button
												class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3"
												type="submit" value="login">Log in</button>
												
												
									</form>

								</div>
								

								<div
									class="d-flex align-items-center justify-content-center pb-4">
									
									<p class="mb-0 me-2">Don't have an account?</p>
									<a href="registration.jsp">Create new</a>
								</div>



							</div>
						</div>
						<div class="col-lg-6 d-flex align-items-center gradient-custom-2">
							<div class="text-white px-3 py-4 p-md-5 mx-md-4">
								<h4 class="mb-4">We are more than just a company</h4>
								<p class="small mb-0">"You are not poor because you don't
									have MONEY You are poor if you don't have a DREAM."</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>

	</section>
	<%if(request.getAttribute("success")!=null){
	out.print(request.getAttribute("success"));}
	%>

<%if(request.getAttribute("error")!=null){
	out.print(request.getAttribute("error"));}
	%>
</body>

<%@ include file="footer.jsp" %>
</html>
