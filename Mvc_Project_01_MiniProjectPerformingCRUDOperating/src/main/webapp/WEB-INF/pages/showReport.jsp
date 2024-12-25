<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- Error Message -->
<c:if test="${!empty msg}">
	<h3 class="text-center text-danger">${msg}</h3>
</c:if>
<!-- Bootstrap CSS -->
<link	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"	rel="stylesheet">

<!-- Add New Student Link -->
<div class="text-center" style="margin-top: 20px;">
	<a href="addStudentData">Add New Student</a>
</div>

<h1 class="text-center">Student Report</h1>

<!-- Search Form -->
<frm:form modelAttribute="student" action="Search">
	<table align="center"
		style="background-color: pink; border-radius: 20px">
		<tr>
			<td>Student ID:</td>
			<td><frm:input path="id" /></td>
		</tr>
		<tr>
			<td><label>Student Name:</label></td>
			<td><frm:input path="name" /></td>
		</tr>
		<tr>
			<td><label>Email:</label></td>
			<td><frm:input path="email" /></td>
		</tr>
		<tr>
			<td><label>Contact Number:</label></td>
			<td><frm:input path="contactNumber" /></td>
		</tr>
		<tr>
			<td colspan="2" class="text-center"><input type="submit"
				value="Search" /> <input type="reset" value="Reset" /></td>
		</tr>
	</table>
</frm:form>

<!-- Display Report -->
<c:choose>
	<c:when test="${!empty reportList}">
		<table class="table table-bordered text-center">
			<thead class="thead-dark">
				<tr>
					<th>Student ID</th>
					<th>Student Name</th>
					<th>Email</th>
					<th>Contact Number</th>
					<th>Date of Birth</th>
					<th>Joining Date</th>
					<th>Passout Date</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stud" items="${reportList}">
					<tr>
						<td>${stud.id}</td>
						<td>${stud.name}</td>
						<td>${stud.email}</td>
						<td>${stud.contactNumber}</td>
						<td><fmt:formatDate value="${stud.dateOfBirth}"
								pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${stud.joiningDate}"
								pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${stud.passoutDate}"
								pattern="dd-MM-yyyy" /></td>
						<td><a href="edit?no=${stud.id}"
							class="btn btn-warning btn-sm">Edit</a></td>
						<td><a href="delete?no=${stud.id}"
							class="btn btn-danger btn-sm">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h3 class="text-center text-muted">No student data available.</h3>
	</c:otherwise>
</c:choose>



