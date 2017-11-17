<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: jwlv
  Date: 2017/11/7
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1>Register</h1>
    <sf:form method="post" commandName="spitter">
        First Name:<sf:input path="firstName"/>
        <sf:errors path="firstName" cssClass="error" element="span" /><br/>
        Last Name:<sf:input path="lastName"/>
        <sf:errors path="lastName" cssClass="error" /><br/>
        Email:<sf:input path="email"/>
        <sf:errors path="email" cssClass="error" /><br/>
        Username:<sf:input path="username"/>
        <sf:errors path="username" cssClass="error" /><br/>
        Password:<sf:input path="password"/>
        <sf:errors path="password"  cssClass="error" /><br/>
        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>
