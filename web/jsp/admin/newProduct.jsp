<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/9/12
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div id="welcome">Add Product</div>
<form action="frontservlet?command=AdminAddProduct" method="POST">
    <div class="form-group row">
        <label for="inputProductName" class="col-sm-2 col-form-label">Product Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputProductName" name="productName">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputProductInfo" class="col-sm-2 col-form-label">Information</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputProductInfo" name="info">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputCategoryName" class="col-sm-2 col-form-label">Category</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputCategoryName" name="category">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPrice" class="col-sm-2 col-form-label">Price</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputPrice" name="price">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputWeight" class="col-sm-2 col-form-label">Weight</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputWeight" name="weight">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Confirm</button>
    <button type="button" class="btn btn-light" onclick="history.go(-1);">Cancel</button>
</form>
</body>
</html>
