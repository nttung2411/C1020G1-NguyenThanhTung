<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2021
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>Tên sản phẩm: </td>
                <td>${requestScope.product.name}</td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td>${requestScope.product.manufacturer}</td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td>${requestScope.product.price}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Xoá sản phẩm"></td>
                <td><a href="">Trang chủ</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
