var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}

$(document).ready(function() {
	$("#goback").click(function(){
		history.go(-1);
	});
	$("#goindex").click(function(){
		location.href="/tm/index.jsp";
	});
});
