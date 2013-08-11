<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>QTrack | Project List</title>
</head>
<body>
<%@include file="header.jsp"%>
<form:form method="POST" modelAttribute="project" action="${pageContext.request.contextPath}/project/save">
    <form:hidden path="id" />
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="projectName" /></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="projectDesc" /></td>
        </tr>
        <tr>
            <td>Project Tag:</td>
            <td><form:input path="projectTag" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

</body>
</html>