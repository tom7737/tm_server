<%@page import="com.bjgt.ms.entity.vo.PageResult"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.apache.commons.collections.functors.ForClosure"%>
<%@page import="java.util.*"%>
<%@page import="com.bjgt.ms.entity.*"%>
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
<title>商标列表</title>
</head>
<body scroll="no" style="overflow-x: hidden" 	topmargin="0" marginwidth="0" marginheight="0"
		onkeydown="KeyDown()" oncontextmenu="return false">
	<!-- onload="a()" -->
	<%@ include file="/tm/head.jsp"%>
	<input type="hidden" id="subtime" name="subtime">
	<input type="hidden" id="pagesize" name="pagesize" value="${pageSize}">
	<input type="hidden" id="pageno" name="pageno" value="${pageno}">
	<input type="hidden" id="querytusu" name="querytusu"
		value="${querytusu}">
	<input type="hidden" id="radio_multiple" name="radio_multiple"
		value="${radioMultiple}">
	<input type="hidden" id="querytmlb" name="querytmlb"
		value="${querytmlb}">
	<div style="margin-top: 48px;">
		<form name="frm" method="post" action="/tm/webdetail.html">
			<input type="hidden" name="ftmid" id="ftmid"> <input
				type="hidden" name="tmlb" id="tmlb">
		</form>
		<div id="img_div">
		</div>
		<input id="query" onclick="netxTuxing();" type="button"
			class="tinput2" style="height: 30px;" value="">
	</div>
	<script Language="javaScript" src="/tm/js/img_list.js"></script>
</body>
</html>