<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header">
	<h1 id="logo">
		<a href="<c:url value="/" /> ">RODIN</a>
	</h1>
	<nav id="nav">
		<ul>
			<li class="current">환영합니다.</li>
			<li class="submenu"><a href="#">Menu</a>
				<ul>
					<li class="submenu"><a href="#">recommendation</a>
						<ul>
							<li><a href="<c:url value="/bgp" />">BGColor</a></li>
							<li><a href="#">page2</a></li>
							<li><a href="#">page3</a></li>
							<li><a href="#">page4</a></li>
							<li><a href="#">page5</a></li>
						</ul></li>
					<li><a href="<c:url value="/font" />">Font</a></li>
					<li><a href="<c:url value="/poster" />">Poster</a></li>
					<li><a href="<c:url value="/statics" />">statics</a></li>
					<li class="submenu"><a href="#">Community</a>
						<ul>
							<li><a href="#">자유게시판1</a></li>
							<li><a href="#">자유게시판2</a></li>
							<li><a href="#">자유게시판3</a></li>
							<li><a href="#">자유게시판4</a></li>
						</ul></li>
					<li><a href="<c:url value="/help" />">Help</a></li>
					<li><a href="<c:url value="/mypage" />">Mypage</a></li>

				</ul></li>
			<li><a href="<c:url value="/user/login" />"
				class="button primary">login</a></li>
			<li><a href="<c:url value="/user/join" />"
				class="button primary">Sign Up</a></li>

		</ul>
	</nav>
</header>
