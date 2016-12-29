<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bjgt.ms.entity.*"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<link rel="stylesheet" type="text/css" href="/image/twt.css" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>分类表</title>
<style>
.main {
	width: 100%;
}

.left {
	width: 712px;
	float: left;
	height: 413px;
}

.right {
	width: 243px;
	float: right;
	background: url(/css/imge/main_10.gif) no-repeat;
	height: 415px;
}
</style>
</head>

<body scroll="no" style="overflow-x: hidden" topmargin="0"
	marginwidth="0" marginheight="0" onkeydown="KeyDown()"
	oncontextmenu="return false">
	<form name="frm" method="post" action="/spdmimage/mtospdmimg.html">
		<input type="hidden" name="page" id="page" value="${page}">
	</form>
	<%@ include file="/tm/head.jsp"%>
		<div style="width: 100%;position: fixed;">
			<div id="query"
				style="float: left; background: rgba(255, 204, 51, 0.5); height: 60px; width: 40px; margin-top: 200px;">
				<img style="height: 100%; width: 100%;"
					src="/css/bookcss/arrow_w_l.png" />
			</div>
			<div id="query2"
				style="float: right; margin-right: 2px;  background: rgba(255, 204, 51, 0.5); height: 60px; width: 40px; margin-top: 200px;">
				<img style="height: 100%; width: 100%;"
					src="/css/bookcss/arrow_w_r.png" />
			</div>
		</div>
	<div style="margin-top: 48px;">
		<center> <img id="spdmimg" src="/img/spdm/${page}.jpg"
			width="100%;" /> </center>
	</div>
	<!-- 	<div align="center"> -->
	<!-- 		style="position: fixed;" -->
	<!-- 		<input id="query" type="button" class="tsubmit" value="上一页"> <input -->
	<!-- 			id="query2" type="button" class="tsubmit2" value="下一页"> -->
	<!-- 	</div> -->
	<script type="text/javascript" src="/tm/js/spdmimg.js"></script>
</body>
</html>