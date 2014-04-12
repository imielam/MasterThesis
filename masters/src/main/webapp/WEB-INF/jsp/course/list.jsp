<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>id</th>
			<th>type</th>
			<th>start date</th>
			<th>end date</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${courses}" var="course">
			<tr>
				<td><a href='<spring:url value="/course/detail/${course.id}.html" />'>
						<c:out value="${course.id}" />
				</a></td>
				<td><c:out value="${course.type.name}" /></td>
				<td><c:out value="${course.startDate}" /></td>
				<td><c:out value="${course.endDate}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>