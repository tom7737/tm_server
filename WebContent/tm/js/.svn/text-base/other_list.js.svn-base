var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}

$(document).ready(function() {
	if($("#countno").val()==0){
		netxTuxing();
	}
	// var data = getCookie("querydata");
	// data = JSON.parse(data);
	// alert(1);
	// alert(data);
});
function netxTuxing() {
	$("#query").val("加载中...");
	$("#query").attr("onclick","");
	var json = {
			"pageno":parseInt($("#pageno").val())+1,
			"pagesize":$("#pagesize").val(),
			"querytmlb":$("#querytmlb").val(),
			"querystr":$("#querystr").val(),
			"querytype":$("#querytype").val(),
			"countno":$("#countno").val(),
			"field":$("#field").val()
	};
	$.ajax({
		type : 'POST',
		url : "/other/mwebquery.html",
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
			var data = json.result;
			$("#countno").val(data.countno);
			if (data.list) {
				if (data.list.length > 0) {
					// 修改当前页
					$("#pageno").val(parseInt($("#pageno").val())+1);
					var pageno = parseInt(data.pageno);
					var pagesize =parseInt(data.pagesize);
					var countno =parseInt(data.countno);
					var maxpage =parseInt(data.maxpage);
					var addother = '';
//					(data.querytmlb< 10 ? '0':'')+
					var ftmlb = data.querytmlb;
					$.each(data.list, function(index, ttmnew) {
						addother +='<tr class="t_table_tr'+(index %2!=0?2:'')+'" onclick="getdetail(\''+ttmnew.ftmid+'\',\''+ftmlb+'\');"><td class="t_table_td_bianhao"><nobr> '+((pageno-1)*pagesize+index+1)+' </nobr></td><td class="t_table_td_left"><nobr> '+ftmlb+' </nobr></td><td class="t_table_td_right"><nobr>'+(ttmnew.ftmchin ==null ?"":ttmnew.ftmchin)+(ttmnew.ftmeng==null ?"":ttmnew.ftmeng)+(ttmnew.ftmpy==null ?"":ttmnew.ftmpy)+(ttmnew.ftmhead==null ?"":ttmnew.ftmhead)+(ttmnew.ftmsz==null ?"":ttmnew.ftmsz)+'</nobr></td></tr>';
					});
					// 添加页面
//					 alert(addother);
					$("#other_div").append(addother);
//					// 添加页码
//					$("#other_div").append("<div id='count_div_'"+pageno+"><p name = '"+pageno+"' align='center'>"+((pageno-1)*pagesize+1)+" ~ "+(((pageno-1)+1)*pagesize)+"</p></div>");
					if(pageno==maxpage){
						$("#query").val("已经是最后一页了 "+countno);
						$("#query").attr("onclick","");
					}else{
						$("#query").val("加载下一页  ("+(pageno*pagesize+1)+" ~ "+((pageno+1)*pagesize)+")/"+countno);
						$("#query").attr("onclick","netxTuxing();");
					}
// location.href = "#"+pageno;
				}else{
					$("#query").val("没有查询出任何数据！");
				}
			}
		}
	});
}
function getdetail(ftmid, tmlb) {
	// alert(1);
	// alert(ftmid);
	$("#ftmid").val(ftmid);
	$("#tmlb").val(tmlb);
	document.frm.submit();
}

