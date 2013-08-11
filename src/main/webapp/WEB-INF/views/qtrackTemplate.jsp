<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html>
<head>
    <title>QTrack | ${title}</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/header.css" />
</head>
<body>
    <jsp:include page="header.jsp" />
    <jsp:include page="${viewName}.jsp" />
    <%--<%@include file="footer.jsp"%>--%>
</body>
</html>