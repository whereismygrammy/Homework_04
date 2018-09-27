<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 27.09.18
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/flight" method="post">

    <p>Wybierz lotnisko wylotu</br>

        <select name="flightDep">
            <c:forEach items="${list}" var="airport">
                <option value="${airport.code}">${airport.name}</option>
            </c:forEach>
        </select>
    </p>


    <p>Wybierz lotnisko Przylotu</br>

        <select name="flightArr">
            <c:forEach items="${list}" var="airport">
                <option value="${airport.code}">${airport.name}</option>
            </c:forEach>
        </select>
    </p>

    <p>Czas startu</br>
        <input type="datetime-local" name="localtime"></p>

    <p>Długość lotu w godzinach</br>
        <input type="number" min="0" step="1" name="time"></p>

    <p>Cena lotu</br>
        <input type="number" min="0" step="0.01" name="price"></p>


    <input type="submit">
</form>


</body>
</html>
</p>
