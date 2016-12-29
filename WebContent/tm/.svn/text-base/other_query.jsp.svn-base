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
<script type="text/javascript" src="/files/utils.js"></script>
<title>共腾商标查询-${fieldstr}查询</title>
</head>

<body scroll="no" style="overflow-x: hidden" topmargin="0"
	marginwidth="0" marginheight="0" onkeydown="KeyDown()"
	oncontextmenu="return false">
	<%@ include file="/tm/head.jsp"%>
	<form name="frm" method="post" action="/other/gootherlist.html">
		<input type="hidden" id="field" name="field" value="${field}">
		<input type="hidden" id="pagesize" name="pagesize" value="20">
		<input type="hidden" id="pageno" name="pageno" value="0">
		<input type="hidden" id="querytype" name="querytype" value="">
		<div style="margin-top: 48px;">
			<div>
				<br />
				<center>
					<h3>${fieldstr}查询</h3>
				</center>
				<br />
				<div style="width: 99%;">
					<input id="querystr" name="querystr" type="text" class="tinput"
						placeholder='请输入查询词' />
				</div>
				<br /> <br />
				<div style="width: 99%;">
					<input id="querytmlb" name="querytmlb" type="text" class="tinput"
						placeholder='请输入查询类别（1~45）' />
				</div>
				<br /> <br />
			</div>
			<div align="center">
				<!-- 		style="position: fixed;" -->
				<input id="query" type="button" class="tsubmit" value="相同查询">
				<input id="query2" type="button" class="tsubmit2" value="近似查询">
			</div>
		</div>
	</form>
	<script Language="javaScript" src="/tm/js/other_query.js"></script>
</body>
</html>