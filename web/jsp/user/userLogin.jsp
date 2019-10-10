<%--
  Created by IntelliJ IDEA.
  User: DennyLee
  Date: 2019/10/1
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="security.AppSession" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
    <title>York Way Coffee</title>
</head>
<body>
<shiro:notAuthenticated>
    <form action="frontservlet?command=Login" method="post">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" value="Login">
    </form>
    <div><a href="frontservlet?command=ForwardRegister">Sign up</a> </div>
</shiro:notAuthenticated>
<shiro:authenticated>

    You are already logged in as <%=AppSession.getUser().getUsername()%>
    <div class="float-left">
        <button type="button" class="btn btn-light" onclick="history.go(-1);">Back</button>
    </div>
</shiro:authenticated>
</body>
</html>
