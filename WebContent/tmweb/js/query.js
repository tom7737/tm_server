var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	$("#btn_eng_1").click(function() {
		if (document.getElementById("btn_eng_1").checked) {
			$("#btn_eng_1v").val("true");
		} else {
			$("#btn_eng_1v").val("false");
		}
		
	});
	$("#btn_eng_2").click(function() {
		if (document.getElementById("btn_eng_2").checked) {
			$("#btn_eng_2v").val("true");
		} else {
			$("#btn_eng_2v").val("false");
		}
		
	});
	$("#btn_chin_1").click(function() {
		if (document.getElementById("btn_chin_1").checked) {
			$("#btn_chin_1v").val("true");
		} else {
			$("#btn_chin_1v").val("false");
		}

	});
	$("#btn_chin_2").click(function() {
		if (document.getElementById("btn_chin_2").checked) {
			$("#btn_chin_2v").val("true");
		} else {
			$("#btn_chin_2v").val("false");
		}
		
	});
	$("#btn_chin_3").click(function() {
		if (document.getElementById("btn_chin_3").checked) {
			$("#btn_chin_3v").val("true");
		} else {
			$("#btn_chin_3v").val("false");
		}
		
	});
	$("#btn_chin_4").click(function() {
		if (document.getElementById("btn_chin_4").checked) {
			$("#btn_chin_4v").val("true");
		} else {
			$("#btn_chin_4v").val("false");
		}
		
	});
	// 英文查询选项按钮点击事件
	$("#btn_eng_selectall").click(function() {
		if (document.getElementById("btn_eng_selectall").checked) {
			for (var int = 1; int <= 2; int++) {
				if (!$("#btn_eng_" + int).is(":checked")) {
					$("#btn_eng_" + int).attr("checked", true);
					$("#btn_eng_" + int + "v").val("true");
				}
			}
		} else {
			for (var int = 1; int <= 2; int++) {
				if ($("#btn_eng_" + int).is(":checked")) {
					$("#btn_eng_" + int).attr("checked", false);
					$("#btn_eng_" + int + "v").val("false");
				}
			}
		}

	});
	// 中文查询全选按钮点击事件
	$("#btn_chin_selectall").click(function() {
		if (document.getElementById("btn_chin_selectall").checked) {
			for (var int = 1; int <= 4; int++) {
				if (!$("#btn_chin_" + int).is(":checked")) {
					$("#btn_chin_" + int).attr("checked", true);
					$("#btn_chin_" + int + "v").val("true");
				}
			}
		} else {
			for (var int = 1; int <= 4; int++) {
				if ($("#btn_chin_" + int).is(":checked")) {
					$("#btn_chin_" + int).attr("checked", false);
					$("#btn_chin_" + int + "v").val("false");
				}
			}
		}

	});
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
	// 近似查询
	$('#query2').click(function() {
		$("#querytype").val(1);
		mysubmit();
	});
	// 相同查询
	$('#query').click(function() {
		$("#querytype").val(0);
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
		alert("请输入名称！");
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
	quertyTtmWell();
}
function quertyTtmWell() {
	var json = {
		'querystr' : $('#querystr').val()
	};
	$.ajax({
		type : 'POST',
		url : "/tmwell/query.html",
		data : json,
		dataType : "text",
		success : function(json) {
			json = JSON.parse(json);
			if (json.status.code != 200) {
				warn.text(json.status.msg);
				warnDiv.show();
				console.log(json.status.msg);
				return;
			}
			var data = json.resultArray;
			if (data) {
				if (data.length > 0) {
					var alertstr = '驰名商标：\r\n';
					$.each(data, function(index, ttmwell) {
						alertstr += ttmwell.ftmchin + ttmwell.ftmchin2
								+ ttmwell.ftmchin3 + '(' + ttmwell.fsysp + ')'
								+ '\r\n';
					});
					alert(alertstr);
				}
			}
			quertyCommonName();
		}
	});
}
function quertyCommonName() {
	var s = '';
	$('input[name="tmlb"]:checked').each(function() {
		s += $(this).val() + ',';
	});
	if (s.length > 0) {
		// 得到选中的checkbox值序列
		s = s.substring(0, s.length - 1);
	}
	var json = {
		'querystr' : $('#querystr').val(),
		'tmlb' : s
	};
	$.ajax({
		type : 'POST',
		url : "/tcommonname/query.html",
		data : json,
		dataType : "text",
		success : function(json) {
			json = JSON.parse(json);
			if (json.status.code != 200) {
				warn.text(json.status.msg);
				warnDiv.show();
				console.log(json.status.msg);
				return;
			}
			var data = json.resultArray;
			if (data) {
				if (data.length > 0) {
					// for ( var int = 0; int < data.length; int++) {
					$.each(data, function(index, commonname) {
						alert(commonname.flx + '[' + commonname.fname
								+ commonname.fpy + ']');
					});
					// }
				}
			}
			// alertMsg('正在进行查询，请勿进行其他操作',0);
			var exp = new Date();
			$("#subtime").val(exp.getTime());
			document.frm.submit();
		}
	});
}
