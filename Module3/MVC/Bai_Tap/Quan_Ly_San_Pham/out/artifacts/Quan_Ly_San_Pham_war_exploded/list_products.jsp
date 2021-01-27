<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2021
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<p>
    <a href="?actionUser=create" style="color: darkorange">Thêm mới sản phẩm</a>
</p>
<table class="table table-striped">
    <tr>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Nhà sản xuất</th>
        <th scope="col">Giá</th>
        <th scope="col">Ảnh</th>
        <th scope="col">Sửa</th>
        <th scope="col">Xoá</th>
    </tr>
    <c:forEach items="${productsListFromServlet}" var="product">
    <tr>
        <td scope="row"><c:out value="${product.name}"/></td>
        <td><c:out value="${product.manufacturer}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td><img src="<c:out value="${product.image}"/>" style="width: 150px;height: 150px"></td>
        <td><a href="?actionUser=edit&name=${product.name}">Sửa</a></td>
        <td><a href="?actionUser=delete&name=${product.name}">Xoá</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
