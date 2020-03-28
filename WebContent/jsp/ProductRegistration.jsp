<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/InventoryControl.css">
<title>商品情報登録</title>
</head>
<body>
	<main>
		<h3>商品情報管理システム</h3>
		<h2>商品情報登録</h2>
		<form>
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
					<label for="name">　商品名：</label>
					<input type="text" name="name">
				</div>
				<div class="form__input--box">
					<label for="price">販売価格：</label>
					<input type="text" name="price" class="form__input--box__price">
				</div>
				<div class="form__input--box">
					<label for="detail">商品説明：</label>
					<textarea name="detail" rows="4"></textarea>
				</div>
			</div>
		</form>
	</main>
</body>
</html>