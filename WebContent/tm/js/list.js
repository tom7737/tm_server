var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}

$(document).ready(
		function() {
//			var data = getCookie("querydata");
//			data = JSON.parse(data);
//			alert(1);
//			alert(data);
		});
function getdetail(ftmid,tmlb){
//	alert(1);
//	alert(ftmid);
	$("#ftmid").val(ftmid);
	$("#tmlb").val(tmlb);
	document.frm.submit();
}
