<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ADMIN Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    <%--          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"--%>
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a class="navbar-brand"> ADMIN Management </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">ADMIN Bai Doc</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${baiDoc != null}">
            <form action="/BaiDoc?action=update" method="post">
                </c:if>
                <c:if test="${baiDoc == null}">
                <form action="/BaiDoc?action=insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${baiDoc != null}">
                                Sua Bai Doc
                            </c:if>
                            <c:if test="${baiDoc == null}">
                                Them Bai Doc
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${baiDoc != null}">
                        <input type="hidden" name="id" value="<c:out value='${baiDoc.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label> Ten Bai Doc</label> <input type="text"
                                                            value="<c:out value='${baiDoc.name}'/>" class="form-control"
                                                            name="name_baidoc" required="required">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>