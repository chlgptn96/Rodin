<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>Rodin</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>

<body class="index is-preload">
	<header id="header" class="alt">
		<h1 id="logo">
			<a href="index.jsp">Rodin <span></span></a>
		</h1>
		<nav id="nav">
			<ul>
				<li class="current">환영합니다.</a></li>
				<li class="submenu"><a href="#">Menu</a>
					<ul>
						<li class="submenu"><a href="#">recommendation</a>
							<ul>
								<li><a href="BgParallelism.jsp">BGColor</a></li>
								<li><a href="#">page2</a></li>
								<li><a href="#">page3</a></li>
								<li><a href="#">page4</a></li>
								<li><a href="#">page5</a></li>
							</ul></li>
						<li><a href="Font.jsp">Font</a></li>
						<li><a href="Poster.jsp">Poster</a></li>
						<li><a href="Statics.jsp">statics</a></li>
						<li><a href="#">Community</a>
							<ul>
								<li><a href="#">자유게시판1</a></li>
								<li><a href="#">자유게시판2</a></li>
								<li><a href="#">자유게시판3</a></li>
								<li><a href="#">자유게시판4</a></li>

							</ul></li>
						<li><a href="Help.jsp">Help</a></li>
						<li><a href="Mypage.jsp">Mypage</a></li>

					</ul></li>
				<li><a href="Login.jsp" class="button primary">Login</a></li>
				<li><a href="MemberForm.jsp" class="button primary">Sign Up</a></li>

			</ul>
		</nav>
	</header>
	<!-- Banner -->
	<section id="banner">

		<div class="inner">

			<header>
				<h2>Rodin</h2>
			</header>
			<p>안녕하세요. RODIN 입니다.</p>
			<br>현재 사용되고 있는 Poster와 Font등을 알려주고 <br>여러분들이 사용하고자 하는 글꼴과
			이미지 창작에 도움이 되고자 하는 템플릿입니다.

			<footer>
				<ul class="buttons stacked">
					<li><a href="Poster.jsp" class="button fit scrolly">포스터 분석하러 가기</a></li>

				</ul>
			</footer>

		</div>

	</section>

	<!-- Main -->
	<article id="main">

		<header class="special container">
			<span class="icon solid fa-chart-bar"></span>
			<h2>
				<a href="www.bitacademy.com"><strong>폰트 검색 순위</strong></a>
			</h2>
			<p>통계 ( 나눔, 고딕, 야놀자~, 여기어때~~~)</p>
		</header>

		<!-- One -->
		<section class="wrapper style2 container special-alt">
			<div class="row gtr-50">
				<div class="col-8 col-12-narrower">

					<header>
						<h2>회사 오시는 길</h2>
					</header>
					<img src="images/bitmap.png">
					<footer>
						<ul class="buttons">
							<li><a
								href="https://www.google.com/maps/place/%EB%B9%84%ED%8A%B8%EA%B5%90%EC%9C%A1%EC%84%BC%ED%84%B0/@37.4954288,127.0276188,17z/data=!4m5!3m4!1s0x0:0x44f6db1c2b6c3bf7!8m2!3d37.4946083!4d127.0276054"
								class="button">Google 지도로 보기</a></li>
						</ul>
					</footer>

				</div>

			</div>
		</section>
	</article>

	<!-- CTA -->
	<section id="cta">

		<header>
			<h2>도움이 필요하신가요?</h2>
			<p>언제든 문의 주세요.</p>
			<footer>
				<ul class="buttons">
					<li><a href="Help.jsp" class="button primary">Rodin에게 하고싶은
							말</a></li>

				</ul>
			</footer>
	</section>

	<!-- Footer -->
	<jsp:include page="footer.jsp" flush="false" />

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>