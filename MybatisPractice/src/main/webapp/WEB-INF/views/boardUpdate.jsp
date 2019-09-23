<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="resources/style2.css">

</head>
<body>
<div class="boardform">
<p>Edit Post</p>

<form action = "updateBoard" method="GET">
		<input type="hidden" value="${board.board_seq}" name="board_seq">
	 <textarea class="wtitle"  name="title" >${board.title}</textarea>
	 <br><br>
	 <textarea class="wcontent"  name="content">${board.content}</textarea>
	<button type="submit">Edit</button>	
	</form>
</div>
</body>
</html>