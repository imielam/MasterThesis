<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="../fragment/course_type_data.jspf"%>
<button type="button" class="btn btn-default">
    <a href='<spring:url value="/course_type/edit/${type.id}.html" />'>
        EDIT </a>
</button>
