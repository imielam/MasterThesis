<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<security:authorize
	access="hasAnyRole('ROLE_ADMIN', 'ROLE_PARTICIPANT')">
	<h2>Courses that I participate in</h2>
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
			<c:forEach items="${myCourses}" var="course">
				<tr>
					<td><a
						href='<spring:url value="/course/detail/${course.id}.html" />'>
							<c:out value="${course.id}" />
					</a></td>
					<td><c:out value="${course.type.name}" /></td>
					<td><c:out value="${course.startDate}" /></td>
					<td><c:out value="${course.endDate}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</security:authorize>

<security:authorize
    access="hasAnyRole('ROLE_ADMIN', 'ROLE_PARTICIPANT', 'ROLE_USER')">
    <h2>Courses that I wait for</h2>
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
            <c:forEach items="${waitingCourses}" var="course">
                <tr>
                    <td><a
                        href='<spring:url value="/course/detail/${course.id}.html" />'>
                            <c:out value="${course.id}" />
                    </a></td>
                    <td><c:out value="${course.type.name}" /></td>
                    <td><c:out value="${course.startDate}" /></td>
                    <td><c:out value="${course.endDate}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_TEACHER')">
	<h2>Courses that I teach</h2>
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
			<c:forEach items="${teacherCourses}" var="course">
				<tr>
					<td><a
						href='<spring:url value="/course/detail/${course.id}.html" />'>
							<c:out value="${course.id}" />
					</a></td>
					<td><c:out value="${course.type.name}" /></td>
					<td><c:out value="${course.startDate}" /></td>
					<td><c:out value="${course.endDate}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</security:authorize>