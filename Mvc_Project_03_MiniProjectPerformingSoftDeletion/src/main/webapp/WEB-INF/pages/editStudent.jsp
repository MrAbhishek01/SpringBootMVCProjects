<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<frm:form modelAttribute="student">
    <table>
     <tr>
            <td><label>Name</label></td>
            <td><frm:input path="id" /></td>
        </tr>
        <tr>
            <td><label>Name</label></td>
            <td><frm:input path="name" /></td>
        </tr>
        <tr>
            <td><label>Email</label></td>
            <td><frm:input path="email" /></td>
        </tr>
        <tr>
            <td><label>Contact Number</label></td>
            <td><frm:input path="contactNumber" /></td>
        </tr>
        <tr>
            <td><label>Date of Birth</label></td>
            <td><frm:input path="dateOfBirth" type="date" /></td>
        </tr>
        <tr>
            <td><label>Joining Date</label></td>
            <td><frm:input path="joiningDate" type="date" /></td>
        </tr>
        <tr>
            <td><label>Passout Date</label></td>
            <td><frm:input path="passoutDate" type="date" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="update" /></td>
        </tr>
    </table>
</frm:form>
