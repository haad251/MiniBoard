<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/style2.css?after">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">

<script>
window.onload=function(){
	var c=document.getElementById("boardContent").value;
	document.getElementById("content").innerText=c;
}
 

</script>

</head>
<body>
	<input type="hidden" id="boardContent" value="${board.content}">
	<div class="boardform">
		<p>
			<a href="getBoard?page=1">Board</a>
		</p>
		<div class="inner">
			<c:if test="${board.board_seq!=null}">
				<div class="d dtitle">${board.title}</div>
				<div class="d dtitleid" style="float: left;">
					ID:${board.id}<br>
				</div>
				<div class="d dtitlemenu" style="float: left;">
					No.${board.board_seq} DATE:${board.indate}</div>
					<br>
					<a href="fileDownload?file_seq=${file.file_seq}">${file.org_name}</a>
					
					
				<div class="d dcontent" id="content">${board.content}</div>
				<c:if test="${board.id==sessionScope.loginId}">
					<form class="detail" action="deleteBoard" method="POST">


						<input type="hidden" value="${board.board_seq}" name="board_seq">
						<button class="mini" type="submit" style="float: right;">Delete</button>
					</form>

					<form class="detail" action="goWrite" method="GET">
						<input type="hidden" value="${board.board_seq}" name="board_seq">
						<input type="hidden" value="${board.title}" name="title">
						<input type="hidden" value="${board.content}" name="content">
						<button class="mini" type="submit" style="float: right;">
							Edit</button>

					</form>
				</c:if>
				<br>
				<br>
				<br>
				<br>

				<div class="insertreply">
					<form class="detail" action="insertReply" method="POST">
						<input type="hidden" value="${sessionScope.loginId}" name="id">
						<input type="hidden" value="${board.board_seq}" name="board_seq">
						<input type="hidden" value="1" name="dept">
						<textarea class="replybox" cols="20" rows="5" name="content"
							style="float: left;"></textarea>
						<button class="mini" type="submit" style="float: left;">Reply</button>
					</form>
				</div>
				<c:forEach items="${rList}" var="replyMap">
					<br>
					<div class="replycontent">
						<div style="margin-bottom: 5px;">
							<div style="display: inline-block; font-weight: bold;">
								${replyMap.ID}</div>
							<c:if test="${replyMap.ID==sessionScope.loginId}">
								<form style="display: inline-block;" action="deleteReply"
									method="POST">
									<input type="hidden" value="${replyMap.REPLY_SEQ}"
										name="reply_seq"> <input type="hidden"
										value="${board.board_seq}" name="board_seq"> <input
										type="hidden" value="${navi.currentPage}" name="page">
									<button class="deleteX" type="submit">X</button>
								</form>
							</c:if>
							<br>
						</div>
						<div class="replycontent" id="rcontent">
							${replyMap.CONTENT}
							<br>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<br> <br> <br>
			<div class="boardmenu" style="float:left;">
	
			<form action="searchBoard" method="get" >
				 <input type="text" class="searchformbox" name="keyword"
					value=${keyword}> 
				<button class="mini" type="submit">Serach</button>
			</form>
			</div>
			<div class="boardmenu" style="float: right;" >
			<form action="goWrite" method="get">
				<button class="mini" type="submit">
					<i class="fas fa-edit fa-lg" style="color: white;"></i>Write
				</button>
			</form>
			</div>
			<table align="center">
				<colgroup>
					<col width="10%;">
					<col width="20%;">
					<col width="40%;">
					<col width="20%;">
				</colgroup>
				<thead>
					<tr>
						<td>No</td>
						<td>Writer</td>
						<td>Title</td>
						<td>Date</td>
					</tr>
				</thead>

				<c:forEach items="${bList}" var="board">
					<c:if test="${board!=null}">

						<c:if test="${keyword==null}">
							<tr class="row"
								onclick="location.href='getBoard?board_seq=${board.board_seq}&page=${navi.currentPage}'"
								style="cursor: pointer">
						</c:if>

						<c:if test="${keyword!=null}">
							<tr class="row"
								onclick="location.href='searchBoard?board_seq=${board.board_seq}&keyword=${keyword}&page=${navi.currentPage}'"
								style="cursor: pointer">
						</c:if>
					</c:if>
					<td class="line">${board.board_seq}</td>
					<td class="line">${board.id}</td>
					<td class="line">${board.title}</td>
					<td class="line">${board.indate}</td>
					</tr>
				</c:forEach>
			</table>

			<div class="pagenumber">
				<c:if test="${keyword==null}">
					<a href="getBoard?page=1">&lt;&lt;</a>
					<a href="getBoard?page=${navi.currentPage-navi.pagePerGroup}"><i
						class="material-icons pageicon">chevron_left</i>&nbsp;&nbsp;</a>

					<c:forEach var="i" begin="${navi.startPageGroup}"
						end="${navi.endPageGroup}">
						<c:if test="${navi.currentPage==i}">
							<a style="font-weight: bold"
								href="getBoard?board_seq=${board.board_seq}&page=${i}">${i}&nbsp;&nbsp;</a>
						</c:if>

						<c:if test="${navi.currentPage!=i}">
							<a href="getBoard?board_seq=${board.board_seq}&page=${i}">${i}&nbsp;&nbsp;</a>
						</c:if>
					</c:forEach>
					<a href="getBoard?page=${navi.currentPage+navi.pagePerGroup}"><i
						class="material-icons">chevron_right</i>&nbsp;&nbsp;</a>
					<a href="getBoard?page=${navi.totalPageCount}">>></a>

				</c:if>

				<c:if test="${keyword!=null}">

					<a
						href="searchBoard?board_seq=${board.board_seq}&page=1&keyword=${keyword}">&lt;&lt;</a>
					<a
						href="searchBoard?board_seq=${board.board_seq}&page=${navi.currentPage-navi.pagePerGroup}&keyword=${keyword}"><i
						class="material-icons pageicon">chevron_left</i>&nbsp;&nbsp;</a>

					<c:forEach var="i" begin="${navi.startPageGroup}"
						end="${navi.endPageGroup}">
						<c:if test="${navi.currentPage==i}">
							<a style="font-weight: bold"
								href="searchBoard?page=${i}&keyword=${keyword}">${i}&nbsp;&nbsp;</a>
						</c:if>

						<c:if test="${navi.currentPage!=i}">
							<a href="searchBoard?page=${i}&keyword=${keyword}">${i}&nbsp;&nbsp;</a>
						</c:if>
					</c:forEach>
					<a
						href="searchBoard?page=${navi.currentPage+navi.pagePerGroup}&keyword=${keyword}"><i
						class="material-icons">chevron_right</i>&nbsp;&nbsp;</a>
					<a
						href="searchBoard?page=${navi.totalPageCount}&keyword=${keyword}">>></a>

				</c:if>

			</div>


			
		</div>
		</div>
</body>
</html>