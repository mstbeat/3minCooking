<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <form action="./product-registration" method="post">
    <input class="submit-btn" type="submit" value="登録">
    <div class="form-input">
      <div class="form-input-box">
        <label>ジャンル：</label>
        <select name="genre">
          <c:forEach var="genre" items="${Genre.values()}">
            <option value="${genre.value}">${genre.key}</option>
          </c:forEach>
        </select>
      </div>
      <div class="form-input-box">
        <label>メーカー：</label>
        <input type="text" name="maker">
      </div>
      <div class="form-input-box">
        <label class="form-input-box-left">商品名：</label>
        <input type="text" name="productName">
      </div>
      <div class="form-input-box">
        <label class="form-input-box-left">在庫数：</label>
        <input type="text" name="stock" class="form-input-box-price">
      </div>
      <div class="form-input-box">
        <label>販売個数：</label>
        <input type="text" name="salesCount" class="form-input-box-price">
      </div>
      <div class="form-input-box">
        <label>販売価格：</label>
        <input type="text" name="sellingPrice" class="form-input-box-price">
      </div>
      <div class="form-input-box">
        <label>商品説明：</label>
        <textarea name="productDetail"></textarea>
      </div>
    </div>
  </form>
</body>
</html>