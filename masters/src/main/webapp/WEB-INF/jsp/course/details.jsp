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
<%@ include file="../fragment/lists/participants.jspf"%>
<div class="row">
<button type="button" class="btn btn-default">
    <a href='<spring:url value="/course/add/participants/${course.id}.html" />'>
        ADD </a>
</button>
</div>