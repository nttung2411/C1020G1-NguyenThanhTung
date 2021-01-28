<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
  <h1>User Management</h1>
  <h2>
    <a href="?action=create">Add New User</a>
  </h2>
  <form>
    <input type="hidden" name="action" value="countryUser">
    <input type="text" name="country" placeholder="Tìm kiếm...">
    <input type="submit" value="Tìm kiếm">
  </form>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of Users</h2></caption>
    <tr>
      <a href="?action=Sort">Sort By Name</a>
    </tr>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${listUser}">
      <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
        <td>
          <a href="?action=edit&id=${user.id}">Edit</a>
          <a href="?action=delete&id=${user.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>