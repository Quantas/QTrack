<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:eval var="appVersion" expression="@qprops['app.version']" />

<!DOCTYPE html>
<html>
<head>
    <title>QTrack | ${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="qtrack-version" content="${appVersion}" />

    <!-- IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
        <script src="${contextPath}/static/js/html5shim.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/bootstrap.min.css" media="screen" />
    <style>
        body
        {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/login.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/bootstrap-responsive.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/header.css" media="screen"/>
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <%-- Load the View here --%>
        <jsp:include page="${viewName}.jsp" />
    </div>

    <%-- Include JS at the bottom for faster page loads --%>
    <script src="${contextPath}/static/js/jquery-2.0.3.min.js"></script>
    <script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>