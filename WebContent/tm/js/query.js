var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {

	// 英文查询选项按钮点击事件
	$("input[name='btn_eng']").click(function() {
		if ($(this).attr("class") == "tinput5") {
			$(this).removeClass("tinput5").addClass("tinput6");
			var id = $(this).attr("id");
			$("#"+id+"v").val("true");
			if($("#btn_eng_1").attr("class")=="tinput6"
				&& $("#btn_eng_2").attr("class")=="tinput6"
				&& $("#btn_eng_selectall").attr("class") == "tinput"){
				$("#btn_eng_selectall").removeClass("tinput").addClass("tinput2");
			}
		} else {
			$(this).removeClass("tinput6").addClass("tinput5");
			var id = $(this).attr("id");
			$("#"+id+"v").val("false");
			if( $("#btn_eng_selectall").attr("class") == "tinput2"){
				$("#btn_eng_selectall").removeClass("tinput2").addClass("tinput");
			}
		}
	});
	// 英文查询全选按钮点击事件
	$("#btn_eng_selectall").click(function(){
		if ($(this).attr("class") == "tinput") {
			$(this).removeClass("tinput").addClass("tinput2");
			for ( var int = 1; int <= 2; int++) {
				if($("#btn_eng_" + int).attr("class")=="tinput5"){
					$("#btn_eng_" + int).removeClass("tinput5").addClass("tinput6");
					$("#btn_eng_" + int+"v").val("true");
				}
			}
		} else {
			$(this).removeClass("tinput2").addClass("tinput");
			for ( var int = 1; int <= 2; int++) {
				if($("#btn_eng_" + int).attr("class")=="tinput6"){
				$("#btn_eng_" + int).removeClass("tinput6").addClass("tinput5");
				$("#btn_eng_" + int+"v").val("false");
				}
			}
		}
	});
	// 中文查询选项按钮点击事件
	$("input[name='btn_chin']").click(function() {
		if ($(this).attr("class") == "tinput3") {
			$(this).removeClass("tinput3").addClass("tinput4");
			var id = $(this).attr("id");
			$("#"+id+"v").val("true");
			if($("#btn_chin_1").attr("class")=="tinput4"
				&& $("#btn_chin_2").attr("class")=="tinput4"
				&& $("#btn_chin_3").attr("class")=="tinput4"
				&& $("#btn_chin_4").attr("class")=="tinput4"
				&& $("#btn_chin_selectall").attr("class") == "tinput"){
				$("#btn_chin_selectall").removeClass("tinput").addClass("tinput2");
			}
		} else {
			$(this).removeClass("tinput4").addClass("tinput3");
			var id = $(this).attr("id");
			$("#"+id+"v").val("false");
			if( $("#btn_chin_selectall").attr("class") == "tinput2"){
				$("#btn_chin_selectall").removeClass("tinput2").addClass("tinput");
			}
		}
	});
	// 中文查询全选按钮点击事件
	$("#btn_chin_selectall").click(function(){
		if ($(this).attr("class") == "tinput") {
			$(this).removeClass("tinput").addClass("tinput2");
			for ( var int = 1; int <= 4; int++) {
				if($("#btn_chin_" + int).attr("class")=="tinput3"){
					$("#btn_chin_" + int).removeClass("tinput3").addClass("tinput4");
					$("#btn_chin_" + int+"v").val("true");
				}
			}
		} else {
			$(this).removeClass("tinput2").addClass("tinput");
			for ( var int = 1; int <= 4; int++) {
				if($("#btn_chin_" + int).attr("class")=="tinput4"){
				$("#btn_chin_" + int).removeClass("tinput4").addClass("tinput3");
				$("#btn_chin_" + int+"v").val("false");
				}
			}
		}
	});
	//商标类别全选按钮点击事件
	$("#select_all").click(function() {
		if ($(this).attr("class") == "t_btn_selectall1") {
			$(this).removeClass("t_btn_selectall1").addClass("t_btn_selectall2");
			$("#tmlb").val("0");
			for ( var int = 1; int <= 45; int++) {
				$("#btn_tmlb_" + int).removeClass("t_btn_tmlb1").addClass("t_btn_tmlb2");
			}
		} else {
			$(this).removeClass("t_btn_selectall2").addClass("t_btn_selectall1");
			$("#tmlb").val("");
			for ( var int = 1; int <= 45; int++) {
				$("#btn_tmlb_" + int).removeClass("t_btn_tmlb2").addClass("t_btn_tmlb1");
			}
		}
		
	});
	//商标类别按钮点击事件
	$("input[name='btn_tmlb']").click(function() {
		if ($(this).attr("class") == "t_btn_tmlb1") {
			$(this).removeClass("t_btn_tmlb1").addClass("t_btn_tmlb2");
		} else {
			$(this).removeClass("t_btn_tmlb2").addClass("t_btn_tmlb1");
		}
		var tmlb = "";
		for ( var int = 1; int <= 45; int++) {
			if ($("#btn_tmlb_" + int).attr("class") == "t_btn_tmlb2") {
				if(int <10){
					tmlb+="0"+int+",";
				}else{
					tmlb+=int+",";
				}
			}
		}
		if(!xyw_checkspace(tmlb)){
			if(tmlb.length>2){
				$("#tmlb").val(tmlb.substring(0, tmlb.length-1));
			}else{
				$("#tmlb").val(tmlb);
			}
		}else{
			$("#tmlb").val("");
		}
	});
	//近似查询
	$('#query2').click(function() {
		$("#querytype").val(1);
		 mysubmit();
	});
	//相同查询
	$('#query').click(function() {
		$("#querytype").val(0);
		 mysubmit();
	});
});
function mysubmit(){
	if (is_submit == 1) {
		return false;
	} else {
		is_submit = 1;
		setTimeout('setIsSubmit()', 1000);
	}
	if (xyw_checkspace($('#querystr').val())) {
		$('#querystr').focus();
		alert("请输入名称！");
		return false;
	}
	if (xyw_checkspace($('#tmlb').val())) {
		$('#tmlb').focus();
		alert("请选择商标类别！");
		return false;
	}
	quertyTtmWell();
}
function quertyTtmWell(){
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
				alertstr +=ttmwell.ftmchin+ttmwell.ftmchin2+ttmwell.ftmchin3+'('+ttmwell.fsysp+')'+'\r\n';
			});
			alert(alertstr);
		 }
     }
	 quertyCommonName();
	 }
	 });
}
function quertyCommonName(){
	var json = {
			'querystr' : $('#querystr').val(),
			'tmlb' : $('#tmlb').val(),
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
//					for ( var int = 0; int < data.length; int++) {
						$.each(data, function(index, commonname) {
						alert(commonname.flx+'['+commonname.fname+commonname.fpy+']');
						});
//					}
				} 
			}
			alertMsg('正在进行查询，请勿进行其他操作',0);
			document.frm.submit();
		}
	});
}
