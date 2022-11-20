<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
					<c:if test="${loginUser != null}">
						<li><a href="#" class="nav-link">${loginUser}님 반갑습니다!</a></li>
					</c:if>
					</ul>
				</nav>
				
				<a href="#"
					class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black float-right text-white"><span
					class="icon-menu h3 text-white"></span></a>
			</div>	
		</div>
	</div>

</header>