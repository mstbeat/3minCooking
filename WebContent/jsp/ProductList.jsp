<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="enums.Genre" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/InventoryControl.css">
<title>商品情報一覧</title>
</head>
<body>
	<h3>商品情報管理システム</h3>
	<h2>商品情報一覧</h2>
	<button type="button" class="submit-btn" onclick="location.href='/m.yasuda/product-registration'">登録</button>
	<div class="list-count">商品情報件数 <c:out value="${productDtoList.size()}" /> 件</div>
	<table border="1">
		<tr>
			<th bgcolor="#BAD3FF">商品ID</th>
			<th bgcolor="#BAD3FF">ジャンル</th>
			<th bgcolor="#BAD3FF">メーカー</th>
			<th bgcolor="#BAD3FF">商品名</th>
			<th bgcolor="#BAD3FF">販売価格</th>
			<th bgcolor="#BAD3FF">更新</th>
		</tr>
		<c:forEach var="productDto" items="${productDtoList}">
			<tr>
				<td align="right"><c:out value="${productDto.productId}" /></td>
				<c:choose>
					<c:when test="${productDto.genre == 0}" >
		 				<td><c:out value="${Genre.getKeyByValue('0') }" /></td>
					</c:when>
					<c:when test="${productDto.genre == 1}" >
						<td><c:out value="${Genre.getKeyByValue('1') }" /></td>
					</c:when>
					<c:when test="${productDto.genre == 2}" >
						<td><c:out value="${Genre.getKeyByValue('2') }" /></td>
					</c:when>
					<c:when test="${productDto.genre == 3}" >
						<td><c:out value="${Genre.getKeyByValue('3') }" /></td>
					</c:when>
					<c:when test="${productDto.genre == 4}" >
						<td><c:out value="${Genre.getKeyByValue('4') }" /></td>
					</c:when>
					<c:when test="${productDto.genre == 5}" >
						<td><c:out value="${Genre.getKeyByValue('5') }" /></td>
					</c:when>
				</c:choose>
				<td><c:out value="${productDto.maker}" /></td>
				<td><c:out value="${productDto.productName}" /></td>
				<td align="right"><c:out value="${productDto.sellingPrice}" /></td>
				<td align="center">
					<form  action="/m.yasuda/product-edit" method="post">
						<input type="hidden" name="productId" value="${productDto.productId}">
						<input class="update-btn" type="submit" value="更新">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>