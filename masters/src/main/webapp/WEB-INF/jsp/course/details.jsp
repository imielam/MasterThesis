<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div>
	<div class="row">
		<div class="form-group">
			<label class="col-sm-2 control-label">ID:</label>
			<div class="col-sm-10">
				<p class="form-control-static">${course.id}</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
			<label class="col-sm-2 control-label">Type:</label>
			<div class="col-sm-10">
				<p class="form-control-static">${course.type.name}</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
			<label class="col-sm-2 control-label">Start date:</label>
			<div class="col-sm-10">
				<p class="form-control-static">${course.startDate}</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
			<label class="col-sm-2 control-label">End date:</label>
			<div class="col-sm-10">
				<p class="form-control-static">${course.endDate}</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
			<label class="col-sm-2 control-label">Description:</label>
			<div class="col-sm-10">
				<p class="form-control-static">${course.type.description}</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
			<label class="col-sm-2 control-label">teacher:</label>
			<div class="col-sm-10">
<!-- 				<p class="form-control-static">placeholder for teacher's name</p> -->
				<p class="form-control-static"><a href='<spring:url value="/teacher/detail/${course.teacher.id}.html" />'>
                        <c:out value="${course.teacher.user.name}" />
                </a></p>
			</div>
		</div>
	</div>
	<div class="row">
		<label class="col-sm-12 control-label">List of participants signed for this course:</label>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
				</tr>
			</thead>
			<tbody>
<!-- 				<tr> -->
<!-- 					<td><a -->
<%-- 						href='<spring:url value="/participant/detail/1.html" />'> --%>
<!-- 							1 -->
<!-- 					</a></td> -->
<!-- 					<td>place holder for participants</td> -->
<!-- 				</tr> -->
				<c:forEach items="${course.participants}" var="participant">
					<tr>
						<td><a
							href='<spring:url value="/participant/detail/${participant.id}.html" />'>
								<c:out value="${participant.id}" />
						</a></td>
						<td><c:out value="${participant.user.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>