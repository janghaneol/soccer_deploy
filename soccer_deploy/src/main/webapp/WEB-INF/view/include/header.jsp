<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.iText{
	width: 100px;
	height: 20px;
}

.z:after{
	display: inline-block;
    width: 1px;
    height: 15px;
    background: #ccc;
    vertical-align: middle;
    content: "";
    margin-left: 7px;
    margin-right: 7px;
}

#header{
	font-size: 12px;
}

#header:before {
    position: absolute;
    width: 100%;
    height: 30px;
    background: #f9f9f9;
    border-bottom: 1px solid #ddd;
    left: 0;
    top: 0;
    content: "";
    z-index: -1;
}
#header #logged_info {
    position: absolute;
    top: 2px;
    right: 21%;
}
.logButton{
	border-radius: revert;
}
#profileView{
	border-radius: 100%;
	width: 20px;
	height: 20px;
}
#profileView:hover{
	border: #F00 2px solid;
}
</style>

<div class="site-mobile-menu site-navbar-target">
	<div class="site-mobile-menu-header">
		<div class="site-mobile-menu-close">
			<span class="icon-close2 js-menu-toggle"></span>
		</div>
	</div>
	<div class="site-mobile-menu-body"></div>
</div>


<header class="site-navbar py-4" role="banner" id="header">
	<div class="container">
			<div class="d-flex align-items-center" id="logged_info">
			<c:choose>
				<c:when test="${loginUser==null}">
				<form:form modelAttribute="loginForm" action="/user/login" method="post">
					<input class="iText" type="text" name="email" value="" placeholder="이메일"> 
					<input class="iText" type="password" name="passwd" value="" placeholder="비밀번호">
				    <span class="keep"> <input name="keep_signed" type="checkbox" id="keepA" value="Y"><label for="keepA">자동 로그인</label></span>
					<button type="submit" class="logButton">로그인</button>
					<a href="/user/regist"><input type="button" value="회원가입"></a>
				</form:form>
				</c:when>
				<c:otherwise>
					<span class="z"><img src="/images/profile/${loginUser.imgFileName}" id="profileView"></span>
					<span class="z"><strong>${loginUser.name}님!</strong></span>
					<span class="z"><a href="/user/${loginUser.id}">내 정보</a></span>
					<a href="/user/logout"><input type="button" value="로그아웃"></a>
				</c:otherwise>
			</c:choose>
			</div>
		<br>
	
		<div class="d-flex align-items-center">
			<div class="site-logo">
				<a href="index"> <img src="/images/logo.png" alt="Logo">
				</a>
			</div>

			<div class="ml-auto">
				<nav class="site-navigation position-relative text-right"
					role="navigation">
					<ul
						class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
						<li><a href="/xMain" class="nav-link">Home</a></li>
						<li><a href="matches" class="nav-link">Matches</a></li>
						<li><a href="/user/list" class="nav-link">Players</a></li>
						<li><a href="mainPage" class="nav-link">MainPage</a></li>
						<li class="dropdown"><a href="/realBoard" class="dropdown-toggle "
						data-toggle="dropdown">Board & Notice<b class="caret"></b></a>
						<ul class="dropdown-menu">
						<li><a href="/realBoard" class="drop">Board</a></li>
						<li><a href="/board" class="drop">자유게시판</a></li>
						</ul></li>
					</ul>
				</nav>

				<a href="#"
					class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black float-right text-white"><span
					class="icon-menu h3 text-white"></span></a>
			</div>
		</div>
	</div>

</header>