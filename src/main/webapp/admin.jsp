<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Панель администратора</title>
</head>
<body>
	<h1>Панель администратора</h1>
	<h2>${message}</h2>
	<form action="${pageContext.request.contextPath}/admin" method="post">
		<label for="area">Цена за генеральную уборку: </label>
		<input type="number" name="type_1" id="type_1" value="${type_1}" required>
		<br>
		
		<label for="area">Цена за уборку после ремонта: </label>
		<input type="number" name="type_2" id="type_2" value="${type_2}" required>
		<br>
		
		<label for="area">Цена за поддерживающую уборку: </label>
		<input type="number" name="type_3" id="type_3" value="${type_3}" required>
		<br>
		<br>
		
		
		<label for="area">Цена за уборку 1 м2: </label>
		<input type="number" name="area" id="area" value="${area}" required>
		<br>
		<br>
		
		
		<label for="area">Цена за услугу "Мытье окон": </label>
		<input type="number" name="service_1" id="service_1" value="${service_1}" required>
		<br>
		
		<label for="area">Цена за услугу "Мытье холодильника": </label>
		<input type="number" name="service_2" id="service_2" value="${service_2}" required>
		<br>
		
		<label for="area">Цена за услугу "Мытье люстр": </label>
		<input type="number" name="service_3" id="service_3" value="${service_3}" required>
		<br>
		
		<label for="area">Цена за услугу "Мытье микроволновки": </label>
		<input type="number" name="service_4" id="service_4" value="${service_4}" required>
		<br>
		
		<label for="area">Цена за услугу "Химчистка диванов": </label>
		<input type="number" name="service_5" id="service_5" value="${service_5}" required>
		<br>
		
		<label for="area">Цена за услугу "Химчистка кресел": </label>
		<input type="number" name="service_6" id="service_6" value="${service_6}" required>
		<br>
		
		<label for="area">Цена за услугу "Химчистка пуфиков": </label>
		<input type="number" name="service_7" id="service_7" value="${service_7}" required>
		<br>
		
		<label for="area">Цена за услугу "Химчистка стульев": </label>
		<input type="number" name="service_8" id="service_8" value="${service_8}" required>
		<br>
		
		<input type="submit" name="sign" value="Изменить цены">
		<br>
		<a href="index.jsp">К главной</a>
		<a href="calculator.jsp">Открыть калькулятор</a>
	</form>
</body>
</html>
