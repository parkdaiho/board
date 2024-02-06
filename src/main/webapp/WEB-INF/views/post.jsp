<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<section class="wrapper">
<ul>
    <li><input type="text" value="${post.title}"></li>
    <li><textarea>${post.contents}</textarea></li>
    <li><button type="button" onclick="location.href='/posts'">목록으로</button></li>
</ul>
</section>
</body>
</html>
