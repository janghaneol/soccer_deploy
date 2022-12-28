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
		style="background-image: url('images/match.jpg');">
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
					<h3>10월</h3>
					<button type="button" id="prev" class="btn-outline-info "
						onclick="">이전</button>
					<button type="button" id="next" class="btn-outline-info "
						onclick="">다음</button>
				</div>
				<div class="right">
					<form id="matchForm" name="" method="GET" action="">
						<select>
							<option value="">전체</option>
							<option value="2022">2022</option>
						</select> <select name="matchesMonth" id="matchesMonth">
							<option value="">전체</option>
							<option value="01">1월</option>
							<option value="02">2월</option>
							<option value="03">3월</option>
							<option value="04">4월</option>
							<option value="05">5월</option>
							<option value="06">6월</option>
							<option value="07">7월</option>
							<option value="08">8월</option>
							<option value="09">9월</option>
							<option value="10">10월</option>
							<option value="11">11월</option>
							<option value="12">12월</option>
						</select> <input id="search" type="submit" value="검색" onclick="">
					</form>
				</div>
			</div>

			<div class="bottom">



				<ul>
					<li>
						<div class="date">날짜</div>
						<ul class="board">
							<c:forEach var="item" items="${list}">
								<li>${item.matchDate}</li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<div class="place">장소</div>
						<ul class="board">
							
						<c:forEach var="item" items="${list}">
								<li>${item.matchPlace}</li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<div class="result">경기일정</div>
						<ul class="board">
									<c:forEach var="item" items="${list}">
								<li><button type="button"
									onclick="openLayerPopup('popup-01', 900, 600, this);"
									class="bg-success" id="">참가명단</button> MyTeam 1 : 0 ${item.opteam}
								</li>
							</c:forEach>
						</ul>
					</li>


					<li>
						<div class="log">참가버튼</div>
						<ul class="board">
									<c:forEach var="i" items="${list}" varStatus="index" begin="0" end="${list.size()}">
								<li><a type="" href="/match/asd?matchId=10">참가신청</a></li>
							</c:forEach>
						</ul>
					</li>
				</ul>
			</div>

			<!-- #wrapper  -->

			<div id="layer-mask"></div>
			<div id="popup-01" class="layer-popup" title="레이어 팝업창 1">
				<header class="header">
					<h3>참가신청명단</h3>
					<a href="#" class="close"><i class="fas fa-times"><span>
								닫기</span></i></a>
				</header>
				<section class="body">
					<div class="wrapper">
						<table border="1">
							<tr>
								<th scope="col">TEAM1</th>
								<th scope="col">SCORE</th>
								<th scope="col">TEAM2</th>
								<th scope="col">WIN</th>
								<th scope="col">TIME</th>
							</tr>
							<tr>
								<td>TEAM1</td>
								<td>0:0</td>
								<td>TEAM2</td>
								<td>TEAM1</td>
								<td>80</td>
							</tr>
						</table>
					</div>
					<!-- quater -->
					<div class="wrapper">
						<table border="1">
							<tr>
								<th scope="col">QUATER</th>
								<th scope="col">TEAM</th>
								<th scope="col">SCORE</th>
								<th scope="col">TEAM</th>
								<th scope="col">WIN</th>
								<th scope="col">TIME</th>
								<th scope="col">GOAL</th>
								<th scope="col">ASSIST</th>
							</tr>
							<tr>
								<td>QUATER1</td>
								<td>TEAM1</td>
								<td>0:0</td>
								<td>TEAM2</td>
								<td>TEAM1</td>
								<td>80</td>
								<td>3</td>
								<td>1</td>
							</tr>
						</table>
					</div>
				</section>
				<footer class="footer">
					<p class="copyright"></p>
					<p class="logo last">
						<img alt="" src="" />
					</p>
				</footer>
			</div>


		</div>
		<a href="/match/schedule" class="btn btn-primary">경기등록</a>
	</div>
	<!---기본 메뉴--->



	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>




	<script>
		function openLayerPopup(id, width, height, el) {
			const $popup = document.getElementById(id);
			const $mask = document.getElementById('layer-mask');
			const $close = $popup.querySelector('.close');
			const $last = $popup.querySelector('.last');
			const $return = el;
			// 팝업창 표시
			$popup.setAttribute('style', 'width: ' + width + 'px; height: '
					+ height + 'px;');
			$popup.setAttribute('tabindex', 0);
			$last.setAttribute('tabindex', 0);
			$popup.insertAdjacentHTML('beforebegin', '<a href="#"></a>');
			$popup.insertAdjacentHTML('afterend', '<a href="#"></a>');
			$mask.classList.add('on');
			$popup.classList.add('on');
			$popup.focus();
			// 팝업창 닫기
			$close.addEventListener('click', close, false);
			// focus
			$popup.previousElementSibling.addEventListener('focusin',
					function() {
						$last.focus();
					}, false);
			$popup.nextElementSibling.addEventListener('focusin', function() {
				$popup.focus();
			}, false);
			function close() {
				$return.focus();
				$mask.classList.remove('on');
				$popup.classList.remove('on');
				$close.removeEventListener('click', close, false);
				$popup.previousElementSibling.remove();
				$popup.nextElementSibling.remove();
			}
		}
	</script>

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
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="/js/aos.js"></script>
	<script src="/js/jquery.fancybox.min.js"></script>
	<script src="/js/jquery.sticky.js"></script>
	<script src="/js/jquery.mb.YTPlayer.min.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>