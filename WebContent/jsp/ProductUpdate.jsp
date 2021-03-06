<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="enums.Genre" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/InventoryControl.css">
<title>商品情報更新</title>
</head>
<body>
  <h3>商品情報管理システム</h3>
  <h2>商品情報更新</h2>
  <form action="./product-update" method="post">
    <div class="btn">
      <input type="hidden" name="productId" value="${productDto.productId}">
      <input class="btn-update-btn" type="submit" value="更新" onclick="return confirm('更新してよろしいですか？');">
    </div>
    <div class="form-input">
      <div class="form-item">
        <div class="form-input-box-left">商品ID：</div>
        <div class="form-item-id">${productDto.productId}</div>
      </div>
      <div class="form-input-box">
        <label>ジャンル：</label>
        <select name="genre">
          <c:forEach var="genre" items="${Genre.values()}">
            <option value="${genre.value}" <c:if test="${productDto.genre == genre.value}">selected</c:if>>
              ${genre.key}</option>
          </c:forEach>
        </select>
      </div>
      <div class="form-input-box">
        <label>メーカー：</label>
        <input type="text" name="maker" value="${productDto.maker}">
      </div>
      <div class="form-input-box">
        <label class="form-input-box-left">商品名：</label>
        <input type="text" name="productName" value="${productDto.productName}">
      </div>
      <div class="form-input-box">
        <label class="form-input-box-left">在庫数：</label>
        <input type="text" name="stock" class="form-input-box-price" value="${productDto.stock}">
      </div>
      <div class="form-input-box">
        <label>販売個数：</label>
        <input type="text" name="salesCount" class="form-input-box-price" value="${productDto.salesCount}">
      </div>
      <div class="form-input-box">
        <label>販売価格：</label>
        <input type="text" name="sellingPrice" class="form-input-box-price" value="${productDto.sellingPrice}">
      </div>
      <div class="form-input-box">
        <label>商品説明：</label>
        <textarea name="productDetail">${productDto.productDetail}</textarea>
      </div>
    </div>
  </form>
  <form action="./product-delete" method="post">
    <div class="btn">
      <input type="hidden" name="productId" value="${productDto.productId}">
      <input class="btn-delete-btn" type="submit" value="削除" onclick="return confirm('削除してよろしいですか？');">
    </div>
  </form>
</body>
</html>