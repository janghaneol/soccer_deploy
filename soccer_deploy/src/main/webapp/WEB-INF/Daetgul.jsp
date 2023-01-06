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

		<div class="hero overlay detail-view ">
            <div class="container">
                <div class="row align-items-center line_up_row test">
                    <div class="col-lg-12 detail">
                        <div class="detail-content">
                            <div class="detail-view-btn">
                                <div class="reg-div">
                                    <!-- jstl controller에서 이전 다음 주소 받는데 이거는 이전과 다음은 까다로우면 목록 버튼만 -->
                                    <a href="#" class="reg btn">이전</a>
                                    <a href="#" class="reg btn">다음</a>
                                    <a href="#" class="reg btn">목록</a>
                                </div>
                            </div>
                            <!-- 제목, 등록 날짜, 작성자 이름  jstl로 불러오기 -->
                            <div class="detail-view-header">
                                <h4>글 제목을 여기로</h4>
                                <div class="detail-info">
                                    <div class="profile">
                                        <p>작성자이름</p>
                                    </div>
                                    <div class="info">
                                        <p>작성날짜</p>
                                    </div>
                                </div>
                            </div>
                            <div class="detail-view-body">
                                <!-- 이미지, 내용  jstl로 불러오기 -->
                                <div class="img-div">
                                    <img src="./images/wew.PNG">
                                    <img src="./images/img_1.jpg">
                                    <img src="./images/img_1.jpg">
                                    <img src="./images/img_1.jpg">
                                    <img src="./images/img_1.jpg">
                                </div>
                                <p>게시글 내용</p>
                            </div>

                            <div class="comment-div">
                                <div class="comment-title">
                                    <h5>댓글</h5>
                                </div>
                                <div>
                                    <ul class="comment-list" data-article="article_id 값">
                                        <!-- 일단  jstl로 grop_no(이거는 article 아이디)와 level_no(댓글 1로)가  같은것들 
                                        for문으로 다 출력 이중 포문하면 될 것 같음 첫번째 포문-->
                                        <li class="comment-list-comment" data-orderno="여기다가 댓글의 order_no 넣어주기">
                                            <div class="comment-list-name">
                                                name1
                                            </div>
                                            <div calss="comment-list-content">
                                                <span>댓글입니다.</span>
                                            </div>
                                            <div class="comment-list-info">
                                                <span>댓글 작성 날짜</span> <button type="button" class="write-reply">댓글달기</button>
                                            </div>
                                        </li>
                                        <!-- 여기서 이중 포문 마지막 부분 grop_no(이거는 article 아이디)
                                            와 level_no(대댓글은 2로 통일한다 치면)인것을 출력-->
                                        <li class="comment-list-comment-reply" data-orderno="여기다가 댓글의 order_no 넣어주기">
                                            <div class="comment-list-name reply">
                                                name2
                                            </div>
                                            <div calss="comment-list-content reply">
                                                <span><strong>name1(이거는 디비 고민)</strong>대댓글입니다.</span>
                                            </div>
                                            <div class="comment-list-info reply">
                                                <span>대댓글 작성 날짜</span> <button type="button" class="write-reply">대댓글달기</button>
                                            </div>
                                        </li>
                                        <%--여기는 없애도 되는데 나중에 controller랑 확인하면서 하는용 그냥 밑에 div class="comment-write랑 같은 부분임
                                        그리고 나중에 board.js에서 action하고 method만 고쳐주면 됨 --%>
                                        <div class="comment-write-reply">
                                            <div class="comment-writer"><strong>대댓글 쓰는사람 이름(로그인한 아이디 받기)</strong></div>
                                            <form action="#">
                                                <textarea id="comment" name="content"
                                                    placeholder="댓글을 입력하세요."></textarea>
                                                <div class="comment-reg">
                                                    <button type="submit" class="comment-reg-btn">등록</button>
                                                </div>
                                                <input type="hidden" name="articleId" value="article_id 값">
                                                <input type="hidden" name="writer" value="작성자 아이디" >
                                                <input type="hidden" name="groupNo" value="article_id와 같은 값">

                                                <!-- 밑에 levelNo는 필요없을 수 있음 대댓글은 2로 고정 시키면 필요없음-->
                                                <input type="hidden" name="levelNo" value="대댓글이면 2일거임 아마이거는 확인 필요">
                                                <input type="hidden" name="orderNo" value="댓글 순서를 가져와서 여기서">
                                            </form>
                                        </div>
                                    </ul>
                                </div>
                            </div>
                            <div class="comment-write">
                                <div class="comment-writer"><strong>댓글 쓰는사람 이름(로그인한 아이디 받기)</strong></div>
                                <form action="#">
                                    <textarea name="comment" id="comment" name="content"
                                        placeholder="댓글을 입력하세요."></textarea>
                                    <div class="comment-reg">
                                        <button type="submit" class="comment-reg-btn">등록</button>
                                    </div>
                                    <input type="hidden" name="articleId" value="article_id 값">
                                    <!-- 작성자 아이디 -->
                                    <input type="hidden" name="writer" value="test" id="myid">
                                    <input type="hidden" name="groupNo" value="article_id와 같은 값">

                                    <!-- 밑에 levelNo는 필요없을 수 있음 댓글은 1로 고정 시키면 필요없음-->
                                    <input type="hidden" name="levelNo" value="댓글이면 1일거임 아마이거는 확인 필요">
                                    <!-- 밑에 orderNo는 필요없을 수 있음 sql문에서 max(order_no)를 사용해서 가져올 수 있음-->
                                    <input type="hidden" name="orderNo" value="댓글 순서를 가져와서 여기서">
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div
            style="position: fixed; bottom: 10px; right: 10px;background-color: #ee1e46; border-radius: 5px; width: 60px; text-align: center;">
            <a href="#banner" style="padding: 5px 0px; border-radius: 5px; font-weight: bold; color: white;">TOP</a>
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