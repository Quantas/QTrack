<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<form:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/user/save" cssClass="form-signin">
    <table>
        <tbody>
        <tr>
            <td>User Name</td>
            <td><form:input path="user.userName" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:password path="user.password" /></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><form:password path="confirmPassword" /></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><form:input path="user.firstName" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><form:input path="user.lastName" /></td>
        </tr>
        <tr>
            <td>Email Address</td>
            <td><form:input path="user.email" /></td>
        </tr>
        <tr>
            <td><button class="btn btn-primary" type="submit">Sign Up</button></td>
        </tr>
        </tbody>
    </table>
</form:form>