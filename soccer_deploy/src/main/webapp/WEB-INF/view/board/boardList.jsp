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
					<h1 class="board-category">
					<c:choose>
						<c:when test="${boardId eq 10 }">
							자유게시판
						</c:when>
						<c:when test="${boardId eq 20 }">
							공지사항
						</c:when>
					</c:choose>
					</h1>
					<div class="board-btn">
						<form
							action="${requestScope['javax.servlet.forward.servlet_path']}"
							method="get">
							<div class="search-bar">
								<input type="text" name="searchValue" class="searchval">
								<button type="submit" class="search"></button>
							</div>
						</form>
						<div class="reg-div">
							<a class="reg btn"
								href="${requestScope['javax.servlet.forward.servlet_path']}/write">등록</a>
						</div>
					</div>

					<table class="table custom-table board">

						<thead>
							<tr>
								<th class="title">제목</th>
								<th class="author">작성자</th>
								<th class="regdate">작성일</th>
								<th class="view">조회</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<!-- jstl 필요한 시작 부분 for문 -->
							<c:if test="${!empty pageResults }">
								<c:forEach var="article" items="${pageResults.content}">
									<tr>
										<c:if test="${!empty param.searchValue }">
											<td><a href="./article/${article.articleId}?searchValue=${param.searchValue}">${article.subject}</a></td>
										</c:if>
										<c:if test="${empty param.searchValue }">
										<td><a href="./article/${article.articleId}">${article.subject}</a></td>
										</c:if>
										<td>${article.writer}</td>
						
										<fmt:formatDate var="set" value="${article.regdate}"
											pattern="yy/MM/dd HH:mm" />
										<td>${set}</td>
										<td>${article.hitcount}</td>
									</tr>
								</c:forEach>
							</c:if>

							<!-- jstl 필요한 끝 부분 for문 -->
						</tbody>
					</table>

					<c:if test="${empty pageResults}">
						<div class="no-article">
							<span>글을 등록해주세요</span>
						</div>
					</c:if>

					<div class="text-center paginationpart">
						<ul class="pagination">
							<c:choose>
								<c:when test="${empty param.searchValue }">
									<c:choose>
										<c:when test="${pageResults.hasPrevious()}">
											<li><a href="?page=${pageResults.number -1  } "><<</a></li>
										</c:when>
										<c:otherwise>
											<li><a><<</a></li>
										</c:otherwise>
									</c:choose>
									<!-- 0부터 시작하므로 end < 0 으로 나온다 따라서 이렇게 해준다. -->
									<c:if test="${endPage > -1 }">
										<c:forEach begin="${startPage}" end="${endPage }" step="1"
											varStatus="status">
											<li
												class=" ${ pageResults.number == status.index ? 'active' : ''}"><a
												href="?page=${status.index }">${status.index+1 }</a></li>
										</c:forEach>
									</c:if>

									<c:choose>
										<c:when test="${pageResults.hasNext()}">
											<li><a href="?page=${pageResults.number +1}">>></a></li>
										</c:when>
										<c:otherwise>
											<li><a>>></a></li>
										</c:otherwise>
									</c:choose>
								</c:when>

								<c:otherwise>
									<c:choose>
										<c:when test="${pageResults.hasPrevious()}">
											<li><a
												href="?searchValue=${param.searchValue }&page=${pageResults.number -1 } "><<</a></li>
										</c:when>
										<c:otherwise>
											<li><a><<</a></li>
										</c:otherwise>
									</c:choose>
									<c:if test="${endPage > -1 }">
										<c:forEach begin="${startPage}" end="${endPage }" step="1"
											varStatus="status">
											<li
												class=" ${ pageResults.number  == status.index ? 'active' : ''}"><a
												href="?searchValue=${param.searchValue }&page=${status.index }">${status.index+1 }</a></li>
										</c:forEach>
									</c:if>
									<c:choose>
										<c:when test="${pageResults.hasNext()}">
											<li><a
												href="?searchValue=${param.searchValue }&page=${pageResults.number +1}">>></a></li>
										</c:when>
										<c:otherwise>
											<li><a>>></a></li>
										</c:otherwise>
									</c:choose>
								</c:otherwise>


							</c:choose>
						</ul>
					</div>
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