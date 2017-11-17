<%--
  Created by IntelliJ IDEA.
  User: jwlv
  Date: 2017/11/17
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>

<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resources/style.css"/>"/>
</head>
<body>
    <div id="header">
        <t:insertAttribute name="header"/><%--插入头部--%>
    </div>
    <div id="content">
        <t:insertAttribute name="body"/><%--插入body--%>
    </div>
    <div id="footer">
        <t:insertAttribute name="footer"/><%--footer--%>
    </div>
</body>
</html>
