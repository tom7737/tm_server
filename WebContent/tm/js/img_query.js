var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {
	tuxingfirst();
	// 基本选项按钮点击事件
	$("#btn_jb").click(function() {
		if ($(this).attr("class") == "tinput5") {
			$(this).removeClass("tinput5").addClass("tinput6");
			$("#btn_ts").removeClass("tinput6").addClass("tinput5");
			$("#ts_div").hide();
			$("#jb_div").show();
		}
	});
	// 图素选项按钮点击事件
	$("#btn_ts").click(function() {
		if ($(this).attr("class") == "tinput5") {
			$(this).removeClass("tinput5").addClass("tinput6");
			$("#btn_jb").removeClass("tinput6").addClass("tinput5");
			$("#jb_div").hide();
			$("#ts_div").show();
		}
	});
	// 交叉按钮点击事件
	$("#btn_eng_1").click(function() {
		if ($(this).attr("class") == "tinput5") {
			$(this).removeClass("tinput5").addClass("tinput6");
			$("#btn_eng_2").removeClass("tinput6").addClass("tinput5");
			$("#radio_multiple").val('and');
		}
	});
	// 合并按钮点击事件
	$("#btn_eng_2").click(function() {
		if ($(this).attr("class") == "tinput5") {
			$(this).removeClass("tinput5").addClass("tinput6");
			$("#btn_eng_1").removeClass("tinput6").addClass("tinput5");
			$("#radio_multiple").val('or');
		}
	});
	// 多个图素查询按钮点击事件
	$("#btn_multiple").click(function() {
		$("#querystr").text("");
		$("#querytusu").val("");
		if ($(this).attr("class") == "tinput") {
			$(this).removeClass("tinput").addClass("tinput2");
			$(this).val('已选择多图素查询');
		} else {
			$(this).removeClass("tinput2").addClass("tinput");
			$(this).val('点击选择多图素查询');
		}
	});
	// 相同查询
	$('#query').click(function() {
		$("#querytype").val(0);
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
	$
			.ajax({
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
							$
									.each(
											data,
											function(index, tuxingsecond) {
												if (tuxingsecond.upcode == 28
														|| (tuxingsecond.upcode == 3 && tuxingsecond.code == 15)
														|| (tuxingsecond.upcode == 3 && tuxingsecond.code == 17)
														|| (tuxingsecond.upcode == 4 && tuxingsecond.code == 7)
														|| (tuxingsecond.upcode == 19 && tuxingsecond.code == 19)) {
													var id = tuxingsecond.upcode
															+ "."
															+ tuxingsecond.code;
													d
															.add(
																	id,
																	tuxingsecond.upcode,
																	id
																			+ " "
																			+ tuxingsecond.name,
																	"javascript:void(0)");
												} else {
													var id = tuxingsecond.upcode
															+ "."
															+ tuxingsecond.code;
													d
															.add(
																	id,
																	tuxingsecond.upcode,
																	id
																			+ " "
																			+ tuxingsecond.name,
																	"javascript:void(0)",
																	"",
																	"",
																	"/img/folder.gif",
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
	if(($("#querytusu").val().split(";")).length>10){
		return;
	}
	if ($("#btn_multiple").attr("class") == "tinput2") {
		$("#querystr").text(
				$("#querystr").text()
						+ document.getElementById('sd' + id).innerHTML + "\n");
		$("#querytusu").val($("#querytusu").val() + id + ";");
	} else {
		$("#querystr").text(document.getElementById('sd' + id).innerHTML);
		$("#querytusu").val(id + ";");
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
		$('#querytusu').focus();
		alert("请选择查询图素！");
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
	if ($('#querytmlb').val()<1||$('#querytmlb').val()>45) {
		$('#querytmlb').focus();
		alert("请输入1~45之间数字！");
		return false;
	}
	document.frm.submit();
}
