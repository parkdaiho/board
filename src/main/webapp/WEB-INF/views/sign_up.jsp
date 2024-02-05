<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/css/sign-up.jsp">
</head>
<body>

<form action="/sign-up" method="post">
    <ul>
        <li><input type="text" name="username" placeholder="USERNAME"></li>
        <li><input type="password" name="password" placeholder="PASSWORD"></li>
        <li><input type="text" name="nickname" placeholder="NICKNAME"></li>
        <li><button type="submit">가입하기</button> <button type="button" onclick="location.href='/login'">돌아가기</button></li>
    </ul>

</form>

</body>
</html>
