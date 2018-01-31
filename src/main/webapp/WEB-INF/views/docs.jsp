<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp" %>

<table class="table">
    <thead>
        <tr>
            <th>#</th>
            <th>title</th>
            <th>body</th>
            <th>Buttons</th>
        </tr>
    </thead>
    <tbody>
        <c:set var="iter" value="1"/>
        <c:forEach var="doc" items="${docs}">
            <tr>
                <th scope="row">${iter}</th>
                <td>${doc.getTitle()}</td>
                <td>${doc.getBody()}</td>
                <td>
                    <span><form action="${pageContext.request.contextPath}/user/docs/${doc.getId()}/delete" method="POST"><button class="btn btn-default" >Delete</button></form></span>
                    <a href="${pageContext.request.contextPath}/user/docs/${doc.getId()}/edit" class="btn btn-default" type="button">Edit</a>
                </td>
            </tr>
            <c:set var="iter" value="${iter+1}"/>
        </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/user/docs/add" class="btn btn-primary" type="button">Add New Doc</a></p>

<%@ include file="layout/footer.jsp" %>