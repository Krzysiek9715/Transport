<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 29.05.2022
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add driver</title>
</head>
<body>

<form:form method="post" modelAttribute="driver">
    Imię:
    <form:input path="firstName"/>
    Nazwisko:
    <form:input path="lastName"/>
    Seria i numer dowodu osobistego:
    <form:input path="idSerialNumber"/>
    Numer telefonu:
    <form:input path="phoneNumber"/>
    Id auta:
    <form:input path="cars"/>
    <input type="submit" value="Dodaj">
</form:form>

</body>
</html>
