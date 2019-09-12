<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/9/12
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Manage Platform</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="welcome">Product Management</div>
<div id="navi">
    <ul>
        <li><a href="frontservlet?command=AdminProduct">Product Management</a></li>
        <li><a href="frontservlet?command=AdminCategory">Category Management</a></li>
        <li><a href="frontservlet?command=AdminOrder">OrderManagement</a></li>
        <li><a href="index.jsp">Logout</a></li>
    </ul>
</div>
<div id="product">
    <form action="frontservlet?command=AdminAddRelation&product=${product.productId}" method="post">
        <table width="100%" align="left">
            <tr>
                <th width="15%"><b>Roast</b></th>
                <th><b>Select</b></th>
            </tr>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td align="center">${category.categoryName}</td>
                    <td><input type="checkbox" name="category" value="${category.categoryName}"></td>
                </tr>
            </c:forEach>
            <button type="submit" class="btn-light">Confirm</button>
            <button type="button" class="btn btn-light" onclick="history.go(-1);">Cancel</button>
        </table>
    </form>
</div>
</body>
</html>
