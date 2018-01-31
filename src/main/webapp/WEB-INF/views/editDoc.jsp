<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp" %>

<form:form class="form-horizontal" method="post" modelAttribute="doc">
    <fieldset>

        <!-- Form Name -->
        <legend>Add Doc</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fullname">Title</label>
            <div class="col-md-4">
                <form:input id="title" name="title" type="text" placeholder="" class="form-control input-md" required="" path="title"/>
                <p class="bg-danger"><form:errors path="title" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Body</label>
            <div class="col-md-4">
                <form:input id="body" name="body" type="text" placeholder="" class="form-control input-md" required="" path="body"/>
                <p class="bg-danger"><form:errors path="body" cssClass="error" /></p>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="add"></label>
            <div class="col-md-4">
                <button id="add" name="add" class="btn btn-primary">Save</button>
            </div>
        </div>

    </fieldset>
</form:form>

<%@ include file="layout/footer.jsp" %>