//Check All Checkbox
$("document").ready(function(){
	//全选
	$("#slt").click(function(){
	    $("input[name='chk[]']").each(function(){
	        $(this).attr("checked",!this.checked);});
	});
	//
});
//下拉条
function xyw_xialatiao(request_url,dom_str,pam_str,dom_width,dom_left,dom_top) {
	var bool;
	$("#"+dom_str).after('<div class="xialatiao_div" id="xialatiao_div_'+dom_str+'" style="display:none; position:absolute; z-index:2; width: '+dom_width+'px; left: '+dom_left+'px; top: '+dom_top+'px;"></div>');
	$("#"+dom_str).keyup(function() {
		var dom_strcontent = $.trim($("#"+dom_str).val());
		if (dom_strcontent.length == 0) {
			$("#xialatiao_div_"+dom_str).hide();
		}
		else {
			$.ajax({
				type: "POST",
				url: request_url,
				data:pam_str+'='+dom_strcontent,
				success: function(msg) {
					$("#xialatiao_div_"+dom_str).show();
					$("#xialatiao_div_"+dom_str).html(msg);
					$("#xialatiao_div_"+dom_str+" #xialatiao_table tr td").click(function() {
						$("#"+dom_str).val($(this).html());
						$("#xialatiao_div_"+dom_str).hide();
					})
					.hover(function() {
						bool = 0;
					}, function() {
						bool = 1;
					})
				}
			})
		}
	})
	.blur(function() {
		if (bool == 1) {
			$("#xialatiao_div_"+dom_str).hide();
		}
	})
}
//检查空白
function xyw_checkspace(checkstr) {
  var str = '';
  for(i = 0; i < checkstr.length; i++) {
    str = str + ' ';
  }
  return (str == checkstr);
}
//判断复选框是否选中
function xyw_checkbox(xyw_checkbox_str) { 
	var falg = 0; 
	$("input[name='"+xyw_checkbox_str+"']:checkbox").each(function () { 
		if ($(this).attr("checked")) { 
			falg =1; 
			return false; 
		} 
	}) 
	if (falg > 0)
		return true; 
	else 
		return false; 
}
//判断e-mail
function xyw_checkemail(xyw_checkemail_str){
	var reg = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
	var email_val = $("#"+xyw_checkemail_str+"").val();
	return reg.test(email_val);   
}
//删除、更新按钮提交
function xyw_updatedel(xyw_updatedel_str){
	if(confirm("请确认要执行此操作?")==true) {
		if(xyw_checkbox(xyw_updatedel_str) == false){
			alert('请选择对应信息！');
			return false;
		}
	}else{
		return false;
	}
}
//编辑器扩展代码
var allPlugin={
	Code:{c:'btnCode',t:'插入代码',h:1,e:function(){
		var _this=this;
		var htmlCode='<div><select id="xheCodeType"><option value="html">HTML/XML</option><option value="js">Javascript</option><option value="css">CSS</option><option value="php">PHP</option><option value="java">Java</option><option value="py">Python</option><option value="pl">Perl</option><option value="rb">Ruby</option><option value="cs">C#</option><option value="c">C++/C</option><option value="vb">VB/ASP</option><option value="">其它</option></select></div><div><textarea id="xheCodeValue" wrap="soft" spellcheck="false" style="width:300px;height:100px;" /></div><div style="text-align:right;"><input type="button" id="xheSave" value="确定" /></div>';			var jCode=$(htmlCode),jType=$('#xheCodeType',jCode),jValue=$('#xheCodeValue',jCode),jSave=$('#xheSave',jCode);
		jSave.click(function(){
			_this.loadBookmark();
			_this.pasteHTML('<pre class="prettyprint lang-'+jType.val()+'">'+_this.domEncode(jValue.val())+'</pre>');
			_this.hidePanel();
			return false;	
		});
		_this.saveBookmark();
		_this.showDialog(jCode);
		}},
		map:{c:'btnMap',t:'插入Google地图',e:function(){
			var _this=this;
			_this.saveBookmark();
			_this.showIframeModal('Google 地图','/xheditor/demos/googlemap/googlemap.html',function(v){
				_this.loadBookmark();
				_this.pasteHTML('<img src="'+v+'" />');
			},538,404);
		}}
	};


var pickerOpts = {
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		dayNamesMin:["日","一","二","三","四","五","六"],
		firstDay: 0,
		nextText: "下一月",
		prevText: "上一月",
		monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		isRTL: false,
		yearRange: "-5:+5"        
};

function setCookie(name, value)// 两个参数，一个是cookie的名子，一个是值
{
	var Days = 30; // 此 cookie 将被保存 30 天
	var exp = new Date(); // new Date("December 31, 9998");
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();
}
function getCookie(name)// 取cookies函数
{
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null)
		return unescape(arr[2]);
	return null;

}
function delCookie(name)// 删除cookie
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}
function alertMsg(msg, mode) { // mode为空，即只有一个确认按钮，mode为1时有确认和取消两个按钮
	msg = msg || '';
	mode = mode || 0;
	var top = document.body.scrollTop || document.documentElement.scrollTop;
	var isIe = (document.all) ? true : false;
	var isIE6 = isIe && !window.XMLHttpRequest;
	var sTop = document.documentElement.scrollTop || document.body.scrollTop;
	var sLeft = document.documentElement.scrollLeft || document.body.scrollLeft;
	var winSize = function() {
		var xScroll, yScroll, windowWidth, windowHeight, pageWidth, pageHeight;
		// innerHeight获取的是可视窗口的高度，IE不支持此属性
		if (window.innerHeight && window.scrollMaxY) {
			xScroll = document.body.scrollWidth;
			yScroll = window.innerHeight + window.scrollMaxY;
		} else if (document.body.scrollHeight > document.body.offsetHeight) { // all
																				// but
																				// Explorer
																				// Mac
			xScroll = document.body.scrollWidth;
			yScroll = document.body.scrollHeight;
		} else { // Explorer Mac...would also work in Explorer 6 Strict,
					// Mozilla and Safari
			xScroll = document.body.offsetWidth;
			yScroll = document.body.offsetHeight;
		}

		if (self.innerHeight) { // all except Explorer
			windowWidth = self.innerWidth;
			windowHeight = self.innerHeight;
		} else if (document.documentElement
				&& document.documentElement.clientHeight) { // Explorer 6 Strict
															// Mode
			windowWidth = document.documentElement.clientWidth;
			windowHeight = document.documentElement.clientHeight;
		} else if (document.body) { // other Explorers
			windowWidth = document.body.clientWidth;
			windowHeight = document.body.clientHeight;
		}

		// for small pages with total height less then height of the viewport
		if (yScroll < windowHeight) {
			pageHeight = windowHeight;
		} else {
			pageHeight = yScroll;
		}

		// for small pages with total width less then width of the viewport
		if (xScroll < windowWidth) {
			pageWidth = windowWidth;
		} else {
			pageWidth = xScroll;
		}

		return {
			'pageWidth' : pageWidth,
			'pageHeight' : pageHeight,
			'windowWidth' : windowWidth,
			'windowHeight' : windowHeight
		}
	}();
	// alert(winSize.pageWidth);
	// 遮罩层
	var styleStr = 'top:0;left:0;position:absolute;z-index:10000;background:#666;width:'
			+ winSize.pageWidth
			+ 'px;height:'
			+ (winSize.pageHeight + 30)
			+ 'px;';
	styleStr += (isIe) ? "filter:alpha(opacity=80);" : "opacity:0.8;"; // 遮罩层DIV
	var shadowDiv = document.createElement('div'); // 添加阴影DIV
	shadowDiv.style.cssText = styleStr; // 添加样式
	shadowDiv.id = "shadowDiv";
	// 如果是IE6则创建IFRAME遮罩SELECT
	if (isIE6) {
		var maskIframe = document.createElement('iframe');
		maskIframe.style.cssText = 'width:'
				+ winSize.pageWidth
				+ 'px;height:'
				+ (winSize.pageHeight + 30)
				+ 'px;position:absolute;visibility:inherit;z-index:-1;filter:alpha(opacity=0);';
		maskIframe.frameborder = 0;
		maskIframe.src = "about:blank";
		shadowDiv.appendChild(maskIframe);
	}
	document.body.insertBefore(shadowDiv, document.body.firstChild); // 遮罩层加入文档
	// 弹出框
	var styleStr1 = 'display:block;position:fixed;_position:absolute;left:'
			+ (winSize.windowWidth / 2 - 200) + 'px;top:'
			+ (winSize.windowHeight / 2 - 150) + 'px;_top:'
			+ (winSize.windowHeight / 2 + top - 150) + 'px;'; // 弹出框的位置
	var alertBox = document.createElement('div');
	alertBox.id = 'alertMsg';
	alertBox.style.cssText = styleStr1;
	// 创建弹出框里面的内容P标签
	var alertMsg_info = document.createElement('P');
	alertMsg_info.id = 'alertMsg_info';
	alertMsg_info.innerHTML = msg;
	alertMsg_info.style.cssText = 'font-size: 20px;text-align:center;';
	alertBox.appendChild(alertMsg_info);
	// 点击消失
	alertBox.onclick = function() {
		document.body.removeChild(alertBox);
		document.body.removeChild(shadowDiv);
		return true;
	};
	shadowDiv.onclick = function() {
		document.body.removeChild(alertBox);
		document.body.removeChild(shadowDiv);
		return true;
	};
	// 创建按钮
	var btn1 = document.createElement('a');
	btn1.id = 'alertMsg_btn1';
	btn1.href = 'javas' + 'cript:void(0)';
	btn1.innerHTML = '<cite>确定</cite>';
	btn1.onclick = function() {
		document.body.removeChild(alertBox);
		document.body.removeChild(shadowDiv);
		return true;
	};
	// alertBox.appendChild(btn1);
	if (mode === 1) {
		var btn2 = document.createElement('a');
		btn2.id = 'alertMsg_btn2';
		btn2.href = 'javas' + 'cript:void(0)';
		btn2.innerHTML = '<cite>取消</cite>';
		btn2.onclick = function() {
			document.body.removeChild(alertBox);
			document.body.removeChild(shadowDiv);
			return false;
		};
		alertBox.appendChild(btn2);
	}
	document.body.appendChild(alertBox);

}