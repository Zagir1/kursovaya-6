<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html lang="ru">
<html>
<head>
<meta charset="UTF-8">
<title>Информация о клиенте</title>
</head>
<body>
	<h1>Заполните контактные данные ${test}</h1>
	<p>Стоимость заказа - ${price}</p>
	<form action="${pageContext.request.contextPath}/credentials" method="post">
		<label for="surname">Фамилия: </label>
		<input type="text" name="surname" id="surname" value="" required>
		<br>
		<label for="name">Имя: </label>
		<input type="text" name="name" id="name" value="" required>
		<br>
		<label for="patronymic">Отчество: </label>
		<input type="text" name="patronymic" id="patronymic" value="" required>
		<br>
		<label for="address">Адрес: </label>
		<input type="text" name="address" id="address" value="" required>
		<br>
		<input type="submit" name="sign" value="Заказать">
	</form>
</body>
</html>