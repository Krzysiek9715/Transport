<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 29.05.2022
  Time: 22:08
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
<c:url var="edit" value="/drivers/edit"/>
<form:form method="POST" modelAttribute="driver" action="${edit}">
    <form:hidden path="id"/>
    Imię:
    <form:input path="firstName"/>
    <form:errors path="firstName"/>
    Nazwisko:
    <form:input path="lastName"/>
    <form:errors path="lastName"/>
    Numer dowodu:
    <form:input path="idSerialNumber"/>
    <form:errors path="idSerialNumber"/>
    Numer telefonu:
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    Id samochodu:
    <form:input path="cars"/>
    <form:errors path="cars"/>
    <input type="submit" value="SAVE EDIT">
</form:form>
</body>
</html>
