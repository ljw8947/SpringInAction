<%--
  Created by IntelliJ IDEA.
  User: jwlv
  Date: 2017/12/6
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<label>StudentInfo</label><br/>
<c:out value="${student.name}"/><br/>
<c:out value="${student.gender}"/><br/>
<c:out value="${student.birthday}"/><br/><br/>
<a href="/students">back to list</a>
</body>
</html>
