<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Регистрация</title>
</head>
<body>
	<h1>Регистрация</h1>
	<div>${error}</div>
	<form action="${pageContext.request.contextPath}/registration" method="post">
		<label for="username">Логин: </label>
		<input type="text" name="username" id="username" required>
		<br>
		<label for="password">Пароль: </label>
		<input type="password" name="password" id="password" required>
		<br>
		<input type="submit" name="sign" value="Зарегистрироваться">
	</form>
</body>
</html>
