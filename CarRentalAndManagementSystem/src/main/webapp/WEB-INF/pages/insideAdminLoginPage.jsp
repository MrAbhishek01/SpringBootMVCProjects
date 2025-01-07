<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<title>Admin Dashboard</title>
</head>
<body>
<h1>${massage}</h1>
	<div class="navbar">
		<div class="brand">Admin Dashboard</div>
		<div class="user-info">
			<span>Welcome, <c:out
					value="${sessionScope.loggedInAdmin.firstName}" /></span> <a
				href="logout">Logout</a>
		</div>
	</div>
	<div class="content">
		<h1>
			<c:out value="${message}" />
		</h1>
		<p>Use the navigation above to log out or access other sections.</p>
	</div>

	<a
		href="editAdminProfile?no=${sessionScope.loggedInAdmin.adminUsername}">Edit
		Profile</a>

</body>
</html>
