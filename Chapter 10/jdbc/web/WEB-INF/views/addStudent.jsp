<%--
  Created by IntelliJ IDEA.
  User: jwlv
  Date: 2017/12/6
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AddStudent</title>
</head>
<body>
    <sf:form modelAttribute="student" method="post">
        <label>Name:</label><sf:input path="name"/><br/>
        <label>Gender:</label>
        boy:<sf:radiobutton path="gender" value="1"/>
        girl:<sf:radiobutton path="gender" value="2"/><br/>
        <label>Birthday:</label><sf:input path="birthday"/><br/>
        <input type="submit" value="submit"/>
    </sf:form>
</body>
</html>
