<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: jwlv
  Date: 2017/10/27
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
</head>
    <body>
        <h1>Welcome to Spittr</h1>
        <a href="<c:url value="/spittles"/>">Spittles</a>|
        <a href="<c:url value="/spitter/register"/>">Register</a>
    </body>


</html>
