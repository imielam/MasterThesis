<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div>
	<h2>Please write your message bellow:</h2>
	<form:form method="POST" modelAttribute="contactMessage"
		class="form-group">
		<fieldset>
			<div class="form-group row-lg-1">
				<form:textarea path="message" rows="10" class="form-control" />
			</div>
			<br />

			<form:errors path="message" cssClass="error" />
			<br /> Please give email address, on which I should answer to:<br />
			<div class="form-group row-lg-1">
				<form:input path="email" maxlength="40" class="form-control" />
			</div>
			<br />
			<form:errors path="email" cssClass="error" />
			<br /> <input name="send" type="submit" value="Send" class="btn btn-default" />
		</fieldset>
	</form:form>
</div>