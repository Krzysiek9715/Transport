<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 03.06.2022
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Dodaj ładunek</title>
</head>
<body>


<form:form method="post" modelAttribute="load">
    Miejsce załadunku:
    <form:input path="loadCity"/>
    Długość trasy:
    <form:input path="kilometers"/>
    Miejsce rozładunku:
    <form:input path="unloadCity"/>
    Stawka:
    <form:input path="price"/>
    Czy potrzebujesz powrót?
    <form:select path="loadImport">
        <form:option value="-" label="--Proszę wybrać--"/>
        <form:options items="${loadImport}"/>
    </form:select>
    Id kierowcy:
    <form:input path="drivers"/>
    <input type="submit" value="Dodaj">
</form:form>

</body>

</html>
