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
	width: 1700px;
	height: 750px;
	padding: 4%;
	padding-left: 16%;
	padding-top : 8%;
}

#deploy {
	position: relative;
	display: flex;
	width: 100%;
	height: 100%;
}

#deploy_one {
	width: 10%;
	height: 100%;
	margin: 2%;
	padding: 1%;
}

#deploy_two {
	width: 80%;
	height: 100%;
	border-radius: 30px;
	border-style: solid;
	border-color: rgb(224, 224, 224);
	padding-left: 5%;
}

#deploy_three {
	width: 10%;
	height: 100%;
	margin: 2%;
	padding: 1%;
}

#image1 {
	width: 300px;
	height: 400px;
}

#deploy_two_In {
	positon: relative;
	display: flex;
	flex-directory: column;
	width: 100%;
	height: 100%;
}

#deploy_two_In_one {
	width: 60%;
	height: 100%;
}

#deploy_two_In_two {
    width: 40%;
    height: 100%;
    padding-left: 5%;
    padding-bottom: 5%;
}

#to_center_footer {
	text-align: center;
}
.field-error {
  color: #ff0000;
}
.thead{
    text-align: center;
}
.th{
    display: table-cell;
    font-weight: bold;
    text-align: left;
}
</style>

<body>

<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

	<!-- 여기까지가 기본구성.  -->
	<!-- 필요하면 지워도 되는데 책임은 못짐. -->

	<div id="zero">

		<div id="deploy">
		
			<div id="deploy_two">

				<div class="site-section">
					<div class="container">
						<div id="deploy_two_In">
							<div id="deploy_two_In_one">
								<h3 class="mb-3">회원 정보</h3>
								<table class="table table-sm">
								
								<thead class="thead-dark">
										<tr>
                                            <th scope="col" colspan="2" >
                                                기본 정보
                                            </th>
                                        </tr>
								</thead>
                                    <tbody>
                                        
                                        <tr class="text-white">
                                            <th scope="row"><strong>이메일</strong></th>
                                            <td>${user.email}</td>
                                        </tr>

                                        <tr class="text-white">
                                            <th scope="row">나이</th>
                                            <td>${user.age}</td>
                                        </tr>
                                        
										<tr class="text-white">
                                            <th scope="row">이름</th>
                                            <td>${user.name}</td>
                                        </tr>
                                        
                                        <tr class="text-white">
                                            <th scope="row">등번호</th>
                                            <td>${user.backNum}</td>
                                        </tr>
                                        
                                        <tr class="text-white">
                                            <th scope="row">포지션</th>
                                            <td>${user.position}</td>
                                        </tr>
                                        
                                        <tr class="text-white">
                                            <th scope="row">주소</th>
                                            <td>${user.address}</td>
                                        </tr>
                                        
                                        <tr class="text-white">
                                            <th scope="row">가입일</th>
                                            <td>${user.regdate}</td>
                                        </tr>
                                    </tbody>

                                </table>
                                <c:if test="${loginUser.id == user.id}">
                                <div class="logButton" style="display: inline;">
                                	<a href="/user/${loginUser.id}/checkpw" class="btn btn-primary">회원정보수정</a>
                                	<a href="/user/${loginUser.id}/delete" class="btn btn-primary" style="margin-left: 10px;">회원탈퇴</a>
                                </div>
                                </c:if>
						</div>
						<div id="deploy_two_In_two">
						<img src="/title2.png" id="image1">
					</div>
					</div>
					
				</div>
			</div>
			<div id="deploy_three"></div>
		</div>

	</div>
</div>

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