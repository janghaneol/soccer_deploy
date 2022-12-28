<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>match</title>

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

<link rel="stylesheet" href="/css/match.css">

</head>

<style>

/* --------------------- */
</style>

<body>


	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

	<!-- 여기까지가 기본구성.  -->
	<!-- 필요하면 지워도 되는데 책임은 못짐. -->

	<!-- <div class="hero overlay"
		style="background-image: url('images/match.jpg');">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-5 mx-auto text-center">
					<h1 class="text-white">Matches</h1>
				</div>
			</div>
		</div>
	</div> -->

	<div class="wrap bg-visual"
		style="background-image: url('/images/match.jpg');">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-5 mx-auto text-center">
					<h1 class="text-white">Matches</h1>
				</div>
			</div>
		</div>
	</div>

	<div class="wrapper">
		<h2>일정/결과</h2>
		<div class="contentWrap">
			<hr>
			<div class="top">
				<div class="center-date">	
					<h3>${empty param.rankMonth ? month : param.rankMonth }월</h3>
					<c:choose>
						<c:when test="${empty param.rankMonth }">
							<a type="button" id="prev" class="btn-outline-info "
								href="./test?rankYear=${param.rankYear}&rankMonth=${month - 1 < 1 ? '01' : (month - 1 < 10 ? '0'+= month - 1 : month -1 )}"
								onclick="${month eq 1 ? 'return false' : ''}">이전</a>
							<a type="button" id="next" class="btn-outline-info "
								href="./test?rankYear=${param.rankYear}&rankMonth=${month + 1 > 12 ? '12' : (month + 1< 10 ? '0'+= month + 1 : month + 1)}"
								onclick="${month eq 12 ? 'return false' : ''}">다음</a>
						</c:when>
						<c:otherwise>
							<a type="button" id="prev" class="btn-outline-info "
								href="./test?rankYear=${param.rankYear}&rankMonth=${param.rankMonth - 1 < 1 ? '01' : (param.rankMonth - 1 < 10 ? '0'+= param.rankMonth - 1 : param.rankMonth -1 )}"
								onclick="${param.rankMonth eq 1 ? 'return false' : ''}">이전</a>
							<a type="button" id="next" class="btn-outline-info "
								href="./test?rankYear=${param.rankYear}&rankMonth=${param.rankMonth + 1 > 12 ? '12' : (param.rankMonth + 1< 10 ? '0'+= param.rankMonth + 1 : param.rankMonth + 1)}"
								onclick="${param.rankMonth eq 12 ? 'return false' : ''}">다음</a>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="right">
					<form id="matchForm" method="get" action="./test">
						<select name="rankYear" id="rankYear">
							<c:forEach var="year" items="${year}">
								<option value="${year}"
									${param.rankYear eq year ? "selected" : ""}>20${year}</option>
							</c:forEach>
						</select> <select name="rankMonth" id="rankMonth">
							<c:forEach var="i" begin="1" end="12">
								<c:choose>
									<c:when test="${i < 10 }">
										<option value="0${i}"
											${empty param.rankMonth ? (month eq i ? "selected" : "") : (param.rankMonth eq i ? "selected" : "")}>${i}월</option>
									</c:when>

									<c:when test="${i eq 10 }">
										<option value="${i}"
											${empty param.rankMonth ? (month eq i ? "selected" : "") : (param.rankMonth eq i ? "selected" : "")}>${i}월</option>
									</c:when>
									<c:otherwise>
										<option value="${i}"
											${empty param.rankMonth ? (month eq i ? "selected" : "") : (param.rankMonth eq i ? "selected" : "")}>${i}월</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</select> <input id="search" type="submit" value="검색">
					</form>
				</div>
			</div>

			<div class="bottom">
				<table class="table custom-table board">

					<thead>
						<tr>
							<th class="">순위</th>
							<th class="">등 번호</th>
							<th class="">이름</th>
							<th class="">골</th>
							<th class="">어시스트</th>
							<th class="">포인트</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<!-- jstl 필요한 시작 부분 for문 -->
						<c:choose>
							<c:when test="${rank.size() eq 0}">
								<c:forEach begin="0" end="9" step="1">
									<tr>
										<td>경기 기록 없음</td>
										<td>경기 기록 없음</td>
										<td>경기 기록 없음</td>
										<td>경기 기록 없음</td>
										<td>경기 기록 없음</td>
										<td>경기 기록 없음</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="rank" items="${rank}" varStatus="status">

									<tr>
										<td>${status.index + 1}</td>
										<td>${rank.backNum}</td>
										<td>${rank.name}</td>
										<td>${rank.goal}</td>
										<td>${rank.assist}</td>
										<td>${rank.point}</td>
									</tr>

								</c:forEach>
							</c:otherwise>
						</c:choose>

						<!-- jstl 필요한 끝 부분 for문 -->
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<!---기본 메뉴--->



	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>






	<script type="/js/viewDetail.js"></script>
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