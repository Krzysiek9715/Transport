<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 03.06.2022
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edytuj dane ładunku</title>
</head>
<body>
<c:url var="edit" value="/loads/edit"/>
<form:form method="POST" modelAttribute="load" action="${edit}">
    <form:hidden path="id"/>
    Miejsce załadunku:
    <form:input path="loadCity"/>
    <form:errors path="loadCity"/>
    Długość trasy:
    <form:input path="kilometers"/>
    <form:errors path="kilometers"/>
    Miejsce rozładunku:
    <form:input path="unloadCity"/>
    <form:errors path="unloadCity"/>
    Stawka:
    <form:input path="price"/>
    <form:errors path="price"/>
    Czy konieczny powrót
    <form:select path="loadImport">



<%--        SPRAWDZIĆ--%>
<%--        <form:option label="--Proszę wybrać--" value="null"/>--%>


        <form:options items="${loadImport}"/>
    </form:select>
    <form:errors path="loadImport"/>
    Id kierowcy realizującego transport:
    <form:input path="drivers"/>
    <form:errors path="drivers"/>
    Id importu:
    <form:input path="importLoads"/>
    <form:errors path="importLoads"/>
    <input type="submit" value="SAVE EDIT">
</form:form>
</body>
</html>
