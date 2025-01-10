










<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Password Update</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CssFiles/AdminCss/forgotAdminPasswordPage.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav>
        <ul>
            <!-- Home link on the left corner -->
            <li class="logo"><a href="${pageContext.request.contextPath}/admin/adminLoginPage">Home</a></li>
            <!-- Additional navigation options -->
            <li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
            <li><a href="${pageContext.request.contextPath}/services">Services</a></li>
            <li><a href="${pageContext.request.contextPath}/help">Help</a></li>
            <li><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
        </ul>
    </nav>
    
    <!-- Main Content -->
    <section class="content">
        <h1>${message}</h1>
        <frm:form method="post" action="forgot-password" modelAttribute="admin">
            <table>
                <tr>
                    <td>Enter Admin Username:</td>
                    
                    <td><frm:input path="adminUsername" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Check ID" /></td>
                </tr>
            </table>
        </frm:form>

        <c:choose>
            <c:when test="${idExists}">
                <form method="post" action="update-password">
                  <input type="hidden" name="adminUsername" value="${admin.adminUsername}" />
                    <table>
                        <tr>
                            <td>Enter New Password:</td>
                            <td><input type="text" name="adminPassword" /></td>
                        </tr>
                        <tr>
                         <td colspan="2"><input type="submit" value="Update Password" /></td>
                        </tr>
                    </table>
                </form>
            </c:when>
        </c:choose>
    </section>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <p>&copy; 2025 Car Rental and Management System. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
