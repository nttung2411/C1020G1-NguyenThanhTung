<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="/calculator">
    <fieldset style="margin-right: 70%">
      <legend>Calculator</legend>
      <label>First operand:</label>
      <input type="number" name="firstNumber" style="margin-left: 20px">
      <br>
      <br>
      <labe>Operator:</labe>
      <select name="operator" style="margin-left: 48px">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
      </select>
      <br>
      <br>
      <label>Second operand:</label>
      <input type="number" name="secondNumber"  style="margin-left: 2px">
      <br>
      <br>
      <input type="submit" value="Calculate" style="margin-left: 113px">
    </fieldset>
  </form>
  </body>
</html>
