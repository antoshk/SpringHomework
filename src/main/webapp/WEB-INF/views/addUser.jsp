<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp" %>

<form:form class="form-horizontal" method="post" modelAttribute="newUser">
    <fieldset>

        <!-- Form Name -->
        <legend>Add Doc</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="username">username</label>
            <div class="col-md-4">
                <form:input id="username" name="username" type="text" placeholder="" class="form-control input-md" required="" path="username"/>
                <p class="bg-danger"><form:errors path="username" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">password</label>
            <div class="col-md-4">
                <form:input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="" path="password"/>
                <p class="bg-danger"><form:errors path="password" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="confirmPassword">Confirm password</label>
            <div class="col-md-4">
                <form:input id="confirmPassword" name="confirmPassword" type="password" placeholder="" class="form-control input-md" required="" path="confirmPassword"/>
                <p class="bg-danger"><form:errors path="confirmPassword" cssClass="error" /></p>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="role">Role</label>
          <div class="col-md-4">
            <form:select id="role" name="role" class="form-control" path="role">
              <form:option value="ROLE_ADMIN">Admin</form:option>
              <form:option value="ROLE_USER">User</form:option>
            </form:select>
            <p class="bg-danger"><form:errors path="role" cssClass="error" /></p>
          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="add"></label>
            <div class="col-md-4">
                <button id="add" name="add" class="btn btn-primary">Add</button>
            </div>
        </div>

    </fieldset>
</form:form>

<%@ include file="layout/footer.jsp" %>