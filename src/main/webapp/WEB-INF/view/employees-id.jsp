<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11.02.2024
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Данные о работнике ${employee.fullName}</h2>
<ul>
  <li>ФИО: ${employee.fullName}</li>
  <li>Зарплата: ${employee.salary}</li>
    <li>Id руководителя: ${employee.supervisorId}</li>

</ul>
<a href="/employee/delete/${employee.id}">Удалить работника</a>  <br>
<a href="/employee/update/${employee.id}">Обновить данные работника</a>

</body>
</html>
