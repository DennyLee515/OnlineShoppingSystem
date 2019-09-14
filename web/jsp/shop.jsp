<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>York Way Coffee</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="welcome">Shop Coffee</div>
<%--<div id="navi">--%>
<%--    <ul>--%>
<%--        <li><a href="index.jsp">Home</a></li>--%>
<%--        <li><a href="frontservlet?command=ViewShop">Shop Coffee</a></li>--%>
<%--        <li><a href="frontservlet?command=ViewCart">CartDetail</a></li>--%>
<%--        <li><a href="">My Account</a> </li>--%>
<%--    </ul>--%>
<%--</div>--%>
<div id="shop">
    <ul>
        <li><a href="frontservlet?command=UserLogin">Home</a></li>
        <li><a href="frontservlet?command=ViewProducts">All Products</a></li>
        <li><a href="frontservlet?command=ViewCategory">Roast</a></li>
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

</body>
</html>
