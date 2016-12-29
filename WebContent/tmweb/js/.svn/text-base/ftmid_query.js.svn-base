var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	// 商标类别全选按钮点击事件
	$("#select_all").click(function() {
		if (document.getElementById("select_all").checked) {
			var checkTypes = document.getElementsByName("tmlb");
			for (var i = 0; i < checkTypes.length; i++) {
				if (checkTypes[i].checked == false) {
					checkTypes[i].checked = true;
				}
			}
		} else {
			var checkTypes = document.getElementsByName("tmlb");
			for (var i = 0; i < checkTypes.length; i++) {
				if (checkTypes[i].checked == true) {
					checkTypes[i].checked = false;
				}
			}
		}
	});
	// 相同查询
	$('#query').click(function() {
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
	var ftmid=$('#ftmid').val();
	if (xyw_checkspace(ftmid)) {
		alert("请输入注册号！");
		return false;
	}
	if(isNaN(ftmid.substring(1))||(ftmid.substring(0,1)!="G" && ftmid.substring(0,1)!="g"&&isNaN(ftmid.substring(0,1)))){
		alert("请输入正确的注册号！");
		return false;
	}
	if($('#ftmid').val().length>8||$('#ftmid').val().length<6){
		alert("只能查询6~8位的注册号！");
		return false;
	}
	var s = '';
	$('input[name="tmlb"]:checked').each(function() {
		s += $(this).val() + ',';
	});
	if (s.length == 0) {
		alert("请选择商标类别！");
		return false;
	}
	document.frm.submit();
}
