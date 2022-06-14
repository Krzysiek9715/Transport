<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 06.06.2022
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
<head>
    <title>Title</title>
</head>
<br>
ID ładunku:
<c:out value="${export.id}"/></br>
Miejsce załadunku:
<c:out value="${export.loadCity}"/></br>
Miejsce rozładunku:
<c:out value="${export.unloadCity}"/></br>
Kilometry:
<c:out value="${export.kilometers}"/></br>
Stawka EURO/KM:
<c:out value="${euroForKm}"/>

</body>
</html>
