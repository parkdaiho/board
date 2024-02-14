<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link rel="stylesheet" href="/css/css.css">
</head>
<body>
  <div class="board_wrap">
    <div class="board_title">
      <strong>게시판</strong>
      <p>게시물 목록이 있다.</p>
    </div>
    <div class="board_view_wrap">
      <div class="board_view">
        <div class="title">
          ${post.title}
        </div>
        <div class="info">
          <dl>
            <dt>번호</dt>
            <dd>${post.id}</dd>
          </dl>
          <dl>
            <dt>글쓴이</dt>
            <dd>${post.writer}</dd>
          </dl>
          <dl>
            <dt>작성일</dt>
            <dd>${post.createdAt}</dd>
          </dl>
          <dl>
            <dt>조회</dt>
            <dd>${post.views}</dd>
          </dl>
        </div>
        <div class="contents">
          ${post.contents}
        </div>
      </div>
      <div class="btn_wrap">
        <button type="button" onclick="location.href='/posts'">목록</button>
        <c:if test="${post.isWriter}">
          <button type="button" onclick="location.href='/post/${post.id}'">수정</button>
          <button type="button" id="delete_btn">삭제</button>
          <input type="hidden" id="id" value="${post.id}">
        </c:if>
      </div>
    </div>
  </div>
<script src="/js/post.js"></script>
</body>
</html>