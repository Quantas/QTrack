<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h3>Issues</h3>
<table class="table">
    <thead>
        <tr>
            <th>Title</th>
            <th>Status</th>
            <th>Description</th>
            <th>Project</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${issues}" var="issue">
        <tr>
            <td>${issue.title}</td>
            <td>${issue.issueStatus.levelName}</td>
            <td>${issue.desc}</td>
            <td><a href="${contextPath}/project/${issue.project.id}">${issue.project.projectTag}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${contextPath}/issue/add" class="btn btn-small">Add</a>