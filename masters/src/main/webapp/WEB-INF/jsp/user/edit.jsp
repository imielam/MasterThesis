<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<c:if test="${param.success eq true }">
	<div class="alert alert-success">User data saved!</div>
</c:if>

<form:form method="POST" modelAttribute="user" class="form-horizontal"
	role="form">
	<fieldset>
		<%@ include file="../form_fragment/user_data.jspf"%>

		<h2>Permanent address's data</h2>

		<div class="form-group">
			<label class="col-sm-2 control-label">Street:</label>
			<div class="col-sm-10">
				<p class="form-inline ">
					<form:input path="permamentAddress.street" maxlength="40"
						class="form-control" />
					<form:input path="permamentAddress.streetHN" maxlength="40"
						class="form-control" /> / <form:input path="permamentAddress.streetAN"
							maxlength="40" class="form-control" />
				</p>
				<p class="form-inline ">
					<form:input path="permamentAddress.postalCode" maxlength="40"
						class="form-control" />
					,
					<form:input path="permamentAddress.city" maxlength="40"
						class="form-control" />
				</p>
			</div>
		</div>

		
			<h2>Residential address's data</h2>

				<div class="form-group">
					<label class="col-sm-2 control-label">Street:</label>
					<div class="col-sm-10">
                <p class="form-inline ">
						<form:input path="residenceAddress.street" maxlength="40"
							class="form-control" />
						<form:input path="residenceAddress.streetHN" maxlength="40"
							class="form-control" /> / <form:input path="residenceAddress.streetAN"
								maxlength="40" class="form-control" />
						</p>
                <p class="form-inline ">
						<form:input path="residenceAddress.postalCode" maxlength="40"
							class="form-control" />
						,
						<form:input path="residenceAddress.city" maxlength="40"
							class="form-control" />
						</p>	
					</div>
				</div>

		<div class="form-group">
            <div class="col-sm-12">
                <input name="send" type="submit" value="Save"
                    class="btn btn-default" />
                <button type="button" class="btn btn-default">
                    <a href='<spring:url value="/user/${user.id}.html" />'>
                        Cancel </a>
                </button>
            </div>
        </div>
	</fieldset>
</form:form>