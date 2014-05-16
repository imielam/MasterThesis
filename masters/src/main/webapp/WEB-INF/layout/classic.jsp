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

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>
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
						<%-- 						<LI CLASS="${CURRENT == 'USERS' ? 'ACTIVE' : '' }"><A --%>
						<%-- 							HREF='<SPRING:URL VALUE="/ADMIN/USERS.HTML" />'>USERS</A></LI> --%>
						<li class="dropdown ${current == 'users' ? 'active' : '' }"><a
							href="#" class="dropdown-toggle" data-toggle="dropdown">Users
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/admin/users.html">List</a></li>
								<li><a href="/admin/register.html">Register </a></li>
								<!--                                <li><a href="#">Something else here</a></li> -->
								<!--                                <li class="divider"></li> -->
								<!--                                <li class="dropdown-header">Nav header</li> -->
								<!--                                <li><a href="#">Separated link</a></li> -->
								<!--                                <li><a href="#">One more separated link</a></li> -->
							</ul></li>
						<li class="${current == 'about' ? 'active' : '' }"><a
							href='<spring:url value="/about.html" />'>About</a></li>
						<li class="${current == 'contact' ? 'active' : '' }"><a
							href='<spring:url value="/contact.html" />'>Contact</a></li>

						<li class="dropdown ${current == 'course' ? 'active' : '' }"><a
							href="#" class="dropdown-toggle" data-toggle="dropdown">Course
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/course/list.html">List</a></li>
								<!-- 								<li><a href="#">Another action</a></li> -->
								<!-- 								<li><a href="#">Something else here</a></li> -->
								<!-- 								<li class="divider"></li> -->
								<!-- 								<li class="dropdown-header">Nav header</li> -->
								<!-- 								<li><a href="#">Separated link</a></li> -->
								<!-- 								<li><a href="#">One more separated link</a></li> -->
							</ul></li>

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