<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>SignUp</title>
  <link rel="stylesheet" href="/css/css.css">
</head>
<body>
<div class="sign_up_wrap">
  <div class="sign_up_title">
    <h1>회원가입</h1>
    <p></p>
  </div>
  <div class="sign_up_form">
    <form action="/sign-up" method="post" onsubmit="return validCheck()">
      <ul>
        <li><label for="username">USERNAME : </label><input type="text" name="username" id="username"></li>
        <li><label for="password">PASSWORD : </label><input type="password" name="password" id="password"></li>
        <li><label for="nickname">NICKNAME : </label><input type="text" name="nickname" id="nickname"></li>
      </ul>
      <div class="btn_wrap">
        <button type="submit">가입하기</button>
      </div>
    </form>
  </div>
</div>
<script src="/js/signUp.js"></script>
</body>
</html>