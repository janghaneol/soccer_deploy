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
<script defer src="/js/imgReg.js"></script>
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
				<div class="col-lg-12" style="width: 50%; border: solid; border-radius: 30px; color: white; padding: 5%; margin-top: 130px;">
					<h1>글쓰기</h1>
					<form method="post"
						action="${requestScope['javax.servlet.forward.servlet_path']}"
						enctype="multipart/form-data">
						<%--<input type="hidden" id="writer" name="writer" value="${나중에 로그인한 아이디 입력하면 됨}" > --%>
						<!-- 작성자 아이디 넘기기 -->
						<div class="write">
							<div>
								<input type="text" name="subject"
									class="form-control board-subject" placeholder="제목을 입력해주세요.">
								<!-- 제목 넘기기 -->
							</div>
						</div>
						<div class="write">
							<div>
								<textarea class="form-control board-content" name="content"
									placeholder="내용을 입력해주세요."></textarea>
								<!-- 내용 넘기기 -->
							</div>
						</div>
						<div>
							<label for="file" class="label-file">
								<div class="file-upload">이미지 업로드</div>
							</label> <span id="filenames">선택된 파일 없음</span> <input type="file"
								id="file" name="uploadFiles" style="display: none;"
								accept="image/*" multiple="multiple" />
						</div>
						<div class="board-reg-btn">
							<button type="submit" class="btn btn-primary bt">등록</button>
							<c:choose>
								<c:when test="${empty param.searchValue}">
									<a href="/board/${boardId}/article"
										class="btn btn-primary">목록</a>
								</c:when>
								<c:otherwise>
									<a
										href="/board/${boardId}/article?searchValue=${param.searchValue}"
										class="btn btn-primary">목록</a>
								</c:otherwise>
							</c:choose>

						</div>
						<%-- <input type="hidden" name="writer" value="alsk2@ac.kr"> 임시--%>
						<input type="hidden" name="writer" value="${loginUser.email}">
						 <input
							type="hidden" name="boardId" value="${boardId}"> <input
							type="hidden" name="levelNo" value=0> <input
							type="hidden" name="orderNo" value=0>

					</form>
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