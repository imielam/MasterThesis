<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>

	<%@ taglib uri="http://www.springframework.org/security/tags"
		prefix="security"%>
	<tilesx:useAttribute name="current" />

	<div class="container">

		<!-- Static navbar -->
		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="/" />'>Masters</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? 'active' : '' }"><a
							href='<spring:url value="/" />'>Home</a></li>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="dropdown ${current == 'users' ? 'active' : '' }"><a
								href="#" class="dropdown-toggle" data-toggle="dropdown">Users
									<b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<security:authorize access="hasRole('ROLE_ADMIN')">
										<li><a href="/admin/users.html">List</a></li>
										<li><a href="/admin/register.html">Register </a></li>
									</security:authorize>
									<!--                                <li><a href="#">Something else here</a></li> -->
									<!--                                <li class="divider"></li> -->
									<!--                                <li class="dropdown-header">Nav header</li> -->
									<!--                                <li><a href="#">Separated link</a></li> -->
									<!--                                <li><a href="#">One more separated link</a></li> -->
								</ul></li>
						</security:authorize>
						<li class="${current == 'about' ? 'active' : '' }"><a
							href='<spring:url value="/about.html" />'>About</a></li>
						<li class="${current == 'contact' ? 'active' : '' }"><a
							href='<spring:url value="/contact.html" />'>Contact</a></li>
						<li class="dropdown ${current == 'course' ? 'active' : '' }">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Course
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/course_type/list.html">Types</a></li>
								<security:authorize access="isAuthenticated()">
									<li><a href="/course/available.html">List of available
											courses</a></li>
									<li><a href="/course/my.html">List of my courses</a></li>
								</security:authorize>
								<security:authorize access="hasRole('ROLE_ADMIN')">
									<li><a href="/course/list.html">All courses</a></li>
									<li><a href="/course/create.html">Create new course</a></li>
									<li><a href="/course_type/create.html">Create new
											course type</a></li>
								</security:authorize>
								<!-- 								<li><a href="#">Another action</a></li> -->
								<!-- 								<li><a href="#">Something else here</a></li> -->
								<!-- 								<li class="divider"></li> -->
								<!-- 								<li class="dropdown-header">Nav header</li> -->
								<!-- 								<li><a href="#">Separated link</a></li> -->
								<!-- 								<li><a href="#">One more separated link</a></li> -->
							</ul>
						</li>
						<li class="dropdown ${current == 'material' ? 'active' : '' }">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Materials
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/materials/example.html">Example materials</a></li>
								<security:authorize
									access="hasAnyRole('ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_PARTICIPANT')">
									<li><a href="/materials/full.html">Learning materials</a></li>
								</security:authorize>
							</ul>
						</li>

						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'login' ? 'active' : '' }"><a
								href='<spring:url value="/login.html" />'>Login</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="dropdown ${current == 'account' ? 'active' : '' }"><a
								href="#" class="dropdown-toggle" data-toggle="dropdown">My
									Account <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="/user/detail.html">Details </a></li>
									<li><form method="post">
											<button formaction='<spring:url value="/logout.html" />'
												type="submit" name="${_csrf.parameterName}"
												value="${_csrf.token}">Logout</button>
										</form></li>
								</ul></li>
						</security:authorize>
						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'register' ? 'active' : '' }"><a
								href="/register.html">Register </a></li>
						</security:authorize>

						<!-- 						<div class="btn-group"> -->
						<!-- 							<button type="button" class="btn btn-default dropdown-toggle" -->
						<!-- 								data-toggle="dropdown"> -->
						<!-- 								Dropdown <span class="caret"></span> -->
						<!-- 							</button> -->
						<!-- 							<ul class="dropdown-menu"> -->
						<!-- 								<li><a href="#">Dropdown link</a></li> -->
						<!-- 								<li><a href="#">Dropdown link</a></li> -->
						<!-- 							</ul> -->
						<!-- 						</div> -->
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>



		<tiles:insertAttribute name="body" />
		<br /> <br />

		<center>
			<tiles:insertAttribute name="footer" />
		</center>
	</div>
</body>
</html>