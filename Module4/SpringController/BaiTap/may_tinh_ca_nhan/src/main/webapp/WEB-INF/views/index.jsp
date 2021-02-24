<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/23/2021
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/result">
<input type="text" name="number1">
<input type="text" name="number2">
<br>
<br>
<button type="submit" value="+" name="calculator">Addition(+)</button>
<button type="submit" value="-" name="calculator">Subtraction(-)</button>
<button type="submit" value="*" name="calculator">Multiplication(X)</button>
<button type="submit" value="/" name="calculator">Division(/)</button>
</form>

<h4>${result}</h4>
</body>
</html>
