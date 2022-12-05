<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page='../boostrap/boostrapUser.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            /*background: url("https://firebasestorage.googleapis.com/v0/b/wangha-93b45.appspot.com/o/dark.png?alt=media&token=2a6cbd33-eae8-46a1-980a-b72f41a29036");*/
            background-size: cover;
            font-family: sans-serif;
        }

        h1 {
            margin: 0 0 10px;
            padding: 0;
            color: #0257f8;
            font-size: 24px;
        }

        .box {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 500px;
            transform: translate(-50%, -50%);
        }

        input {
            position: relative;
            display: inline-block;
            font-size: 20px;
            box-sizing: border-box;
            transition: .5s;
        }

        input[type="text"] {
            background: #fff;
            width: 340px;
            height: 50px;
            border: none;
            outline: none;
            padding: 0 25px;
            border-radius: 25px 0 0 25px;
        }

        input[type="submit"] {
            position: relative;
            left: -5px;
            border-radius: 0 25px  25px 0;
            width: 150px;
            height: 50px;
            border: none;
            outline: none;
            cursor: pointer;
            background: #e84118;
            color: #fff;
        }
        input[type="submit"]:hover {
            background: #fbc531;
        }

    </style>
</head>
<body>

<img src="https://firebasestorage.googleapis.com/v0/b/wangha-93b45.appspot.com/o/lms.jpg?alt=media&token=bb391b89-189b-4044-8250-205e22535447" style="width: 100%">
<%--<h1 style="color: red">Chào mừng bạn đến trung tâm đào tạo IT Rikkei Academy</h1>--%>
<section>
    <div class="box">
        <h1>Search</h1>
        <form method="post" action="/UserSl">
            <input type="text" name="name_search" placeholder="Tên bài học">
            <input type="submit" name="" value="Search">
        </form>
    </div>
</section>


</body>
<jsp:include page='../boostrap/footer.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
</html>
