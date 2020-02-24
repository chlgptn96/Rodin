<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>폰트 분석 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" crossorigin="anonymous">
		-->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" crossorigin="anonymous">
		<link rel="stylesheet" href="<c:url value="/assets/css/css_side/main.css"/>" />
		<link rel="stylesheet" href="<c:url value="/assets/css/css_cropper/cropper.css"/> ">
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
			#upload-btn, #extract-btn, #submit-btn, #upload-submit, #to-cropper {
				width: 100%;
				text-align: center;
			}

			.label {
		      cursor: pointer;
		    }
		
		    .progress {
		      display: none;
		      margin-bottom: 1rem;
		    }

		
		    .alert {
		      display: none;
		    }
		
		    .img-container img {
		      max-width: 100%;
		    }
		    		    

		</style>
	</head>
	<body class="is-preload-0 is-preload-1 is-preload-2">
		<div class="alert" role="alert"></div>
		<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modalLabel">폰트 자르기</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="img-container">
							<img id="image" src="https://rodin-image.s3.ap-northeast-2.amazonaws.com/${posterList[0] }">
						</div>
					</div>
					<div class="modal-body cropped-image">
						<div class="result-container">
							
							<!-- 
							<p>폰트이름 : ${accu_1st.fontsName }</p>
							<p>제작회사 : ${accu_1st.fontsCompany }</p>
							<p>재배포 가능 여부 : ${accu_1st.fontsLicense7 }</p>
							<p>정확도 : <fmt:formatNumber value="${accu_1st.accuracy }" pattern=".00"/>%</p>
							<p>등록날짜 : ${accu_1st.regdate }</p>
							-->
							<!-- 
							<p>폰트이름 : ${font.fontsName }</p>
							<p>제작회사 : ${font.fontsCompany }</p>
							<p>재배포 가능 여부 : ${font.fontsLicense7 }</p>
							<p>정확도 : <fmt:formatNumber value="${font.accuracy }" pattern=".00"/>%</p>
							<p>등록날짜 : ${font.regdate }</p>
							 -->
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
						<button type="button" class="btn btn-primary" id="crop">자르기</button>
					</div>
				</div>
			</div>
		</div>
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

				<form id="multipartForm" action="" method="POST" enctype="multipart/form-data">				
				<!-- <form id="uploadForm"> -->	
					<input id="url" type="hidden" name="url" value="" >
				
					<label id="upload-btn" for="file_upload">파일 추가</label>
					<input id="file_upload" type="file" name="file1" >
					<!-- 
					<input id="upload-submit" type="submit" value="파일 업로드" onclick="javascript: form.action='<c:url value="/analysis/upload"/>';">
					-->
					<input id="upload-submit" type="submit" value="파일 업로드" onclick="javascript: form.action='<c:url value="/analysis/s3upload" />';">
					<!--
					<input id="to-cropper" type="submit" value="폰트 추출" onclick="javascript: form.action='<c:url value="/analysis/cropper" />';">
					-->
					<input id="to-cropper" type="button" value="폰트 추출">
					<input id="submit-btn" type="submit" value="폰트 검색" onclick="javascript: form.action='<c:url value="/analysis/flask"/>';">
				</form>
			</header>
			<section id="thumbnails">
				<c:forEach items="${posterList }" begin="0" end="5" var="poster" varStatus="status">
					<article>
						<a class="thumbnail" href="https://rodin-image.s3.ap-northeast-2.amazonaws.com/${poster }">
							<img class="thumbnail-base-image" src="https://rodin-image.s3.ap-northeast-2.amazonaws.com/${poster }" alt="" />
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
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
		<script src="<c:url value="/assets/js/js_side/browser.min.js" />" ></script>
		<script src="<c:url value="/assets/js/js_side/breakpoints.min.js" />" ></script>
		<script src="<c:url value="/assets/js/js_side/main.js" />" ></script>
		<script src="<c:url value="/assets/js/js_cropper/cropper.js" />" ></script>
		<script>

		var baseSrc;
		// var baseUrl = 
		var image = document.getElementById('image');
		// var _alert = document.getElementsByClassName('alert')[0];
		var $alert = $('.alert');
		// var _modal = document.getElementById('modal');
		var $modal = $('#modal');
		var $croppedImageBox = $('.cropped-image');
		var croppedImage = document.getElementById('cropped-image');
		var cropper;
		var srcList = document.getElementsByClassName('thumbnail-base-image');
		
		
		
		for (let i = 0; i < srcList.length; i++) {
			srcList[i].addEventListener('click', function() {
				baseSrc = srcList[i].getAttribute('src');
				// alert(baseSrc);
				image.src = baseSrc;
			});
		}
		
		document.getElementById('to-cropper').addEventListener('click', function() {
			// $croppedImageBox.css('display', 'none');
			$alert.hide();
			$modal.modal('show');	
		});
		
		$modal.on('shown.bs.modal', function() {
			cropper = new Cropper(image, {
				aspectRatio: NaN,
				viewMode: 3,
			});
		}).on('hidden.bs.modal', function() {
			cropper.destroy();
			cropper = null;
		});
		
		document.getElementById('crop').addEventListener('click', function() {
			// var initialURL;

			// $modal.modal('hide');
			var canvas = cropper.getCroppedCanvas({
				maxWidth: 500,
				maxHeight: 500,
			});
			// $croppedImageBox.css('display', 'block');
			// croppedImage.src = canvas.toDataURL();
			$alert.removeClass('alert-success alert-warning');
			//initialURL = image.src;
		
			canvas.toBlob(function (blob){
				var formData = new FormData();
				
				formData.append('croppedImage', blob, 'croppedImage.jpg');
				$.ajax({
					url: '<c:url value="/analysis/flask" />',
					enctype: 'multipart/form-data',
					method: 'POST',
					data: formData,
					processData: false,
					contentType: false,
					success: function() {
						// $croppedImageBox.css('display', 'block');
						// $alert.show().addClass('alert-success').text('Upload success');
						// alert(result);
						/*
						
						*/
						$.ajax({
							url: '<c:url value="/analysis/getFontInfo" />',
							method: 'POST',
							dataType: "json",
							success: function(data) {
								// alert("data : ", data.fontsName);
								
								// alert(data.font.fontsName);
								$(".result-container").children().remove();
								$(
									'<img id="cropped-image" src="' + canvas.toDataURL() + '" >' +
									'<div class="img-container">' +
										'<img src="https://rodin-font-image.s3.ap-northeast-2.amazonaws.com/abc/' + data.font.ocr + '/' + data.font.fontPiece + '">' +
									'</div>' + 
									'<p>폰트이름 : ' + data.font.fontsName + '</p>' + 
									'<p>제작회사 : ' + data.font.fontsCompany + '</p>'  + 
									'<p>재배포 가능 여부 : ' + data.font.fontsLicense7 + '</p>' +  
									'<p>정확도 : ' + data.font.accuracy.toFixed(2) + '%</p>'
								).appendTo($(".result-container"));
							},
							error: function() {
								alert("failed");
							}
						});

					},
					error: function() {
						croppedImage.src = baseSrc;
						// $alert.show().addClass('alert-warning').text('Upload error');
					},
					complete: function () {

					}
				});
				//alert(formData);
			});

			
		});
		
		/*
		$('.thumbnail-base-image').on('click', function() {
			baseSrc = $(this).attr('src');
			alert(baseSrc);
		});
		*/
		
		
		</script>

	</body>
	
	<script>
	</script>
</html>