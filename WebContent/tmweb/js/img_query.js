var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	tuxingfirst();
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
	$('#btn_multiple').click(function() {
		$("#querystr").text("");
		$("#querytusu").val("");
	});
	// 相同查询
	$('#query').click(function() {
		mysubmit();
	});
});
function tuxingfirst() {
	var json = {};
	$.ajax({
		type : 'POST',
		url : "/tuxingfirst/getall.html",
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
					d = new dTree('d');
					d.add(0, -1, '商标图素');
					$.each(data, function(index, tuxingfirst) {
						d.add(tuxingfirst.code, 0, tuxingfirst.code + " "
								+ tuxingfirst.name, "javascript:void(0)", "",
								"", "/img/folder.gif", "/img/folderopen.gif");
					});
					$('#usertree').html(d.toString());
				}
			}
		}
	});
}
function tuxingsecond(id) {
	var json = {
		pid : id
	};
	$.ajax({
		type : 'POST',
		url : "/tuxingsecond/getbypid.html",
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
					$.each(data, function(index, tuxingsecond) {
						if (tuxingsecond.upcode == 28
								|| (tuxingsecond.upcode == 3 && tuxingsecond.code == 15 )
								|| (tuxingsecond.upcode == 3 && tuxingsecond.code == 17 )
								|| (tuxingsecond.upcode == 4 && tuxingsecond.code == 7 )
								|| (tuxingsecond.upcode == 19 && tuxingsecond.code == 19 )) {
							var id = tuxingsecond.upcode + "."
									+ tuxingsecond.code;
							d.add(id, tuxingsecond.upcode, id + " "
									+ tuxingsecond.name, "javascript:void(0)");
						} else {
							var id = tuxingsecond.upcode + "."
									+ tuxingsecond.code;
							d.add(id, tuxingsecond.upcode, id + " "
									+ tuxingsecond.name, "javascript:void(0)",
									"", "", "/img/folder.gif",
									"/img/folderopen.gif");
						}
					});
					$('#usertree').html(d.toString());
				}
			}
		}
	});
}
function tuxingthird(id) {
	var json = {
		pid : id
	};
	$.ajax({
		type : 'POST',
		url : "/tuxingthird/getbypid.html",
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
					$.each(data, function(index, tuxingthird) {
						var id = tuxingthird.fupcode + "."
								+ tuxingthird.supcode + "." + tuxingthird.code;
						d.add(id, tuxingthird.fupcode + "."
								+ tuxingthird.supcode, id + " "
								+ tuxingthird.name, "javascript:void(0)");
					});
					$('#usertree').html(d.toString());
				}
			}
		}
	});
}
function addchild(id) {
	var count = (id.split(".")).length - 1;
	if (count == 0) {
		tuxingsecond(id);
	} else if (count == 1) {
		if (id.length - id.replace("28.") == 3 || id == "3.15" || id == "3.17"
				|| id == "4.7" || id == "19.19") {
			addquerytusu(id);
		} else {
			tuxingthird(id);
		}
	} else {
		addquerytusu(id);
	}

}
function addquerytusu(id) {
	if (document.getElementById("btn_multiple").checked) {
		$("#querystr").text(
				$("#querystr").text()
						+ document.getElementById('sd' + id).innerHTML + "\n");
		$("#querytusu").val($("#querytusu").val() + id + ";");
	} else {
		$("#querystr").text(document.getElementById('sd' + id).innerHTML);
		$("#querytusu").val(id+ ";");
	}
}
function mysubmit() {
	if (is_submit == 1) {
		return false;
	} else {
		is_submit = 1;
		setTimeout('setIsSubmit()', 1000);
	}
	if (xyw_checkspace($('#querytusu').val())) {
		alert("请选择查询图素！");
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

