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
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div id="welcome" class="card-title"><b>Products</b></div>
<div id="shop">
    <ul>
        <li><a href="frontservlet?command=UserLogin">Home</a></li>
        <li><a href="frontservlet?command=ViewProducts">All Products</a></li>
        <li><a href="frontservlet?command=ViewCategory">Roast</a></li>
        <li><a href="frontservlet?command=ViewCart">Cart</a></li>
        <li><a href=""></a> </li>
        <li><a href="index.jsp">Logout</a> </li>
        <li>
            <div id = "search">
                <form action="frontservlet?command=SearchProduct" method="post">
                    <input type="text" name="name">
                    <input type="submit" value="Search">
                </form>
            </div>
        </li>
    </ul>

</div>
<div class="container">
    <div id="product" class="table">
        <table width="100%" align="center">
            <tr>
                <th width="15%" align="center"><b>Product Name</b></th>
                <th width="40%" align="center"><b>Info</b></th>
                <th width="15" align="center"><b>Price</b></th>
                <th width="15%" align="center"><b>Weight</b></th>
                <th><b></b></th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.info}</td>
                    <td>${product.price}</td>
                    <td>${product.weight}</td>
                    <td>
                        <a href="frontservlet?command=ViewProductCategory&product=${product.productId}"
                                methods="post" role="button">Select Roast</a></td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
