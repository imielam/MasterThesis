<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<c:if test="${param.success eq true }">
	<div class="alert alert-success">Teacher data saved!</div>
</c:if>

<%-- <c:set var="login" value="${user.login}" /> --%>
<%@ include file="../fragment/participant_data.jspf"%>
<button type="button" class="btn btn-default">
	<a href='<spring:url value="/participant/edit/${participant.id}.html" />'>
        EDIT
	</a>
</button>