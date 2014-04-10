<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div>
	<h2>Please write your message bellow:</h2>
	<form:form method="POST" modelAttribute="contactMessage">
		<fieldset>
			<div class="input-group">
				<form:input path="message" size="250" maxlength="500" />
			</div>
			<br />
			<div class="input-group">
				<form:errors path="message" cssClass="error" />
			</div>
			<br /> Please give email address, on which I should answer to:<br />
			<div class="input-group">
				<form:input path="email" size="20" maxlength="40" />
			</div>
			<br />
			<form:errors path="email" cssClass="error" />
			<br /> <input name="send" type="submit" value="Send" />
		</fieldset>
	</form:form>
</div>