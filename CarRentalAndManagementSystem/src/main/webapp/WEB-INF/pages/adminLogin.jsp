<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1>${message}</h1>
<frm:form modelAttribute="admin">
	<table>
		<tr>
			<td>enter user name</td>
			<td><frm:input path="adminUsername" /></td>
		</tr>
		<tr>
			<td>enter password</td>
			<td><frm:input path="adminPassword" /></td>
		</tr>
		<tr>

			<td><input type="submit" />&nbsp;&nbsp; <a href="forgotAdminPassword">forgot Password</a> <br>
			<a href="adminRegisterPage">new user</a></td>
		</tr>

	</table>
</frm:form>