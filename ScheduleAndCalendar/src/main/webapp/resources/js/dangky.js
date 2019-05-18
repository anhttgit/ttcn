$(document).ready(function() {

	function validateEmail(email) {
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(String(email).toLowerCase());
	}

	$("#fullname").keyup(function(){
		$("#sokytu").text($("#fullname").val().length);
	});


	$("#btn_submit_register").click(function(){
		if($("#fullname").val() == ""){
			toastr.warning('Vui lòng nhập tên đầy đủ!','Thông báo');
		}else if($("#email").val() == ""){
			toastr.warning('Vui lòng nhập địa chỉ Email!','Thông báo');
		}else if($("#username").val() == ""){
			toastr.warning('Vui lòng nhập tên tài khoản!','Thông báo');
		}else if($("#password").val() == ""){
			toastr.warning('Vui lòng nhập mật khẩu!','Thông báo');
		}else if($("#repassword").val() == ""){
			toastr.warning('Vui lòng nhập lại mật khẩu lần nữa!','Thông báo');
		}else{
			if($("#email").val() != ""){
				if(!validateEmail($("#email").val())){
					toastr.warning('Vui lòng nhập đúng định dạng địa chỉ Email!','Thông báo');
				}else if($("#password").val() != $("#repassword").val()){
					toastr.warning('Mật khẩu nhập lại không trùng khớp!','Thông báo');
				}else{
					 $("#register_form").submit();
				}
			}

		}
	});
});