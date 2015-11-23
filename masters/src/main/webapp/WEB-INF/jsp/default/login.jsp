<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%> --%>

<%@ include file="../../layout/taglib.jsp"%>

<style>
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<form class="form-signin" role="form"
	action='<spring:url value="/j_spring_security_check"></spring:url>'
	method="POST">
	<h2 class="form-signin-heading">Please sign in</h2>
	<input type="text" class="form-control" name='j_username'
		placeholder="Name" required autofocus> <input type="password"
		name='j_password' class="form-control" placeholder="Password" required>
	<!-- <div class="checkbox">
		<label> <input type="checkbox" value="remember-me">
			Remember me
		</label>
	</div> -->
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
		in</button>
</form>