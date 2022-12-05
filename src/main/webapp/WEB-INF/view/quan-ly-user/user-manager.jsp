<%@ page import="java.util.List" %>
<%@ page import="rikkei.academy.model.Role" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>USER MANAGER</title>
</head>
<body>
<h1 style="color: blue; text-align: center">========================USER MANAGER============================</h1>
<a href="/HomeServlet?action=goHome"> <p>Back Home</p></a>
<table border="1" style="width: 100%; text-align: center">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>USER_NAME</th>
        <th>EMAIL</th>
        <th>PASS</th>
        <th>ROLE</th>
        <th>AVATAR</th>
        <th>EDIT ROLE</th>
        <th>DELETE</th>
    </tr>

    <c:forEach items='${requestScope["userList"]}' var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <c:forEach var="role" items="${user.roleList}">
                <td>
                    ${role.name}
                </td>
            </c:forEach>

            <td><img src="${ user.avatar}" style="width: 10%"></td>
            <td>
                <a href="/users?action=edit_user&id=${user.id}">Edit</a>
            </td>
            <td>
                <a href="/users?action=delete_user&id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
