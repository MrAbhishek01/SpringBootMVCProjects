<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Registration</title>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/CssFiles/AdminCss/adminRegistration.css">
    </head>
<body>
    <!-- Navigation Bar -->
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

    <!-- Form Section -->
    <div class="form-container">
        <h1>Customer Registration</h1>
        <frm:form modelAttribute="customer">
            <table>
                <tr>
                    <td>User Name:</td>
                    <td><frm:input path="customerUsername" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><frm:input path="customerPassword" type="password" /></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><frm:input path="firstName" /></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><frm:input path="lastName" /></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><frm:input path="dateOfBirth" type="date" /></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td class="gender-options">
                        <label><frm:radiobutton path="gender" value="Male" /> Male</label>
                        <label><frm:radiobutton path="gender" value="Female" /> Female</label>
                        <label><frm:radiobutton path="gender" value="Other" /> Other</label>
                    </td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><frm:input path="address" /></td>
                </tr>
                <tr>
                    <td>Email ID:</td>
                    <td><frm:input path="emailId" /></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><frm:input path="phoneNumber" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type="submit" value="Register" />
                    </td>
                </tr>
            </table>
        </frm:form>
    </div>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <p>&copy; 2025 Car Rental and Management System. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>