<%-- 
    Document   : createEmp
    Created on : Sep 14, 2025, 10:02:24 PM
    Author     : ADMIN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Employee</title>
</head>
<body>
    <h1>Create New Employee</h1>

    <!-- Form để nhập thông tin nhân viên mới -->
    <form action="${pageContext.request.contextPath}/employees?action=create" method="post">
         <label for="name">Name:</label>
         <input type="text" id="name" name="id" required><br><br>
         
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br><br>

        <button type="submit">Create Employee</button>
    </form>
          <a href="${pageContext.request.contextPath}/employees">Back to Employee List</a>
</body>
</html>
