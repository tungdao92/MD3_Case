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

<%--<img src="/img/lms.jpg">--%>
<form method="get">
    <table align="center" border="1" , style="width: 50%; text-align: center" class="table table-striped">
        <tr class="table-warning">
            <th scope="col">ID</th>
            <th scope="col">Tên Lộ Trình</th>
        </tr>

        <c:forEach var="lotrinh" items='${requestScope["listLoTrinh"]}'>
            <tr class="table-danger">
                <td><a href="/UserSl?action=showModule&id=${lotrinh.id}">${lotrinh.id}</a></td>
                <td><a href="/UserSl?action=showModule&id=${lotrinh.id}">${lotrinh.name}</a></td>
            </tr>
        </c:forEach>

    </table>
</form>


</body>
<jsp:include page='../boostrap/footer.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
</html>
