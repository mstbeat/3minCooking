<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/InventoryControl.css">
<title>商品情報更新</title>
</head>
<body>
	<main>
		<h3>商品情報管理システム</h3>
		<h2>商品情報更新</h2>
		<form  action="/m.yasuda/product-update" method="post">
			<div class="btn">
				<input type="hidden" name="productId" value="${productDto.productId}">
				<input class="btn-update-btn" type="submit" value="更新" onclick="return confirm('更新してよろしいですか？');">
				<a href="/m.yasuda/product-delete?productId=${productDto.productId}" style="text-decoration:none;">
					<button type="button" class="btn-delete-btn" onclick="return confirm('削除してよろしいですか？');">削除</button>
				</a>
			</div>
			<div class="form">
				<div class="form-item">
					<div>　商品ID：</div>
					<div class="form-item-id">${productDto.productId}</div>
				</div>
				<div class="form-input-box">
					<label for="genre">ジャンル：</label>
					<select name="genre">
						<c:forEach var="genre" items="${genres}">
							<option value="${genre.value}" <c:if test="${productDto.genre == genre.value}">selected</c:if>>${genre.key}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-input-box">
					<label for="maker">メーカー：</label>
					<input type="text" name="maker" value="${productDto.maker}">
				</div>
				<div class="form-input-box">
					<label for="ProductName">　商品名：</label>
					<input type="text" name="productName" value="${productDto.productName}">
				</div>
				<div class="form-input-box">
					<label for="sellingPrice">販売価格：</label>
					<input type="text" name="sellingPrice" class="form-input-box-price" value="${productDto.sellingPrice}">
				</div>
				<div class="form-input-box">
					<label for="productDetail">商品説明：</label>
					<textarea name="productDetail" rows="4">${productDto.productDetail}</textarea>
				</div>
			</div>
		</form>
	</main>
</body>
</html>