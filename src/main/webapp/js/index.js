$(document).ready(function() {
	var url = "board/get";
	var args = {};
	$.post(url, args, function(data) {
		$("#tech").text(data[0].name);
	});
})