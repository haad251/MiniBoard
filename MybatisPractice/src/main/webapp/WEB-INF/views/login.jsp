<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="resources/style2.css?after">
</head>
<body>
<div class="main">
 <p>Login</p>
<form action="selectUser" method="POST">
	<input class="loginbox"  type ="text" name="id" placeholder="아이디" required="" value="${User.id}"><br>
    <input class="loginbox"  type ="password" name="pw" placeholder="패스워드" required="" value="${User.pw}"><br>
	${message}<br>
        <button class="btn" type="submit" >Login</button>
</form>
</div>

</body>
</html>