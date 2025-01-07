<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

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
