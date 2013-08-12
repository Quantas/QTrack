<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>QTrack | ${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

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
        <jsp:include page="${viewName}.jsp" />
    </div>
    <%--<%@include file="footer.jsp"%>--%>
    <script src="${contextPath}/static/js/jquery-2.0.3.min.js"></script>
    <script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>