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
<body scroll="no" style="overflow-x: hidden" >
	<!-- topmargin="0"
	marginwidth="0" marginheight="0" onkeydown="KeyDown()"
	oncontextmenu="return false"-->
	<%@ include file="/tm/head.jsp"%>
	<input type="hidden" id="countno" name="countno" value="0">
	<input type="hidden" id="querytype" name="querytype" value="${querytype}">
	<input type="hidden" id="pagesize" name="pagesize" value="${pagesize}">
	<input type="hidden" id="pageno" name="pageno" value="${pageno}">
	<input type="hidden" id="querystr" name="querystr" value="${querystr}">
	<div style="margin-top: 48px;">
		<form name="frm" method="post" action="/spdmimage/mtospdmimg.html">
			<input type="hidden" name="page" id="page">
		</form>
		<table class="t_table" id="t_table">
			<thead class="t_table_tr2">
				<td class="t_table_td_bianhao"><nobr>编号</nobr></td>
				<td class="t_table_td_left"><nobr>类别</nobr></td>
				<td class="t_table_td_right"><nobr>商品中文名称</nobr></td>
				<td class="t_table_td_right"><nobr>商品英文名称</nobr></td>
			</thead>
			<tbody id="other_div"></tbody>
		</table>
		<input id="query" onclick="netxTuxing();" type="button"
			class="tinput2" style="height: 30px;" value="">
	</div>
	<script Language="javaScript" src="/tm/js/spdmgf_list.js"></script>
</body>
</html>