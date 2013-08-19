<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:if test="${error != null}">
    <div class="alert alert-error">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>ERROR:&nbsp;</strong>${error}
    </div>
</c:if>
<form class="form-signin" action="../j_spring_security_check" method="post" >
    <h2 class="form-signin-heading">Please sign in</h2>
    <input type="text" class="input-block-level" placeholder="Username" id="j_username" name="j_username">
    <input type="password" class="input-block-level" placeholder="Password" id="j_password" name="j_password">
    <button class="btn btn-large btn-primary" type="submit">Log In</button>
    <a href="${contextPath}/user/signup" class="btn btn-large btn">Sign Up</a>
</form>

<script>
    window.onload = function()
    {
        document.getElementById("j_username").focus();
    };
</script>