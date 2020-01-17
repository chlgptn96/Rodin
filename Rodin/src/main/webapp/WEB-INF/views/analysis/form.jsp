<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>file transfer example</title>
</head>
<body>
	<form action="<c:url value="/analysis/upload"/>" method="POST" enctype="multipart/form-data">
		<label>File</label>
		<input type="file" name="file">
		<input type="submit" value="upload">
	</form>
</body>
</html>