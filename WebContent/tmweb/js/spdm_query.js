var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	// 规范查询
	$('#query').click(function() {
		$("#frm").attr("action","/spdmgf/webquery.html");
		mysubmit();
	});
	// 非规范查询
	$('#query2').click(function() {
		$("#frm").attr("action","/spdmfgf/webquery.html");
		mysubmit();
	});
});
function mysubmit() {
	if (is_submit == 1) {
		return false;
	} else {
		is_submit = 1;
		setTimeout('setIsSubmit()', 1000);
	}
	if (xyw_checkspace($('#querystr').val())) {
		alert("请输入查询词！");
		return false;
	}
	document.frm.submit();
}
