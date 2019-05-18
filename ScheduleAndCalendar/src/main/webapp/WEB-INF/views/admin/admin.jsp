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
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/dashboard.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/toastr.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/tempusdominus-bootstrap-4.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin.css">
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/toastr.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/moment.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/tempusdominus-bootstrap-4.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/setuptoartr.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary menu_calendar">
		<a class="navbar-brand" href="#">Navbar</a>
		<div class="navbar-collapse" id="navbarSupportedContent">
			<ul class="left_menu_calendar">
				<li class="nav-item active">
					<a class="nav-link" href="#">Thiết lập chung</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Người dùng</a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle profilenav" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Đặng Quốc Thắng
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="myaccount.html"></i> Thông tin</a>
						<a class="dropdown-item" href="#"></i> Đổi mật khẩu</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="login"><i class="fas fa-sign-out-alt"></i> Đăng xuất</a>
					</div>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<h4 class="card-title border-bottom p-2 bg-primary">Thời gian bắt đầu kì</h4>
					<div class="card-block p-3">
						<form>
							<div class="input-group date" id="batdaukimoi" data-target-input="nearest">
								<input type="text" class="form-control datetimepicker-input" data-target="#batdaukimoi"/>
								<div class="input-group-append" data-target="#batdaukimoi" data-toggle="datetimepicker">
									<div class="input-group-text"><i class="fa fa-calendar"></i></div>
								</div>
							</div>
							<button type="submit" class="btn btn-primary mb-2 mt-3 float-right">Cập nhật</button>
							<script type="text/javascript">
								$(function () {
									$('#batdaukimoi').datetimepicker({
										format: 'L',
										defaultDate: "11/17/1999",
									});
								});
							</script>
						</form>
					</div>
				</div>

				<!-- Thiết lập thời gian bắt đầu, kết thúc-->
				<div class="card mt-3 mb-4">
					<h4 class="card-title border-bottom p-2 bg-primary">Thêm tiết học</h4>
					<div class="card-block p-3">
						<form>
							<label class="font-weight-bold" for="inputGroupSelect01">Chọn tiết: </label>
							<select class="custom-select" id="inputGroupSelect01">
								<option value="1" selected>Tiết 1</option>
								<option value="2">Tiết 2</option>
								<option value="3">Tiết 3</option>
								<option value="3">Tiết 4</option>
								<option value="3">Tiết 5</option>
								<option value="3">Tiết 6</option>
								<option value="3">Tiết 7</option>
								<option value="3">Tiết 8</option>
								<option value="3">Tiết 9</option>
								<option value="3">Tiết 10</option>
								<option value="3">Tiết 11</option>
								<option value="3">Tiết 12</option>
								<option value="3">Tiết 13</option>
							</select>
							<label class="font-weight-bold mt-1" for="inputGroupSelect01">Thời gian bắt đầu: </label>
							<div class="input-group date" id="tietbatdau" data-target-input="nearest">
								<input type="text" class="form-control datetimepicker-input" data-target="#tietbatdau"/>
								<div class="input-group-append" data-target="#tietbatdau" data-toggle="datetimepicker">
									<div class="input-group-text"><i class="fas fa-clock"></i></div>
								</div>
							</div>
							<label class="font-weight-bold mt-1" for="inputGroupSelect01">Thời gian kết thúc: </label>
							<div class="input-group date" id="tietketthuc" data-target-input="nearest">
								<input type="text" class="form-control datetimepicker-input" data-target="#tietketthuc"/>
								<div class="input-group-append" data-target="#tietketthuc" data-toggle="datetimepicker">
									<div class="input-group-text"><i class="fas fa-clock"></i></div>
								</div>
							</div>
							<button type="submit" class="btn btn-primary mb-2 mt-3 float-right">Thêm tiết học</button>
							<script type="text/javascript">
								$(function () {
									$('#tietbatdau').datetimepicker({
										format: 'LT'
									});
									$('#tietketthuc').datetimepicker({
										format: 'LT'
									});
								});
							</script>

						</form>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-block">
						<table class="table lesson_table">
							<thead class="thead-light">
								<tr>
									<th scope="col">#</th>
									<th scope="col">Tiết</th>
									<th scope="col">Thời gian bắt đầu</th>
									<th scope="col">Thời gian kết thúc</th>
									<th scope="col">Hoạt động</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>Tiết 1</td>
									<td>7:00 AM</td>
									<td>7:55 AM</td>
									<td class="tool_lesson">
										<ul>
											<li><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
												Launch demo modal
											</button>
										</li>
										<li><a href="">Xóa</a></li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row">1</th>
								<td>Tiết 1</td>
								<td>7:00 AM</td>
								<td>7:55 AM</td>
								<td class="tool_lesson">
									<ul>
										<li><a href="">Sửa</a></li>
										<li><a href="">Xóa</a></li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row">1</th>
								<td>Tiết 1</td>
								<td>7:00 AM</td>
								<td>7:55 AM</td>
								<td class="tool_lesson">
									<ul>
										<li><a href="">Sửa</a></li>
										<li><a href="">Xóa</a></li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row">1</th>
								<td>Tiết 1</td>
								<td>7:00 AM</td>
								<td>7:55 AM</td>
								<td class="tool_lesson">
									<ul>
										<li><a href="">Sửa</a></li>
										<li><a href="">Xóa</a></li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row">1</th>
								<td>Tiết 1</td>
								<td>7:00 AM</td>
								<td>7:55 AM</td>
								<td class="tool_lesson">
									<ul>
										<li><a href="">Sửa</a></li>
										<li><a href="">Xóa</a></li>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									...
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>