<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<c:if test="${param.success eq true }">
	<div class="alert alert-success">Course data saved!</div>
</c:if>

<form:form method="POST" modelAttribute="course" class="form-horizontal"
	role="form">
	<fieldset>

		<h2>Course's data</h2>

		<div class="form-group">
			<label class="col-sm-2 control-label">Type:</label>
			<div class="col-sm-6">
				<form:select path="type.id" items="${mapType}" maxlength="40"
					class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Start date:</label>
			<div class="col-sm-6">
				<form:input type="date" path="startDate" maxlength="40"
					class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">End date:</label>
			<div class="col-sm-6">
				<form:input type="date" path="endDate" maxlength="40"
					class="form-control" />
			</div>
		</div>

<!-- 		<div class="form-group"> -->
<!-- 			<label class="col-sm-2 control-label">Description:</label> -->
<!-- 			<div class="col-sm-6"> -->
<%-- 				<form:textarea path="type.description" maxlength="250" rows="10" --%>
<%-- 					class="form-control" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="form-group">
			<label class="col-sm-2 control-label">Teacher:</label>
			<div class="col-sm-6">
				<form:select path="teacher.id" items="${mapTeachers}" maxlength="40"
					class="form-control" />
			</div>
		</div>
		<!--         <div class="row"> -->
		<!-- 			<div class="form-group"> -->
		<!-- 				<label class="col-sm-2 control-label">teacher:</label> -->
		<!-- 				<div class="col-sm-10"> -->
		<!-- 					               <p class="form-control-static">placeholder for teacher's name</p> -->
		<!-- 					<p class="form-control-static"> -->
		<!-- 						<a -->
		<%-- 							href='<spring:url value="/teacher/detail/${course.teacher.id}.html" />'> --%>
		<%-- 							<c:out value="${course.teacher.user.name}" /> --%>
		<!-- 						</a> -->
		<!-- 					</p> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->

		<div class="form-group">
			<div class="col-sm-12">
				<input name="send" type="submit" value="Save"
					class="btn btn-default" />
				<button type="button" class="btn btn-default">
					<a href='<spring:url value="/course/detail/${course.id}.html" />'>
						Cancel </a>
				</button>
			</div>
		</div>
		<div class="row">
			<label class="col-sm-12 control-label">List of participants
				signed for this course:</label>
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>name</th>
					</tr>
				</thead>
				<tbody>
					<!--                <tr> -->
					<!--                    <td><a -->
					<%--                        href='<spring:url value="/participant/detail/1.html" />'> --%>
					<!--                            1 -->
					<!--                    </a></td> -->
					<!--                    <td>place holder for participants</td> -->
					<!--                </tr> -->
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
	</fieldset>
</form:form>