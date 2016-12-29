<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd"> -->
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<link rel="stylesheet" type="text/css" href="/image/alertmsg.css" />
<link rel="stylesheet" href="/image/dtree.css" type="text/css">
<script type="text/javascript" src="/files/utils.js"></script>
<script type="text/javascript" src="/javascript/dtree.js"></script>
<title>商标查询</title>
</head>

<body scroll="no" style="overflow-x: hidden" 	topmargin="0" marginwidth="0" marginheight="0"
		onkeydown="KeyDown()" oncontextmenu="return false">
	<%@ include file="/tm/head.jsp"%>
	<%-- 	<form name="frm" method="post" action="/tmtuxing/mwebquery.html"> --%>
	<form name="frm" method="post" action="/tmtuxing/goimglist.html">
		<input type="hidden" id="querytusu" name="querytusu" value="">
		<input type="hidden" id="subtime" name="subtime"> <input
			type="hidden" id="pagesize" name="pagesize" value="20"> <input
			type="hidden" id="pageno" name="pageno" value="0">
		<!-- 	position: fixed; -->
		<div style="width: 98%;margin-top: -82px; position: fixed;">
			<textarea rows="4" class="ttextarea" id="querystr" name="querystr"
				readonly="readonly" placeholder='请选择图素（最多10个）'></textarea>
		</div>
		<div style="margin-top: 128px;">
			<div align="center">
				<input id="btn_jb" type="button" class="tinput6" value="基本选项">
				<input id="btn_ts" type="button" class="tinput5" value="选择图素">
			</div>
			<br />
			<div id="jb_div">
				<div style="width: 99%;">
					<input id="querytmlb" name="querytmlb" type="text" class="tinput"
						placeholder='请输入查询类别（1~45）' />
				</div>
				<br />
				<div align="center" style="width: 100%;">
					<input type="button" id="btn_multiple" value="点击选择多图素查询"
						class="tinput">
				</div>
				<br />
				<div align="center" style="width: 100%;">
					<input type="button" id="btn_eng_1" value="交叉" class="tinput6">
					<input type="button" id="btn_eng_2" value="合并" class="tinput5">
					<input type="hidden" id="radio_multiple" name="radio_multiple"
						value="">
				</div>
				<br /> <br />
			</div>
			<div id="ts_div" style="display: none;">
				<p>
					<a href="javascript: d.openAll();">打开全部</a> 
					| <a href="javascript: d.closeAll();">关闭全部</a>
				</p>
				<div id="usertree"></div>
			</div>
			<br />
			<div align="center">
				<!-- 		style="position: fixed;" -->
				<input id="query" type="button" class="tinput2" value="查询">
			</div>
		</div>
	</form>
	<script Language="javaScript" src="/tm/js/img_query.js"></script>
</body>
</html>