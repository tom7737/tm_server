<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bjgt.ms.entity.*"%>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%--<base href=".">--%>
<title>${ttm.ftmchin}${ttm.ftmeng}${ttm.ftmpy}${ttm.ftmhead}${ttm.ftmsz}</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet" href="/files/newpublic2.css" type="text/css" />
<script type="text/javascript" src="/files/utils.js"></script>
<script type="text/javascript" src="/files/popup.js"></script>
<script type="text/javascript" src="/files/popupclass.js"></script>
</head>
<body topmargin="0" marginwidth="0" marginheight="0"
	onkeydown="KeyDown()" oncontextmenu="return false">
	<br>
		<table class="import_hpb" border="0" cellpadding="0" cellspacing="0">
			<tbody>
			<tr>
				<td class="t2" align="center" colspan="4" width="100%">商标的详细信息</td>
			</tr>
			<tr>
				<td class="t2" width="15%"><nobr>国际分类</nobr></td>
				<td class="tleft" width="35%"><nobr>${ttm.tmlb}</nobr></td>
				<td class="t2" align="center" colspan="2" rowspan="7" width="50%">
								<img src="/tm/getimage.html?ftmid=${ttm.ftmides}&tmlb=${ttm.tmlb}"
									alt="${ttm.ftmchin} ${ttm.ftmpy} ${ttm.ftmeng} ${ttm.ftmsz} ${ttm.ftmhead}" style=" width:100%;"/>

				</td>
			</tr>
			<tr>
				<td class="t2"><nobr>商标类型</nobr></td>
				<td class="tleft"><nobr>${ttm.fsblx}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>注册号</nobr></td>
				<td class="tleft"><nobr>${ttm.ftmids}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>初审公告</nobr></td>
				<td class="tleft"><nobr> <c:if
						test="${ttm.fggq!=null && ttm.fggq>0}">${ttm.fggq}<c:if
							test="${ttm.fcsym!=null && ttm.fcsym>0}">/${ttm.fcsym}</c:if>
					</c:if> </nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>注册公告</nobr></td>
				<td class="tleft"><nobr> <c:if
						test="${ttm.fzcq!=null && ttm.fzcq>0}">${ttm.fzcq}<c:if
							test="${ttm.fzcym!=null && ttm.fzcym>0}">/${ttm.fzcym}</c:if>
					</c:if> </nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>申请日期</nobr></td>
				<td class="tleft"><nobr>${ttm.fsqdate}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>初审日期</nobr></td>
				<td class="tleft"><nobr>${ttm.fcsdate}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>注册日期</nobr></td>
				<td class="tleft"><nobr>${ttm.fzcdate}</nobr></td>
				<td class="t2" width="15%"><nobr>截止日期</nobr></td>
				<td class="tleft"><nobr>${ttm.fjzdate}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>商标中文</nobr></td>
				<td class="tleft" colspan="3"><nobr>${ttm.ftmchin}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>商标拼音</nobr></td>
				<td class="tleft" colspan="3"><nobr>${ttm.ftmpy}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>商标英文</nobr></td>
				<td class="tleft" colspan="3"><nobr>${ttm.ftmeng}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>商标字头</nobr></td>
				<td class="tleft"><nobr>${ttm.ftmhead}</nobr></td>
				<td class="t2"><nobr>商标数字</nobr></td>
				<td class="tleft"><nobr>${ttm.ftmsz}</nobr></td>
			</tr>
			<tr>
				<td class="t2"><nobr>注册人</nobr></td>
				<td class="tleft" colspan="3">${ttm.fsqr1}</td>
			</tr>
			<tr>
				<td class="t2"><nobr>原注册人</nobr></td>
				<td class="tleft" colspan="3">${ttm.fsqr2}</td>
			</tr>
			<tr>
				<td class="t2"><nobr>注册地址</nobr></td>
				<td class="tleft" colspan="3">${ttm.faddr}</td>
			</tr>
			<tr>
				<td class="t2"><nobr>代理组织</nobr></td>
				<td class="tleft" colspan="3">${ttm.fdlzz}</td>
			</tr>
			<tr>
				<td class="t2"><nobr>使用商品</nobr></td>
				<td class="tleft" colspan="3">${ttm.fsysp}</td>
			</tr>
			<tr>
				<td class="t2"><nobr>商品组别</nobr></td>
				<td class="tleft" colspan="3">${ttm.fspzb}</td>
			</tr>
			<tr>
				<td class="t2"><nobr>备注</nobr></td>
				<td class="tleft" colspan="3">${ttm.fbz}</td>
			</tr>
			<tr>
				<td class="t2"><nobr>商标流程</nobr></td>
				<td class="tleft" colspan="3"><nobr>${ttm.tmlc}</nobr></td>
			</tr>
			<tr>
				<td align="center" class="t1" colspan="4"><font color="red">仅供参考,无任何法律效力,请核实后使用</font>
				</td>
			</tr>
			</tbody>
		</table>
</body>
</html>