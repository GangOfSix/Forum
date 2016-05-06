$(document).ready(function(){

	$("#button").click(function(){
		
		alert("click");
		var url = "post/posting";
		var args = $("#posting").serialize();
		$.post(url, args, function(data) {
			
			if (data == "success") {
				alert("发帖成功！");
				window.location.href = "";
			} else
				alert("fail");
		});
	});

	
});