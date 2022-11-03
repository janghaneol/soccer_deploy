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
#deploy{
    position : relative;
    display :flex;
 	
    width:100%;
    height:50%;
}
#deploy_one{
    width:25%;
    height:100%;
    margin :2%;
    
    border-radius : 30px;
    border-style : solid;
    border-color : rgb(224,224,224);
    
    padding :1%;
}
#deploy_two{
    width:55%;
    height:100%;
    margin :2%;
    
    border-radius : 30px;
    border-style : solid;
    border-color : rgb(224,224,224);
    
    padding :1%;
}
#deploy_three{
    width:20%;
    height:100%;
	margin :2%;
	
	border-radius : 30px;
    border-style : solid;
    border-color : rgb(224,224,224);
    
    padding :1%;
}
#to_center_footer{
	
	text-align : center;
}

</style>

<body>

	<div class="site-wrap">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>


		<header class="site-navbar py-4" role="banner">

			<div class="container">
				<div class="d-flex align-items-center">
					<div class="site-logo">
						<a href="index"> <img src="images/logo.png" alt="Logo">
						</a>
					</div>
					<div class="ml-auto">
						<nav class="site-navigation position-relative text-right"
							role="navigation">
							<ul
								class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
								<li class="active"><a href="index" class="nav-link">Home</a></li>
								<li><a href="matches" class="nav-link">Matches</a></li>
								<li><a href="players" class="nav-link">Players</a></li>
								<li><a href="blog" class="nav-link">Blog</a></li>
								<li><a href="contact" class="nav-link">Contact</a></li>
							</ul>
						</nav>

						<a href="#"
							class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black float-right text-white"><span
							class="icon-menu h3 text-white"></span></a>
					</div>
				</div>
			</div>

		</header>

		<div class="hero overlay"
			style="background-image: url('images/bg_3.jpg');">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-5 ml-auto">
						<h1 class="text-white">World Cup Event</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Soluta, molestias repudiandae pariatur.</p>
						<div id="date-countdown"></div>
						<p>
							<a href="#" class="btn btn-primary py-3 px-4 mr-3">Book
								Ticket</a> <a href="#" class="more light">Learn More</a>
						</p>
					</div>
				</div>
			</div>
		</div>

	</div>





	<!-- 여기까지가 기본구성.  -->
	<!-- 필요하면 지워도 되는데 책임은 못짐. -->
<div class="container">
	
	<div id="deploy">
    <div id="deploy_one"> <jsp:include page="chat_front.jsp"/> </div>
    <div id="deploy_two">공지글, 경기일정글</div>
    <div id="deploy_three">로그인</div>
	</div>
	
</div>


	<footer class="footer-section">
		<div class="container">
		<div id="to_center_footer">
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