/**
 * 
 */
function KeyDown() {
	if ((window.event.altKey) && ((window.event.keyCode == 37) || // 屏蔽 Alt+
																	// 方向键 ←
	(window.event.keyCode == 39))) { // 屏蔽 Alt+ 方向键 →
		event.returnValue = false;
	}
	if ((event.keyCode == 116) || // 屏蔽 F5 刷新键
	(event.ctrlKey && event.keyCode == 82)) { // Ctrl + R
		event.keyCode = 0;
		event.returnValue = false;
	}
	if ((event.ctrlKey) && (event.keyCode == 78)) // 屏蔽 Ctrl+n
		event.returnValue = false;
	if ((event.shiftKey) && (event.keyCode == 121)) // 屏蔽 shift+F10
		event.returnValue = false;

	// if ((event.keyCode == 112) || //屏蔽 F1 刷新键
	// (event.keyCode == 122) || //屏蔽 F11 全屏显示会有后退
	// (event.shiftKey) || //屏蔽 shift 刷新键
	// (event.altKey) || //屏蔽 alert 刷新键
	// (event.ctrlKey)) //屏蔽 crrl 刷新键
	// event.returnValue = false;
}

/**
 * 
 */
function KeyDownALL() {
	if ((window.event.altKey) && ((window.event.keyCode == 37) || // 屏蔽 Alt+
																	// 方向键 ←
	(window.event.keyCode == 39))) { // 屏蔽 Alt+ 方向键 →
		event.returnValue = false;
	}
	if ((event.keyCode == 8) || // 屏蔽退格删除键
	(event.keyCode == 116) || // 屏蔽 F5 刷新键
	(event.ctrlKey && event.keyCode == 82)) { // Ctrl + R
		event.keyCode = 0;
		event.returnValue = false;
	}
	if ((event.ctrlKey) && (event.keyCode == 78)) // 屏蔽 Ctrl+n
		event.returnValue = false;
	if ((event.shiftKey) && (event.keyCode == 121)) // 屏蔽 shift+F10
		event.returnValue = false;

	// if ((event.keyCode == 112) || //屏蔽 F1 刷新键
	// (event.keyCode == 122) || //屏蔽 F11 全屏显示会有后退
	// (event.shiftKey) || //屏蔽 shift 刷新键
	// (event.altKey) || //屏蔽 alert 刷新键
	// (event.ctrlKey)) //屏蔽 crrl 刷新键
	// event.returnValue = false;
}

// 去左空格;
function ltrim(s) {
	return s.replace(/(^\s*)/, "");
}
// 去右空格;
function rtrim(s) {
	return s.replace(/(\s*$)/, "");
}
// 去左右空格;
function trim(s) {
	// s.replace(/(^\s*)|(\s*$)/, "");
	return rtrim(ltrim(s));
}

/*******************************************************************************
 * 函数名称： checkNotWord(arg) 参数是： 字符串 功能： 判断是否是含有非汉字字符（不能为空） 返回的值： 如果不是汉字则返回真否则返回假
 ******************************************************************************/
function checkNotWord(Num) {
	var i, j, strTemp;
	ifvalue = true;

	strTemp = "0123456789.;abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

	if (Num.length == 0)
		return true;

	for (i = 0; i < Num.length; i++) {
		j = strTemp.indexOf(Num.charAt(i));
		if (j != -1) {
			// 说明有字符不是数字或'.'或者字母
			// return true;
			ifvalue = false;
		}
	}
	// 说明是汉字
	return ifvalue;
}

/*******************************************************************************
 * //函数名：checkChar()checkNotEnglishChar //功能介绍：检查是否含有非字母 //参数说明：要检查的字符串
 * //返回值：true：含有非字母 ;false：全部为字母
 ******************************************************************************/
function checkNotChar(str) {
	var strSource = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	var ch;
	var i;
	var temp;
	if (str.length == 0)
		return true;
	for (i = 0; i <= (str.length); i++) {
		ch = str.charAt(i);
		temp = strSource.indexOf(ch);
		if (temp == -1 && ch != ' ') {
			return true;
		}
	}
	return false;
}

/**
 * 为汉字返回true
 * 
 * @param {Object}
 *            val
 * @return {TypeName}
 */
function isHanZi(val) {
	var reg = new RegExp("[\\u4E00-\\u9FFF]+", "g");// /[\u4E00-\u9FA5]/
													// [\\u4E00-\\u9FFF]+
	var flag = true;
	if (!reg.test(val)) {
		flag = false;
	} else {
		for (var i = 0; i < val.length; i++) {
			if (val.charCodeAt(i) <= 256) { // 255
				flag = false;
			}
		}
	}
	return flag;
}

/**
 * 为汉字返回true
 * 
 * @param {Object}
 *            val
 * @return {TypeName}
 */
function isHanZiOld(val) {
	var reg = new RegExp("[\\u4E00-\\u9FFF]+", "g");// /[\u4E00-\u9FA5]/
													// [\\u4E00-\\u9FFF]+
	var flag = true;
	if (!reg.test(val)) {
		flag = false;
	} else {
		for (var i = 0; i < val.length; i++) {
			if (val.charCodeAt(i) <= 256) { // 255
				flag = false;
			}
		}
	}
	return flag;
}
/**
 * 统计输入字符串的长度，如果是汉字，则字符串长度加2 ；否则字符串长度加1。
 * 
 * @param {Object}
 *            str
 * @return {TypeName}
 */
function chkstrlen(str) {
	var strlen = 0;
	for (var i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) > 255) // 如果是汉字，则字符串长度加2
			strlen += 2;
		else
			strlen++;
	}
	return strlen;
}
/**
 * 判断ID是否存在
 */
function exist(id) {
	var s = document.getElementById(id);
	if (s) {
		return true;
	} else {
		return false;
	}
}