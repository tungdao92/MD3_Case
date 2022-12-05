<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 3/10/2022--%>
<%--  Time: 4:56 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<jsp:include page='/WEB-INF/view/boost/traps.jsp'>--%>
<%--    <jsp:param name="articleId" value=""/>--%>
<%--</jsp:include>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1> JAVA</h1>--%>
<%--<a href="users?action=change_avatar"> Change avatar</a>--%>

<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LO TRINH HOC</title>
</head>
<body>
<h1 style="color: blue; text-align: center">========================LO  TRINH RIKKEI============================</h1>
<input id="newStudent" type="text">
<button onclick="createStudent()">Them lo trinh</button>
<input id="search" placeholder="Search lo trinh ....." type="text" oninput="actionSearch()">
<span id="validate"></span>
<table border="1" style="width: 100%; text-align: center">
    <th>STT</th>
    <th>NAME</th>
    <th>EDIT</th>
    <th>DELETE</th>
    <tbody id="drawTable">

    </tbody>
</table>
</body>
</html>
