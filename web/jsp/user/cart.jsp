<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/9/7
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>My Cart</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div id="welcome" class="card-title"><b>My Cart</b></div>
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
        <table width="100%">
            <tr>
                <th width="30%"><b>Product Name</b></th>
                <th width="25%"><b>Roast</b></th>
                <th width="15%"><b>Amount</b></th>
                <th width="15%"><b>Subtotal</b></th>
                <th width="15"></th>
            </tr>
            <c:forEach var="cartDetail" items="${cartDetails}">
                <tr>
                    <td>${cartDetail.product.productName}</td>
                    <td>${cartDetail.category.categoryName}</td>
                    <td>${cartDetail.productAmount}</td>
                    <td>${cartDetail.totalPrice}</td>
                    <td><a
                            href="frontservlet?command=DeleteProductInCart&&cartDetail=${cartDetail.cartDetailId}"
                           methods="post" role="button">Delete</a></td></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>