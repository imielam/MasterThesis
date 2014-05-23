<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Max participants</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${types}" var="type">
			<tr>
				<td><a href='<spring:url value="/course_type/detail/${type.id}.html" />'>
						<c:out value="${type.id}" />
				</a></td>
				<td><c:out value="${type.name}" /></td>
				<td><c:out value="${type.maxParticipantNumber}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>