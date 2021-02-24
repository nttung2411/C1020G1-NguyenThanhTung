<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/24/2021
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Settings</title>
  </head>
  <body>
  <h1>Setting</h1>
  <form:form modelAttribute="settingMail" action="/update">
    <table>
      <tr>
        <th>Languages</th>
        <td><form:select path="languages">
          <form:options items="${language}"/>
        </form:select></td>
      </tr>
      <tr>
        <th>Page Size:</th>
        <td><form:select path="pageSize">
          <form:options items="${pageSize}"/>
        </form:select></td>
      </tr>
      <tr>
        <th>Spams filter:</th>
        <td><form:checkbox path="spamsFilter"/>
            Enable spams filter</td>
      </tr>
      <tr>
        <th>Signature:</th>
        <td><form:textarea path="signature"/></td>
      </tr>
      <tr>
        <th></th>
        <td><input type="submit" value="Update">
            <input type="submit" value="Cancel"></td>
      </tr>
    </table>
  </form:form>
  </body>
</html>
