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
<script defer type="module" src="js/LineUpMake.js"></script>
<link rel="stylesheet" href="css/LineUpMake.css">


<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<link rel="stylesheet" href="css/jquery.fancybox.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">

<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">

<script>
	
	function PrintDiv() {
		let date = new Date(document.querySelector("#date").value);
		let fomat = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDay();
		div = document.querySelector(".open");
		let setName = div.classList[1];
		console.log(setName);
		
		html2canvas(div).then(function(canvas) {
			let myImage = canvas.toDataURL();
			downloadURI(myImage, fomat+"_"+setName+".jpg");
		});
	}
	function downloadURI(uri, name) {
		let link = document.createElement("a")
		link.download = name;
		link.href = uri;
		document.body.appendChild(link);
		link.click();
		document.body.removeChild(link);
	}
</script>

</head>

<body>
	<input type="hidden" id="date" value="${entry[0].match.matchDate} ">
	<input type="hidden" id="size" value="${quarter.size()}">
	<div class="site-wrap">
	
		<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

		<div class="hero overlay"
			>
			<div class="container">
				<div class="row align-items-center line_up_row">
					<div class="row align-items-center line_up_row">
						<div class="pop">
							<h4>변경사항을 저장하시겠습니까?</h4>
							<div class="btn_pop">
								<button type="button" class="Ysave">저장</button> <button type="button" class="Nsave">취소</button>
							</div>
						</div>
	
					<div class="chan_set">
						<button type="button" class="make_first">1set</button>
						<button type="button" class="make_second"
							style="${quarter.size() > 1 ? '' : 'display:none;'}">2set</button>
						<button type="button" class="make_third"
							style="${quarter.size() > 2 ? '' : 'display:none;'}">3set</button>
						<button type="button" class="make_fourth"
							style="${quarter.size() > 3 ?  '' : 'display:none;'}">4set</button>
						<button type="button" class="img_sava" onclick="PrintDiv();">이미지저장</button>
					</div>
					<div class="lineUp" id="lineUp">

						<div class="dragin first_set open" id="dragin" data-quarter="${quarter[0].id}">

							<div class="form first empty st" id="player"></div>
							<div class="form first empty cf" id="player"></div>
							<div class="form first empty lm" id="player"></div>
							<div class="form first empty lcm" id="player"></div>
							<div class="form first empty rcm" id="player"></div>
							<div class="form first empty rm" id="player"></div>
							<div class="form first empty lb" id="player"></div>
							<div class="form first empty lcb" id="player"></div>
							<div class="form first empty rcb" id="player"></div>
							<div class="form first empty rb" id="player"></div>
							<div class="form first empty gk" id="player"></div>
							<div class="sub"><span>${entry[0].match.matchDate}/1set</span></div>
						</div>

						<div class="dragin second_set close" id="dragin" data-quarter="${quarter.size() > 1 ? quarter[1].id : ''}">
							<div class="form second empty st" id="player"></div>
							<div class="form second empty cf" id="player"></div>
							<div class="form second empty lm" id="player"></div>
							<div class="form second empty lcm" id="player"></div>
							<div class="form second empty rcm" id="player"></div>
							<div class="form second empty rm" id="player"></div>
							<div class="form second empty lb" id="player"></div>
							<div class="form second empty lcb" id="player"></div>
							<div class="form second empty rcb" id="player"></div>
							<div class="form second empty rb" id="player"></div>
							<div class="form second empty gk" id="player"></div>
							<div class="sub"><span>${entry[0].match.matchDate}/2set</span></div>
						</div>

						<div class="dragin third_set close" id="dragin" data-quarter="${quarter.size() > 2 ? quarter[2].id : ''}">
							<div class="form third empty st" id="player"></div>
							<div class="form third empty cf" id="player"></div>
							<div class="form third empty lm" id="player"></div>
							<div class="form third empty lcm" id="player"></div>
							<div class="form third empty rcm" id="player"></div>
							<div class="form third empty rm" id="player"></div>
							<div class="form third empty lb" id="player"></div>
							<div class="form third empty lcb" id="player"></div>
							<div class="form third empty rcb" id="player"></div>
							<div class="form third empty rb" id="player"></div>
							<div class="form third empty gk" id="player"></div>
							<div class="sub"><span>${entry[0].match.matchDate}/3set</span></div>
						</div>

						<div class="dragin fourth_set close" id="dragin" data-quarter="${quarter.size() > 3 ? quarter[3].id	 : ''}">
							<div class="form fourth empty st" id="player"></div>
							<div class="form fourth empty cf" id="player"></div>
							<div class="form fourth empty lm" id="player"></div>
							<div class="form fourth empty lcm" id="player"></div>
							<div class="form fourth empty rcm" id="player"></div>
							<div class="form fourth empty rm" id="player"></div>
							<div class="form fourth empty lb" id="player"></div>
							<div class="form fourth empty lcb" id="player"></div>
							<div class="form fourth empty rcb" id="player"></div>
							<div class="form fourth empty rb" id="player"></div>
							<div class="form fourth empty gk" id="player"></div>
							<div class="sub"><span>${entry[0].match.matchDate}/4set</span></div>
						</div>
						
					</div>
					<div class="search">
						<button type="button" class="close_pop">X</button>

						<div class="col-lg-12">
							<h1>Players</h1>
							<div class="search-bar">
								<input type="text" class="searchval">
								<button type="button" class="nameSearch"></button>
							</div>
							<div class="scroll">
								<table class="table custom-table list">
									<thead>
										<tr>
											<th class="f_col">No.</th>
											<th class="s_col">이름</th>
											<th class="t_col">선호포지션</th>
											<th class="ff_col">참가현황</th>
										</tr>
									</thead>

									<tbody class="bodypart">
									
									</tbody>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		

		
	</div>
	<jsp:include page="/WEB-INF/view/include/section.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
	<!-- .site-wrap -->

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/jquery.countdown.min.js"></script>
	<script src="js/bootstrap-datepicker.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.fancybox.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.mb.YTPlayer.min.js"></script>


	<script src="js/main.js"></script>
	<script src="js/html2canvas.js"></script>
</body>
</html>