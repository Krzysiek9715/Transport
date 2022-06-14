<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 13.06.2022
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Edytuj dane użytkownika</title>
</head>
<body>
<c:url var="edit" value="/users/edit"/>
<form:form method="POST" modelAttribute="user" action="${edit}">
    <form:hidden path="id"/>
    Nazwa użytkownika:
    <form:input path="username"/>
    <form:errors path="username"/>
    Hasło:
    <form:input type="password" path="password"/>
    Imię:
    <form:input path="firstName"/>
    <form:errors path="firstName"/>
    Nazwisko:
    <form:input path="lastName"/>
    <form:errors path="lastName"/>
    Email:
    <form:input path="email"/>
    <form:errors path="email"/>
    ID kierowcy:
    <form:input path="drivers"/>
    <form:errors path="drivers"/>
    Funkcja
    <form:select path="role">
        <form:option value=" " label="--Proszę wybrać--"/>
        <form:options items="${roles}" itemValue="id" itemLabel="name"/>
    </form:select>
    <input type="submit" value="SAVE EDIT">
</form:form>
</body>
</html>
