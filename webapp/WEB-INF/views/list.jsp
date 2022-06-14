<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook3</title>
</head>
<body>
	<h1>Guestbook3</h1>
	<p>안녕하세요<br> 게스트북 리스트입니다</p>
	
	<form action="/guestbook3/write" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea name="content" rows="10" cols="60"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<button type="submit">확인</button>
				</td>
			</tr>
		</table>
	</form>
	<br>
	
	<c:forEach items="${requestScope.guestList}" var="guestbookVo">
		<table border="1">
			<tr>
				<td>${guestbookVo.no }</td>
				<td>${guestbookVo.name }</td>
				<td>${guestbookVo.regDate }</td>
				<td><a href="/guestbook3/deleteForm?no=${guestbookVo.no }">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">
					${guestbookVo.content }
				</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	
	
</body>
</html>