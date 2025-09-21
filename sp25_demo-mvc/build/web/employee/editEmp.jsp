<%-- 
    Document   : editEmp
    Created on : Sep 14, 2025, 10:02:38 PM
    Author     : ADMIN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>
<body>
    <h1>Edit Employee</h1>
    <form action="${pageContext.request.contextPath}/employees" method="post">
        <input type="hidden" name="id" value="${employee.id}" />

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${employee.email}" required><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${employee.address}" required><br><br>

        <button type="submit">Update</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/employee/listEmp.jsp">Back to Employee List</a>
</body>
</html>
