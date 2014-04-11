<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="course" items="${courses}">
    <div class="course-description">
        <h2>${course.name}</h2><br/>
        <p>
        <h4>Maximal number of participants:</h4> ${course.maxNumber}<br/>
        <h4>Description:</h4> ${course.description}
        </p>
    </div>
</c:forEach>