var is_submit = 0;
function setIsSubmit() {
	is_submit = 0;
}
$(document).ready(function() {

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
	//相同查询
	$('#query').click(function() {
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
	var ftmid=$('#ftmid').val();
	if (xyw_checkspace(ftmid)) {
		alert("请输入注册号！");
		return false;
	}
	if(isNaN(ftmid.substring(1))||(ftmid.substring(0,1)!="G" && ftmid.substring(0,1)!="g"&&isNaN(ftmid.substring(0,1)))){
		alert("请输入正确的注册号！");
		return false;
	}
	if($('#ftmid').val().length>8||$('#ftmid').val().length<6){
		alert("只能查询6~8位的注册号！");
		return false;
	}
	if (xyw_checkspace($('#tmlb').val())) {
		alert("请选择商标类别！");
		return false;
	}
//	alertMsg('正在进行查询，请勿进行其他操作',0);
	document.frm.submit();
}
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
function alertMsg(msg, mode) { //mode为空，即只有一个确认按钮，mode为1时有确认和取消两个按钮
    msg = msg || '';
    mode = mode || 0;
    var top = document.body.scrollTop || document.documentElement.scrollTop;
    var isIe = (document.all) ? true : false;
    var isIE6 = isIe && !window.XMLHttpRequest;
    var sTop = document.documentElement.scrollTop || document.body.scrollTop;
    var sLeft = document.documentElement.scrollLeft || document.body.scrollLeft;
    var winSize = function(){
        var xScroll, yScroll, windowWidth, windowHeight, pageWidth, pageHeight;
        // innerHeight获取的是可视窗口的高度，IE不支持此属性
        if (window.innerHeight && window.scrollMaxY) {
            xScroll = document.body.scrollWidth;
            yScroll = window.innerHeight + window.scrollMaxY;
        } else if (document.body.scrollHeight > document.body.offsetHeight) { // all but Explorer Mac
            xScroll = document.body.scrollWidth;
            yScroll = document.body.scrollHeight;
        } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
            xScroll = document.body.offsetWidth;
            yScroll = document.body.offsetHeight;
        }

        if (self.innerHeight) {    // all except Explorer
            windowWidth = self.innerWidth;
            windowHeight = self.innerHeight;
        } else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
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

        return{
            'pageWidth':pageWidth,
            'pageHeight':pageHeight,
            'windowWidth':windowWidth,
            'windowHeight':windowHeight
        }
    }();
    //alert(winSize.pageWidth);
    //遮罩层
    var styleStr = 'top:0;left:0;position:absolute;z-index:10000;background:#666;width:' + winSize.pageWidth + 'px;height:' +  (winSize.pageHeight + 30) + 'px;';
    styleStr += (isIe) ? "filter:alpha(opacity=80);" : "opacity:0.8;"; //遮罩层DIV
    var shadowDiv = document.createElement('div'); //添加阴影DIV
    shadowDiv.style.cssText = styleStr; //添加样式
    shadowDiv.id = "shadowDiv";
    //如果是IE6则创建IFRAME遮罩SELECT
    if (isIE6) {
        var maskIframe = document.createElement('iframe');
        maskIframe.style.cssText = 'width:' + winSize.pageWidth + 'px;height:' + (winSize.pageHeight + 30) + 'px;position:absolute;visibility:inherit;z-index:-1;filter:alpha(opacity=0);';
        maskIframe.frameborder = 0;
        maskIframe.src = "about:blank";
        shadowDiv.appendChild(maskIframe);
    }
    document.body.insertBefore(shadowDiv, document.body.firstChild); //遮罩层加入文档
    //弹出框
    var styleStr1 = 'display:block;position:fixed;_position:absolute;left:' + (winSize.windowWidth / 2 - 200) + 'px;top:' + (winSize.windowHeight / 2 - 150) + 'px;_top:' + (winSize.windowHeight / 2 + top - 150)+ 'px;'; //弹出框的位置
    var alertBox = document.createElement('div');
    alertBox.id = 'alertMsg';
    alertBox.style.cssText = styleStr1;
    //创建弹出框里面的内容P标签
    var alertMsg_info = document.createElement('P');
    alertMsg_info.id = 'alertMsg_info';
    alertMsg_info.innerHTML = msg;
    alertMsg_info.style.cssText = 'font-size: 20px;text-align:center;';
    alertBox.appendChild(alertMsg_info);
    //点击消失
    alertBox.onclick = function () {
        document.body.removeChild(alertBox);
        document.body.removeChild(shadowDiv);
        return true;
    };
    shadowDiv.onclick = function () {
        document.body.removeChild(alertBox);
        document.body.removeChild(shadowDiv);
        return true;
    };
    //创建按钮
    var btn1 = document.createElement('a');
    btn1.id = 'alertMsg_btn1';
    btn1.href = 'javas' + 'cript:void(0)';
    btn1.innerHTML = '<cite>确定</cite>';
    btn1.onclick = function () {
        document.body.removeChild(alertBox);
        document.body.removeChild(shadowDiv);
        return true;
    };
//    alertBox.appendChild(btn1);
    if (mode === 1) {
        var btn2 = document.createElement('a');
        btn2.id = 'alertMsg_btn2';
        btn2.href = 'javas' + 'cript:void(0)';
        btn2.innerHTML = '<cite>取消</cite>';
        btn2.onclick = function () {
            document.body.removeChild(alertBox);
            document.body.removeChild(shadowDiv);
            return false;
        };
        alertBox.appendChild(btn2);
    }
    document.body.appendChild(alertBox);

}