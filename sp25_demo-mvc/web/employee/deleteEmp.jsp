<%-- 
    Document   : deleteEmp
    Created on : Sep 14, 2025, 10:02:32 PM
    Author     : ADMIN
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Employee</title>
</head>
<body>
    <h1>Are you sure you want to delete this employee?</h1>
    
    <!-- Hiển thị thông tin nhân viên cần xóa -->
    <p><strong>Name:</strong> ${employee.name}</p>
    <p><strong>Email:</strong> ${employee.email}</p>
    <p><strong>Address:</strong> ${employee.address}</p>

    <!-- Form để xác nhận xóa -->
    <form action="employees?action=delete" method="post">
        <!-- Gửi id nhân viên cần xóa -->
        <input type="hidden" name="id" value="${employee.id}">
        
        <button type="submit">Yes, delete this employee</button>
        <a href="employees">Cancel</a>
    </form>
</body>
</html>
