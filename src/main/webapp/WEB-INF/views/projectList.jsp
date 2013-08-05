<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>QTrack | Project List</title>
</head>
<body>
<table>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.projectTag}</td>
            <td>${project.projectName}</td>
            <td>${project.projectDesc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>