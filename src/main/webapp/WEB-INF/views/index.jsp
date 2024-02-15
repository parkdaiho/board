<%@ page import="me.parkdaiho.board.util.CookieUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Cookie rememberIdCookie = CookieUtils.findCookie(request, "remember_id");

  if(rememberIdCookie != null) {
    request.setAttribute("username", CookieUtils.deserialize(rememberIdCookie, String.class));
  }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="/css/css.css">
</head>
<body>
<div class="login_wrap">
  <div class="login_title">
    <h1>LOGIN</h1>
    <p>로그인을 해주세요.</p>
  </div>
    <div class="login_form">
      <form action="/login" method="post">
        <ul>
          <li><input type="text" placeholder="USERNAME" id="username" name="username" value="${username}"></li>
          <li><input type="password" placeholder="PASSWORD" id="password" name="password"></li>
          <c:choose>
            <c:when test="${username != null}">
              <li><input type="checkbox" id="remember_id" name="remember_id" value="check" checked><label for="remember_id">아이디저장</label></li>
            </c:when>
            <c:otherwise>
              <li><input type="checkbox" id="remember_id" name="remember_id" value="check"><label for="remember_id">아이디저장</label></li>
            </c:otherwise>
          </c:choose>
          <li><a href="/sign-up">회원가입</a></li>
        </ul>
        <div class="btn_wrap">
          <button type="submit" id="login" onclick="return validCheck()">로그인</button>
        </div>
      </form>
    </div>
</div>
<script src="/js/login.js?s"></script>
</body>
</html>