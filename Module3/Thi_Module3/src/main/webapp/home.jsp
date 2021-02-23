<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/29/2021
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  <style>
    .header img {
      float: left;
      height: 90%;
      width: 30%;
    }

    .header h5 {
      color: lawngreen;
      float: right;
      padding: 5%;
    }

    .margin-navbar{
      margin-left: 20%;
      margin-right: 0;
    }

    a:hover{
      text-decoration: underline black !important;
    }

    .width-text{
      width: 100px;
    }
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="header">
    <div class="row">
      <div class="col-lg-6">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8J4JNkaxhycCMm6CKvcQWe9ea0ge-tib3PQ&usqp=CAU">
      </div>
      <div class="col-lg-6">
        <h5>Nguyễn Thanh Tùng</h5>
      </div>
    </div>
  </div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto margin-navbar">
      <li class="nav-item active margin-navbar">
        <a class="nav-link width-text" href="?actionUser=home">Trang Chủ<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active margin-navbar">
        <a class="nav-link width-text" href="?actionUser=listProduct">Danh Sách</a>
      </li>
      <li class="nav-item active margin-navbar">
        <a class="nav-link width-text" href="?actionUser=addProduct">Tạo Mới</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</body>
</html>
