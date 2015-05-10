<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<c:if test="${param.success eq true }">
	<div class="alert alert-success">User data saved!</div>
</c:if>

<form:form method="POST" modelAttribute="user"
	class="form-horizontal mainForm" role="form">
	<fieldset>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<%@ include file="../form_fragment/lists/roles.jspf"%>
		</security:authorize>
		<%@ include file="../form_fragment/login_data.jspf"%>
		<%@ include file="../form_fragment/user_data.jspf"%>
		<%@ include file="../form_fragment/address_data.jspf"%>

		<div class="col-sm-12">
			<img alt="It is not working Captcha :("
				src='<spring:url value="/captcha/captcha.html" />' />
			<form:input path="captcha.message" maxlength="40"
				class="form-control" />
		</div>

		<div class="form-group">
			<div class="col-sm-12">
				<input name="send" type="submit" value="Save"
					class="btn btn-default" />
				<button type="button" class="btn btn-default">
					<a href='<spring:url value="/home.html" />'> Cancel </a>
				</button>
			</div>
		</div>

	</fieldset>
</form:form>

<!-- <script type="text/javascript">
	$(document).ready(function() {
		//TODO: add role validation
		// 		roleForm();
		loginForm();
		userForm();
		permAddressForm();
		resAddressForm();
	});
</script>
 -->