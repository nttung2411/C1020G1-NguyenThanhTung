<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result: </h1>
<c:if test="${requestScope.result == 'Infinity'}">
    <p>Cannot division by zero</p>
</c:if>

<c:if test="${requestScope.result != 'Infinity'}">
    <p><%=request.getAttribute("firstNumber")%> <%=request.getAttribute("operator")%>
        <%=request.getAttribute("secondNumber")%>
        = <%=request.getAttribute("result")%></p>
</c:if>
</body>
</html>
