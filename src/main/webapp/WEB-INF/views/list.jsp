<%@ page import="java.util.List" %>
<%@ page import="me.parkdaiho.board.dto.PostListResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  if(request.getAttribute("lists") != null) {
    List<PostListResponse> lists = (List<PostListResponse>) request.getAttribute("lists");
  }
%>
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
    <div class="board_list_wrap">
      <div class="board_list">
        <div class="top">
          <div class="num">번호</div>
          <div class="title">제목</div>
          <div class="writer">글쓴이</div>
          <div class="date">작성일</div>
          <div class="count">조회</div>
        </div>
        <div>
          <div class="num">1</div>
          <div class="title"><a href="">글 제목이 들어갑니다.</a></div>
          <div class="writer">박이름</div>
          <div class="date">2024.2.8</div>
          <div class="count">33</div>
        </div>
      </div>
      <div class="board_page">
        <a href="#" class="btn first"><<</a>
        <a href="#" class="btn prev"><</a>
        <a href="#" class="num on">1</a>
        <a href="#" class="num">2</a>
        <a href="#" class="num">3</a>
        <a href="#" class="num">4</a>
        <a href="#" class="num">5</a>
        <a href="#" class="btn last">></a>
        <a href="#" class="btn next">>></a>
      </div>
      <div class="btn_wrap">
        <a href="write.jsp" class="on">등록</a>
      </div>
    </div>
  </div>
</body>
</html>