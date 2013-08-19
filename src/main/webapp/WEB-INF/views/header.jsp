<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<security:authentication var="user" property="principal" />

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="${contextPath}/">QTrack</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li><a href="${contextPath}/project/all">Projects</a></li>
                    <li><a href="${contextPath}/issue/all">Issues</a></li>
                    <security:authorize access="isAuthenticated()">
                        <li>
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">${loggedInUser.userName}&nbsp;<img width="20px" src="https://www.gravatar.com/avatar/${loggedInUser.gravatarHash}?r=pg&d=identicon&s=20" />&nbsp;<b class="caret"></b></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                    <li><a href="${contextPath}/user/profile">Profile</a></li>
                                    <li><a href="${contextPath}/auth/logout">Logout</a></li>
                                </ul>
                            </li>
                        </li>
                    </security:authorize>
                    <security:authorize access="!isAuthenticated()">
                        <li><a href="${contextPath}/auth/login">Login</a></li>
                    </security:authorize>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
<br />