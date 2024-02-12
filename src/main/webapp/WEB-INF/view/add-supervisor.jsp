<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h2> Добавление руководителя </h2>

<br><br>

<form:form method="post" action="createSupervisor" modelAttribute="supervisor">

  ФИО <form:input path="fullName"/>
  <form:errors path="fullName"/>
  <br>
  Зарплата <form:input path="salary"/>
  <form:errors path="salary"/>
  <br>
  Категория <form:select path="category">
  <form:errors path="category"/>
  <form:option value="1"/>
  <form:option value="2"/>
</form:select>
<br><br>

<input type="submit" value="OK">

</form:form>
</body>
</html>