<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
    <link rel="stylesheet" type="text/css" href="<s:url value="/resources/style.css"/>"/>
</head>
    <body>

        <h1><s:message code="spittr.welcome"/> </h1>
        <a href="<s:url value="/spittles"/>">Spittles</a>|
        <a href="/spitter/register">Register</a>
        <s:url value="/spitter/register" var ="register_url" />
        <a href="${register_url}">tags_Register</a>

    </body>


</html>
