$(document).ready(function() {
	var url = "board/get";
	var args = {};
	$.post(url, args, function(data) {
		for(var i=0; i<data.length; i++) {
			$("#main-div").append("<a href='board/enter?id="+data[i].id+"'>" + data[i].name + "</a>");
			$("#main-div").append("<br />");
		}
		
	});
})