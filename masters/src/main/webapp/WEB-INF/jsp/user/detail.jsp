<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<c:if test="${param.success eq true }">
	<div class="alert alert-success">User data saved!</div>
</c:if>

<c:set var="address_r" value="${user.residenceAddress}" />
<c:set var="address_p" value="${user.permamentAddress}" />
<c:set var="login" value="${user.login}" />
<%@ include file="../fragment/login_data.jspf"%>
<%@ include file="../fragment/user_data.jspf"%>
<%@ include file="../fragment/address_data.jspf"%>
<button type="button" class="btn btn-default">
	<a href='<spring:url value="/user/edit/${user.id}.html" />'> EDIT </a>
</button>
<c:if test="${not empty user.teachers }">

	<div class="row">
		<h2>History of employment contract:</h2>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${user.teachers}" var="teachers">
					<tr>
						<td><a
							href='<spring:url value="/teacher/detail/${teachers.id}.html" />'>
								<c:out value="${teachers.id}" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</c:if>
<c:if test="${not empty user.participants }">
	<div class="row">
		<h2>History of participation:</h2>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${user.participants}" var="participant">
					<tr>
						<td><a
							href='<spring:url value="/participant/detail/${participant.id}.html" />'>
								<c:out value="${participant.id}" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</c:if>