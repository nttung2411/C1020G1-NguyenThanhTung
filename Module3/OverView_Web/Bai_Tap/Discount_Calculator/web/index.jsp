<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/22/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Discount Calculator</title>
  </head>
  <body>
  <form method="post" action="/calculator">
    <label>Tên sản phẩm: </label>
    <input type="text" name="nameProduct" placeholder="Nhập tên sản phẩm" style="width: 15%">
    <br>
    <br>
    <label>Giá niêm yết: </label>
    <input type="text" name="priceProduct" placeholder="Nhập giá sản phẩm" style="width: 10%">
    <br>
    <br>
    <label>Chiết khấu: </label>
    <input type="text" name="discountProduct" placeholder="Chiết khấu" style="width: 10%">
    <br>
    <input type="submit" value="Nhập">
  </form>
  </body>
</html>
