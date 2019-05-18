<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Thêm thời khóa biểu vào Google Calendar</title>
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
						<a class="dropdown-item" href="#"></i> Thông tin</a> <a
							class="dropdown-item" href="#"></i> Đổi mật khẩu</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><i
							class="fas fa-sign-out-alt"></i> Đăng xuất</a>
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
						<h1>Thêm thời khóa biểu</h1>
						<div class="themlichtkb">
							<form:form method="POST" modelAttribute="scheduleCreate" action="${contextPath}/schedule/create">
								<spring:bind path="semester">
									<div class="form-group ${status.error ? 'has-error' : ''}">
										<label for="semester">Chọn học kỳ:</label>
										<form:select path="semester" class="custom-select">
											<form:option value="-" label="--Please Select--" />
											<form:options items="${semesters}" />
										</form:select>
										<form:errors path="semester" />
									</div>
								</spring:bind>

								<spring:bind path="studentId">
									<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="mt-4" for="studentId">Mã sinh viên/
											giảng viên:</label>
										<form:input path="studentId" id="studentId"
											class="form-control" title="Mã GV/SV có 5/6 kí tự" type="text" pattern=".{5,6}" />
										<form:errors path="studentId" />
									</div>
								</spring:bind>
								
								<button type="submit"
									class="btn btn-primary mt-4 float-right w-25">Thêm
									lịch</button>
							</form:form>
							<div class="backhome">
								<a href="../home">Dùng các chức năng khác</a>
							</div>


							<%-- <form method="POST">
								<label for="chonhk">Chọn học kỳ thêm thời khóa biểu:</label> <select
									class="custom-select" name="chonhk">
									<option value="hk1">Học kỳ 1</option>
									<option value="hk2">Học kỳ 2</option>
									<option value="hk3">Học kỳ 3</option>
								</select> <label class="mt-4" for="masv">Nhập mã sinh viên:</label> <input
									class="form-control" title="Mã sinh viên có ít nhất 6 kí tự"
									type="text" pattern=".{6,6}"
									title="Mã sinh viên bao gồm 6 kí tự" name="masv">
								<button type="submit"
									class="btn btn-primary mt-4 float-right w-25">Thêm
									lịch</button>
							</form>
							<div class="backhome">
								<a href="../home">Dùng các chức năng khác</a>
							</div> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/dashboard.js"></script>
</body>
</html>