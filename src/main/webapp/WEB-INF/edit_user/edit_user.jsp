<%@ page import="java.util.List" %>
<%@ page import="rikkei.academy.model.Role" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>USER EDIT</title>
</head>
<body>
<a href="/HomeServlet?action=goHome"> <p>Back Home</p></a>
<form method="post" action="/users?action=edit_user">
    <table border="1">
        <c:if test="${requestScope['message'] != null}">
            <p style="color: #0b5fda">${requestScope['message']}</p>
        </c:if>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>USER_NAME</th>
            <th>EMAIL</th>
            <th>PASS</th>
            <th>ROLE</th>
        </tr>
        <tr>
            <td><input value="${edit_user.id}" name="id"></td>
            <td> ${edit_user.name}</td>
            <td>${edit_user.username}</td>
            <td>${edit_user.email}</td>
            <td>${edit_user.password}</td>

            <c:forEach var="role" items="${edit_user.roleList}">
                <td>
                       <select name="role" >
                           <c:if test="${role.name=='USER'}">
                               <option value="USER" selected>USER</option>
                               <option value="ADMIN">ADMIN</option>
                           </c:if>
                           <c:if test="${role.name=='ADMIN'}">
                               <option value="USER" >USER</option>
                               <option value="ADMIN" selected>ADMIN</option>
                           </c:if>
                       </select>
                </td>
            </c:forEach>
        </tr>
    </table>
<button type="submit"  > submit</button>
</form>
</body>
</html>
