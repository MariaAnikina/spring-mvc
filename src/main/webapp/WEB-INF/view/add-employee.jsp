<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11.02.2024
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/employee/createEmployee/${supervisorId}" modelAttribute="employee">

    ФИО <form:input path="fullName"/>
    <form:errors path="fullName"/>
    <br>
    Зарплата <form:input path="salary"/>
    <form:errors path="salary"/>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
