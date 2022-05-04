<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html lang="ru">
<html>
<head>
<meta charset="UTF-8">
<title>Результат</title>
</head>
<body>
	<h1>Заказ оформлен!</h1>
	${test}
	<a href="/kursovaya/order.pdf">Открыть pdf-файл заказа</a>
	<a href="/kursovaya/order.pdf" download>Скачать pdf-файл заказа</a>
</body>
</html>