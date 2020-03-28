<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/InventoryControl.css">
<title>商品情報一覧</title>
</head>
<body>
	<main>
		<h3>商品情報管理システム</h3>
		<h2>商品情報一覧</h2>
		<form>
			<input class="submit--btn" type="submit" value="登録">
			<div class="list--count">商品情報件数 3 件</div>
			<table border="1" color="#999">
			    <tr>
			      <th bgcolor="#BAD3FF">商品ID</th>
			      <th bgcolor="#BAD3FF">ジャンル</th>
			      <th bgcolor="#BAD3FF">メーカー</th>
			      <th bgcolor="#BAD3FF">商品名</th>
			      <th bgcolor="#BAD3FF">販売価格</th>
			      <th bgcolor="#BAD3FF">更新</th>
			    </tr>
			    <tr>
			      <td align="right">1</td>
			      <td>家電</td>
			      <td>パナソニック</td>
			      <td>201SB-BK</td>
			      <td align="right">31000</td>
			      <td align="center">
			      	<input class="update--btn" type="submit" value="更新">
			      </td>
			    </tr>
			    <tr>
			      <td align="right">2</td>
			      <td>家電</td>
			      <td>SONY</td>
			      <td>44K8-S01</td>
			      <td align="right">68980</td>
			      <td align="center">
			      	<input class="update--btn" type="submit" value="更新">
			      </td>
			    </tr>
			    <tr>
			      <td align="right">3</td>
			      <td>家電</td>
			      <td>アイリスオーヤマ</td>
			      <td>三段収納棚</td>
			      <td align="right">4800</td>
			      <td align="center">
			      	<input class="update--btn" type="submit" value="更新">
			      </td>
			    </tr>
			  </table>
		</form>
	</main>
</body>
</html>