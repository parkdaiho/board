<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
          글 제목이 들어갑니다.
        </div>
        <div class="info">
          <dl>
            <dt>번호</dt>
            <dd>1</dd>
          </dl>
          <dl>
            <dt>글쓴이</dt>
            <dd>박이름</dd>
          </dl>
          <dl>
            <dt>작성일</dt>
            <dd>2024.2.8</dd>
          </dl>
          <dl>
            <dt>조회</dt>
            <dd>33</dd>
          </dl>
        </div>
        <div class="contents">
          글 내용이 들어갑니다.<br>
          글 내용이 들어갑니다.<br>
          글 내용이 들어갑니다.<br>
          글 내용이 들어갑니다.<br>
          글 내용이 들어갑니다.
        </div>
      </div>
      <div class="btn_wrap">
        <a href="list.jsp" class="on">목록</a>
        <a href="edit.html">수정</a>
      </div>
    </div>
  </div>
</body>
</html>