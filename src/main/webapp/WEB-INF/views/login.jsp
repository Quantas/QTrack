<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<h1>Login</h1><div id="login-error">

    <!-- TODO check j_spring_security_check... -->
    ${error}</div><form action="../j_spring_security_check" method="post" >
    <p>
        <label for="j_username">Username</label>
        <input id="j_username" name="j_username" type="text" />
    </p><p>

    <label for="j_password">Password</label>
    <input id="j_password" name="j_password" type="password" />
</p><input  type="submit" value="Login"/>

</form>