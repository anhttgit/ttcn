$(document).ready(function() {
	//Khi người dùng nhấn xác nhận
	$("#btn_submit").click(function(){
		var username = $("#username");
		var password = $("#password");

		if(username.val() == "" || password.val() == ""){
			if(username.val() == ""){
				toastr.warning('Vui lòng nhập tên tài khoản!','Thông báo');
			}else if(password.val() == ""){
				toastr.warning('Vui lòng nhập mật khẩu!','Thông báo');
			}
		}
	});
});