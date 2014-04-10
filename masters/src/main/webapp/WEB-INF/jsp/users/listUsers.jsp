<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<table cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Verified</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <s:url value="/users/user?id={userID}" var="user_url">
            <s:param name="userID" value="${user.id}" />
        </s:url>
        <tr>
            <th>${user.id}</th>
            <th><a href="${ user_url }">${user.username}</a></th>
            <th>${user.verified}</th>
        </tr>
    </c:forEach>
</table>

