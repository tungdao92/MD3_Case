<%--
  Created by IntelliJ IDEA.
  User: TungDao
  Date: 10/6/2022
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page='../boostrap/boostrapUser.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/UserSl?action=search-module">
    <input type="text" name="name_search">
    <label>
        <a href="/UserSl?action=search-module"><button>Search</button></a>
    </label>
</form>
    <table align="center" border="1" , style="width: 50%; text-align: center" class="table table-striped">
        <tr class="table-warning">
            <th scope="col">ID</th>
            <th scope="col">ID Lộ Trình</th>
            <th scope="col">Tên Module</th>
        </tr>

        <c:forEach items='${requestScope["listModule"]}' var="lt1">
            <tr>
                <td>${lt1.id}</td>
                <td>${lt1.id_lotrinh}</td>
                <td><a href="/UserSl?action=showBaiDoc&id=${lt1.id}">${lt1.name_module}</a></td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
<jsp:include page='../boostrap/footer.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
