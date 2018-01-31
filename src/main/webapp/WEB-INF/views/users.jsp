<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp" %>

<table class="table">
    <thead>
        <tr>
            <th>id</th>
            <th>Username</th>
            <th>Role</th>
            <th>Doc count</th>
            <th>Buttons</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <th scope="row">${user.getId()}</th>
                <td>${user.getUsername()}</td>
                <td>${user.getRole().toString()}</td>
                <td>${user.getDocuments().size()}</td>
                <td>
                    <span><form action="${pageContext.request.contextPath}/admin/users/${user.getId()}/delete" method="POST"><button class="btn btn-default" >Delete</button></form></span>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/admin/users/add" class="btn btn-primary" type="button">Add New User</a></p>

<%@ include file="layout/footer.jsp" %>