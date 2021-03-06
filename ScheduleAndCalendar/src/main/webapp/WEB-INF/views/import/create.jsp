<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<title>Thêm lịch từ file excel vào Google Calendar</title>
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
		<a class="navbar-brand" href="#">Navbar</a>
		<div class="navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle profilenav" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Đặng Quốc Thắng
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#"></i> Thông tin</a>
						<a class="dropdown-item" href="#"></i> Đổi mật khẩu</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt"></i> Đăng xuất</a>
					</div>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row row-calendar">
			<div class="chucnang tdExpandInBounce animated">
				<div class="row">
					<div class="col-md-12">
						<h1>Thêm lịch từ Excel</h1>
						<div class="themlichtkb">
							<form method="POST" >
								<span>Chọn tệp Excel:</span><br /><br />
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="inputGroupFile01">
									<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
								</div>
								<button type="submit" class="btn btn-primary mt-4 float-right w-25">Upload Excel</button>
							</form>
							<div class="backhome">
								<a href="../home">Dùng các chức năng khác</a>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
		<script type="text/javascript" src="js/dashboard.js"></script>
	</body>
	</html>