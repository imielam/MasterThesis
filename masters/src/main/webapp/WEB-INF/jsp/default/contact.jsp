<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../../layout/taglib.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div>

    <c:if test="${param.success eq true }">
        <div class = "alert alert-success">Message was sent!</div>
    </c:if>
    

	<h2>Please write your message bellow:</h2>
	<form:form method="POST" modelAttribute="contactMessage" 
		class="form-horizontal" role="form">
		<fieldset>
			<div class="form-group col-sm-12">
				<form:textarea path="message" rows="10" class="form-control" />
			</div>
			<br />

			<form:errors path="message" cssClass="error" />
			<br /> Please give email address, on which I should answer to:<br />
			<div class="form-group col-sm-12">
				<form:input path="email" maxlength="40" class="form-control" />
			</div>
			<br />
			<form:errors path="email" cssClass="error" />
			<br />

			<div class="form-group">
				<div class="col-sm-12">
					<input name="send" type="submit" value="Send"
						class="btn btn-default" />
				</div>
			</div>
		</fieldset>
	</form:form>
</div>