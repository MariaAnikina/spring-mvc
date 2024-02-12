
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Список всех работников</h2>
<ul>
    <c:forEach var="empl" items="${employees}">
        <li> <a href="/employee/${empl.id}">${empl.fullName}</a> </li>
    </c:forEach>
</ul>
<br>
</body>
</html>
