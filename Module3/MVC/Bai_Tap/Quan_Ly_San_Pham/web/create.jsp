<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Tạo mới sản phẩm</h1>
<form method="post">
    <fieldset>
        <legend>Tạo sản phẩm mới</legend>
<table>
    <tr>
        <td>Tên sản phẩm</td>
        <td><input type="text" name="name"></td>
    </tr>

    <tr>
        <td>Nhà sản xuất</td>
        <td><input type="text" name="manufacturer"></td>
    </tr>

    <tr>
        <td>Giá</td>
        <td><input type="text" name="price"></td>
    </tr>

    <tr>
        <td>Ảnh</td>
        <td><input type="text" name="image"></td>
    </tr>

    <tr>
        <td></td>
        <td><input type="submit" value="Đồng ý"></td>
    </tr>
</table>
    </fieldset>
</form>
</body>
</html>
