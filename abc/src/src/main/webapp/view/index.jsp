<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="add">
		<input type="text" placeholder="a" name="num1">
		<input type="text" placeholder="b" name="num2">
	    <input type="submit">
	</form>
	<br>
	<form action="addAlien">
		Aid: <input type="text" name="aid">
		AName: <input type="text"  name="aname">
	    <input type="submit">
	</form>
	
	<form action="fetchData" method="get">
		Aid: <input type="text" name="aid"> <input type="submit"
			value="search">
	</form>
</body>
</html>