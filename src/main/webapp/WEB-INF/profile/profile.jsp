<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>loTrinh</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ms+Madi&family=Poppins:ital,wght@0,700;1,300&display=swap"
          rel="stylesheet">
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
    <link href="https://fonts.googleapis.com/css2?family=Alkalami&family=Roboto:wght@700&display=swap" rel="stylesheet">

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .dropdown-content:hover {
            display: block;
        }

        nav {
            display: flex;
            justify-content: space-around;
            align-items: center;
            min-height: 8vh;
            background-color: #ffffff;
            font-family: 'Alkalami', serif;
            font-family: 'Roboto', sans-serif;
        }

        .logo {
            color: rgb(226, 226, 226);
            text-transform: uppercase;
            letter-spacing: 5px;
            font-size: 15px;
        }

        .nav-links {
            display: flex;
            /*background-color: darkred;*/
            justify-content: space-around;
            width: 30%;
            margin-bottom: 0 !important;
        }

        .nav-links li {
            list-style: none;
        }

        .nav-links a {
            color: rgb(226, 226, 226);
            text-decoration: none;
            letter-spacing: 3px;
            font-weight: bold;
            font-size: 14px;
        }

        .bugger {
            display: none;
            cursor: pointer;
        }

        .bugger div {
            width: 25px;
            height: 3px;
            background-color: rgb(226, 226, 226);
            margin: 5px;
            transition: all 0.3s ease;
        }
        body {
            background-image: url("https://i.pinimg.com/originals/2c/84/5a/2c845a66b8ad2a8aafd288bdc16cd459.jpg");
            background-size: cover;
            width: 100%;
            height: 100vh;
            background-position: center;
        }
        @media screen and (max-width: 1024px) {
            .nav-links {
                width: 60%;
            }
            body {
                background-image: url("https://i.pinimg.com/originals/2c/84/5a/2c845a66b8ad2a8aafd288bdc16cd459.jpg");
                background-size: cover;
                width: 100%;
                height: 100vh;
                background-position: center;
            }
        }

        @media screen and (max-width: 768px) {
            body {
                overflow-x: hidden;
                background-image: url("https://i.pinimg.com/originals/2c/84/5a/2c845a66b8ad2a8aafd288bdc16cd459.jpg");
            }
            .nav-links {
                position: absolute;
                right: 0;
                height: 92vh;
                top: 8vh;
                background-color: #ffffff;
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 50%;
                transform: translateX(100%);
                transition: transform 0.5s ease-in;
            }

            .nav-links li {
                opacity: 0;
            }

            .bugger {
                display: block;
            }
        }

        .nav-active {
            transform: translate(0%);
        }

        @keyframes navLinkFade {
            from {
                opacity: 0;
                transform: translate(50px);
            }
            to {
                opacity: 1;
                transform: translate(0px);
            }
        }

        .toggle .line1 {
            transform: rotate(-45deg) translate(-5px, 6px);
        }

        .toggle .line2 {
            opacity: 0;
        }

        .toggle .line3 {
            transform: rotate(45deg) translate(-5px, -6px);
        }

        /*ssss*/
        .dropbtn {
            background-color: #ffffff;
            color: #ff0000;
            padding: 16px;
            font-size: 13px;
            border: none;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: #ff0000;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: rgb(255, 243, 0);
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown-content:hover {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: #ffd200;
        }

        .anh1 {
            display: flex;
            justify-content: center;
        }

    </style>
    <style>
        .dropdown-content:hover {
            display: block;
        }
    </style>
<body>
<form action="loginServlet" method="post">
    <input type="hidden" name="action" value="home">
    <nav>
        <div class="logo">
            <h1 style="color: darkred">WELCOME : ${user.name}</h1>
        </div>
        <ul class="nav-links">

            <div class="dropdown">
                <a href="/HomeServlet?action=goHome"><p class="dropbtn">Trang Chu</p></a>
            </div>


            <div class="dropdown">
                <a href="/users?action=user"><p class="dropbtn">User</p></a>
            </div>


            <%--            <div class="dropdown">--%>
            <%--                <a href="/HomeServlet?action=lo-trinh"><p class="dropbtn">Lo trinh</p></a>--%>
            <%--            </div>--%>

            <div class="dropdown">
                <p class="dropbtn">Lo trinh</p>
                <div class="dropdown-content">
                    <a href="/AdminServlet?action=">CRUD LOTRINH</a>
                    <a href="/BaiDoc?action=">CRUD MODULE</a>

                </div>
            </div>

            <div class="dropdown">
                <p class="dropbtn">Bang Dieu Khien</p>
                <div class="dropdown-content">
                    <a href="/HomeServlet?action=baitap">Danh sach bai tap</a>
                    <a href="/HomeServlet?action=caidat">Cai Dat</a>
                    <a href="/HomeServlet?action=doimatkhau">Doi Mat Khau</a>
                </div>
            </div>

            <div class="dropdown">
                <a href="users?action=logout"><p class="dropbtn">Log Out</p></a>
            </div>


        </ul>
        <div class="bugger">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>
    </nav>
    <%--<form action="loginServlet" method="post">--%>
    <%--    <input type="hidden" name="action" value="home">--%>
    <%--    <nav>--%>
    <%--        <img class="anh1" style="width: 5%" src="/img/LOGO.png" alt="">--%>

    <%--        <div class="logo">--%>
    <%--            <h1 style="color: darkred">WELCOME : ${user.name}</h1>--%>
    <%--        </div>--%>
    <%--        <ul class="nav-links">--%>

    <%--            <div class="dropdown">--%>
    <%--                <a href="/HomeServlet?action=goHome"><p class="dropbtn">Trang Chu</p></a>--%>
    <%--            </div>--%>


    <%--&lt;%&ndash;            <div class="dropdown">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<<<<<<< HEAD&ndash;%&gt;--%>
    <%--                <a href="/users?action=user"><p class="dropbtn">User</p></a>--%>
    <%--&lt;%&ndash;&lt;%&ndash;            </div>&ndash;%&gt;&ndash;%&gt;--%>


    <%--&lt;%&ndash;            <div class="dropdown">&ndash;%&gt;--%>
    <%--                <a href="/HomeServlet?action=lo-trinh"><p class="dropbtn">Lo trinh</p></a>--%>
    <%--&lt;%&ndash;=======&ndash;%&gt;--%>
    <%--&lt;%&ndash;                <p class="dropbtn">Lo trinh</p>&ndash;%&gt;--%>
    <%--&lt;%&ndash;                <div class="dropdown-content" style="display: none" >&ndash;%&gt;--%>
    <%--&lt;%&ndash;                    <a href="/AdminServlet?action=">CRUD LOTRINH</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;                    <a href="/BaiDoc?action=">CRUD MODULE</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;>>>>>>> ha&ndash;%&gt;--%>
    <%--            </div>--%>


    <%--            <div class="dropdown">--%>
    <%--                <p class="dropbtn">Bang Dieu Khien</p>--%>
    <%--                <div class="dropdown-content">--%>
    <%--                    <a href="/HomeServlet?action=baitap">Danh sach bai tap</a>--%>
    <%--                    <a href="/HomeServlet?action=caidat">Cai Dat</a>--%>
    <%--                    <a href="/HomeServlet?action=doimatkhau">Doi Mat Khau</a>--%>
    <%--                </div>--%>
    <%--            </div>--%>


    <%--            <div class="dropdown">--%>
    <%--                <a href="users?action=logout"><p class="dropbtn">Log Out</p></a>--%>
    <%--            </div>--%>


    <%--        </ul>--%>
    <%--        <div class="bugger">--%>
    <%--            <div class="line1"></div>--%>
    <%--            <div class="line2"></div>--%>
    <%--            <div class="line3"></div>--%>
    <%--        </div>--%>
    <%--    </nav>--%>

    <script>
        const navSile = () => {
            const bugger = document.querySelector('.bugger');
            const nav = document.querySelector('.nav-links');
            const navLinks = document.querySelectorAll('.nav-links li');
            bugger.addEventListener('click', () => {
                nav.classList.toggle('nav-active');
                navLinks.forEach((link, index) => {
                    if (link.style.animation) {
                        link.style.animation = '';
                    } else {
                        link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 0.5}s`;
                    }
                });
                bugger.classList.toggle('toggle');
            });
        }
        navSile();
    </script>

</form>
</body>
</html>