<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/9/6
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewAllProducts</title>
</head>
<body>
<c:forEach var="products" items="${products}">
    <h1>${products}</h1>
</c:forEach>
</body>
</html>
