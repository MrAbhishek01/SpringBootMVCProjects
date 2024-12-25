<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Report</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        .center {
            text-align: center;
        }

        .button {
            text-align: center;
        }
    </style>
</head>
<body>

    <h1 align="center">Employee Report</h1>

    <frm:form modelAttribute="employee" action="search">
        <table align="center">
            <tr>
                <td>Employee Name</td>
                <td><frm:input path="empName" /></td>
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
                        <frm:option value="">Select Department</frm:option>
                        <frm:option value="IT">IT</frm:option>
                        <frm:option value="HR">HR</frm:option>
                        <frm:option value="Finance">Finance</frm:option>
                        <frm:option value="Marketing">Marketing</frm:option>
                    </frm:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="button">
                    <input type="submit" value="Search">
                </td>
            </tr>
        </table>
    </frm:form>

    <c:choose>
        <c:when test="${!empty reportList}">
            <table align="center">
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Employee Email</th>
                        <th>Employee Salary</th>
                        <th>Employee Department</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="emp" items="${reportList}">
                        <tr>
                            <td>${emp.empId}</td>
                            <td>${emp.empName}</td>
                            <td>${emp.empEmail}</td>
                            <td>${emp.empSalary}</td>
                            <td>${emp.empDepartment}</td>
                            <td>
                                <a href="edit?no=${emp.empId}">
                                    <img src="images/edit.png" width="30" height="20" alt="Edit">
                                </a>
                            </td>
                            <td>
                                <a onclick="return confirm('Are you sure to delete?')" href="delete?no=${emp.empId}">
                                    <img src="images/delete.png" width="20" height="20" alt="Delete">
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h2 align="center">Data not found</h2>
        </c:otherwise>
    </c:choose>

    <div class="center">
        <a href="register">
            <img src="images/add.png" width="100" height="100" alt="Add Employee"
                style="border: 1px solid black; border-radius: 10px;" />
        </a>
    </div>

    <h2 class="center">${message}</h2>

    <div class="center">
        <a href="./">
            <img src="images/home.png" width="50" height="50" alt="Home">
        </a>
    </div>

</body>
</html>
