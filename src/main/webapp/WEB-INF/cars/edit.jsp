<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 30.05.2022
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Edytuj dane kierowcy</title>
</head>
<body>
<c:url var="edit" value="/cars/edit"/>
<form:form method="POST" modelAttribute="car" action="${edit}">
    <form:hidden path="id"/>
    Numery rejestracyjne:
    <form:input path="plates"/>
    <form:errors path="plates"/>
    Marka:
    <form:input path="brand"/>
    <form:errors path="brand"/>
    Rok produkcji:
    <form:input path="yearOfProduction"/>
    <form:errors path="yearOfProduction"/>
    Kierowca:
    <form:input path="driver"/>
    <form:errors path="driver"/>
    <input type="submit" value="SAVE EDIT">
</form:form>
</body>
</html>
