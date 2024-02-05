<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/css/login.css">
</head>
<body>
<section class="loginForm">
    <form action="/login" method="post">
        <ul>
            <li><input type="text" name="username" placeholder="USERNAME"></li>
            <li><input type="password" name="password" placeholder="PASSWORD"></li>
            <li><button type="submit">로그인</button> <button type="button" onclick="location.href='/sign-up'">회원가입</button></li>
        </ul>
    </form>
</section>
</body>
</html>
