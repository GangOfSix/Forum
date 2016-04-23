$(document).ready(function() {
	var url = "board/get";
	var args = {};
	$.post(url, args, function(data) {
/*		for(var i=0; i<data.length; i++) {
			$("#main-div").append("<a>" + data[i].name + "</a>");
			$("#main-div").append("<br />");
		}*/
		
	});
})