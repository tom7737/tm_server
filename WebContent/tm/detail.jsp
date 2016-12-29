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
<title>商标详情</title>
</head>

<body scroll="no" style="overflow-x: hidden" 	topmargin="0" marginwidth="0" marginheight="0"
		onkeydown="KeyDown()" oncontextmenu="return false">

	<%@ include file="/tm/head.jsp"%>

	<div style="margin-top: 48px;">
		<table class="t_table" id="t_table">
		<tr class="t_table_tr_detail1">
				<td class="t_table_td_left_detail"><nobr>国际分类</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.tmlb}</nobr></td>
				<td class="t_table_td_left_detail"><nobr>商标类型</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.fsblx}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>注册号</nobr></td>
				<td class="t_table_td_right_detail2" colspan="3"><nobr>${ttm.ftmids}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>初审公告</nobr></td>
				<td class="t_table_td_right_detail2"><nobr> <c:if
						test="${ttm.fggq!=null && ttm.fggq>0}">${ttm.fggq}<c:if
							test="${ttm.fcsym!=null && ttm.fcsym>0}">/${ttm.fcsym}</c:if>
					</c:if> </nobr></td>
				<td class="t_table_td_left_detail"><nobr>注册公告</nobr></td>
				<td class="t_table_td_right_detail2"><nobr> <c:if
						test="${ttm.fzcq!=null && ttm.fzcq>0}">${ttm.fzcq}<c:if
							test="${ttm.fzcym!=null && ttm.fzcym>0}">/${ttm.fzcym}</c:if>
					</c:if> </nobr></td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>申请日期</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.fsqdate}</nobr></td>
				<td class="t_table_td_left_detail"><nobr>初审日期</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.fcsdate}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>注册日期</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.fzcdate}</nobr></td>
				<td class="t_table_td_left_detail"><nobr>截止日期</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.fjzdate}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>商标中文</nobr></td>
				<td class="t_table_td_right_detail" colspan="3"><nobr>${ttm.ftmchin}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>商标拼音</nobr></td>
				<td class="t_table_td_right_detail" colspan="3"><nobr>${ttm.ftmpy}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>商标英文</nobr></td>
				<td class="t_table_td_right_detail" colspan="3"><nobr>${ttm.ftmeng}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>商标字头</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.ftmhead}</nobr></td>
				<td class="t_table_td_left_detail"><nobr>商标数字</nobr></td>
				<td class="t_table_td_right_detail2"><nobr>${ttm.ftmsz}</nobr></td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>注册人</nobr></td>
				<td class="t_table_td_right_detail" colspan="3">${ttm.fsqr1}</td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>原注册人</nobr></td>
				<td class="t_table_td_right_detail" colspan="3">${ttm.fsqr2}</td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>注册地址</nobr></td>
				<td class="t_table_td_right_detail" colspan="3">${ttm.faddr}</td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>代理组织</nobr></td>
				<td class="t_table_td_right_detail" colspan="3">${ttm.fdlzz}</td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>使用商品</nobr></td>
				<td class="t_table_td_right_detail" colspan="3">${ttm.fsysp}</td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>商品组别</nobr></td>
				<td class="t_table_td_right_detail" colspan="3">${ttm.fspzb}</td>
			</tr>
			<tr class="t_table_tr_detail2">
				<td class="t_table_td_left_detail"><nobr>备注</nobr></td>
				<td class="t_table_td_right_detail" colspan="3">${ttm.fbz}</td>
			</tr>
			<tr class="t_table_tr_detail">
				<td class="t_table_td_left_detail"><nobr>商标流程</nobr></td>
				<td class="t_table_td_right_detail" colspan="3"><nobr>${ttm.tmlc}</nobr></td>
			</tr>
		</table>
		<img src="/tm/getimage.html?ftmid=${ttm.ftmides}&tmlb=${ttm.tmlb}" alt="" style="width:100%;" />
	</div>
</body>
</html>