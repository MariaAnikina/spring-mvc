<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11.02.2024
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Список сотрудников руководителя с id = "${supervisorId}"</h2>
<ul>
<c:forEach var="employee" items="${employees}">
   <li> <a href="/employee/${employee.id}">${employee.fullName}</a> </li>
</c:forEach>
    </ul>
</body>
</html>
