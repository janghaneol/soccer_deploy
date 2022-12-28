<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>schedule</title>

<link
	href="/https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/fonts/icomoon/style.css">
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/css/jquery-ui.css">
<link rel="stylesheet" href="/css/owl.carousel.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="/css/jquery.fancybox.min.css">

<link rel="stylesheet" href="/css/bootstrap-datepicker.css">

<link rel="stylesheet" href="/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="/css/aos.css">

<link rel="stylesheet" href="/css/style.css"> 
<!-- 달력 위젯  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />

</head>

<style>

/* --------------------- */
input[name='publeYear'] {
    text-align: center;
}


</style>


<body>
	
<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>


	<div class="hero overlay">
						<div class="container">
							<div class="row align-items-center line_up_row">
								<div class="col-lg-12">
									<h1></h1>
									<form method="post" action="/match/schedule">
									<%--<input type="hidden" id="writer" name="writer" value="${나중에 로그인한 아이디 입력하면 됨}" > --%>	
										<!-- 작성자 아이디 넘기기 -->
										<div class="write">
											<div>
												<input type="text" name="subject" class="form-control board-subject" placeholder="제목을 입력해주세요.">
												<!-- 제목 넘기기 -->
											</div>
										</div>
										<div class="write">
											<div>
												<textarea class="form-control board-content" name="content" placeholder="내용을 입력해주세요."></textarea>
												<!-- 내용 넘기기 -->
											</div>
										</div>
										<div class="calForm" style="display: flex; margin-top: 5%; margin-bottom: 5%;">
												<input name="publeYear" autocomplete="off" readonly="readonly">
												<label class="label-form" style="color: white; margin-left: 20px;">시간 : </label>
												<input name="time" style="margin-left: 10px;" type="time" autocomplete="off">
										</div>
										<div>
											<label for="file" class="label-file">
												<div class="file-upload">이미지 업로드</div>
											</label>
											<span id="filenames">선택된 파일 없음</span>
												<input type="file" id="file"  name="file" style="display:none;"  accept="image/*"/>
										</div>
										<div class="board-reg-btn">
											<button type="submit" class="btn btn-primary bt">등록</button>
											<a href="#" class="btn btn-primary">목록</a>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>




	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>

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
	<!-- 달력위젯을 사용하기위한 script -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	
	<script type="text/javascript">
	/* 달력 위젯 적용 */
	
	/* 설정 */
	const config = {
		dateFormat: 'y/mm/dd',
		showOn : "button",
		buttonText:"날짜 선택",
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    yearSuffix: '년',
        changeMonth: true,
        changeYear: true
	}
	
	$(function() {
		  $( "input[name='publeYear']" ).datepicker(config);
		});
	</script>
</body>
</html>