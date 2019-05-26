<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container">
	<div class="row row-calendar">
		<div class="chucnang tdExpandInBounce animated">
			<div class="row">
				<div class="col-md-12">
					<h1>Thêm thời khóa biểu</h1>
					<div class="themlichtkb">
						<form:form method="POST" modelAttribute="scheduleCreate"
							action="${contextPath}/schedule/create">
							<spring:bind path="semester">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label for="semester">Chọn học kỳ:</label>
									<form:select path="semester" class="custom-select">
										<form:option value="-" label="--Chọn một giá trị--" />
										<form:options items="${semesters}" />
									</form:select>
									<form:errors path="semester" />
								</div>
							</spring:bind>

							<spring:bind path="studentId">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="mt-4" for="studentId">Mã sinh viên/ giảng
										viên:</label>
									<form:input path="studentId" id="studentId"
										class="form-control" title="Mã GV/SV có 5/6 kí tự" type="text"
										pattern=".{5,6}" />
									<form:errors path="studentId" />
								</div>
							</spring:bind>

							<button type="submit"
								class="btn btn-primary mt-4 float-right w-25">Thêm lịch</button>
						</form:form>
						<div class="backhome">
							<a href="../home">Dùng các chức năng khác</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>