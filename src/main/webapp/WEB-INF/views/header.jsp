<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<security:authentication var="user" property="principal" />

<div id="header">
    <div id="header-left">
        QTrack
    </div>
    <div id="header-right">
        <security:authorize access="isAuthenticated()">
            ${user.username}&nbsp;|&nbsp;<a href="${contextPath}/auth/logout">Logout</a>
        </security:authorize>
        <security:authorize access="!isAuthenticated()">
            <a href="${contextPath}/auth/login">Login</a>
        </security:authorize>
    </div>
</div>
<br />