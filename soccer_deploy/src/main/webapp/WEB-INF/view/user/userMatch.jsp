<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Soccer &mdash; Website by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/css/board.css">


<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="/fonts/icomoon/style.css">

<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/css/jquery-ui.css">
<link rel="stylesheet" href="/css/owl.carousel.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">

<link rel="stylesheet" href="/css/jquery.fancybox.min.css">

<link rel="stylesheet" href="/css/bootstrap-datepicker.css">

<link rel="stylesheet" href="/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="/css/aos.css">

<link rel="stylesheet" href="/css/style.css">
</head>

<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

	<div class="herol overlay">
		<div class="container">
			<div class="row align-items-center line_up_row">
				<div class="col-lg-12 board-list">

					<table class="table custom-table board">

						<thead>
							<tr>
								<th class="matchDate">경기시간</th>
								<th class="title">위치</th>
								<th class="author">상대팀</th>
								
								<th class="view">신청여부</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<c:forEach items="${entry}" var="entry" varStatus="status">
							<fmt:formatDate var="time" value="${entry.matchDate}" pattern="yy/MM/dd HH:mm" />
								<tr>
									<td class="text-white">${time}</td>
									<td class="text-white">${entry.matchPlace}</td>
									<td class="text-white">${entry.opteam}</td>
									<c:choose>
										<c:when test="${date[status.index] == false}">
											<td><a href=""><input type="button" value="기간 만료"></a></td>
										</c:when>
										<c:otherwise>
											<td><a href="/match/cancel?matchId=${entry.id}"><input type="button" value="신청 취소"></a></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<c:if test="${empty entry}">
						<div class="no-article">
							<span>신청한 경기가 없습니다.</span>
						</div>
					</c:if>

				</div>


			</div>
		</div>
	</div>



	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
	<!-- .site-wrap -->

	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/js/jquery-ui.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/jquery.stellar.min.js"></script>
	<script src="/js/jquery.countdown.min.js"></script>
	<script src="/js/bootstrap-datepicker.min.js"></script>
	<script src="/js/jquery.easing.1.3.js"></script>
	<script src="/js/aos.js"></script>
	<script src="/js/jquery.fancybox.min.js"></script>
	<script src="/js/jquery.sticky.js"></script>
	<script src="/js/jquery.mb.YTPlayer.min.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>