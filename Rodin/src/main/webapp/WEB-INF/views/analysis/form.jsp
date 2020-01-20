<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>file transfer example</title>
	<script type="text/javascript">
		var ws = new WebSocket("ws://localhost:5000/chat");
		ws.onmessage = function(event) {
	  		console.log(event);
	  		console.log("error");
		}
		function send() {
			console.log("request success");
	  		ws.send(document.getElementById('chat').value );
		}
	</script>
</head>
<body>
	<form action="<c:url value="/analysis/upload"/>" method="POST" enctype="multipart/form-data">
		<label>File</label>
		<input type="file" name="file">
		<input type="submit" value="upload">
	</form>
	<div>
    	hello
    	<input id="chat">
    	<button onclick="send()">send</button>
  	</div>    
</body>
</html>