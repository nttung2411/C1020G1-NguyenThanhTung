<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/4/2021
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
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

        .error{
            color: red;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>
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
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container-fluid" style="padding: 0">
    <div class="row" style="margin-right: 40px">
        <div class="col-lg-4" style="padding: 0">
            <div class="sidebar">
                <img src="https://dulichtour.vn/wp-content/uploads/2017/05/CauRongDaNang.jpg" style="width: 95%;height:100%">
            </div>
        </div>

        <div class="col-lg-8" style="padding: 0">
            <div class="body" style="text-align: center">
                <h2>Thêm mới sản phẩm</h2>
                <h5 style="color: red"><c:out value="${msgDisplay}"/></h5>
                <form method="post" id="validate">
                    <table cellpadding="5">
                        <tr>
                            <th>Tên sản phẩm:</th>
                            <td>
                                <input type="text" name="name" size="45" required/>
                            </td>
                        </tr>
                        <tr>
                            <th>Giá sản phẩm:</th>
                            <td>
                                <input type="text" name="price" size="45" required/>
                            </td>
                        </tr>
                        <tr>
                            <th>discount:</th>
                            <td>
                                <select name="discount">
                                    <option value="5">5%</option>
                                    <option value="10">10%</option>
                                    <option value="15">15%</option>
                                    <option value="20">20%</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Tồn kho:</th>
                            <td>
                                <input type="text" name="stock" size="45" required/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Tạo mới"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $('#datepicker').datepicker({
        uiLibrary: 'bootstrap'
    });

    $(document).ready(function() {

        //Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
        $("#validate").validate({
            rules: {
                name : "required",
                price: "required",
                stock: "required",
            },
            messages: {
                name: "Không được bỏ trống",
                price : "Không được bỏ trống",
                stock : "Không được bỏ trống"
            }
        });
    });
</script>
</body>
</html>
