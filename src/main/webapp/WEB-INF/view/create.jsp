<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set value="${entity.id == null ? \"Create\" : \"Update\"}" var="action" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
        <title>${action} ${entityName}</title>
    </head>
    <body>
        <c:set value="${pageContext.request.contextPath}" var="path"/>
        <nav>
            <a href="${path}">Home</a>
        </nav>
        <h2>${action} ${entityName}</h2>
        <form:form id="myForm" method="post" action="${path}/${entityName}/create" modelAttribute="entity">
            <c:if test="${entity.id != null}">
                <form:hidden path="id" ></form:hidden>
            </c:if>
            <c:forEach items="${properties}" var="prop">
                <form:label path="${prop.getName()}">${prop.getName()}:</form:label>
                <form:input path="${prop.getName()}"/><br/>
                <form:errors path="${prop.getName()}"/>
            </c:forEach>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>
