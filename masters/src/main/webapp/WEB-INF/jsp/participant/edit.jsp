<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<c:if test="${param.success eq true }">
	<div class="alert alert-success">Participant data saved!</div>
</c:if>

<form:form method="POST" modelAttribute="participant" class="form-horizontal mainForm"
	role="form">
	<fieldset>
		<%@include file="../form_fragment/participant_data.jspf" %>

		<div class="form-group">
			<div class="col-sm-12">
				<input name="send" type="submit" value="Save"
					class="btn btn-default" />
				<button type="button" class="btn btn-default">
					<a href='<spring:url value="/participant/detail/${participant.id}.html" />'> Cancel
					</a>
				</button>
			</div>
		</div>
	</fieldset>
</form:form>

<script type="text/javascript">
    $(document).ready(function() {
        participantForm();
    });
</script>