<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Long ver = new Random().nextLong();
    request.setAttribute("ver", ver);
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<section class="wrapper">
    <input type="hidden" id="post_id" value="${postId}">
<ul>
    <li><label for="title">제목</label><input type="text" id="title" value="${post.title}"></li>
    <li><textarea>${post.contents}</textarea></li>
    <li><button type="button" onclick="location.href='/posts'">목록으로</button></li>
    <li><button type="button" id="delete-btn">삭제하기</button></li>
    <li><button type="button" onclick="location.href='/post/${postId}'">수정하기</button></li>
</ul>
</section>
<script src="/js/post.js?ver=${ver}"></script>
</body>
</html>
