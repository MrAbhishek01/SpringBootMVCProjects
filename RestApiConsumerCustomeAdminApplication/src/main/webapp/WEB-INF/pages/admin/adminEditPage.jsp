<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Admin Details</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/CssFiles/AdminCss/adminEditPage.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav>
        <ul>
        
      <li class="logo"><a href="${pageContext.request.contextPath}/admin/insideAdminLoginPage">Home</a></li>
         								
      
            <li><a href="/CustomerAdminCarRentalAndManagementSystem/about">About Us</a></li>
            <li><a href="/CustomerAdminCarRentalAndManagementSystem/services">Services</a></li>
            <li><a href="/CustomerAdminCarRentalAndManagementSystem/help">Help</a></li>
            <li><c:out
					value="Welcome ${sessionScope.loggedInAdmin.firstName}" /> <a href="${pageContext.request.contextPath}/admin/logout">Logout</a></li>
            	
        </ul>
    </nav>
    <section class="content">
        <h1>Update Admin Details</h1>
<frm:form modelAttribute="admin">
	<table>
		<tr>
			<td><frm:label path="adminUsername">Username</frm:label></td>
			<td><frm:input path="adminUsername" readonly="true" /></td>
		</tr>
		<tr>
			<td><frm:label path="adminPassword">Password</frm:label></td>
			<td><frm:input path="adminPassword" type="password" /></td>
		</tr>
		<tr>
			<td><frm:label path="firstName">First Name</frm:label></td>
			<td><frm:input path="firstName" /></td>
		</tr>
		<tr>
			<td><frm:label path="lastName">Last Name</frm:label></td>
			<td><frm:input path="lastName" /></td>
		</tr>
		<tr>
			<td><frm:label path="dateOfBirth">Date of Birth</frm:label></td>
			<td><frm:input path="dateOfBirth" type="date" /></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><frm:radiobutton path="gender" value="Male" /> Male <frm:radiobutton
					path="gender" value="Female" /> Female <frm:radiobutton
					path="gender" value="Other" /> Other</td>
		</tr>
		<tr>
			<td><frm:label path="address">Address</frm:label></td>
			<td><frm:input path="address" /></td>
		</tr>
		<tr>
			<td><frm:label path="emailId">Email</frm:label></td>
			<td><frm:input path="emailId" /></td>
		</tr>
		<tr>
			<td><frm:label path="phoneNumber">Phone Number</frm:label></td>
			<td><frm:input path="phoneNumber" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="update" /></td>
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

