var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}

$(document).ready(function() {
	//			var data = getCookie("querydata");
		//			data = JSON.parse(data);
		//			alert(1);
		//			alert(data);
	});

function dopage(flag) {
	//url="wswdsq_getWdsqCondition.xhtml";
	if (flag == 1) {
		document.getElementById("pagenum").value = 1;
	}
	if (flag == 2 && document.getElementById("pagenum").value > 1) {
		document.getElementById("pagenum").value = parseInt(document
				.getElementById("pagenum").value) - 1;
	}
	if (flag == 3
			&& parseInt(document.getElementById("countpage").value) > parseInt(document
					.getElementById("pagenum").value)) {
		document.getElementById("pagenum").value = parseInt(document
				.getElementById("pagenum").value) + 1;
	}
	if (flag == 4) {
		document.getElementById("pagenum").value = $("#countpage").val();
	}
	pageSubmit();
}
function go_pageNum() {
	//url="wswdsq_getWdsqCondition.xhtml";
	var goNum = $.trim($("#goNum").val());
	var pageNum = document.getElementById("pagenum").value;
	if (goNum == '') {
		document.getElementById("goNum").value = pageNum;
		alert('请输入一个数字');
		return false;
	}
	if (isNaN(goNum)) {
		document.getElementById("goNum").value = pageNum;
		alert('请输入一个数字!');
		return false;
	}
	var reg1 = /^\d+$/;
	if (!reg1.test(goNum)) {
		document.getElementById("goNum").value = pageNum;
		alert('请输入一个正整数!');
		return false;
	}
	var countpage = document.getElementById("countpage").value;
	if (pageNum == goNum) {
		return;
	}
	if (parseInt(countpage) < parseInt(goNum)) {
		document.getElementById("goNum").value = pageNum;
		return false;
	}
	document.getElementById("pagenum").value = parseInt(goNum);
	pageSubmit();
}

function pageSubmit() {
	var pagenum = $("#pagenum").val();
	var pageno = document.getElementById("pageno").firstChild.nodeValue;
	//隐藏原来的数据
	var index = (pageno-1)*50+1;
	var b = index+50;
	for(;index < b;index++){
		$("#tr_"+index).hide(); 
	}	
	//更换页码
	document.getElementById("pageno").firstChild.nodeValue = pagenum;
	//显示数据
	var x = (pagenum-1)*50+1;
	var y = x+50;
	for(;x < y;x++){
		$("#tr_"+x).attr("style","");
	}
}
function getdetail(ftmid, tmlb) {
	$("#ftmid").val(ftmid);
	$("#tmlb").val(tmlb);
	document.frm.submit();
}
