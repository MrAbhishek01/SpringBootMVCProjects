<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
   
    <link rel="stylesheet" href="/RestApiConsumerCustomeAdminApplication/CssFiles/AdminCss/insideAdminLoginPage.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav>
        <div class="brand">Admin Dashboard</div>
        <div class="user-info">
            <span>Welcome, <c:out value="${sessionScope.loggedInAdmin.firstName}" /></span>
            <a href="/RestApiConsumerCustomeAdminApplication/admin/logout">Logout</a>
        </div>
    </nav>
    
    <!-- Main Content -->
    <section class="content">
        <h1>Admin Dashboard</h1>
        <h2><c:out value="${message}" /></h2>
        <p>Use the navigation above to log out or access other sections.</p>
        
        <div class="actions">
            <a href="/RestApiConsumerCustomeAdminApplication/admin/editAdminProfile?id=${sessionScope.loggedInAdmin.adminUsername}">
                Edit Profile
            </a>
        </div>
    </section>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <p>&copy; 2025 Car Rental and Management System. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
