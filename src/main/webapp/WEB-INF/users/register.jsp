<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 09.06.2022
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj użytkownika</title>
</head>
<body>

<form:form method="post" modelAttribute="user">
    Imię:
    <form:input path="firstName" placeholder ="Imię użytkownika"/>
    Nazwisko:
    <form:input path="lastName" placeholder = "Nazwisko"/>
    Email:
    <form:input type="email" path="email" placeholder = "E-mail"/>
    Funkcja:
    <form:select path="role">
        <form:option value="-" label="--Proszę wybrać--"/>
        <form:options items="${roles}" itemValue="id" itemLabel="name"/>
    </form:select>
    Nazwa użytkownika:
    <form:input path="username" placeholder = "login"/>
    Hasło:
    <form:input type="password" path="password"/>
    <input type="submit" value="Dodaj">
</form:form>

</body>
</html>
