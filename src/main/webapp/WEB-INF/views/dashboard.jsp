<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h3>Welcome to the Dashboard</h3>
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
        <div class="span2">
            &nbsp;
        </div>
        <div class="span6">
            &nbsp;
        </div>
    </div>
</div>