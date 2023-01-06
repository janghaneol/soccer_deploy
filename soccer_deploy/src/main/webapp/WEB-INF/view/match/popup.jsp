<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<table border="">
		<caption>참가신청명단</caption>
			<tr>
				<th scope="col">경기번호</th>
				<th scope="col">유저ID</th>
				<th scope="col">이메일</th>
				<th scope="col">나이</th>
				<th scope="col">이름</th>
				<th scope="col">포지션</th>
				<th scope="col">등번호</th>
			</tr>
			<c:forEach var="popup" items="${popupList}">
			<tr>
				<td>${popup.match_id}</td>
				<td>${popup.user_id}</td>
				<td>${popup.email}</td>
				<td>${popup.age}</td>
				<td>${popup.name}</td>
				<td>${popup.position}</td>
				<td>${popup.back_num}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>