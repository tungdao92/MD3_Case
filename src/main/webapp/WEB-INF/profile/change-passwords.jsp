<%--
  Created by IntelliJ IDEA.
  User: TungDao
  Date: 10/9/2022
  Time: 8:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='../boostrap/boostrapUser.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Change pass</h1>

<c:if test="${requestScope['message'] != null}">
    <p style="color: red">${requestScope['message']}</p>
</c:if>

<form method="post">
    Old Password<br>
    <input type="text" name="old-pass"><br>
    New Password<br>
    <input type="text" name="new-pass"><br>
    Repeat Password<br>
    <input type="text" name="repeat-pass"><br>
    <button>Submit</button>
</form>
</body>
</html>
<jsp:include page='../boostrap/footer.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
