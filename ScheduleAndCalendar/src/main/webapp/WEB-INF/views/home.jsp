<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Đăng nhập dự án lịch</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/dashboard.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/toastr.min.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/style.css">
<script type="text/javascript"
	src="${contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/toastr.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/setuptoartr.js"></script>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-primary menu_calendar">
		<a class="navbar-brand" href="#">Navbar</a>
		<div class="navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle profilenav" href="#"
					id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Đặng Quốc Thắng </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<i><a class="dropdown-item" href="myaccount.html"></i> Thông tin</a> <a
							class="dropdown-item" href="#"></i> Đổi mật khẩu</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><i
							class="fas fa-sign-out-alt"></i> Đăng xuất</a>
					</div></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row row-calendar">
			<div class="col-md-4 col-sm-6 card-calendar mt-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Xem lịch</h5>
						<p class="card-text">Đang phát triển.</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 card-calendar mt-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thêm thời khóa biểu</h5>
						<p class="card-text">Đang phát triển.</p>
						<a class="link-function" href="schedule/create"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 card-calendar mt-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thêm lịch thi</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a class="link-function" href="testschedule/create"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 card-calendar mt-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thêm lịch coi thi</h5>
						<p class="card-text">Đang phát triển.</p>
						<!-- <a class="link-function" href=""></a> -->
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 card-calendar mt-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thêm lịch từ excel</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a class="link-function" href="import/create"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript"
		src="${contextPath}/resources/js/dashboard.js"></script>
</body>
</html>