<%@page import="java.lang.reflect.Field"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of ${entityName}s</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
    </head>
    <body align="center">
        <c:set value="${pageContext.request.contextPath}" var="path" />
        <nav>
            <a href="${path}">Home</a>
        </nav>
        <h2>List of ${entityName}s</h2>
        <a href="${path}/${entityName}/create">Create</a>
        <c:if test="${entities.size() > 0}">
            <table border="1" align="center">
                <thead>
                    <tr>
                        <c:forEach items="${properties}" var="p">
                            <th>
                                ${p.getDisplayName()}
                            </th>
                        </c:forEach>
                        <th colspan="2">actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${entities}" var="t">
                        <tr id="${entityName}${t.id}">
                            <c:forEach items="${properties}" var="p">
                                <td data-field="${p.getDisplayName()}">
                                    ${p.getReadMethod().invoke(t)}
                                </td>
                            </c:forEach>
                            <td>
                                <a href="${path}/${entityName}/update?id=${t.id}">Update</a>
                            </td>
                            <td>
                                <a href="${path}/${entityName}/delete?id=${t.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <script>
//            function atrDoubleClickHandler(e) {
//                const inp = document.createElement("input");
//                inp.setAttribute("type", "text");
//                inp.setAttribute("size", 12);
//                inp.setAttribute("value", e.target.innerText);
//                e.target.innerText = "";
//                e.target.appendChild(inp);
//            }
//
//            (function func() {
//                const atrs = document.querySelectorAll("td.atr");
//                atrs.forEach(atr => atr.addEventListener("dblclick", atrDoubleClickHandler));
//            })();

        </script>
    </body>
</html>
