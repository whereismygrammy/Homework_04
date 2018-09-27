<%--
  Created by IntelliJ IDEA.
  User: tom
  Date: 25.09.18
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

${empty param.author ? "" : "<p> Wybrany autor ".concat(param.author).concat("</p>")}

</body>
</html>
