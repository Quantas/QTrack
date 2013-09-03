<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h3>Users</h3>
<table class="table">
    <thead>
    <tr>
        <th>Username</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Active</th>
        <th>Roles</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.userName}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.active}</td>
            <td>
                <c:forEach items="${user.roles}" var="role">
                    ${role.roleName}&nbsp;
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${contextPath}/admin/user/add" class="btn btn-small">Add</a>