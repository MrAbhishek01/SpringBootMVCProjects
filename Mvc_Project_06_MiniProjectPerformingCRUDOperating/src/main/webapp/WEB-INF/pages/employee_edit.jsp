<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"  %>

<h1 align="center">Employee Registration</h1>

<frm:form modelAttribute="employee">
    <table align="center" border="1">
             <tr>
            <td>Employee Name</td>
            <td><frm:input path="empName"/></td>
        </tr>
        <tr>
            <td>Employee Email-Id</td>
            <td><frm:input path="empEmail" /></td>
        </tr>
        <tr>
            <td>Employee Salary</td>
            <td><frm:input path="empSalary" /></td>
        </tr>
        <tr>
            <td>Employee Department</td>
            <td>
                <frm:select path="empDepartment">
                    <frm:option value="IT">IT</frm:option>
                    <frm:option value="HR">HR</frm:option>
                    <frm:option value="Finance">Finance</frm:option>
                    <frm:option value="Marketing">Marketing</frm:option>
                </frm:select>
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="update">
            </td>
        </tr>
    </table>
</frm:form>
<a href="./"><img src="images/home.png" width="50" height="50"> </a>