<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertere</title>

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
    margin-bottom: 10%;
}

#to_center_footer {
	text-align: center;
}

.position, .backnum, .age {
	width: 120px;
	float:left;
}



.container.py-4 {
	margin: 0 auto;
	width: 503px;
}

.d-grid.gap-2 {
	padding-top: 30px;
}

.bg {
    padding-top: 10%;
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


.age, .backnum, .position {
	width: 130px;
	display: table-cell;
}
.backnum+.position, .age+.backnum {
	padding-left: 10px;
}



</style>
<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

	<section class="bg">
		<div class="container py-4">
			<div id="deploy_two">
			<!-- registForm Start -->
				<form:form modelAttribute="user" action="/user/regist" method="post" >
				<fieldset>
					<div>
						<label for="exampleInputEmail1" class="form-label mt-4">이메일</label>
						<form:input type="text" class="form-control" value="${user.email}" 
							aria-describedby="emailHelp" path="email" placeholder="이메일은 필수입력사항입니다."/>
					</div>
					
					
					<div>
						<label class="form-label mt-4" for="inputValid">비밀번호</label> 
						<form:input	type="password" class="form-control" id="inputValid" placeholder="영어와 숫자를 포함한 6~12자" path="passwd"/>
						<div class="valid-feedback"></div>
					</div>	
						
					<div>
						<label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label>
						<input type="password" class="form-control"	id="inputInvalid" placeholder="위의 칸과 같은 비밀번호를 입력해주세요."/>
					</div>

					<div>
						<label for="exampleInputEmail1" class="form-label mt-4">이름</label>
						<form:input type="text" value="${user.name}" class="form-control" placeholder="이름은 필수입력사항입니다." path="name" />
					</div>

					<div class="form">
						<div class="age">
							<label class="form-label mt-4">나이</label>
							<form:input type="text" class="form-control" placeholder="나이" maxlength="3" path="age"/>
						</div>
						<div class="backnum">
							<label class="form-label mt-4">등 번호</label>
							<form:input type="text" class="form-control" placeholder="최대 3자리" maxlength="3" path="backNum"/>
						</div>
						
						<div class="position">
							<label class="form-label mt-4">포지션</label>
							<form:select class="form-control" path="position">
							<option>FW</option>
							<option>MF</option>
							<option>DF</option>
							<option>GK</option>
							</form:select>
						</div>
					</div>
					 
					<div>
						<label for="exampleInputEmail1" class="form-label mt-4">주소</label>
						<form:input type="text" value="${user.address}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" path="address"/>
					</div>

					<div class="d-grid gap-2">
						<button class="btn btn-primary btn-lg" type="submit">가입하기</button>
					</div>
				</fieldset>
				</form:form>
				<!-- registForm End -->

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