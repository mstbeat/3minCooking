<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <button type="button" class="submit-btn" onclick="location.href='./product-registration'">登録</button>
  <div class="list-count">商品情報件数 <c:out value="${productDtoList.size()}" /> 件</div>
  <table border="1">
    <tr>
      <th class="table-header">商品ID</th>
      <th class="table-header">ジャンル</th>
      <th class="table-header">メーカー</th>
      <th class="table-header">商品名</th>
      <th class="table-header">販売価格</th>
      <th class="table-header">更新</th>
    </tr>
    <c:forEach var="productDto" items="${productDtoList}">
      <tr>
        <td class="table-right"><c:out value="${productDto.productId}" /></td>
        <td><c:out value="${Genre.getKeyByValue(productDto.genre)}" /></td>
        <td><c:out value="${productDto.maker}" /></td>
        <td><c:out value="${productDto.productName}" /></td>
        <td class="table-right"><c:out value="${productDto.sellingPrice}" /></td>
        <td class="table-center">
          <form  action="./product-edit" method="post">
            <input type="hidden" name="productId" value="${productDto.productId}">
            <input class="update-btn" type="submit" value="更新">
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>