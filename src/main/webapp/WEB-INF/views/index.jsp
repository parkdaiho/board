<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <ul>
        <li><input type="text" placeholder="USERNAME"></li>
        <li><input type="password" placeholder="PASSWORD"></li>
        <li><input type="checkbox" id="remember_id"><label for="remember_id">아이디저장</label></li>
        <li><a href="">회원가입</a></li>
      </ul>
    </div>
    <div class="btn_wrap">
      <a href="#">로그인</a>
    </div>
</div>
</body>
</html>