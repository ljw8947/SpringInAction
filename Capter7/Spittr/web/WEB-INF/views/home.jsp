<%--
  Created by IntelliJ IDEA.
  User: jwlv
  Date: 2017/10/27
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <h1><s:message code="spittr.welcome"/> </h1>
        <a href="<s:url value="/spittles"/>">Spittles</a>|
        <s:url value="/spitter/register" var ="register_url" />
        <a href="${register_url}">Register</a><br/>
        <a href="<s:url value="/spitter/errorone"/>">将异常映射为特定的状态码</a><br/>
        <a href="<s:url value="/spitter/errortwo"/>">编写处理异常的方法</a>|
    </body>
</html>
