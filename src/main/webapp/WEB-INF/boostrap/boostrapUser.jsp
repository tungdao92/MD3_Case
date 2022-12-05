<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
          integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
          integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
          integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
          crossorigin="anonymous"></script>
  <link rel="stylesheet" href="css.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  <style>
    .img {
      width: 20%;
    }

    button {
      display: block;
    }

    navbarNav {
      display: none;
    }

    .navbar-toggler {
      justify-content: flex-end;
    }


    .img1 {
      display: flex;
      flex-direction: row-reverse;
      border-radius: 50%;
      height: 30px;
      width: 30px;
    }

    .name {
      display: flex;
      justify-content: center;
      font-weight: bold;
      padding-left: 10px;
    }

    .name1 {
      display: flex;
    }

    .user {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }



  </style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="container-fluid">
       <div class="logo"><a href="/UserSl?action=home"><img class="img" src="https://firebasestorage.googleapis.com/v0/b/wangha-93b45.appspot.com/o/123.jpg?alt=media&token=e839a5b8-c4b2-402b-a76c-f465c273fbec"></a></div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span id="toggler" class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/UserSl?action=home"><p><i
                            class="bi bi-house-door"></i> Trang Chủ</p></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="UserSl?action=lotrinh"><p><i class="bi bi-archive"></i> Lộ Trình</p></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/UserSl?action=account"><p><i class="bi bi-menu-button-wide"></i> Bảng Điều Khiển</p></a>
                </li>

            </ul>
        </div>
<%-->>>>>>> tung1--%>

    <div class="user">
      <div class="dropdown">
        <div class="name1">

          <div class="name" type="summit" id="dropdownMenu2"
               data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false">
            <c:if test='${requestScope["avatar"]!=null}'>
              <li class="nav-item">
                <img width="50px" height="50px" style="border-radius: 50%" src="${requestScope["avatar"]}" alt="">
              </li>
            </c:if>
            <p>${user.name}</p>
          </div>
          <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <a href="/UserSl?action=account"><button class="dropdown-item" >Tài Khoản</button></a>
            <a href=""><button class="dropdown-item" type="submit">Lịch Sử Bào Thi</button></a>
            <a href=""><button class="dropdown-item" type="submit">Khóa Học Gần Đây</button></a>
            <a href=""><button class="dropdown-item" type="submit">Danh Sách Bài Tập</button></a>
            <a href="/users?action=logout"><button class="dropdown-item" type="submit">Đăng Xuất</button></a>
          </div>
        </div>
      </div>
    </div>
  </div>
</nav>
<script>
  $(document).ready(function () {
    $("button").click(function () {

      $("#navbarNav").slideToggle();
    });
  })
</script>

</body>
</html>