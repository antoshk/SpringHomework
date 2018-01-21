<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>This is the homepage!</p>

        <c:if test="${not empty studentList}">
            <ul>
                <c:forEach var="student" items="${studentList}">
                    <li>${student.getName()}</li>
                </c:forEach>
            </ul>
        </c:if>

        <form action="${pageContext.request.contextPath}/generate" method="post"><button>generate</button></form>
        <form action="${pageContext.request.contextPath}/add" method="get"><button>add student</button></form>

    </body>
</html>
