<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHIN 家計簿</title>
</head>
<body>
	<h1>welcome to visit</h1>
	<!--정보 송신할 곳을 설정-->
	<form action="Login" method="post">

		ID:<br><input type="text" name="id"><br> 
		password<br><input	type="password" name="pw"><br> 
		<input type="submit"
			value="LOGIN">
			<a href="join.jsp">Join</a><br>
	</form>

</body>
</html>