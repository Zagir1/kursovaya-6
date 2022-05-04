<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Главная страница</title>
</head>
<body>
	<h1>Калькулятор</h1>
	<div>${error}</div>
	<div>${message}</div>
	<form action="${pageContext.request.contextPath}/authorization" method="post">
		<label for="username">Логин: </label>
		<input type="text" name="username" id="username" required>
		<br>
		<label for="password">Пароль: </label>
		<input type="password" name="password" id="password" required>
		<br>
		<input type="submit" name="sign" value="Авторизоваться">
	</form>
	<div>
		<a href="registration.jsp">Регистрация</a>
	</div>
</body>
</html>
