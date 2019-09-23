<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<html>
<head>
	<title>update</title>
 <link rel="stylesheet" type="text/css" href="resources/style2.css">
</head>
<body>
<div class="main">
           <p>Edit User Info</p>
	<form action="updateUser" method="POST">
		<input type="hidden" name="id" value="${sessionScope.loginId}">
         <input type ="password" name="pw" placeholder="password" required="" value="${User.pw}"><br>
         <input type ="text" name="name" placeholder="name" required="" value="${User.name}"><br>
         <input type ="text" name="phone" placeholder="Tel" required="" value="${User.phone}"><br>
        <input type ="email" name="email" placeholder="E-mail" required="" value="${User.email}"><br>
         <input type="text" name="birthdate" placeholder="BirthDate" required="" value="${User.birthdate}"><br>
        <button class="btn" type="submit" >Edit</button>
        
	</form>
 </div>
</body>
</html>
