<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container mt-5">
	<div class="row">
		<div class="col-md-4">
			<div class="card">
				<h4 class="card-title border-bottom p-2 bg-primary">Thời gian
					bắt đầu kì</h4>
				<div class="card-block p-3">
					<form>
						<div class="input-group date" id="batdaukimoi"
							data-target-input="nearest">
							<input type="text" class="form-control datetimepicker-input"
								data-target="#batdaukimoi" />
							<div class="input-group-append" data-target="#batdaukimoi"
								data-toggle="datetimepicker">
								<div class="input-group-text">
									<i class="fa fa-calendar"></i>
								</div>
							</div>
						</div>
						<button type="submit"
							class="btn btn-primary mb-2 mt-3 float-right">Cập nhật</button>
						<script type="text/javascript">
							$(function() {
								$('#batdaukimoi').datetimepicker({
									format : 'L',
									defaultDate : "11/17/1999",
								});
							});
						</script>
					</form>
				</div>
			</div>

			<!-- Thiết lập thời gian bắt đầu, kết thúc-->
			<div class="card mt-3 mb-4">
				<h4 class="card-title border-bottom p-2 bg-primary">Thêm tiết
					học</h4>
				<div class="card-block p-3">
					<form>
						<label class="font-weight-bold" for="inputGroupSelect01">Chọn
							tiết: </label> <select class="custom-select" id="inputGroupSelect01">
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
						</select> <label class="font-weight-bold mt-1" for="inputGroupSelect01">Thời
							gian bắt đầu: </label>
						<div class="input-group date" id="tietbatdau"
							data-target-input="nearest">
							<input type="text" class="form-control datetimepicker-input"
								data-target="#tietbatdau" />
							<div class="input-group-append" data-target="#tietbatdau"
								data-toggle="datetimepicker">
								<div class="input-group-text">
									<i class="fas fa-clock"></i>
								</div>
							</div>
						</div>
						<label class="font-weight-bold mt-1" for="inputGroupSelect01">Thời
							gian kết thúc: </label>
						<div class="input-group date" id="tietketthuc"
							data-target-input="nearest">
							<input type="text" class="form-control datetimepicker-input"
								data-target="#tietketthuc" />
							<div class="input-group-append" data-target="#tietketthuc"
								data-toggle="datetimepicker">
								<div class="input-group-text">
									<i class="fas fa-clock"></i>
								</div>
							</div>
						</div>
						<button type="submit"
							class="btn btn-primary mb-2 mt-3 float-right">Thêm tiết
							học</button>
						<script type="text/javascript">
							$(function() {
								$('#tietbatdau').datetimepicker({
									format : 'LT'
								});
								$('#tietketthuc').datetimepicker({
									format : 'LT'
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
										<li><button type="button" class="btn btn-primary"
												data-toggle="modal" data-target="#exampleModal">
												Launch demo modal</button></li>
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
					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
										changes</button>
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