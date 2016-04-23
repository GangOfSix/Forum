$(document).ready(function() {
	$("#disappear-a").click(function () {
		$("#nav-div").fadeOut();
		$("#bars-div").fadeIn();
	});

	$("#bars-div").click(function () {
		$("#nav-div").fadeIn();
		$(this).fadeOut();
	});

})