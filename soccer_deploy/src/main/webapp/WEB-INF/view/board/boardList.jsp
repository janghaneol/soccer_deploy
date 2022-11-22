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
	<link rel="stylesheet" href="css/board.css">


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

<body>
	
		<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

		<div class="hero overlay" >
            <div class="container">
                <div class="row align-items-center line_up_row">
                    <div class="col-lg-12 board-list">
                        <h1 class="board-category">공지사항 or 자유게시글</h1>
                        <div class="board-btn">
                            <div class="search-bar">
                                <input type="text" class="searchval">
                                <button type="button" class="search"></button>
                            </div>
                            <div class="reg-div">
                                <a  class="reg btn" href="/reg">등록</a>
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
                                <tr>
                                    <td><a href="#">제목1</a></td>
                                    <td>작성자이름1</td>
                                    <td>작성일1</td>
                                    <td>조회수1</td>
                                </tr>
                                <tr><td><a href="#">제목2</a></td>
                                    <td>작성자이름2</td>
                                    <td>작성일2</td>
                                    <td>조회수2</td></tr>
                                <tr>
                                    <td><a href="#">제목3</a></td>
                                    <td>작성자이름3</td>
                                    <td>작성일3</td>
                                    <td>조회수3</td>
                                </tr>
                                <tr>
                                    <td><a href="#">제목4</a></td>
                                    <td>작성자이름4</td>
                                    <td>작성일4</td>
                                    <td>조회수3</td>
                                </tr>
                                <tr>
                                    <td><a href="#">제목5</a></td>
                                    <td>작성자이름5</td>
                                    <td>작성일5</td>
                                    <td>조회수3</td>
                                </tr>
                                <tr>    
                                    <td><a href="#">제목6</a></td>
                                    <td>작성자이름6</td>
                                    <td>작성일6</td>
                                    <td>조회수6</td>
                                </tr>
                                <tr>
                                    <td><a href="#">제목7</a></td>
                                    <td>작성자이름7</td>
                                    <td>작성일7</td>
                                    <td>조회수7</td>
                                </tr>
                                <tr>
                                    <td><a href="#">제목8</a></td>
                                    <td>작성자이름8</td>
                                    <td>작성일8</td>
                                    <td>조회수8</td>
                                </tr>
                                <tr>
                                    <td><a href="#">제목9</a></td>
                                    <td>작성자이름9</td>
                                    <td>작성일9</td>
                                    <td>조회수9</td>
                                </tr>
                                <tr>
                                    <td><a href="#">제목10</a></td>
                                    <td>작성자이름10</td>
                                    <td>작성일10</td>
                                    <td>조회수10</td>
                                </tr>
                                <!-- jstl 필요한 끝 부분 for문 -->
                            </tbody>
                        </table>

                        <div class="text-center paginationpart">
                            <ul class="pagination">
                                <!-- jstl 필요한 시작 부분 선생님 페이지처리 참고 -->
                                <li><a href="#">«</a></li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">»</a></li>
                                <!-- jstl 필요한 끝 부분 선생님 페이지처리 참고 -->
                            </ul>
                        </div>
                    </div>


                </div>
            </div>
        </div>

		

		<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
	<!-- .site-wrap -->

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