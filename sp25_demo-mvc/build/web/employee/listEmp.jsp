<%-- 
    Document   : listEmp
    Created on : Sep 14, 2025, 10:02:46 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
     <style>
        .actions { display:flex; gap:.5rem; }
        .actions form { margin:0; }
        .btn { padding:.3rem .6rem; border:1px solid #999; background:#f7f7f7; cursor:pointer; }
        .btn--danger { border-color:#c33; }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee List</h1>
        <table border = "1">
            <tr>
                <th>ID</th><!-- comment -->
                <th>Name</th>
                <th>Email</th>
                <th>address</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="employee" items = "${employee}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.address}</td>
                    <td>
                <div class="actions">
                    <!-- Sửa: GET kèm id -->
                    <form method="get" action="${pageContext.request.contextPath}/employee/editEmp.jsp">
                        <input type="hidden" name="id" value="${employee.id}">
                        <button type="submit" class="btn">Sửa</button>
                    </form>

                    <form method="post" action="${pageContext.request.contextPath}/employee/deleteEmp.jsp"
                          onsubmit="return confirm('Xoá nhân viên #${employee.id}?');">
                        <input type="hidden" name="id" value="${employee.id}">
                        <button type="submit" class="btn btn--danger">Xoá</button>
                    </form>
                </div>
            </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
