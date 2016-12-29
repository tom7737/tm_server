var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	// 相同查询
	$('#query').click(function() {
		$("#querytype").val("eq");
		mysubmit();
	});
	// 近似查询
	$('#query2').click(function() {
		$("#querytype").val("like");
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
		$('#querystr').focus();
		alert("请输入查询词！");
		return false;
	}
	if (xyw_checkspace($('#querytmlb').val())) {
		$('#querytmlb').focus();
		alert("请输入查询商标类别！");
		return false;
	}
	if (isNaN($('#querytmlb').val())) {
		$('#querytmlb').focus();
		alert("请输入数字！");
		return false;
	}
	if ($('#querytmlb').val() < 1 || $('#querytmlb').val() > 45) {
		$('#querytmlb').focus();
		alert("请输入1~45之间数字！");
		return false;
	}
	document.frm.submit();
}
