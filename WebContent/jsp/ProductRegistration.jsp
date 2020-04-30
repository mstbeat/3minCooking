<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="enums.Genre" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/InventoryControl.css">
<title>商品情報登録</title>
</head>
<body>
	<h3>商品情報管理システム</h3>
	<h2>商品情報登録</h2>
	<form action="/m.yasuda/product-registration" method="post">
		<input class="submit-btn" type="submit" value="登録">
		<div class="form-input">
			<div class="form-input-box">
				<label for="genre">ジャンル：</label>
				<select name="genre" id="genre">
					<c:forEach var="genre" items="${Genre.values()}">
						<option value="${genre.value}">${genre.key}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-input-box">
				<label for="maker">メーカー：</label>
				<input type="text" name="maker" id="maker">
			</div>
			<div class="form-input-box">
				<label for="productName">　商品名：</label>
				<input type="text" name="productName" id="productName">
			</div>
			<div class="form-input-box">
				<label for="sellingPrice">販売価格：</label>
				<input type="text" name="sellingPrice" class="form-input-box-price" id="sellingPrice">
			</div>
			<div class="form-input-box">
				<label for="productDetail">商品説明：</label>
				<textarea name="productDetail" id="productDetail"></textarea>
			</div>
		</div>
	</form>
</body>
</html>