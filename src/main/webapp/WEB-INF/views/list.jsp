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
    <p>총 ${count} 개의 게시물</p>
  </div>
  <div class="board_list_wrap">
    <div class="board_list">
      <div class="top">
        <div class="num">번호</div>
        <div class="title">제목</div>
        <div class="writer">글쓴이</div>
        <div class="date">작성일</div>
        <div class="count">조회</div>
      </div>
      <c:forEach var="post" items="${list}">
        <div>
          <div class="num">${post.id}</div>
          <div class="title"><a href="/posts/${post.id}">${post.title}</a></div>
          <div class="writer">${post.nickname}</div>
          <div class="date">${post.createdAt}</div>
          <div class="count">${post.views}</div>
        </div>
      </c:forEach>
    </div>
    <c:if test="${totalPages != 0}">
      <div class="board_page">
        <a href="/posts?page=1" class="btn first"><<</a>
        <a href="/posts?page=${page == 1 ? 1 : page - 1}" class="btn prev"><</a>
        <c:forEach var="num" begin="${fistNumOfBlock}" end="${lastNumOfBlock}">
          <c:choose>
            <c:when test="${page == num}">
              <a href="/posts?page=${page}" class="num on">${page}</a>
            </c:when>
            <c:otherwise>
              <a href="/posts?page=${num}" class="num">${num}</a>
            </c:otherwise>
          </c:choose>
        </c:forEach>
        <a href="/posts?page=${page == totalPages ? page : page + 1}" class="btn last">></a>
        <a href="/posts?page=${totalPages}" class="btn next">>></a>
      </div>
    </c:if>
    <div class="btn_wrap">
      <a href="/post" class="on">등록</a>
      <a href="/logout">로그아웃</a>
    </div>
  </div>
</div>
</body>
</html>