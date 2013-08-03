<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Environment</title>
</head>
<body>
<table>
    <c:forEach items="${envs}" var="env">
        <tr>
            <td>${env.key}</td>
            <td>${env.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>