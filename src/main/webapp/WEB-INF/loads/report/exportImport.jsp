<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 06.06.2022
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Export:</br>
ID exportu:
<c:out value="${export.id}"/></br>
Miejsce załadunku:
<c:out value="${export.loadCity}"/></br>
Miejsce rozładunku:
<c:out value="${export.unloadCity}"/></br>
Kilometry:
<c:out value="${export.kilometers}"/></br>
Import:</br>
ID importu:
<c:out value="${importLoad.id}"/></br>
Miejsce załadunku:
<c:out value="${importLoad.loadCity}"/></br>
Miejsce rozładunku:
<c:out value="${importLoad.unloadCity}"/></br>
Kilometry:
<c:out value="${importLoad.kilometers}"/></br>
Suma kilometrów:</br>
<c:out value="${sumKilometers}"/></br>
Całkowita stawka:</br>
<c:out value="${sumPrice}"/></br>
Stawka:</br>
<c:out value="${euroForKm}"/></br>


<%--<a href="<c:out value="/"/>">Menu główne</a>--%>

</body>
</html>