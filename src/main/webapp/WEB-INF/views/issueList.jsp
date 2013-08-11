<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
    <c:forEach items="${issues}" var="issue">
        <tr>
            <td>${issue.id}</td>
            <td>${issue.title}</td>
            <td>${issue.desc}</td>
            <td>${issue.project.projectTag}</td>
        </tr>
    </c:forEach>
</table>