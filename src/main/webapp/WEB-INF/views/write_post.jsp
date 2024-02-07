<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Long ver = new Random().nextLong();
    request.setAttribute("ver", ver);
%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
<h2>게시물 작성</h2>
<section>
    <input type="hidden" name="post_id" id="post_id" value="${postId}">
    <ul>
        <li><input type="text" id="title" placeholder="enter your title" value="${post.title}"></li>
        <li><textarea id="contents" placeholder="Please enter your content">${post.contents}</textarea></li>
        <li><button type="button" id="add-btn">작성하기</button> <button type="button" onclick="history.back()">돌아가기</button>
            <button type="button" id="modify-btn">수정하기</button></li>
    </ul>
</section>
<script src="/js/post.js?ver${ver}"></script>
</body>
</html>
