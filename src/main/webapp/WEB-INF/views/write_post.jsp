<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
<h2>게시물 작성</h2>
<section>
    <input type="hidden" name="userId" id="userId" value="${userId}">
    <ul>
        <li><input type="text" id="title" placeholder="enter your title"></li>
        <li><textarea id="contents" placeholder="Please enter your content"></textarea></li>
        <li><button type="button" id="add-btn">작성하기</button> <button type="button" onclick="history.back()">돌아가기</button></li>
    </ul>
</section>
<script src="/js/post.js"></script>
</body>
</html>
