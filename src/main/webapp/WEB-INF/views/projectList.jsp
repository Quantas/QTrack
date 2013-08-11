<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:if test="${error != null}">
<div id="error">${error}</div><br />
</c:if>
<table border="1" style="border-collapse:collapse">
    <c:forEach items="${projects}" var="project">
        <tr>
            <td><a href="${contextPath}/issue/project/${project.id}">${project.projectTag}</a></td>
            <td>${project.projectName}</td>
            <td>${project.projectDesc}</td>
            <td><a href="${contextPath}/project/edit/${project.id}">Edit</a></td>
            <td><a href="${contextPath}/project/delete/${project.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${contextPath}/project/add">Add</a>