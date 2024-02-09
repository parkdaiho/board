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
    <div class="board_write_wrap">
      <div class="board_write">
        <div class="title">
          <dl>
            <dt>제목</dt>
            <dd><input type="text" placeholder="제목 입력"></dd>
          </dl>
        </div>
        <div class="info">
          <dl>
            <dt>글쓴이</dt>
            <dd><input type="text" placeholder="글쓴이 이름"></dd>
          </dl>
          <dl>
            <dt>비밀번호</dt>
            <dd><input type="password" placeholder="비밀번호 입력"></dd>
          </dl>
        </div>
        <div class="contents">
          <textarea placeholder="내용 입력"></textarea>
        </div>
      </div>
      <div class="btn_wrap">
        <a href="#" class="on">등록</a>
        <a href="list.jsp">취소</a>
      </div>
      <div class="btn_wrap">
        <a href="#" class="on">수정</a>
        <a href="view.jsp">취소</a>
      </div>
    </div>
  </div>
</body>
</html>