<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<style>
    th, td {
        text-align: center;
    }
</style>
<body>
<table class="table table-hover">
        <tr>
            <th scope="col">Tên Khách Hàng</th>

            <th scope="col">Ngày Sinh</th>

            <th scope="col">Địa Chỉ</th>

            <th scope="col">Ảnh</th>
        </tr>
    <c:forEach var="customer" items="${customerListServlet}">
    <tr>
      <td><c:out value="${customer.name}"/></td>

      <td><c:out value="${customer.dateOfBirth}"/></td>

      <td><c:out value="${customer.address}"/></td>


      <td><img src="<c:out value="${customer.image}"/>" style="width: 100px;height: 100px"></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
