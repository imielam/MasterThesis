<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<c:if test="${param.success eq true }">
	<div class="alert alert-success">User data saved!</div>
</c:if>

<form:form method="POST" modelAttribute="user" class="form-horizontal"
	role="form">
	<fieldset>

		<h2>Role's data</h2>

		<div class="form-group">
			<label class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-6">
				<form:select path="login.role.id" items="${mapRoles}" maxlength="40"
					class="form-control" />
			</div>
		</div>
		<h2>Login's data</h2>

		<div class="form-group">
			<label class="col-sm-2 control-label">Login:</label>
			<div class="col-sm-6">
				<form:input path="login.login" maxlength="40" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">e-mail:</label>
			<div class="col-sm-6">
				<form:input path="login.email" maxlength="40" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Password:</label>
			<div class="col-sm-6">
				<form:password path="login.password" maxlength="40"
					class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Repeat password:</label>
			<div class="col-sm-6">
				<form:password path="login.rePassword" maxlength="40"
					class="form-control" />
			</div>
		</div>

		<h2>User's data</h2>

		<div class="form-group">
			<label class="col-sm-2 control-label">name:</label>
			<div class="col-sm-6">
				<form:input path="name" maxlength="40" class="form-control" />
			</div>
		</div>

		<h2>Permanent address's data</h2>

		<div class="form-group">
			<label class="col-sm-2 control-label">Street:</label>
			<div class="col-sm-10">
				<p class="form-inline ">
					<form:input path="permamentAddress.street" maxlength="40"
						class="form-control" />
					<form:input path="permamentAddress.streetHN" maxlength="40"
						class="form-control" />
					/
					<form:input path="permamentAddress.streetAN" maxlength="40"
						class="form-control" />
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
						class="form-control" />
					/
					<form:input path="residenceAddress.streetAN" maxlength="40"
						class="form-control" />
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
					<a href='<spring:url value="/user/${user.id}.html" />'> Cancel
					</a>
				</button>
			</div>
		</div>
	</fieldset>
</form:form>