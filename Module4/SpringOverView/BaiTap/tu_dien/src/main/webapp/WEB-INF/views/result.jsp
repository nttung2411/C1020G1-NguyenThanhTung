<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/22/2021
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dịch</title>
</head>
<body>
<c:if test ="${tiengViet != 'Không tìm thấy'}">
    <p>Nghĩa của từ ${tiengAnh} là ${tiengViet}</p>
</c:if>

<c:if test ="${tiengViet == 'Không tìm thấy'}">
    <p>${tiengViet}</p>
</c:if>
</body>
</html>
