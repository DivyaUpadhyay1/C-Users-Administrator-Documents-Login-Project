<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<style>
body {
    font-size: 1rem;
    line-height: 2.15;
    padding-left: .75em;
    padding-right: .75em;
}

.card-registration .select-arrow {
    top: 13px;
}
</style>
<body>

    <h1>Registration</h1>
    <form action="SaveServlet" method="post" id="registrationForm" onsubmit="return validatePassword()">
        <section class="h-100 bg-dark">
            <div class="container py-5 h-100">
                <div
                    class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col">
                        <div class="card card-registration my-4">
                            <div class="row g-0">
                                <div class="col-xl-6 d-none d-xl-block">
                                    <img
                                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                                        alt="Sample photo" class="img-fluid"
                                        style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
                                </div>
                                <div class="col-xl-6">
                                    <div class="card-body p-md-5 text-black">
                                        <h3 class="mb-5 text-uppercase">Registration Form</h3>

                                        <div class="form-outline mb-4">
                                            <input type="name" placeholder="Enter Name" name="name" id="name" class="form-control form-control-lg" required="required" />
                                            <label class="form-label" for="form3Example90"></label>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="password" placeholder="Enter password" name="password" id="password"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-control form-control-lg" required="required" />
                                            <label class="form-label" for="form3Example90"></label>
                                            <button type="button" onclick="togglePassword('password')" class="btn btn-sm btn-secondary">Show Password</button>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="password" placeholder="Enter Confirm password" name="cpassword" id="cpassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-control form-control-lg" required="required" />
                                            <label class="form-label" for="form3Example90"></label>
                                            <button type="button" onclick="togglePassword('cpassword')" class="btn btn-sm btn-secondary">Show Password</button>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="text" placeholder="Enter Email" name="email" id="email" class="form-control form-control-lg" required="required" />
                                            <label class="form-label" for="form3Example90"></label>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6 mb-4">
                                                <select name="country">
                                                    <option>India</option>
                                                    <option>USA</option>
                                                    <option>UK</option>
                                                    <option>Other</option>
                                                </select>
                                            </div>
                                            <div class="d-flex justify-content-end pt-3">
                                                <button type="reset" class="btn btn-light btn-lg">Reset</button>
                                                <button type="submit" value="Save Employee" class="btn btn-warning btn-lg ms-2" id="submitButton">Submit form</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </form>

    <div id="message">
        <h3>Password must contain the following:</h3>
        <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
        <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
        <p id="number" class="invalid">A <b>number</b></p>
        <p id="length" class="invalid">Minimum <b>8 characters</b></p>
    </div>

    <script>
        function validatePassword() {
            var password = document.getElementById("password");
            var cpassword = document.getElementById("cpassword");

            if (password.value !== cpassword.value) {
                alert("Password and Confirm Password do not match.");
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }

        function togglePassword(inputId) {
            var input = document.getElementById(inputId);
            if (input.type === "password") {
                input.type = "text";
            } else {
                input.type = "password";
            }
        }
    </script>

</body>
 <%@ include file="footer.jsp" %>
</html>
