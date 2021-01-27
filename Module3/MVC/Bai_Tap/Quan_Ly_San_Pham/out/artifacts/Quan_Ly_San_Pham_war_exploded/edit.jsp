<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>Tên sản phẩm: </td>
                <td><input type="text" name="name" value="${requestScope.product.name}" disabled></td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td><input type="text" name="manufacturer" value="${requestScope.product.manufacturer}"></td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td><input type="text" name="price" value="${requestScope.product.price}"></td>
            </tr>

            <tr>
                <td>Ảnh: </td>
                <td><input type="text" name="image" value="${requestScope.product.image}"></td>
            </tr>

            <tr>
                <td><input type="submit" value="Đồng ý"></td>
                <td><a href="">Trang chủ</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
