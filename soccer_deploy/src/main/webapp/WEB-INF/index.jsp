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
<link rel="stylesheet" href="/css/vshover.css">

</head>

<style>
#deploy {
	position: relative;
	display: flex;
	width: 1300px;
	height: 750px;
	margin-top: 8%;
	margin-bottom: 8%;
}

#deploy_one {
	width: 60%;
	height: 100%;
	margin-right: 2%;
	/* border-radius : 30px;
    border-style : solid;
    border-color : rgb(224,224,224); */
	padding: 1%;
}

#deploy_two {
	position: relative;
	display: flex;
	flex-direction: column;
	width: 20%;
	height: 100%;
	border-radius: 30px;
	border-style: solid;
	border-color: rgb(224, 224, 224);
	padding: 1%;
}

#deploy_two_one {
	width: 100%;
	height: 50%;
}

#deploy_two_two {
	width: 100%;
	height: 50%;
}

#to_center_footer {
	text-align: center;
}

#to_center_text {
	text-align: center;
}

#translateY1 {
	transform: translateY(78px);
}

#translateY2 {
	transform: translateY(270px);
}

#v{
	text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000;
}
</style>

<body>

		<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>


		<div class="hero overlay">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-12">
						<div class="widget-next-match">
							<div class="widget-title">
								<h3>Next Match</h3>
							</div>
							<div class="widget-body mb-3">
								<div class="widget-vs">
									<div class="d-flex align-items-center justify-content-around justify-content-between w-100">
										<div class="team-1 text-center">
											<img src="images/logo_1.png" alt="Image">
											<h3 id="v">My Team</h3>
										</div>
										<div>
											<span class="vs"><span>VS</span></span>
										</div>
										<div class="team-2 text-center">
											<img src="images/profile/${recentMatch.matchImgName}" alt="Image">
											<h3 id="v">${recentMatch.opteam}</h3>
										</div>
									</div>
								</div>
							</div>
   
							<div class="text-center widget-vs-contents mb-4">
								<h4 style="text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000;">경기 시간 / 장소</h4>
								<p class="mb-5">
									<fmt:formatDate var="time" value="${recentMatch.matchDate}" pattern="yy/MM/dd HH:mm" />
									<span class="d-block" id="v">${time}</span> 
									<a href="" onClick="window.open('/findRoad/${recentMatch.id}','','width=700,height=500');return false"><span class="d-block" id="v">${recentMatch.matchPlace}</span></a>
								</p>
									<c:choose>
										<c:when test="${entry == false}">
											<a href="/match/enrollment?matchId=${recentMatch.id}" class="btn btn-primary">참가신청</a>
										</c:when>
										
										<c:otherwise>
											<a href="/match/cancel?matchId=${recentMatch.id}" class="btn btn-primary">참가취소</a>
										</c:otherwise>
									</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>







	<!-- 여기까지가 기본구성.  -->
	<!-- 필요하면 지워도 되는데 책임은 못짐. -->

	<div class="container">

		<div id="deploy">

			<div id="deploy_one">


				<c:forEach var="item" items="${resultMatch}" varStatus="status">

					<c:choose>
						<c:when test="${empty item.value}">
							<div id="translateY${status.index + 1}" class="tooltipCustom">
								<div class="container">
									<div class="row">
										<div class="col-lg-12">

											<div class="d-flex team-vs ">

												<div class="team-1 w-50">
													<div class="team-details w-100 text-center">
														<img src="images/profile/basic.png" alt="Image" class="img-fluid">
														<h3>기록없음</h3>

													</div>
												</div>
												<div class="team-2 w-50">
													<div class="team-details w-100 text-center">
														<img src="images/profile/basic.png" alt="Image" class="img-fluid">
														<h3>기록없음</h3>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>


							</div>

						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${status.index eq 0 }">
									<div id="translateY1" class="tooltipCustom">

										<span class="tooltiptext tooltip-left">
											<ul class="list-unstyled">
												<c:forEach var="player" items="${resultPlayer['first']}">
												
													<li>${player.name}(${player.backNum})</li>
												</c:forEach>
											</ul>
										</span>
										<div class="container">
											<div class="row">
												<div class="col-lg-12">

													<div class="d-flex team-vs ">
														<span class="score">${item.value.win }-${item.value.count - item.value.win}</span>
														<div class="team-1 w-50">
															<div class="team-details w-100 text-center">
																<img src="images/profile/logo_1.png" alt="Image"
																	class="img-fluid">
																<h3>
																	<c:choose>
																		<c:when
																			test="${item.value.win > (item.value.count - item.value.win)}">myTeam <span>(win)</span>
																		</c:when>
																		<c:when
																			test="${item.value.win < (item.value.count - item.value.win)}">myTeam <span>(loss)</span>
																		</c:when>
																		<c:otherwise>myTeam <span>(draw)</span>
																		</c:otherwise>
																	</c:choose>
																</h3>

															</div>
														</div>
														<div class="team-2 w-50">
															<div class="team-details w-100 text-center">
																<img src="images/profile/${item.value.matchImgName}" alt="Image"
																	class="img-fluid">
																<h3>
																	<c:choose>
																		<c:when
																			test="${item.value.win < (item.value.count - item.value.win)}">${item.value.opteam} <span>(win)</span>
																		</c:when>
																		<c:when
																			test="${item.value.win > (item.value.count - item.value.win)}">${item.value.opteam} <span>(loss)</span>
																		</c:when>
																		<c:otherwise>${item.value.opteam} <span>(draw)</span>
																		</c:otherwise>
																	</c:choose>
																</h3>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>


									</div>
								</c:when>
								<c:otherwise>
									<div id="translateY2" class="tooltipCustom">

										<span class="tooltiptext tooltip-left">
											<ul class="list-unstyled">
												<c:forEach var="player" items="${resultPlayer['second']}">
													<li>${player.name}(${player.backNum})</li>
												</c:forEach>
											</ul>
										</span>
										<div class="container">
											<div class="row">
												<div class="col-lg-12">

													<div class="d-flex team-vs ">
														<span class="score">${item.value.win }-${item.value.count - item.value.win}</span>
														<div class="team-1 w-50">
															<div class="team-details w-100 text-center">
																<img src="images/profile/logo_1.png" alt="Image"
																	class="img-fluid">
																<h3>
																	<c:choose>
																		<c:when
																			test="${item.value.win > (item.value.count - item.value.win)}">myTeam <span>(win)</span>
																		</c:when>
																		<c:when
																			test="${item.value.win < (item.value.count - item.value.win)}">myTeam <span>(loss)</span>
																		</c:when>
																		<c:otherwise>myTeam <span>(draw)</span>
																		</c:otherwise>
																	</c:choose>
																</h3>

															</div>
														</div>
														<div class="team-2 w-50">
															<div class="team-details w-100 text-center">
																<img src="images/profile/${item.value.matchImgName}" alt="Image"
																	class="img-fluid">
																<h3>

																	<c:choose>
																		<c:when
																			test="${item.value.win < (item.value.count - item.value.win)}">${item.value.opteam} <span>(win)</span>
																		</c:when>
																		<c:when
																			test="${item.value.win > (item.value.count - item.value.win)}">${item.value.opteam} <span>(loss)</span>
																		</c:when>
																		<c:otherwise>${item.value.opteam} <span>(draw)</span>
																		</c:otherwise>
																	</c:choose>
																</h3>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>


									</div>
								</c:otherwise>
							</c:choose>
						</c:otherwise>

					</c:choose>


				</c:forEach>


				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->

				<%-- <div id="deploy_one">
    
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-12">
						<h1 class="text-white" align="center">Players</h1>
							
							<table class="table custom-table">
						<thead>
							<tr>
								<th>Player</th>
								<th>Position</th>
								<th>Goal</th>
								<th>Assist</th>
								<th>Matches</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="data" items="${컨트롤러에서 넘어옴}">
							
							<tr>데이터 받는 곳 주석으로 표시 해놨음. (데이터 사이 간격은 흰 줄로 표시됨.)
								<td><strong class="text-white">${data.데이터받는곳}</strong></td>
								<td class="text-white">${data.데이터받는곳}</td>
								<td class="text-white">${data.데이터받는곳}</td>
								<td class="text-white">${data.데이터받는곳}</td>
								<td class="text-white">${data.데이터받는곳}</td>
							</tr>
							
							</c:forEach>
						</tbody>

					</table>
					</div>
				</div>
			</div>
	
    
    </div> --%>


				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
				<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->



			</div>

			<div id="deploy_two">

				<div id="deploy_two_one">

					<div id="to_center_text">
						<h1 class="text-white" align="center">Login</h1>

						<br>
						<c:choose>
							<c:when test="${loginUser == null}">
								<div class="form-group">
									<a href="/user/login"><button
											class="btn btn-primary py-3 px-5">Go To Login</button></a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="form-group">
									<a href=""><button class="btn btn-primary py-3 px-5">${loginUser.name}님</button></a>
									<br> <a href="/user/logout"><button
											class="btn btn-primary py-3 px-5">Logout</button></a>
								</div>
							</c:otherwise>
						</c:choose>
					</div>

				</div>


				<script type="text/javascript">
					var newName, n = 0;
					function newWindow(value) {
						n = n + 1;
						newName = value + n;
					}

					function MyOpenWindow() {
						newWindow("MyWindow");
						window
								.open('http://localhost:5000/', newName,
										"width=1050,height=800,toolbar=no,location=no,status=no,"
												+

												"menubar=no,scrollbars=yes,resizable=yes,left=200,top=50");
					}
				</script>


				<div id="deploy_two_two">

					<div id="to_center_text">
						<h1 class="text-white" align="center">Chatting</h1>
						<br>
						<div class="form-group">
							<a href="#none" onclick="MyOpenWindow()"><button
									class="btn btn-primary py-3 px-5">Go To Chatting</button></a>
						</div>

					</div>

				</div>


			</div>
		</div>

		<!-- <div class="row justify-content-center">
        <div class="col-lg-7 text-center">
          <div class="custom-pagination">
            <a href="#">1</a>
            <span>2</span>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">7</a>
            <a href="#">8</a>
            <a href="#">9</a>
            <a href="#">10</a>
          </div>
        </div>
     </div> -->

		<!-- 버튼(페이징) -->



	</div>


	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>

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


</body>
</html>