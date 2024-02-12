<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Список руководителей</h2>
<ul>
<c:forEach var="supervisor" items="${supervisors}">
   <li> <a href="/supervisor/${supervisor.id}">${supervisor.fullName}</a> </li>
</c:forEach>
    </ul>
<br>
<a href="/supervisor/add">Добавить руководителя</a>  <br>
<a href="/employee">Получить всех работников</a>
</body>
</html>
