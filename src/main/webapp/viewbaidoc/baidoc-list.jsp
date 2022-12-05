<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Bai Doc Management </title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a class="navbar-brand"> Bai Doc Management </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Bai Doc</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">Menu Bai Doc</h3>
        <hr>
        <div class="container text-left">

            <a href="/BaiDoc?action=newbaidoc" class="btn btn-success">Them Moi Bai Doc</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>STT</th>
                <th>TEN Bai Doc</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="doclist" items="${listBaiDoc}">

                <tr>
                    <td><c:out value="${doclist.id}" /></td>
                    <td><c:out value="${doclist.name}" /></td>
                    <td><a href="/BaiDoc?action=edit&id=${doclist.id}">Sua</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="/BaiDoc?action=delete&id=<c:out value='${doclist.id}' />">Xoa</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>
</html>