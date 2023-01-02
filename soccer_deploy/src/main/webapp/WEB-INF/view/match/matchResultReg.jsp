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
<script defer type="module" src="/js/resultReg.js"></script>
</head>

<style>
/* --------------------- */
</style>

<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>



	<!---기본 메뉴--->
	<div class="hero overlay detail-view">
		<div class="container">
			<div class="row align-items-center line_up_row">
				<div class="col-lg-12 detail">
					<h1>글쓰기</h1>
					<form method="post" action="./result">
						<table class="table custom-table board">

							<thead>
								<tr>
									<th class="backNum">등번호</th>
									<th class="name">이름</th>
									<th class="goal">골</th>
									<th class="assist">어시스트</th>
									<th class="point">포인트</th>
								</tr>
							</thead>
							<tbody class="text-center">
								<c:forEach var="lineup" items="${sessionScope.lineup}"
									varStatus="status">
									<c:if test="${status.index % 11 eq 0 }">
										<tr>
										<fmt:parseNumber var="set" integerOnly="true" value="${status.index / 11 + 1 }"/>
											<td colspan="5">${set} set</td>
										</tr>
									</c:if>
									<tr class="input">
										<td>${lineup.backNum}</td>
										<td>${lineup.name}</td>
										<td><input type="text" 
											class="form-control board-subject" placeholder="골"
											value="${lineup.goal}" onfocus="this.select()" id="goal" name="LineUpList[${status.index}].goal"></td>
										<td><input type="text" 
											class="form-control board-subject" placeholder="어시스트"
											value="${lineup.assist}" onfocus="this.select()" id="assist" name="LineUpList[${status.index}].assist"></td>
										<td><input type="text"
											class="form-control board-subject" placeholder="포인트"
											readonly="readonly" value="${lineup.point}" id="point" name="LineUpList[${status.index}].point"></td>
									</tr>
									<input type="hidden" value="${lineup.quarter}" name="LineUpList[${status.index}].quarterId">
									<input type="hidden" value="${lineup.playerId}" name="LineUpList[${status.index}].entryId">
									

								</c:forEach>
							</tbody>
						</table>
						<table class="table custom-table board">
							<thead>
								<tr>
									<th class="backNum" colspan="4">set</th>
									<th class="name">승/패</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="quarter" items="${quarter}" varStatus="temp">
								
									<tr><td colspan="4">${temp.index+1}set</td><td><select name="QuarterList[${temp.index}].outcome" >
                                    <option value="1">승</option>
                                    <option value="0">패</option>
                                    <input type="hidden" name="QuarterList[${temp.index}].id" value="${quarter.id}">
                                    <input type="hidden" name="QuarterList[${temp.index}].matchId" value="${quarter.match.id}">
                                    <input type="hidden" name="QuarterList[${temp.index}].quarterTime" value="${quarter.quarterTime}">
                                    
                                </select></td></tr>
								</c:forEach>
									
							</tbody>
						</table>
						<div class="board-reg-btn">
							<button type="submit" class="btn btn-primary bt">등록</button>
							<c:choose>
								<c:when test="${fn:contains(redirect,'/match/result') }">
									<a href="${redirect}" class="btn btn-primary">목록</a>
								</c:when>
								<c:otherwise>
								<a href="/match/result" class="btn btn-primary">목록</a>
								</c:otherwise>
							</c:choose>
							
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>




	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
	</div>




	<script src="/js/viewDetail.js"></script>
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