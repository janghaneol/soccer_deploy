<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>

<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

<style>
html, body {
	position: relative;
	height: 100%;
}

body {
	background: #eee;
	font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
	font-size: 14px;
	color: #000;
	margin: 0;
	padding: 0;
}

.swiper {
	width: 50%;
	height: 50%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

img {
	margin: 0 auto;
	display: block;
	
}
</style>

<a href="https://colorlib.com/wp/templates/"><img src="https://colorlib.com/wp/wp-content/uploads/sites/2/colorlib-push-logo.png" alt="Colorlib logo"></a>
<h1 style="text-align:center;">Thank you for using our template!</h1>
<p style="text-align:center;">For more awesome templates please visit <strong><a href="https://colorlib.com/wp/templates/">Colorlib</a></strong>.</p>
<br>
<p style="text-align:center; color:red;"><strong>Copyright information for the template can't be altered/removed unless you purchase a license.</strong>

<p style="text-align:center;"><strong>Removing copyright information without the license will result in suspension of your hosting and/or domain name(s).</strong>

<p style="text-align:center;"><strong>More information about the license is available <a href="https://colorlib.com/wp/licence/">here</a></strong>.</p>

<p style="text-align:center;"><a style="text-align:center;" href="http://localhost:5000/">채팅접속 예시</a></p>

<!--주의1 : Visual Studio Code에서 서버를 동작시키고 들어갈것 !!  -->
<!--주의2 : 우선 vsCode 파일이 자신의 환경에 알맞는 디렉토리로 표시되어 있는지 확인 후, 서버를 동작시킬것 !! -->



<div class="swiper mySwiper">
	<div class="swiper-wrapper">
		<div class="swiper-slide">
			<img src="https://placeimg.com/1000/1000/any">
		</div>
		<div class="swiper-slide">
			<img src="https://placeimg.com/1000/1000/any">
		</div>
		<div class="swiper-slide">
			<img src="https://placeimg.com/1000/1000/any">
		</div>
	</div>
	<div class="swiper-button-next"></div>
	<div class="swiper-button-prev"></div>
	<div class="swiper-pagination"></div>
</div>

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<script>
      var swiper = new Swiper(".mySwiper", {
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
          delay: 2500,
          disableOnInteraction: false,
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });

    </script>
</html>