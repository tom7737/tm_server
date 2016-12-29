var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	// 商标类别全选按钮点击事件
	$("#select_all").click(function() {
		if (document.getElementById("select_all").checked) {
			var checkTypes = document.getElementsByName("checked_tmlb");
			for (var i = 0; i < checkTypes.length; i++) {
				if (checkTypes[i].checked == false) {
					checkTypes[i].checked = true;
				}
			}
		} else {
			var checkTypes = document.getElementsByName("checked_tmlb");
			for (var i = 0; i < checkTypes.length; i++) {
				if (checkTypes[i].checked == true) {
					checkTypes[i].checked = false;
				}
			}
		}
	});
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
		alert("请输入查询词！");
		return false;
	}
	$("#querytmlbs").val("");
	var s = "";
	$('input[name="checked_tmlb"]:checked').each(function() {
		s += $(this).val() + ',';
	});
	if (s.length == 0) {
		alert("请选择商标类别！");
		return false;
	}else{
		$("#querytmlbs").val(s);
	}
	document.frm.submit();
}
