<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../../layout/taglib.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<c:set var="address_r" value="${user.residenceAddress}"/>
<c:set var="address_p" value="${user.permamentAddress}"/>
<%@ include file="../fragment/user_data.jspf" %>
<%@ include file="../fragment/address_data.jspf" %>