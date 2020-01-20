<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
		<script src="http://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
		<script>
			
			var sock = new SockJS("<c:url value="/analysis" />");
			sock.onmessage = onMessage;
			sock.onclose = onClose;
			
			$(function(){
				$("#sendBtn").click(function() {
					console.log('send message...');
					sendMessage();
				});
			});
			
			function sendMessage() {
				sock.send($("#message").val());
			}
			
			function onMessage(e) {
				var data = e.data;
				var sessionid = null;
				var message = null;
				
				var strArray = data.split('|');
				
				for (var i = 0; i < strArray.length; i++) {
					console.log('str[' + i + ']: ' + strArray[i]);
				}
				
				var currentuser_session = $("#sessionuserid").val();
				console.log('current session id: ' + currentuser_session);
				
				sessionid = strArray[0];
				message = strArrary[1];
				
				if (sessionid == currentuser_session) {
					var printHTML = "<div class='well'>";
					printHTML += "<div class='alert alert-info'>";
					printHTML += "<strong>[" + sessionid + "] -> " + message + "</strong>";
					printHTML += "</div>";
					printHTML += "</div>";
					
					$("#chatdata").append(printHTML);
				} else {
					var printHTML = "<div class='well'>";
					printHTML += "<div class='alert alert-warning'>";
					printHTML += "<strong>[" + sessionid + "] -> " + message + "</strong>";
					printHTML += "</div>";
					printHTML += "</div>";
					
					$("#chatdata").append(printHTML);
				}
				
				console.log("chatting data: " + data);
				
			}
			
			function onClose(e) {
				$("#data").append("연결 끊김");
			}
			// alert("end");
		</script>
	</head>
	<body>
		<button id="sendBtn">send</button><br>
		<input id="message" type="text" /><br>
		<div id="chatdata"></div><br>
		<div id="data"></div><br>
	</body>
</html>
