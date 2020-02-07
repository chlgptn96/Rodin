<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Poster</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="<c:url value="/assets/css_side/main.css"/>" />
		<!--
		<noscript><link rel="stylesheet" href="<c:url value="/assets/css_side/noscript.css"/>" /></noscript>
		-->
		<style>
			input[type="file"] {
				/* 파일 필드 숨기기 */
				position: absolute;
				width: 1px;
				height: 1px;
				padding: 0;
				margin: -1px;
				overflow: hidden;
				clip:rect(0,0,0,0);
				border: 0;
			}
		</style>
	</head>
	<body class="is-preload-0 is-preload-1 is-preload-2">
		<div id="main">
			<header id="header">
				<h1>포스터 분석</h1>
				<!--
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands fa-github"><span class="label">Github</span></a></li>
					<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
				</ul>
				-->
				<form action="<c:url value="/poster/upload"/>" method="POST" enctype="multipart/form-data">
					<label id="upload-btn" for="file_upload">파일 업로드</label>
					<input id="file_upload" type="file" name="file1">
					<input type="submit" value="결과 확인">
				</form>
			</header>
			<section id="thumbnails">
				<article>
					<a class="thumbnail" href="<c:url value="/images/fulls/1.jpg"/>"  data-position="left center"><img src="<c:url value="images/thumbs/1.jpg"/>" alt="" /></a>
					<h2>Diam tempus accumsan</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
				</article>
				<article>
					<a class="thumbnail" href="<c:url value="/images/fulls/2.jpg"/>"><img src="<c:url value="images/thumbs/2.jpg"/>" alt="" /></a>
					<h2>Vivamus convallis libero</h2>
					<p>Sed velit lacus, laoreet at venenatis convallis in lorem tincidunt.</p>
				</article>
				<article>
					<a class="thumbnail" href="<c:url value="/images/fulls/3.jpg"/>" data-position="top center"><img src="<c:url value="images/thumbs/3.jpg"/>" alt="" /></a>
					<h2>Nec accumsan enim felis</h2>
					<p>Maecenas eleifend tellus ut turpis eleifend, vitae pretium faucibus.</p>
				</article>
				<article>
					<a class="thumbnail" href="<c:url value="/images/fulls/4.jpg"/>"><img src="<c:url value="images/thumbs/4.jpg"/>" alt="" /></a>
					<h2>Donec maximus nisi eget</h2>
					<p>Tristique in nulla vel congue. Sed sociis natoque parturient nascetur.</p>
				</article>
				<article>
					<a class="thumbnail" href="<c:url value="/images/fulls/5.jpg"/>" data-position="top center"><img src="<c:url value="images/thumbs/5.jpg"/>" alt="" /></a>
					<h2>Nullam vitae nunc vulputate</h2>
					<p>In pellentesque cursus velit id posuere. Donec vehicula nulla.</p>
				</article>
				<article>
					<a class="thumbnail" href="<c:url value="/images/fulls/6.jpg"/>"><img src="<c:url value="images/thumbs/6.jpg"/>" alt="" /></a>
					<h2>Phasellus magna faucibus</h2>
					<p>Nulla dignissim libero maximus tellus varius dictum ut posuere magna.</p>
				</article>
			</section>
			<footer id="footer">
				<ul class="copyright">
					<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a>.</li>
				</ul>
			</footer>
		</div>

		<!-- Scripts -->
		<script src="<c:url value="/assets/js_side/jquery.min.js" />" ></script>
		<script src="<c:url value="/assets/js_side/browser.min.js" />" ></script>
		<script src="<c:url value="/assets/js_side/breakpoints.min.js" />" ></script>
		<script src="<c:url value="/assets/js_side/main.js" />" ></script>

	</body>
</html>