<!DOCTYPE html>
<html>
<head>
    <title>Update Password</title>
</head>
 <jsp:include page="header.jsp"/>
<body>
    <h2>Update Password</h2>
    <form action="UpdatePasswordServlet" method="post" onsubmit="return validateForm();">
        <table>
            <tr>
                <div class="form-outline mb-4">
                    <td> 
                        <input type="text" placeholder="Username" name="name" id="name" class="form-control form-control-lg" required="required" />
                        <label class="form-label" for="form3Example90"></label>
                    </td>
                </div>
            </tr>
            <tr>
                <div class="form-outline mb-4">
                    <td> 
                        <input type="password" placeholder="Enter oldPassword" name="oldPassword" id="oldPassword"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-control form-control-lg" required="required" />
                        <label class="form-label" for="form3Example90"></label>
                        <button type="button" onclick="togglePassword('oldPassword')" class="btn btn-sm btn-secondary">Show</button>
                    </td>
                </div>
            </tr>
            <tr>
                <div class="form-outline mb-4">
                    <td> 
                        <input type="password" placeholder="Enter newPassword" name="newPassword" id="newPassword"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-control form-control-lg" required="required" />
                        <label class="form-label" for="form3Example90"></label>
                        <button type="button" onclick="togglePassword('newPassword')" class="btn btn-sm btn-secondary">Show</button>
                    </td>
                </div>
            </tr>
            <tr>
                <div class="form-outline mb-4">
                    <td> 
                        <input type="password" placeholder="Enter Confirm password" name="cpassword" id="cpassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-control form-control-lg" required="required" />
                        <label class="form-label" for="form3Example90"></label>
                        <button type="button" onclick="togglePassword('cpassword')" class="btn btn-sm btn-secondary">Show</button>
                    </td>
                </div>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update Password"></td>
            </tr>
        </table>
    </form>
    
    <div id="message">
        <h3>Password must contain the following:</h3>
        <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
        <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
        <p id="number" class="invalid">A <b>number</b></p>
        <p id="length" class="invalid">Minimum <b>8 characters</b></p>
    </div>

    <script>
        function togglePassword(inputId) {
            var input = document.getElementById(inputId);
            if (input.type === "password") {
                input.type = "text";
            } else {
                input.type = "password";
            }
        }

        function validateForm() {
            var newPassword = document.getElementById("newPassword").value;
            var cpassword = document.getElementById("cpassword").value;
            if (newPassword !== cpassword) {
                alert("New Password and Confirm Password must match.");
                return false;
            }
            return true;
        }
    </script>
    
    <%if(request.getAttribute("error3")!=null){
        out.print(request.getAttribute("error3"));}
    %>
</body>
<%@ include file="footer.jsp" %>
</html>
