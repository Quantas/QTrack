<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h3>Projects</h3>
<c:if test="${error != null}">
    <div class="alert alert-error">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>ERROR:&nbsp;</strong>${error}
    </div>
    <br />
</c:if>
<table class="table">
    <thead>
        <tr>
            <th>Tag</th>
            <th>Name</th>
            <th>Description</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td><a href="${contextPath}/issue/project/${project.id}">${project.projectTag}</a></td>
            <td>${project.projectName}</td>
            <td>${project.projectDesc}</td>
            <td><a href="${contextPath}/project/edit/${project.id}">Edit</a></td>
            <td><a href="${contextPath}/project/delete/${project.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${contextPath}/project/add" class="btn btn-small">Add</a>