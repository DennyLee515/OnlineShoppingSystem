<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/9/12
  Time: 23:21
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
    <table width="100%" align="left">
        <tr>
            <th width="15%"><b>Product Name</b></th>
            <th width="40%"><b>Info</b></th>
            <th width="15"><b>Price</b></th>
            <th width="15%"><b>Weight</b></th>
            <th><b></b></th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td align="center">${product.productName}</td>
                <td align="center">${product.info}</td>
                <td align="center">${product.price}</td>
                <td align="center">${product.weight}</td>
                <td>
                    <a
                            href="frontservlet?command=AdminDeleteRelation&category=${category.categoryId}&product=${product.productId}"
                       methods="post" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        <button type="button" class="btn btn-light" onclick="history.go(-1);">Cancel</button>
    </table>
    <br>

</div>
</body>
</html>
