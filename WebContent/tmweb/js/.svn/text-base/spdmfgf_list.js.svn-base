var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}

$(document).ready(function() {
	// var data = getCookie("querydata");
	// data = JSON.parse(data);
	// alert(1);
	// alert(data);
});

function dopage(flag) {
	// url="wswdsq_getWdsqCondition.xhtml";
	if (flag == 1 && document.getElementById("pageno").value > 1) {
		document.getElementById("pageno").value = 1;
	} else if (flag == 2 && document.getElementById("pageno").value > 1) {
		document.getElementById("pageno").value = parseInt(document
				.getElementById("pageno").value) - 1;
	} else if (flag == 3
			&& parseInt(document.getElementById("maxPage").value) > parseInt(document
					.getElementById("pageno").value)) {
		document.getElementById("pageno").value = parseInt(document
				.getElementById("pageno").value) + 1;
	} else if (flag == 4
			&& parseInt(document.getElementById("maxPage").value) > parseInt(document
					.getElementById("pageno").value)) {
		document.getElementById("pageno").value = $("#maxPage").val();
	} else {
		return;
	}
	pageSubmit();
}
function go_pageNum() {
	// url="wswdsq_getWdsqCondition.xhtml";
	var goNum = $.trim($("#goNum").val());
	var pageNum = document.getElementById("pageno").value;
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
	var countpage = document.getElementById("maxPage").value;
	if (pageNum == goNum) {
		return;
	}
	if (parseInt(countpage) < parseInt(goNum)) {
		document.getElementById("goNum").value = pageNum;
		return false;
	}
	document.getElementById("pageno").value = parseInt(goNum);
	pageSubmit();
}
function pageSubmit() {
	alertMsg('正在进行查询，请勿进行其他操作', 0);
	document.other_query_frm.submit();
}
function getdetail(page) {
	$("#page").val(page);
	document.frm.submit();
}

