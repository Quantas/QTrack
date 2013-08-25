<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<form class="form-signin" action="../j_spring_security_check" method="post" >
    <h2 class="form-signin-heading">QTrack Login</h2>
    <input type="text" class="input-block-level" placeholder="Username" id="j_username" name="j_username">
    <input type="password" class="input-block-level" placeholder="Password" id="j_password" name="j_password">
    <button class="btn btn-primary" type="submit">Log In</button>
</form>

<script>
    window.onload = function()
    {
        document.getElementById("j_username").focus();
    };
</script>