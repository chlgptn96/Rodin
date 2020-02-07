<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="<c:url value="/assets/css/main_rodin.css"/>" />
		<!--
		<noscript>
			<link rel="stylesheet" href="<c:url value="/assets/css/noscript.css"/>" />
		</noscript>
		-->
<title>폰트</title>
</head>
<body class="index is-preload">
	<c:import url="/WEB-INF/views/includes/header.jsp" />
	
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
		<section class="wrapper style5 container special-alt">
			<div class="row gtr-50">
				<div class="col-8 col-12-narrower">

					<form action="<c:url value="/socket/upload"/>" method="POST"
						enctype="multipart/form-data">
						<label id="upload_file" class="small" for="upload">파일 업로드</label>
						<input id="upload" type="file" name="file1">
						<input class="small" type="submit" value="upload">
					</form>

				</div>
			</div>
		</section>
	</article>
	<div id="sidebar">
		<!-- Header -->
		<header class="header">
			<h1>포스터 분석</h1>
		</header>

		<!-- Thumbnail -->
		<section class="thumbnails">
			<article>
				<a class="thumbnail" href="images/fulls/01.jpg" data-position="left center"><img src="images/thumbs/01.jpg" alt="" /></a>
				<h2>Diam tempus accumsan</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
			</article>
			<article>
				<a class="thumbnail" href="images/fulls/02.jpg"><img src="images/thumbs/02.jpg" alt="" /></a>
				<h2>Vivamus convallis libero</h2>
				<p>Sed velit lacus, laoreet at venenatis convallis in lorem tincidunt.</p>
			</article>
			<article>
				<a class="thumbnail" href="images/fulls/03.jpg" data-position="top center"><img src="images/thumbs/03.jpg" alt="" /></a>
				<h2>Nec accumsan enim felis</h2>
				<p>Maecenas eleifend tellus ut turpis eleifend, vitae pretium faucibus.</p>
			</article>
		</section>
	</div>

	<c:import url="/WEB-INF/views/includes/footer.jsp" />
	<script src="<c:url value="/assets/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/assets/js/jquery.dropotron.min.js"/>"></script>
	<script src="<c:url value="/assets/js/jquery.scrolly.min.js"/>"></script>
	<script src="<c:url value="/assets/js/jquery.scrollex.min.js"/>"></script>
	<script src="<c:url value="/assets/js/browser.min.js"/>"></script>
	<script src="<c:url value="/assets/js/breakpoints.min.js"/>"></script>
	<script src="<c:url value="/assets/js/util.js"/>"></script>
	<script src="<c:url value="/assets/js/main.js"/>"></script>

</body>
</html>