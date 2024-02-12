<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h2> Обновление работника </h2>

<br><br>

<form:form method="post" action="/employee/updateEmployee/${id}" modelAttribute="employee">

  ФИО <form:input path="fullName"/>
  <form:errors path="fullName"/>
  <br>
  Зарплата <form:input path="salary"/>
  <form:errors path="salary"/>
  <br>
  id руководителя <form:input path="supervisorId"/>
  <form:errors path="supervisorId"/>
  <br>
  <input type="submit" value="OK">

</form:form>
</body>
</html>