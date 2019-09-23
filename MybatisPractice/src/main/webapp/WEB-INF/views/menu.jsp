<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/style2.css?after">
</head>
<body>
<div class="main">

		<p>Hi, ${sessionScope.loginId} </p>
	<h4>${message}</h4>

	<form action="goBoardform" method="get">
		<button class="btn" type="submit">Board</button>
	</form>
	<br>
	
	<form action="logout" method="get">
	<button class="btn" type="submit">Logout</button>
	</form>
	<br>

	<form action="goUpdateUserform" method="get">
		<button class="btn" type="submit">Edit User Info</button>
	</form>
	<br>

	<form action="deleteUser" method="POST">
		<input type="hidden" value="${sessionScope.loginId}" name="id">
		<button class="btn" type="submit">Sign out</button>
	</form>
	
</div>
</body>
</html>