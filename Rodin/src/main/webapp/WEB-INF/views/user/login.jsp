<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="<c:url value="/assets/css/main.css"/>" />
<noscript>
	<link rel="stylesheet" href="<c:url value="/assets/css/noscript.css"/>" />
</noscript>
</head>
<body class="contact is-preload">
	<c:import url="/WEB-INF/views/includes/header.jsp" />

	<article id="main">

		<header class="special container">
			<h2>안녕하세요 RODIN입니다.</h2>
			<p>우리 RODIN사이트를 이용하시려면 LOGIN을 하셔야 합니다.!</p>
		</header>

		<!-- One -->
		<section class="wrapper style4 special container medium">

			<!-- Content -->
			<div class="content">
				<form method="post" action="<c:url value="/user/login" />">
					<div class="row gtr-50">
						<div class="col-6 col-12-mobile">
							ID <input type="text" name="email" placeholder="Email" />
						</div>
						<div class="col-6 col-12-mobile">
							PASSWORD <input type="password" name="password" placeholder="password" />
						</div>

						<div class="col-12">
							<ul class="buttons">
								<li><input type="submit" class="special" value="Login" /></li>
							</ul>
						</div>
						<p>
							<b>회원이 아니시면 <a href="<c:url value="/user/join" />">여기</a>를 눌러 가입해 주세요.</b>						
						</p>
					</div>
				</form>
			</div>

		</section>

	</article>

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