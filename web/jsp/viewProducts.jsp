<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/9/6
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>York Way Coffee</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="welcome">Products</div>
<div id="navi">
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="frontservlet?command=ViewShop">Shop Coffee</a></li>
        <li><a href="frontservlet?command=ViewCart">Cart</a></li>
        <li><a href="">My Account</a></li>
    </ul>
</div>
<div id="shop">
    <ul>
        <li><a href="frontservlet?command=ViewProducts">All Products</a></li>
        <li><a href="frontservlet?command=ViewCategories">Origins</a></li>
    </ul>
    <div id="search">
        <form action="frontservlet?command=SearchProduct" method="post">
            Search Coffee<input type="text" name="name">
            <input type="submit" value="Search">
        </form>
    </div>
</div>
<br>
<br>
<div id="product">
    <table width="100%" align="left">
        <tr>
            <th width="15%"><b>Product Name</b></th>
            <th width="40%"><b>Info</b></th>
            <th width="15%"><b>Origin</b></th>
            <th width="15"><b>Price</b></th>
            <th width="15%"><b>Weight</b></th>
            <th><b></b></th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td align="center">${product.productName}</td>
                <td align="center">${product.info}</td>
                <td align="center">${product.categoryId}</td>
                <td align="center">${product.price}</td>
                <td align="center">${product.weight}</td>
                <td>
                    <form action="frontservlet?command=AddToCart&&product=${product.productId}"
                          method=
                                  "post">
                        Amount: <input id="name" type="text" name="amount" align="left" value="0">
                        <input type="submit" value="Add to cart">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%--<script type="text/javascript">--%>
<%--    function add() {--%>
<%--        var x, text;--%>
<%--        x = document.getElementById("name").value;--%>
<%--        var url = "frontservlet?command=AddToCart&&product=" +${product};--%>
<%--        location.href = url;--%>
<%--    }</script>--%>
</body>
</html>
