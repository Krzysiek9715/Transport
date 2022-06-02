<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 30.05.2022
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj samochód</title>
</head>
<body>

<form:form method="post" modelAttribute="car">
Numery rejestracyjne:
    <form:input path="plates"/>
Marka:
    <form:input path="brand"/>
Rok produkcji:
    <form:input path="yearOfProduction"/>
    Kierowca:
    <form:input path="driver"/>
<input type="submit" value="Dodaj">
</form:form>
</body>
</html>
