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
.wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
}

.content {
	border-radius: 30px;
	border-style: solid;
	border-color: rgb(224, 224, 224);
	padding-left: 5%;
	padding-right: 5%;
	padding-top: 2%;
	padding-bottom: 2%;
	text-align: center;
}
</style>

<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

	<!-- 여기까지가 기본구성.  -->
	<!-- 필요하면 지워도 되는데 책임은 못짐. -->

	<div class="wrapper">
                <div class="content">
                    <h3>회원 탈퇴</h3>
                    <form action="/user/${loginUser.id}/delete" method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <div style="text-align: center;">   
                        <label class="text-white">이메일 : &nbsp;${loginUser.email}</label>
                        <br>
                        <label class="text-white">비밀번호 재확인 : &nbsp;</label>
                        <input type="password" id="passwd" name="passwd"></input>
                         </div>
                        <div style="text-align: center;">
                            <button class="btn btn-primary" type="submit" onclick="delOk()">탈퇴</button>
                            <a href="/user/${loginUser.id}" class="btn btn-primary" style="margin-left: 20px;">취소</a>
                        </div>
                    </form>
                </div>
        
            </div>
                                    
                               
    <script>
        var msg = '${msg}';
        if(msg === 'pwError'){
            alert("비밀번호를 다시 확인하여주세요.");
        }

        function delOk(){
            if(!confirm('정말로 회원탈퇴하시겠습니까?')){
                return false;
            }
        }
       
    </script>


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