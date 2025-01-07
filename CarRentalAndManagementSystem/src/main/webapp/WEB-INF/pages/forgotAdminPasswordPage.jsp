<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1>${message}</h1>

<frm:form method="post" action="checkUserId" modelAttribute="admin">
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
        <!-- Display the form for entering the new password -->
        <form method="post" action="updatePassword">
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
