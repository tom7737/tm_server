var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}

$(document).ready(function() {
	netxTuxing();
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
			"querytusu":$("#querytusu").val(),
			"radio_multiple":$("#radio_multiple").val()
	};
	$.ajax({
		type : 'POST',
		url : "/tmtuxing/mwebquery2.html",
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
			if (data.list) {
				if (data.list.length > 0) {
					//修改当前页
					$("#pageno").val(parseInt($("#pageno").val())+1);
					var pageno = parseInt(data.pageno);
					var pagesize =parseInt(data.pagesize);
					var countno =parseInt(data.countno);
					var maxpage =parseInt(data.maxpage);
					var addimg = "<div id='img_div_"+pageno+"'>";
					var screenwidth = document.body.clientWidth/2-2;
					$.each(data.list, function(index, ttuxinggj) {
						var tmtype = (ttuxinggj.tmtype< 10 ? '0':'')+ttuxinggj.tmtype;
						addimg+="<img src='/tuxing/"+tmtype+"/"+ttuxinggj.ftmid+".jpg' " +
							"alt='' style='height:"+screenwidth+"px; width: "+screenwidth+"px;border:1px solid #900;' " +
							"onclick='getdetail(\""+ttuxinggj.ftmid+"\",\""+tmtype+"\")' />";
						
					});
					addimg+="</div>";
					//添加页面
					//alert(addimg);
					$("#img_div").append(addimg);
					//添加页码
					$("#img_div").append("<div id='count_div_'"+pageno+"><p name = '"+pageno+"' align='center'>"+((pageno-1)*pagesize+1)+" ~ "+(((pageno-1)+1)*pagesize)+"</p></div>");
					if(pageno==maxpage){
						$("#query").val("已经是最后一页了 "+countno);
						$("#query").attr("onclick","");
					}else{
						$("#query").val("加载下一页  ("+(pageno*pagesize+1)+" ~ "+((pageno+1)*pagesize)+")/"+countno);
						$("#query").attr("onclick","netxTuxing();");
					}
//					location.href = "#"+pageno;
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

