<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login - Car Rental and Management System</title>
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CssFiles/AdminCss/adminLogin.css">

</head>
<body>

    <!-- Navigation Bar -->
    <nav>
        <ul>
            <!-- Home link on the left corner -->
            <li class="logo"><a href="./">Home</a></li>
            <!-- Additional navigation options -->
            <li><a href="./about">About Us</a></li>
            <li><a href="./services">Services</a></li>
            <li><a href="./help">Help</a></li>
            <li><a href="./contact">Contact Us</a></li>
        </ul>
    </nav>

    <!-- Main Content Section -->
    <section class="content">
        <h1>Customer Login</h1>
        <p>Please log in to access the Customer dashboard.</p>
        <p>${message}</p>
        
        <!-- Login Form -->
        <frm:form modelAttribute="customer">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><frm:input path="customerUsername" class="input-field"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                  <td><frm:input path="customerPassword" class="input-field"/></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type="submit" value="Login" class="submit-button" />
                        <br><br>
                        <a href="./forgotCustomerPassword" class="link">Forgot Password?</a><br>
                        <a href="customerRegisterPage" class="link">New User? Register Here</a>
                    </td>
                </tr>
            </table>
        </frm:form>
    </section>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <p>&copy; 2025 Car Rental and Management System. All rights reserved.</p>
        </div>
    </footer>

</body>
</html>
