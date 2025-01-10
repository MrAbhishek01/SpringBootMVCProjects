<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CssFiles/AdminCss/insideAdminLoginPage.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav>
        <div class="brand">Customer Dashboard</div>
        <div class="user-info">
<span>Welcome, <c:out
					value="${sessionScope.loggedInCustomer.firstName}" /></span> <a
				href="logout">Logout</a>
        </div>
    </nav>
    
    <!-- Main Content -->
    <section class="content">
        <h1>Customer Dashboard</h1>
        <h2><c:out value="${message}" /></h2>
        <p>Use the navigation above to log out or access other sections.</p>
        
        <div class="actions">
         
		<a href="/RestApiConsumerCustomeAdminApplication/customer/editCustomerProfile?customerId=${sessionScope.loggedInCustomer.customerUsername}">Edit Profile</a>
		
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
