<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#header {
		height: 4.3em;
	}
	#header nav {
		top: initial;
	}
	#logo a {
		font-size: 2.5em;
    	top: 0.5em;
    	position: absolute;
	}
	
</style>
<header id="header">
	<h1 id="logo">
		<a href="<c:url value="/" /> ">RODIN</a>
	</h1>
	<nav id="nav">
		<ul>
			<c:choose>
				<c:when test="${empty user }">
					<li class="current">Guest 님, 환영합니다.</li>
					<li><a href="<c:url value="/user/login" />" class="button primary">login</a></li>
					<li><a href="<c:url value="/user/join" />" class="button primary">Sign Up</a></li>
				</c:when>
				<c:otherwise>
					<li class="current">${user.name } 님, 환영합니다.</li>
					<li class="submenu"><a href="#">Menu</a>
						<ul>
							<!-- 
							<li class="submenu"><a href="#">recommendation</a>
								<ul>
									<li><a href="<c:url value="/bgp" />">BGColor</a></li>
									<li><a href="#">page2</a></li>
									<li><a href="#">page3</a></li>
									<li><a href="#">page4</a></li>
									<li><a href="#">page5</a></li>
								</ul>
							</li>
							-->
							<li><a href="<c:url value="/analysis" />">폰트분석</a></li>
							<!--  -->
							<!--  
							<li><a href="<c:url value="/poster" />">Poster</a></li>
							-->
							<li><a href="<c:url value="/poster" />">포스터</a></li>
							<li><a href="<c:url value="/statics" />">통계</a></li>
							<!--  -->
							<!--  
							<li class="submenu"><a href="#">Community</a>
								<ul>
									<li><a href="#">자유게시판1</a></li>
									<li><a href="#">자유게시판2</a></li>
									<li><a href="#">자유게시판3</a></li>
									<li><a href="#">자유게시판4</a></li>
								</ul>
							</li>
							-->
							<li><a href="<c:url value="/help" />">Help</a></li>
							<li><a href="<c:url value="/user/logout" />">Logout</a></li>
						</ul>
					</li>
					
					<li><a href="<c:url value="/mypage" />" class="button primary">Mypage</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</header>
