<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="stylesheet" href="/css/result.css">

</head>

<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	border-color: white;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg th {
	border-color: white;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg .tg-baqh {
	text-align: center;
	vertical-align: top
}
</style>
<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>



	<!---기본 메뉴--->
	<div class="herol overlay detail-view">
		<div class="container">
			<div class="row align-items-center line_up_row">
				<div class="col-lg-12 detail"
					style="align-items: initial !important;">
					<h1>경기상세</h1>
					<div class="reg-div"
						style="justify-content: flex-end !important; padding: 10px 0px;">

						<c:choose>
							<c:when test="${fn:contains(redirect,'/match/result') }">
								<a href="${redirect}" class="btn btn-primary">목록</a>
							</c:when>
							<c:otherwise>
								<a href="/match/result" class="btn btn-primary">목록</a>
							</c:otherwise>
						</c:choose>

					</div>
					<table class="tg">
						<thead style="color: #ee1e46;">
							<tr>
								<th class="tg-baqh">장소</th>
								<th class="tg-baqh" colspan="3"><a href=""
									onClick="window.open('/findRoad','','width=700,height=500');return false">
										${match.matchPlace}</a></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="tg-baqh">날짜</td>
								<fmt:formatDate var="set" value="${match.matchDate}"
									pattern="yy/MM/dd HH:mm" />

								<td class="tg-baqh" colspan="3">${set}</td>

							</tr>
							<tr>
								<td class="tg-baqh">상대팀</td>
								<td class="tg-baqh" colspan="3">${match.opteam}</td>
							</tr>
							<c:forEach var="quarter" items="${quarter}" varStatus="st" begin="0">
								<tr>
									<td class="tg-baqh" colspan="4">${quarter - lineUp[0].quarterId + 1}set</td>
								</tr>
								<tr>
									<td class="tg-baqh">등번호</td>
									<td class="tg-baqh">이름</td>
									<td class="tg-baqh">골</td>
									<td class="tg-baqh">어시스트</td>
								</tr>
								
								<c:forEach var="lineup" items="${lineUp}" begin="0"
									varStatus="status">
									<c:if test="${lineup.quarterId eq quarter }">
										<tr>
											<td class="tg-baqh">${lineup.entry.user.backNum}</td>
											<td class="tg-baqh">${lineup.entry.user.name}</td>
											<td class="tg-baqh">${lineup.goal}</td>
											<td class="tg-baqh">${lineup.assist}</td>
										</tr>
									</c:if>
								</c:forEach>
							</c:forEach>


						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>




	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
	</div>




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