<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:set var="participants" value="${course.participants}" />
<c:set var="type" value="${course.type}" />

<%@ include file="../fragment/course_data.jspf"%>
<button type="button" class="btn btn-default">
	<a href='<spring:url value="/course/edit/${course.id}.html" />'>
		EDIT </a>
</button>
<security:authorize access="hasRole('ROLE_ADMIN')">
	<%@ include file="../fragment/lists/enrolled_participants.jspf"%><button
		type="button" class="btn btn-default">
		<a
			href='<spring:url value="/course/add/participants/${course.id}.html" />'>
			ADD </a>
	</button>
</security:authorize>
<%@ include file="../fragment/lists/waiting_participants.jspf"%>
<security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_PARTICIPANT')">
	<div class="row">
		<button type="button" class="btn btn-default">
			<a href='<spring:url value="/course/sign/${course.id}.html" />'>
				SIGN </a>
		</button>
	</div>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
<div class="row">
        <button type="button" class="btn btn-default">
            <a href='<spring:url value="/course/accept/${course.id}.html" />'>
                ACCEPT </a>
        </button>
    </div>
</security:authorize>