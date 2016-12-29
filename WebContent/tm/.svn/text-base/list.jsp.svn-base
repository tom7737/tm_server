<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.apache.commons.collections.functors.ForClosure"%>
<%@page import="java.util.*"%>
<%@page import="com.bjgt.ms.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
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

<body scroll="no" style="overflow-x: hidden">
	<%@ include file="/tm/head.jsp"%>
	<div style="margin-top: 48px;">
		<form name="frm" method="post" action="webdetail.html">
			<input type="hidden" name="ftmid" id="ftmid"> <input
				type="hidden" name="tmlb" id="tmlb">
		</form>
		<table class="t_table" id="t_table">
			<tr class="t_table_tr2">
				<td class="t_table_td_bianhao"><nobr>编号</nobr></td>
				<td class="t_table_td_left"><nobr>类别</nobr></td>
				<td class="t_table_td_right"><nobr>名称（共${fn:length(result)}条）用时：${querttime}秒</nobr></td>
			</tr>
			<c:forEach items="${result}" varStatus="i" var="ttmnew">
				<tr class="t_table_tr${i.index %2!=0?2:''}"
					onclick="getdetail('${ttmnew.ftmides}','${ttmnew.ftmlb}');">
					<td class="t_table_td_bianhao"><nobr> ${i.index+1} </nobr></td>
					<td class="t_table_td_left"><nobr> ${ttmnew.ftmlb} </nobr></td>
					<td class="t_table_td_right"><nobr>${ttmnew.ftmchin ==null ?"":ttmnew.ftmchin}
					${ttmnew.ftmeng==null ?"":ttmnew.ftmeng}
					${ttmnew.ftmpy==null ?"":ttmnew.ftmpy}
					${ttmnew.ftmhead==null ?"":ttmnew.ftmhead}
					${ttmnew.ftmsz==null ?"":ttmnew.ftmsz}
						</nobr></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script Language="javaScript" src="/tm/js/list.js"></script>
</body>
</html>