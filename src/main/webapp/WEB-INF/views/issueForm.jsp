<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="issue" action="${pageContext.request.contextPath}/issue/save">
    <form:hidden path="id" />
    <table>
        <tbody>
        <tr>
            <td>Name</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><form:input path="desc" /></td>
        </tr>
        <tr>
            <td>Status</td>
            <td><form:select path="issueStatus" items="${statusList}" /></td>
        </tr>
        <tr>
            <td>Project</td>
            <td><form:select path="project" items="${projectList}" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>