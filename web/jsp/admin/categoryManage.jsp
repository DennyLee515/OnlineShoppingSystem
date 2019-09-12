<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/9/12
  Time: 14:33
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
<div id="welcome">Category Management</div>
<div id="navi">
    <ul>
        <li><a href="frontservlet?command=AdminProduct">Product Management</a></li>
        <li><a href="frontservlet?command=AdminCategory">Category Management</a></li>
        <li><a href="frontservlet?command=AdminOrder">OrderManagement</a></li>
        <li><a href="index.jsp">Logout</a></li>
    </ul>
</div>
<div id="category">
    <table width="100%" align="left">
        <tr>
            <th width="40%"><b>Category Name</b></th>
            <th width="30%"><b> </b></th>
            <th width="30%"><b> </b></th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td align="center">${category.categoryName}</td>
                <td>
                    <a href="frontservlet?command=AdminManageCategory&method=edit&category=${category.categoryId}"
                       methods="post" role="button">Edit</a></td>
                <td>
                    <a href="frontservlet?command=AdminManageCategory&method=delete&category=${category.categoryId}"
                       methods="post" role="button">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <a href="frontservlet?command=AdminManageCategory&method=create"
       methods="post" role="button">Add new Category</a>
</div>
</body>
</html>
