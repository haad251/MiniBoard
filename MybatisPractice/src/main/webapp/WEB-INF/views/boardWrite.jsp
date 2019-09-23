<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/style2.css?after">
</head>
<body>
<div class="boardform">

<p>Write Post</p>

<c:if test="${board.board_seq!=null}">
<form action="updateBoard" method="post" enctype="multipart/form-data">
<input type="hidden" name="board_seq" value="${board.board_seq}">
</c:if>

<c:if test="${board.board_seq==null}" >
<form action="insertBoard" method="post" enctype="multipart/form-data">
</c:if>
<br>
	<div class="d dtitle"> 
	<textarea class="wtitle" rows="1" name="title" placeholder="Title">${board.title}</textarea>
	</div>
	<br>
	<div class="d dcontent">

	<br>
	
	<input type="file" name="uploadFile">

	<br>
	<br>
	
	<textarea class="wcontent" rows="20" name="content" placeholder="Content" >${board.content}</textarea>
	<button type="submit">Submit</button>	
	</form>
	</div>

</div>
</body>
</html>