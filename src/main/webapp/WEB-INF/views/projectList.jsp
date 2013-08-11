<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>QTrack | Project List</title>
</head>
<body>
<%@include file="header.jsp"%>
<table border="1" style="border-collapse:collapse">
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.projectTag}</td>
            <td>${project.projectName}</td>
            <td>${project.projectDesc}</td>
            <td><a href="${contextPath}/project/edit/${project.id}">Edit</a></td>
            <td><a href="${contextPath}/project/delete/${project.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${contextPath}/project/add">Add</a>
</body>
</html>