<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 27.09.18
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Księga gości</title>
</head>
<body>

<h3>Księga gości</h3>
<h4>Dodaj wpis</h4>

<form action="/guest-book" method="post">


    <p>Nazwa</br>
        <input type="text" name="name"></p>

    <p>Opis</br>
        <input type="text" name="description"></p>

    <input type="submit">
</form>


<table>

    <tr>
        <td><b>Nazwa</b></td>
        <td><b>Opis</b></td>
    </tr>

    <c:forEach var="bk" items="${book}">

        <tr>
            <td>${bk.name}</td>
            <td>${bk.description}</td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
