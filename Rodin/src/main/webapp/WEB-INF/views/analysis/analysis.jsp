<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>폰트 분석 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="<c:url value="/assets/css/css_side/main.css"/>" />
		<!--
		<noscript><link rel="stylesheet" href="<c:url value="/assets/css_side/noscript.css"/>" /></noscript>
		-->
		<style>
			form {
				margin: 0;
				padding: 0;
			}
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
			#upload-btn, #extract-btn, #submit-btn, #upload-submit {
				width: 100%;
				text-align: center;
			}

		</style>
	</head>
	<body class="is-preload-0 is-preload-1 is-preload-2">
		<div id="main">
			<header id="header">
				<h2>
					<a href="<c:url value="/" /> ">HOME</a>
				</h2>
				<h1>포스터 분석</h1>
				<!--
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands fa-github"><span class="label">Github</span></a></li>
					<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
				</ul>
				-->

				<form action="" method="POST" enctype="multipart/form-data">
				<!-- <form id="uploadForm"> -->
					<label id="upload-btn" for="file_upload">파일 추가</label>
					<input id="file_upload" type="file" name="file1">
					<!-- 
					<input id="upload-submit" type="submit" value="파일 업로드" onclick="javascript: form.action='<c:url value="/analysis/upload"/>';">
					-->
					<input id="upload-submit" type="submit" value="파일 업로드" onclick="javascript: form.action='<c:url value="/analysis/s3upload" />';">
					<input id="extract-btn" type="button" value="폰트 추출">
					<input id="submit-btn" type="submit" value="폰트 검색" onclick="javascript: form.action='<c:url value="/analysis/flask"/>';">
				</form>
			</header>
			<section id="thumbnails">
				<c:forEach items="${posterList }" begin="0" end="5" var="poster" varStatus="status">
					<article>
						<a class="thumbnail" href="https://rodin-image.s3.ap-northeast-2.amazonaws.com/${poster }">
							<img src="https://rodin-image.s3.ap-northeast-2.amazonaws.com/${poster }" alt="" />
						</a>
					</article>
				</c:forEach>
			</section>
			<footer id="footer">
				<ul class="copyright">
					<li>&copy;2020 Rodin.</li>
				</ul>
			</footer>
		</div>

		<!-- Scripts -->
		<script src="<c:url value="/assets/js/js_side/jquery.min.js" />" ></script>
		<script src="<c:url value="/assets/js/js_side/browser.min.js" />" ></script>
		<script src="<c:url value="/assets/js/js_side/breakpoints.min.js" />" ></script>
		<script src="<c:url value="/assets/js/js_side/main.js" />" ></script>

	</body>
	
	<script>
	
	</script>
</html>