<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertere</title>

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

</head>
<style>
#zero {
	position: relative;
	width: 100%;
	height: 100%;
	padding: 10%;
	padding-left: 10%;
	padding-right: 10%;
	padding-bottom: 10%;
}

#deploy {
	position: relative;
	display: flex;
	width: 100%;
	height: 100%;
}

#deploy_two {
	width: 100%;
	height: 100%;
	border-radius: 30px;
	border-style: solid;
	border-color: rgb(224, 224, 224);
	padding-left: 5%;
	padding-right: 5%;
	padding-bottom: 5%;
}

#to_center_footer {
	text-align: center;
}

.bir_yy, .bir_mm, .bir_dd {
	width: 160px;
	display: table-cell;
}

.bir_mm+.bir_dd, .bir_yy+.bir_mm {
	padding-left: 10px;
}

.container.py-4 {
	margin: 0 auto;
	width: 503px;
}

.d-grid.gap-2 {
	padding-top: 30px;
}

.bg {
	height: 1053px;
	padding-top: 55px;
	padding-bottom: 75px;
}

.flex-fill.mx-xl-5.mb-2 {
	margin: 0 auto;
	width: 700px;
	padding-right: 7rem;
	padding-left: 7rem;
}

.container.py-4 {
	margin: 0 auto;
	width: 503px;
}

.d-grid.gap-2 {
	padding-top: 30px;
}
</style>
<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

	<section class="bg">
		<div class="container py-4">
				<div id="deploy_two">
					<form>
							<div class="form-group">
									<label for="exampleInputEmail1" class="form-label mt-4">이메일</label>
									<input type="text" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp">
							</div>
							<div class="form-group has-success">
									<label class="form-label mt-4" for="inputValid">비밀번호</label> <input
											type="password" class="form-control is-valid" id="inputValid">
									<div class="valid-feedback"></div>
							</div>

							<div class="form-group has-danger">
							<label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label>
							<input type="password" class="form-control is-invalid"
								id="inputInvalid">
							<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1" class="form-label mt-4">이름</label>
							<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp">
						</div>
						<div class="bir_wrap">
							<label class="form-label mt-4">생년월일</label>
							<div class="bir_yy">
								<span class="ps_box"> <input type="text"
									class="form-control" id="yy" placeholder="년(4자)" maxlength="4">
								</span>
							</div>
							<div class="bir_mm">
								<span class="ps_box"> <input type="text"
									class="form-control" id="mm" placeholder="월" maxlength="2">
								</span>
							</div>
							<div class="bir_dd">
								<span class="ps_box"> <input type="text"
									class="form-control" id="dd" placeholder="일" maxlength="2">
								</span>
							</div>
						</div>
						<div class="form-group">
						<label for="exampleSelect1" class="form-label mt-4">성별</label> 
						<select	class="form-select" id="exampleSelect1" style="width: 160px;">
								<option>남자</option>
								<option>여자</option>
							</select>
						</div>
						
						
						<div class="d-grid gap-2">
								<button class="btn btn-primary btn-lg" type="button">가입하기</button>
						</div>
						
				</form>
				
				
				</div>
			</div>
	</section>












	<footer class="footer-section">
		<div class="container">
			<div id="to_center_footer">
				<div class="row">
					<div class="col-lg-3">
						<div class="widget mb-3">
							<h3>News</h3>
							<ul class="list-unstyled links">
								<li><a href="#">All</a></li>
								<li><a href="#">Club News</a></li>
								<li><a href="#">Media Center</a></li>
								<li><a href="#">Video</a></li>
								<li><a href="#">RSS</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="widget mb-3">
							<h3>Tickets</h3>
							<ul class="list-unstyled links">
								<li><a href="#">Online Ticket</a></li>
								<li><a href="#">Payment and Prices</a></li>
								<li><a href="#">Contact &amp; Booking</a></li>
								<li><a href="#">Tickets</a></li>
								<li><a href="#">Coupon</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="widget mb-3">
							<h3>Matches</h3>
							<ul class="list-unstyled links">
								<li><a href="#">Standings</a></li>
								<li><a href="#">World Cup</a></li>
								<li><a href="#">La Lega</a></li>
								<li><a href="#">Hyper Cup</a></li>
								<li><a href="#">World League</a></li>
							</ul>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="widget mb-3">
							<h3>Social</h3>
							<ul class="list-unstyled links">
								<li><a href="#">Twitter</a></li>
								<li><a href="#">Facebook</a></li>
								<li><a href="#">Instagram</a></li>
								<li><a href="#">Youtube</a></li>
							</ul>
						</div>
					</div>

				</div>

				<div class="row text-center">
					<div class="col-md-12">
						<div class=" pt-5">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="icon-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
					</div>

				</div>
			</div>
		</div>
	</footer>




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