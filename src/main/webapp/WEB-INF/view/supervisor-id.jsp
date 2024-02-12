<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11.02.2024
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Данные о работнике ${supervisor.fullName}</h2>
<ul>
    <li>ФИО: ${supervisor.fullName}</li>
    <li>Зарплата: ${supervisor.salary}</li>
    <li>Категория: ${supervisor.category}</li>
    <a href="/employee/employees/${supervisor.id}">Получить список сотрудников руководителя</a> <br>
    <a href="/employee/add/${supervisor.id}">Добавить сотрудника</a>  <br>
    <a href="/supervisor/update/${supervisor.id}">Обновить данные руководителя</a>  <br>
    <a href="/supervisor/delete/${supervisor.id}">Удалить руководителя</a>
</ul>
</body>
</html>
