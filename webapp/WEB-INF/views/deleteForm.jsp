<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook3 삭제</title>
</head>
<body>
	<form action="/guestbook3/delete" method="get">
		<input type="hidden" name="no" value="${param.no }">
		비밀번호 <input type="password" name="password">
		
		<button type="submit">삭제</button>
		<br>
		<a href="./list">메인으로 돌아가기</a></td>
	</form>
</body>
</html>
