<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Contact - Twenty by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="<c:url value="/assets/css/main.css"/>" />
		<!--
		<noscript>
			<link rel="stylesheet" href="<c:url value="/assets/css/noscript.css"/>" />
		</noscript>
		-->
<style>
chk-box {
	disply: none;
}

* {
	font-family: 'malgun gothic';
}

#content.cols-d {
	width: 1000px;
	min-width: 400px;
}

.f {
	position: relative;
	margin: 0;
	padding: 0;
	color: #666;
}

.f p {
	width: 100%;
	margin: 0 0 13px;
	font-size: 1.3em;
	text-align: center;
	margin-top: 20px;
}

.f p:after {
	content: "";
	display: block;
	overflow: hidden;
	clear: both;
	height: 0;
}

.f textarea {
	position: relative;
	width: 570px;
	height: 118px;
	min-height: 118px;
	padding: 3px 3px 3px 6px;
	border: 1px solid #ececec;
	border-top-color: #e1e1e1;
	border-left-color: #e1e1e1;
	background: #ececec;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
}

.scheme-g {
	margin: 26px 0 8px;
	padding: 0px;
	font-size: 1.2em;
	font-weight: 100;
}

</style>


<script type="text/javascript">

	/*
		회원가입 검증 작동안함
	*/
	$(document).ready(function() {

		$("#nextBtn").click(function() {
			if ($("#check_1").is(":checked") == false) {
				alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
				return;
			} else if ($("#check_2").is(":checked") == false) {
				alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다..");
				return;
			} else if ($("#check_3").is(":checked") == false) {
				alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다...");
				return;
			} else {
				$("#terms_form").submit();
			}
		});
	});
</script>


</head>
<body>
	<c:import url="/WEB-INF/views/includes/header.jsp" />


	<article id="main">

		<header class="special container">
			<span class="icon solid">회원 가입</span>
			<h2>RODIN에 오신걸 환영합니다.</h2>
			<p>함께 공유하면서 성장하는 RODIN이 되겠습니다.</p>
		</header>

		<!-- One -->
		<section class="wrapper style4 special container medium">

			<!-- Content -->
			<div class="content">
				<h1>
					<b>회원 가입</b>
				</h1>
				<form method="post" action="<c:url value="/user/join" />">

					<div class="row gtr-50">

						<div class="col-6 col-12-mobile">
							<input type="text" name="name" placeholder="이름" />
						</div>
						<div class="col-6 col-12-mobile">
							<input type="text" name="email" placeholder="이메일" />
						</div>
						<div class="col-6 col-12-mobile">
							<input type="password" name="password" placeholder="비밀번호" />
						</div>
						<div class="col-6 col-12-mobile">
							<input type="text" name="phone" placeholder="휴대폰 번호" />
						</div>
						<div class="col-6 col-12-mobile">
							<input type="text" name="birth"
								placeholder="생일 입력 ex) 2000-12-01" />
						</div>
						<div class="col-6 col-12-mobile">
							<input type="text" name="job" placeholder="직업(선택사항)" />
						</div>
						<div class="col-12">
							<textarea name="profile" placeholder="프로필" rows="7"></textarea>

						</div>


						<div class="checkbox-container">
							<input type="checkbox" name="interests" value="HTML">HTML
							<input type="checkbox" name="interests" value="CSS">CSS <input
								type="checkbox" name="interests" value="웹디자인">웹디자인
						</div>
						<div class="checkbox-container">

							<input type="checkbox" name="interests" value="HTML">HTML
							<input type="checkbox" name="interests" value="CSS">CSS <input
								type="checkbox" name="interests" value="웹디자인">웹디자인
						</div>
						<div class="checkbox-container">

							<input type="checkbox" name="interests" value="HTML">HTML
							<input type="checkbox" name="interests" value="CSS">CSS <input
								type="checkbox" name="interests" value="웹디자인">웹디자인
						</div>
						<div class="checkbox-container">

							<input type="checkbox" name="interests" value="HTML">HTML
							<input type="checkbox" name="interests" value="CSS">CSS <input
								type="checkbox" name="interests" value="웹디자인">웹디자인
						</div>
						<div class="checkbox-container">

							<input type="checkbox" name="interests" value="HTML">HTML
							<input type="checkbox" name="interests" value="CSS">CSS <input
								type="checkbox" name="interests" value="웹디자인">웹디자인
						</div>
						<div class="checkbox-container">

							<input type="checkbox" name="interests" value="HTML">HTML
							<input type="checkbox" name="interests" value="CSS">CSS <input
								type="checkbox" name="interests" value="웹디자인">웹디자인
						</div>

						<article id="content" class="cols-d">
							<div>
								<h1>이용약관</h1>

								<h4 class="scheme-g">●이용약관1</h4>
								<textarea style="font-size: 1em;">내용입니다.
            </textarea>
								<p>
									<input type="checkbox" id="check_1" name="" /> 위의 약관에 동의 합니다.<br />
								</p>
								<h4 class="scheme-g">●이용약관2</h4>
								<textarea style="font-size: 1em;">내용입니다.
            </textarea>
								<p>
									<input type="checkbox" id="check_2" name="" /> 위의 약관에 동의 합니다.<br />
								</p>
								<h4 class="scheme-g">●개인정보취급방침</h4>
								<textarea style="font-size: 1em;">내용입니다. 

            </textarea>
								<p>
									<input type="checkbox" id="check_3" name="" /> 위의 약관에 동의 합니다.<br />

								</p>

							</div>
						</article>

						<div class="col-12">
							<ul class="buttons">
								<li><input type="reset" class="special" value="초기화" /></li>
								<li><input type="submit" class="special" id="nextBtn" value="회원 가입 하기" /></li>
							</ul>
						</div>
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