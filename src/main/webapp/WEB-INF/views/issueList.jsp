<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h3>${project.projectTag} Issues</h3>
<table class="table">
    <thead>
        <tr>
            <th>Title</th>
            <th>Status</th>
            <th>Creator</th>
            <th>Assignee</th>
            <th>Create Date</th>
            <th>Project</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${issues}" var="issue">
        <tr>
            <td>${issue.title}</td>
            <td>${issue.issueStatus.levelName}</td>
            <td>${issue.createdBy.firstName}&nbsp;${issue.createdBy.lastName}</td>
            <td>${issue.assignedTo.firstName}&nbsp;${issue.assignedTo.lastName}</td>
            <td><joda:format value="${issue.createdDate}" style="SM" /></td>
            <td><a href="${contextPath}/project/${issue.project.id}">${issue.project.projectTag}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${contextPath}/issue/add" class="btn btn-small">Add</a>