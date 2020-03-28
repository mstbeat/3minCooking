<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/m.yasuda/css/InventoryControl.css">
<title>商品情報登録</title>
</head>
<body>
	<main>
		<h3>商品情報管理システム</h3>
		<h2>商品情報登録</h2>
		<form action="/m.yasuda/product-registration" method="post">
			<input class="submit--btn" type="submit" value="登録">
			<div class="form">
				<div class="form__input--box">
					<label for="genre">ジャンル：</label>
					<select name="genre">
						<option value="">指定なし</option>
						<option value="appliances">家電</option>
						<option value="furniture">家具</option>
						<option value="food">食品</option>
						<option value="fashion">ファッション</option>
						<option value="books">書籍</option>
					</select>
				</div>
				<div class="form__input--box">
					<label for="maker">メーカー：</label>
					<input type="text" name="maker">
				</div>
				<div class="form__input--box">
					<label for="productName">　商品名：</label>
					<input type="text" name="productName">
				</div>
				<div class="form__input--box">
					<label for="sellingPrice">販売価格：</label>
					<input type="text" name="sellingPrice" class="form__input--box__price">
				</div>
				<div class="form__input--box">
					<label for="productDetail">商品説明：</label>
					<textarea name="productDetail" rows="4"></textarea>
				</div>
			</div>
		</form>
	</main>
</body>
</html>