<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<frm:form modelAttribute="admin">
    <table>
        <tr>
            <td>User name:</td>
            <td><frm:input path="adminUsername" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><frm:input path="adminPassword" type="password"/></td>
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
			<td></td>
			<td><frm:input path="dateOfBirth" type="date" /></td>
		</tr>

        <tr>
            <td>Gender:</td>
            <td>
                <frm:radiobutton path="gender" value="Male" /> Male
                <frm:radiobutton path="gender" value="Female" /> Female
                <frm:radiobutton path="gender" value="Other" /> Other
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
            <td colspan="2" style="text-align:center;">
                <input type="submit" value="Register" />
            </td>
        </tr>
    </table>
</frm:form>
