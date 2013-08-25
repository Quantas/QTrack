<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<form:form method="POST" commandName="signupUser" action="${pageContext.request.contextPath}/user/save" cssClass="form-signin">
    <table>
        <tbody>
        <tr>
            <td>User Name&nbsp;<span class="formError"><form:errors path="userName" /></span></td>
        </tr>
        <tr>
            <td><form:input path="userName" /></td>
        </tr>
        <tr>
            <td>Password&nbsp;<span class="formError"><form:errors path="password" /></span></td>
        </tr>
        <tr>
            <td><form:password path="password" /></td>
        </tr>
        <tr>
            <td>Confirm Password&nbsp;<span class="formError"><form:errors path="confirmPassword" /></span></td>
        </tr>
        <tr>
            <td><form:password path="confirmPassword" /></td>
        </tr>
        <tr>
            <td>First Name&nbsp;<span class="formError"><form:errors path="firstName" /></span></td>
        </tr>
        <tr>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name&nbsp;<span class="formError"><form:errors path="lastName" /></span></td>
        </tr>
        <tr>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td>Email Address&nbsp;<span class="formError"><form:errors path="email" /></span></td>
        </tr>
        <tr>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><button class="btn btn-primary" type="submit">Sign Up</button></td>
        </tr>
        </tbody>
    </table>
</form:form>

<script>
    window.onload = function()
    {
        document.getElementById("userName").focus();
    };
</script>