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
    <c:choose>
      <c:when test="${post != null}">
        <p>게시물 수정하기</p>
      </c:when>
      <c:otherwise>
        <p>게시물 작성하기</p>
      </c:otherwise>
    </c:choose>
  </div>
  <div class="board_write_wrap">
    <div class="board_write">
      <div class="title">
        <dl>
          <dt>제목</dt>
          <dd><input type="text" id="title" placeholder="제목 입력" value="${post.title}"></dd>
        </dl>
      </div>
      <div class="contents">
        <textarea id="contents" placeholder="내용 입력">${post.contents}</textarea>
      </div>
    </div>
    <div class="btn_wrap">
      <c:choose>
        <c:when test="${post != null}">
          <button type="button" id="modify_btn">수정</button>
          <input type="hidden" id="id" value="${post.id}">
        </c:when>
        <c:otherwise>
          <button type="button" id="add_btn">등록</button>
        </c:otherwise>
      </c:choose>
      <button type="button" onclick="history.back()">취소</button>
    </div>
  </div>
</div>
<script src="/js/post.js"></script>
</body>
</html>