<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/dashboard.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/toastr.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/toastr.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/setuptoartr.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary menu_calendar">
		<tiles:insertAttribute name="header" />
	</nav>
		<tiles:insertAttribute name="body" />
	<script type="text/javascript"
		src="${contextPath}/resources/js/dashboard.js"></script>
</body>
</html>