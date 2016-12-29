var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	// var screenwidth = document.body.clientWidth;
	// $("#spdmimg").attr("style","width:"+screenwidth+"px;");
	// 规范查询
	$('#query').click(function() {
		$("#page").val(parseInt($("#page").val()) - 1);
		var pageno = $("#page").val();
		$("#spdmimg").attr("src", "/img/spdm/" + pageno + ".jpg");
//		mysubmit();
	});
	// 非规范查询
	$('#query2').click(function() {
		$("#page").val(parseInt($("#page").val()) + 1);
		var pageno = $("#page").val();
		$("#spdmimg").attr("src", "/img/spdm/" + pageno + ".jpg");
//		mysubmit();
	});
});
function mysubmit() {
	if (is_submit == 1) {
		return false;
	} else {
		is_submit = 1;
		setTimeout('setIsSubmit()', 1000);
	}
	document.frm.submit();
}
