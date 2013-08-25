<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:eval var="appVersion" expression="@qprops['app.version']" />
<spring:eval var="gitVersion" expression="@qprops['app.gitVersion'].substring(0,8)" />

<!DOCTYPE html>
<html>
<head>
    <title>QTrack | ${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="qtrack-version" content="${appVersion}" />
    <meta name="qtrack-gitversion" content="${gitVersion}" />

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
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/qtrack.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/bootstrap-responsive.css" media="screen" />
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="container" style="min-height: 400px">
        <%-- Show the errors/messages here --%>
        <c:if test="${error != null}">
            <div class="alert alert-error">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>ERROR:&nbsp;</strong>${error}
            </div>
        </c:if>
        <c:if test="${info != null}">
            <div class="alert alert-info">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>INFO:&nbsp;</strong>${info}
            </div>
        </c:if>

        <%-- Load the View here --%>
        <jsp:include page="${viewName}.jsp" />
    </div>

    <div id="footer">
        <div class="container">
            <p class="muted credit">
                &copy;2013 QTrack&nbsp;&nbsp;Version: ${appVersion}&nbsp;&nbsp;Rev: ${gitVersion}<br />
                Host: ${pageContext.request.remoteHost}&nbsp;&nbsp;Port: ${pageContext.request.serverPort}
                Protocol: ${pageContext.request.protocol}&nbsp;&nbsp;Locale: ${pageContext.request.locale}<br />
                Generated At: <script>
                                var today = new Date();
                                document.write(today.toDateString() + " " +today.toTimeString());
                              </script><br />
                Generation Time: ${execTime}ms<br />
                User: ${loggedInUser.userName}
            </p>
        </div>
    </div>

    <%-- Include JS at the bottom for faster page loads --%>
    <script src="${contextPath}/static/js/jquery-2.0.3.min.js"></script>
    <script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>