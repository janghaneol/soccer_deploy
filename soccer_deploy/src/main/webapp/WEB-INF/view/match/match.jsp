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
		<div class="wrapper">
			<h2>일정</h2>
		</div>
		
		
		<div class="contentWrap">
			<hr>
			<div class="top">
				<div class="center-date">
					<h3>${empty param.matchMonth ? month : param.matchMonth }월</h3>
					
				<c:choose>
						<c:when test="${empty param.matchMonth }">
							<a type="button" id="prev" class="btn-outline-info "
								href="?matchYear=${param.matchYear}&matchMonth=${month - 1 < 1 ? '01' : (month - 1 < 10 ? '0'+= month - 1 : month -1 )}"
								onclick="${month eq 1 ? 'return false' : ''}">이전</a>
							<a type="button" id="next" class="btn-outline-info "
								href="?matchYear=${param.matchYear}&matchMonth=${month + 1 > 12 ? '12' : (month + 1< 10 ? '0'+= month + 1 : month + 1)}"
								onclick="${month eq 12 ? 'return false' : ''}">다음</a>
						</c:when>
						<c:otherwise>
							<a type="button" id="prev" class="btn-outline-info "
								href="?matchYear=${param.matchYear}&matchMonth=${param.matchMonth - 1 < 1 ? '01' : (param.matchMonth - 1 < 10 ? '0'+= param.matchMonth - 1 : param.matchMonth -1 )}"
								onclick="${param.matchMonth eq 1 ? 'return false' : ''}">이전</a>
							<a type="button" id="next" class="btn-outline-info "
								href="?matchYear=${param.matchYear}&matchMonth=${param.matchMonth + 1 > 12 ? '12' : (param.matchMonth + 1< 10 ? '0'+= param.matchMonth + 1 : param.matchMonth + 1)}"
								onclick="${param.matchMonth eq 12 ? 'return false' : ''}">다음</a>
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="right">
					<form id="matchForm" method="get">
						<select name="matchYear" id="matchYear">
							<c:forEach var="year" items="${year}">
								<option value="${year}" ${param.matchYear eq year ? "selected" : ""}>20${year}</option>
							</c:forEach>
						</select>  
						<select name="matchMonth" id="matchMonth">
							<c:forEach var="i" begin="1" end="12">
								<c:choose>
								  
									<c:when test="${i < 10 }">
										<option value="0${i}"
											${empty param.matchMonth ? (month eq i ? "selected" : "") : (param.matchMonth eq i ? "selected" : "")}>${i}월</option>
									</c:when>
									
									<c:when test="${i eq 10 }">
										<option value="${i}"
											${empty param.matchMonth ? (month eq i ? "selected" : "") : (param.matchMonth eq i ? "selected" : "")}>${i}월</option>
									</c:when>
									
									<c:otherwise>
										<option value="${i}"
											${empty param.matchMonth ? (month eq i ? "selected" : "") : (param.matchMonth eq i ? "selected" : "")}>${i}월</option>
									</c:otherwise>
									
								</c:choose>

							</c:forEach>
						</select> <input id="search" type="submit" value="검색" onclick=""><a href="/match/schedule" class="btn btn-primary" style="margin-left: 5px;">경기등록</a>
					</form>
				</div>
			</div>
  
			<div class="bottom">
				
				<c:choose>
					<c:when test="${empty result }">
						<ul>
							<li>
								<div class="date">날짜</div>
								<ul class="board">
									<li>기록없음</li>

								</ul>
							</li>
							<li>
								<div class="place">장소</div>
								<ul class="board">


									<li>기록없음</li>
								</ul>
							</li>
							<li>
								<div class="result">경기결과</div>
								<ul class="board">

									<li>기록없음</li>
								</ul>

							</li>


							<li>
								<div class="log">결과보기</div>
								<ul class="board">
									<li>기록없음</li>
								</ul>
							</li>
						</ul>
					</c:when>
				<c:otherwise>
				<ul>
					<li>
						<div class="date">날짜</div>
						<ul class="board">
							<c:forEach var="item" items="${result}">
										<fmt:formatDate var="time" value="${item.matchDate}"
											pattern="yy/MM/dd HH:mm" />
										<li>${time}</li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<div class="place">장소</div>
						<ul class="board">

							<c:forEach var="item" items="${result}">
								<li>${item.matchPlace}</li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<div class="result">경기일정</div>
						<ul class="board">
							<c:forEach var="item" items="${result}">
								<li><button type="button"
										onclick="openLayerPopup('popup-01', 900, 600, this);"
										class="bg-success" id="">참가명단</button>
									${item.opteam}</li>
							</c:forEach>
						</ul>
					</li>


					<li>
						<div class="log">참가버튼</div>
						<ul class="board">
							<c:forEach var="i" items="${result}" varStatus="index" begin="0" end="${result.size()}">
								<li><a type="" href="/match/asd?matchId=${i.id}">참가신청</a></li>
							</c:forEach>
						</ul>
					</li>
				</ul>
					</c:otherwise>
				</c:choose>
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
		/*
		// select 의 월 옵션값이 헤드에 들어갑니다
		var monthChange = function(value) {
			$("#hMonth").text(value + "월");
		}
		
		// 이전, 다음 button으로 헤드값 수정하기 매우 더러워요 코드..
		function count(type){
			const result = document.getElementById("hMonth");
			const month = document.getElementById("matchMonth");
			const next = document.getElementById("next");
			const prev = document.getElementById("prev")

			let number = result.innerText;

				if(type === 'pl'){
					if(parseInt(number)<12){
						number=parseInt(number)+1;
						prev.disabled = false;
						console.log(number);
						if(number<10){
							result.innerText = "0"+number+"월";
						}
						else{
							result.innerText = number+"월";
						}
					}
					else{
						next.disabled='disabled';
					}
				}
				
				else if (type === 'mi'){
					if(parseInt(number)>1){
						number = parseInt(number)-1;
						next.disabled = false;
						console.log(number);
						if(number<10){
							result.innerText = "0"+number+"월";
						}
						else{
							result.innerText = number+"월";
						}	
					}
					else{
						prev.disabled='disabled'; 
					}
				}	
			
		} 
	*/
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
	<script src="/js/jquery.easing.1.3.js"></script>
	<script src="/js/aos.js"></script>
	<script src="/js/jquery.fancybox.min.js"></script>
	<script src="/js/jquery.sticky.js"></script>
	<script src="/js/jquery.mb.YTPlayer.min.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>