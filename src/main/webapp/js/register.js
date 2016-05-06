$(document).ready(function() {
	$("#button").click(
			function() {
				if (validate.form()) {
					var url = "user/register";
					var args = $("#register").serialize();
					alert("click");
					// alert(validate.form());
					
					$.post(url, args, function(data) {
						if (data == "success") {
							alert("注册成功！");
							window.location.href = "";
						} else
							alert("fail");
					});
				} else
					alert("validate fail");

			});
	jQuery.validator
			.addMethod(
					"stringCheck",
					function(value, element) {
						return this.optional(element)
								|| /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9_\u4e00-\u9fa5]+$/
										.test(value);
	
					}, "只能包括中文字、英文字母、数字和下划线");
	
	jQuery.validator
			.addMethod(
					"initialCheck",
					function(value, element) {
						return this.optional(element)
								|| /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9_\u4e00-\u9fa5]{0,15}$/
										.test(value);
	
					}, "请以中文字或英文字母开头");
	
	// 中文字两个字节
	jQuery.validator.addMethod("byteRangeLength", function(
			value, element, param) {
		var length = value.length;
		for (var i = 0; i < value.length; i++) {
			if (value.charCodeAt(i) > 127) {
				length++;
			}
		}
		return this.optional(element)
				|| (length >= param[0] && length <= param[1]);
	}, "请确保输入的值在2-15个字节之间(一个中文字算2个字节)");
	
	var validate = $("#register").validate({

		rules : {
			nickname : {
				required : true,
				initialCheck : true,
				minlength : 2,
				stringCheck : true,
				maxlength : 15,
				byteRangeLength : [ 2, 15 ],
				remote : {                                          // 验证用户名是否存在
			         type:"POST",
			         url:"user/validate",
			          
			         data:{nickname:function(){return $("#nickname").val();}}
				}
			},
			password : {
				required : true,
				minlength : 6,
				maxlength : 20
			},
			confirm_password : {
				required : true,
				
				equalTo : "#password"
			},
			phonenumber : {
				required : true,
				digits : true,
				minlength : 11,
				maxlength : 11
			},
			email : {
				required : true,
				email : true
			}
		},
	
		messages : {
	
			nickname : {
				required : "请填写用户名",
				minlength : "用户名太短",
				maxlength : "用户名过长",
				remote:"用户名已经被注册"
	
			},
	
			password : {
				required : "请填写密码",
				minlength : "密码不能小于{0}个字符",
				maxlength : "密码不能大于{0}个字符"
			},
			confirm_password : {
				required : "请确认密码",
				
				equalTo : "两次输入密码不一致"
			},
			phonenumber : {
				required : "请填写手机号码",
				digits : "请填写正确格式的手机号码",
				minlength : "请填写正确格式的手机号码",
				maxlength : "请填写正确格式的手机号码"
			},
			email : {
				required : "请输入电子邮箱",
				email : "邮箱格式不正确"
				}
			},
	
			onfocusout : function(element) {
				$(element).valid();
			},
	
		
/*		  submitHandler: function(form) { //通过之后回调
			  var url ="user/userRegister"; var args = $("#register").serialize();
			  alert("click"); alert(validate.form());
			  
			  $.post(url, args, function(data) { if (data == "success") {
			  alert("注册成功！"); window.location.href = ""; } else alert("fail"); }); }*/
		 
	});
	
})
