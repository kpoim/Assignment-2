<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
    </head>
    <body>
        <c:set value="${pageContext.request.contextPath}" var="path"/>
        <h1>Home</h1>
        <c:forEach items="${entities}" var="i">
            <a href="${path}/${i}/list"><strong>${i}s</strong></a><br/>
        </c:forEach>
    </body>
</html>
