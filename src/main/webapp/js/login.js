$(document).ready(
		function(){
				$("#login").submit(function(){
				
					var url = "user/login";
					var args = $("#login").serialize();
					$.post(url,args,function(result){
						if (result == true) {
							alert("登录成功！");
							window.location.href = "index.html";
						} else
							alert("用户名或密码错误");
					});
					return false;
					
				});
				
				/*			$("#login").validate({
				rules : {
					str : {
						required : true,
						//remote : {}
					},
					password : {
						required : true,
					}
				},
				messages : {
					str: {
						required : "请输入帐号",
					},
					password : {
						required : "请输入密码"
					},
				},
				submitHandler: function(form){
					var url = "user/login";
					var args = $("#login").serialize();
					alert(args);
					$.post(url,args,function(result){
						if (result == true) {
							alert("登录成功！");
							window.location.href = "";
						} else
							alert("用户名或密码错误");
					});
				},
				
			});*/
		}
);