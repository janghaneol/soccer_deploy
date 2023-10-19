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
					<div class="widget-next-match">
							<div class="widget-title">
								<h3>경기상세</h3>
							</div>
							<div class="widget-body mb-3">
								<div class="widget-vs">
									<div class="d-flex align-items-center justify-content-around justify-content-between w-100">
										<div class="team-1 text-center">
											<img src="/images/logo_1.png" alt="Image">
											<h3 id="v">My Team</h3>
										</div>
										<div>
											<span class="vs"><span>VS</span></span>
										</div>
										<div class="team-2 text-center">
											<img src="/images/${match.matchImgName}" alt="Image">
											<h3 id="v">${match.opteam}</h3>
										</div>
									</div>
								</div>
							</div>
   
							<div class="text-center widget-vs-contents mb-4">
								<h4 style="text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000;">경기 시간 / 장소</h4>
								<p class="mb-5">
									<fmt:formatDate var="time" value="${match.matchDate}" pattern="yy/MM/dd HH:mm" />
									<span class="d-block" id="v">${time}</span> 
									<a href="" onClick="window.open('/findRoad/${match.id}','','width=700,height=500');return false"><span class="d-block" id="v">${match.matchPlace}</span></a>
								</p>
							</div>
						</div>
					<table class="tg">
						
						<tbody>
							
							<c:forEach var="quarter" items="${quarter}" varStatus="st" begin="0">
								<tr>
									<td class="tg-baqh" colspan="4">${quarter - lineUp[0].quarterId + 1}쿼터</td>
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