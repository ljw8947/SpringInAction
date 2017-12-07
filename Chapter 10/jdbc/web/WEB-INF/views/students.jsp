<%--
  Created by IntelliJ IDEA.
  User: jwlv
  Date: 2017/12/6
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>students</title>
</head>
<body>
    <a href="/addStudent">addStudent</a><br/>
    <label>StudentList</label>
    <c:forEach items="${studentList}" var="student">
        <li id="<c:out value="student.studentID"/>">
            <c:out value="${student.name}"/>--
            <c:out value="${student.gender}"/>--
            <c:out value="${student.birthday}"/>--
        </li>
    </c:forEach>

</body>
</html>
