<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" type="text/css" href="resources/style2.css?after"> 
 
<script>
function check(){
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;
	if(id.length<5 || id.length>12){
		document.getElementById("message").innerHTML="<font color='red'>ID는 5~12자리로 입력하세요</font>";
		return false;
	}
	
	if(pw.length<5 || pw.length>12){
		document.getElementById("message").innerHTML="<font color='red'>PW는 5~12자리로 입력하세요</font>";
		return false;
	}
	
	
	
	return true;
}

</script>
 
</head>
<body>
<div class="main">
           <p>Sign up</p>
	<form action="insertUser" method="POST" onsubmit="return check()">
        <input class="loginbox" type ="text" id="id" name="id" placeholder="Id" required="" value="${User.id}"><br>
        <input class="loginbox"  type ="password" id="pw" name="pw" placeholder="Password" required="" value="${User.pw}"><br>
        <input class="loginbox"  type ="text" name="name" placeholder="Name" required="" value="${User.name}"><br>
        <input class="loginbox"  type ="text" name="phone" placeholder="Tel" required="" value="${User.phone}"><br>
        <input class="loginbox"  type ="email" name="email" placeholder="E-mail" required="" value="${User.email}"><br>
        <div id="message">
        </div>
        <button class="btn" type="submit" >Sign up</button>
        
	<a href ="loginform" text-decoration:none>go Login</a>

	</form>
 </div>


</body>
</html>
