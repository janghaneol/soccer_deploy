<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script defer src="/js/boardview.js"></script>
<link rel="stylesheet" href="/css/style.css">
</head>

<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

	<div class="herol overlay detail-view ">
		<div class="container">
			<div class="row align-items-center line_up_row test">
				<div class="col-lg-12 detail">
					<div class="detail-content">
						<c:forEach var="article" items="${articles}" begin="0" end="0"
							varStatus="status">

							<div class="detail-view-btn">
								<div class="reg-div">
									<!-- jstl controller에서 이전 다음 주소 받는데 이거는 이전과 다음은 까다로우면 목록 버튼만 -->
									<c:choose>
										<c:when test="${empty param.searchValue}">
											<c:if test="${bool}">
												<c:if test="${!empty prevNext[0].prev}">
													<a
														href="/board/${article.boardId}/article/${prevNext[0].prev}"
														class="reg btn">이전</a>
												</c:if>
												<c:if test="${!empty prevNext[0].next}">
													<a
														href="/board/${article.boardId}/article/${prevNext[0].next}"
														class="reg btn">다음</a>
												</c:if>
											</c:if>
											<c:if test="${!bool}">
												<c:if test="${!empty prevNext[0].prev}">
													<a
														href="/board/${article.boardId}/article/${prevNext[0].prev}"
														class="reg btn">이전</a>
												</c:if>
												<c:if test="${!empty prevNext[1].next}">
													<a
														href="/board/${article.boardId}/article/${prevNext[1].next}"
														class="reg btn">다음</a>
												</c:if>
											</c:if>
											<a href="/board/${article.boardId}/article" class="reg btn">목록</a>
										</c:when>
										<c:otherwise>
											<c:if test="${bool}">
												<c:if test="${!empty prevNext[0].prev}">
													<a
														href="/board/${article.boardId}/article/${prevNext[0].prev}?searchValue=${param.searchValue}"
														class="reg btn">이전</a>
												</c:if>
												<c:if test="${!empty prevNext[0].next}">
													<a
														href="/board/${article.boardId}/article/${prevNext[0].next}?searchValue=${param.searchValue}"
														class="reg btn">다음</a>
												</c:if>
											</c:if>
											<c:if test="${!bool}">
												<c:if test="${!empty prevNext[0].prev}">
													<a
														href="/board/${article.boardId}/article/${prevNext[0].prev}?searchValue=${param.searchValue}"
														class="reg btn">이전</a>
												</c:if>
												<c:if test="${!empty prevNext[1].next}">
													<a
														href="/board/${article.boardId}/article/${prevNext[1].next}?searchValue=${param.searchValue}"
														class="reg btn">다음</a>
												</c:if>
											</c:if>
											<a
												href="/board/${article.boardId}/article?searchValue=${param.searchValue}"
												class="reg btn">목록</a>
										</c:otherwise>
									</c:choose>


								</div>
							</div>
							<!-- 제목, 등록 날짜, 작성자 이름  jstl로 불러오기 -->
							<div class="detail-view-header">
								<h4>${article.subject}</h4>
								<div class="detail-info">
									<div class="profile">
										<p>${article.writer}</p>
									</div>
									<div class="info">
										<fmt:formatDate var="set" value="${article.regdate}"
											pattern="yy/MM/dd HH:mm" />
										<p>${set}</p>
									</div>
								</div>
							</div>
							<div class="detail-view-body">
								<!-- 이미지, 내용  jstl로 불러오기 -->
								<c:if test="${!empty images}">
									<div class="img-div">
										<c:forEach var="image" items="${images}">
											<img src="/image/${image.imgFileName}">
										</c:forEach>
									</div>
								</c:if>
								<p>${article.content}</p>
							</div>

						</c:forEach>


						<div class="comment-div">
							<div class="comment-title">
								<h5>댓글</h5>

							</div>
							<div>
								<ul class="comment-list"
									data-article="${articles[0].articleId }">
									<!-- 일단  jstl로 grop_no(이거는 article 아이디)와 level_no(댓글 1로)가  같은것들 
                                        for문으로 다 출력 이중 포문하면 될 것 같음 첫번째 포문-->

									<c:if test="${!empty articles[1]}">
										<c:forEach var="article" items="${articles}" begin="1"
											step="1">

											<c:choose>
												<c:when test="${article.levelNo eq 1 }">
													<li class="comment-list-comment"
														data-orderno="${article.orderNo}">
														<div class="comment-list-name">${article.writer}</div>
														<div class="comment-list-content">
															<span>${article.content}</span>
														</div>
														<div class="comment-list-info">
															<fmt:formatDate var="set" value="${article.regdate}"
																pattern="yy/MM/dd HH:mm" />
															<span>${set}</span>
															<button type="button" class="write-reply">댓글달기</button>
														</div>
													</li>
												</c:when>
												<c:otherwise>
													<li class="comment-list-comment-reply"
														data-orderno="${article.orderNo}">
														<div class="comment-list-name reply">${article.writer}</div>
														<div class="comment-list-content reply">
															<span>${article.content}</span>
														</div>
														<div class="comment-list-info reply">
															<fmt:formatDate var="set" value="${article.regdate}"
																pattern="yy/MM/dd HH:mm" />
															<span>${set}</span>
															<button type="button" class="write-reply">대댓글달기</button>
														</div>
													</li>

												</c:otherwise>
											</c:choose>
										</c:forEach>

									</c:if>

									<%--여기는 없애도 되는데 나중에 controller랑 확인하면서 하는용 그냥 밑에 div class="comment-write랑 같은 부분임
                                        그리고 나중에 board.js에서 action하고 method만 고쳐주면 됨 --%>

								</ul>
							</div>
						</div>
						<div class="comment-write">
							<div class="comment-writer">
								<strong>${loginUser.email}</strong>
								
								<%--<strong>alsk2@ac.kr</strong> --%>
							</div>
							<c:if test="${empty param.searchValue }">
								<form
									action="${requestScope['javax.servlet.forward.servlet_path']}/dat"
									method="post">
							</c:if>
							<c:if test="${!empty param.searchValue }">
								<form
									action="${requestScope['javax.servlet.forward.servlet_path']}/dat?searchValue=${param.searchValue}"
									method="post">
							</c:if>
							<textarea id="comment" name="content" placeholder="댓글을 입력하세요."></textarea>
							<div class="comment-reg">
								<button type="submit" class="comment-reg-btn">등록</button>
							</div>

							<!-- 작성자 아이디 -->
							<%--<input type="hidden" name="writer" value="alsk2@ac.kr" id="myid"> --%>
							
							<input type="hidden" name="writer" value="${loginUser.email}" id="myid">
							<input type="hidden" name="groupNo"
								value="${articles[0].articleId }">

							<!-- 밑에 levelNo는 필요없을 수 있음 댓글은 1로 고정 시키면 필요없음-->
							<input type="hidden" name="levelNo" value="1">
							<!-- 밑에 orderNo는 필요없을 수 있음 sql문에서 max(order_no)를 사용해서 가져올 수 있음-->
							<input type="hidden" name="orderNo"
								value="${articles[fn:length(articles)-1].orderNo + 1 }">
							<input type="hidden" name="subject" value="댓글">
							</form>
						</div>
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