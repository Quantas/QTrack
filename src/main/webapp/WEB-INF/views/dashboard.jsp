<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h3>Dashboard</h3>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span5">
            <h5>Projects</h5>
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>Tag</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${projects}" var="project">
                    <tr>
                        <td><a href="${contextPath}/issue/project/${project.id}">${project.projectTag}</a></td>
                        <td>${project.projectName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="span6">
            <h5>Recent Issues</h5>
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${issues}" var="issue">
                    <tr>
                        <td>${issue.id}</td>
                        <td>${issue.title}</td>
                        <td>${issue.issueStatus.levelName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${loggedInUser != null}">
                <h5>My Issues</h5>
                <table class="table table-condensed">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${myIssues}" var="issue">
                        <tr>
                            <td>${issue.id}</td>
                            <td>${issue.title}</td>
                            <td>${issue.issueStatus.levelName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>