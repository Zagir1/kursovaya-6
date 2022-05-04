<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Калькулятор клининговых услуг. Офис</title>
	</head>
	
	<body>
	
		<h1>Калькулятор клининговых услуг. Офис</h1>
		
		<form action="${pageContext.request.contextPath}/calculator" method="post">
			
			<div>${promotext}</div>
			
			<select name="type" id="type">
				<option selected value="Генеральная">Генеральная</option>
				<option value="После ремонта">После ремонта</option>
				<option value="Поддерживающая">Поддерживающая</option>
			</select>
			
			<br>
			
			<label for="area">Площадь помещения: </label>
			<input type="number" name="area" id="area" value="${area}" required>
			
			<br>
			<label for="service">Дополнительные услуги: </label>
			<br>
			<div>
				<input type="checkbox" name="clean_service" id="clean_window" value="Мытье окон">
				<label for="clean_window">Мытье окон</label>
			</div>
			<div>
				<input type="checkbox" name="clean_service" id="clean_fridge" value="Мытье холодильника">
				<label for="clean_fridge">Мытье холодильника</label>
			</div>
			<div>
				<input type="checkbox" name="clean_service" id="clean_chandelier" value="Мытье люстр">
				<label for="clean_chandelier">Мытье люстр</label>
			</div>
			<div>
				<input type="checkbox" name="clean_service" id="clean_microwave" value="Мытье микроволновки">
				<label for="clean_microwave">Мытье микроволновки</label>
			</div>
			<div>
				<input type="checkbox" name="clean_service" id="dry_clean_sofa" value="Химчистка диванов">
				<label for="dry_clean_sofa">Химчистка диванов</label>
			</div>
			<div>
				<input type="checkbox" name="clean_service" id="dry_clean_armchair" value="Химчистка кресел">
				<label for="dry_clean_armchair">Химчистка кресел</label>
			</div>
			<div>
				<input type="checkbox" name="clean_service" id="dry_clean_ottoman" value="Химчистка пуфиков">
				<label for="dry_clean_ottoman">Химчистка пуфиков</label>
			</div>
			<div>
				<input type="checkbox" name="clean_service" id="dry_clean_chair" value="Химчистка стульев">
				<label for="dry_clean_chair">Химчистка стульев</label>
			</div>
			<br>
			
			<input type="submit" name="sign" value="Рассчитать">
			
		</form>
		
		<form action="${pageContext.request.contextPath}/promocode" method="post">
			<label for="promo">Промокод: </label>
			<input type="text" name="promo" id="promo" value="" required>
			<br>
			<input type="submit" name="sign" value="Ввести промокод">
		</form>
		
	</body>
	
</html>