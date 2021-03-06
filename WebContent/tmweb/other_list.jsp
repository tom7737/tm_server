<%@page import="com.bjgt.ms.entity.vo.PageResult"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.apache.commons.collections.functors.ForClosure"%>
<%@page import="java.util.*"%>
<%@page import="com.bjgt.ms.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=".">
<title>商标列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="/files/newpublic2.css" type="text/css">
<script type="text/javascript" src="/files/popup.js"></script>
<script type="text/javascript" src="/files/popupclass.js"></script>
<script type="text/javascript" src="/tmweb/js/other_list.js"></script>
</head>
<body topmargin="0" marginwidth="0" marginheight="0"
	onkeydown="KeyDown()" oncontextmenu="return false">
	<center>
		<br>
		<form name="other_query_frm" method="post" action="/other/webquery.html">
			<input type="hidden" id="field" name="field" value="${field}"> <input
				type="hidden" id="pagesize" name="pagesize" value="${page.pageSize}">
			<input type="hidden" id="pageno" name="pageno" value="${page.pageNo}">
			<input type="hidden" id="countno" name="countno" value="${page.countNo}">
			<input type="hidden" id="querystr" name="querystr"
				value="${querystr}"> <input type="hidden" id="querytype"
				name="querytype" value="${querytype}"> <input type="hidden"
				id="querytmlb" name="querytmlb" value="${querytmlb}"> <input
				type="hidden" id="querytmlbs" name="querytmlbs"
				value="${querytmlbs}"> <input type="hidden" id="maxPage"
				name="maxPage" value="${page.maxPage}">
		</form>
		<form name="frm" method="post" action="/tm/webdetail2.html"
			target="_blank">
			<input type="hidden" name="ftmid" id="ftmid"> <input
				type="hidden" name="tmlb" id="tmlb">
		</form>
		<table class="import_hpb" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td class="norightt1" align="center" width="100%">&nbsp; <input
						type="hidden" id="codeShow"><input type="hidden"
						id="codeUrl"><input type="button" style="display: none;"
						id="code_but"> <c:forEach items="${tmlbs}" var="tm"
							varStatus="i">
							<c:if test="${tm!=querytmlb}">
								<a href="javascript:void(0);" onclick="settmlb('${tm}');">${tm}类</a>
							</c:if>
							<c:if test="${tm==querytmlb}">
								${tm}类
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="borderT2" width="100%">
						<center>
							每页<font>50</font>条记录&nbsp;共<font>${page.countNo}</font>条记录&nbsp;&nbsp;
							第<font id="pageno">${page.pageNo}</font>页&nbsp;&nbsp;共<font>${page.maxPage}</font>页&nbsp;&nbsp;
							<a href="javascript:dopage(1)">首页</a> &nbsp; <a
								href="javascript:dopage(2)">上页</a>&nbsp; <a
								href="javascript:dopage(3)">下页</a> &nbsp; <a
								href="javascript:dopage(4)">尾页</a>&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;转到： <input type="text" name="goNum"
								id="goNum" style="text-align: center;" size="5" value="1">
							<input type="button" class="buttonh"
								onclick="javascript:go_pageNum()" value="跳转">
						</center>
					</td>
				</tr>
				<tr>
					<td class="" width="100%">
						<table class="import_hpb_list" width="100%" border="0"
							cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td class="list_th" width="10%">序号</td>
									<td class="list_th" width="30%">注册号/申请号</td>
									<td class="list_th" width="10%">类别</td>
									<td class="list_th" width="30%">商标</td>
									<td class="list_th" width="10%">商品</td>
								</tr>
								<c:if test="${fn:length(page.list) == 0}">
									<tr>
										<td colspan="5"><center>
												<h3>没有查询到任何数据！</h3>
											</center></td>
									</tr>
								</c:if>

								<c:forEach items="${page.list}" varStatus="i" var="ttm">
									<tr id="tr_${i.index+1}"
										<c:if test="${i.index >= 50}">style="display:none;"</c:if>>
										<td class="list_01">${i.index+1}</td>
										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${querytmlb}')">
												${ttm.ftmids}</a></td>

										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${querytmlb}')">${querytmlb}</a>
										</td>

										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${querytmlb}')">
												${ttm.ftmchin ==null ?"":ttm.ftmchin} ${ttm.ftmeng==null ?"":ttm.ftmeng}
												${ttm.ftmpy==null ?"":ttm.ftmpy} ${ttm.ftmhead==null ?"":ttm.ftmhead}
												${ttm.ftmsz==null ?"":ttm.ftmsz}</a></td>

										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${querytmlb}')">查看</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td class="borderT2" width="100%">
						<center>
							每页<font>50</font>条记录&nbsp;共<font>${page.countNo}</font>条记录&nbsp;&nbsp;
							第<font id="pageno">${page.pageNo}</font>页&nbsp;&nbsp;共<font>${page.maxPage}</font>页&nbsp;&nbsp;
							<a href="javascript:dopage(1)">首页</a> &nbsp; <a
								href="javascript:dopage(2)">上页</a>&nbsp; <a
								href="javascript:dopage(3)">下页</a> &nbsp; <a
								href="javascript:dopage(4)">尾页</a>&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;转到： <input type="text" name="goNum"
								id="goNum" style="text-align: center;" size="5" value="1">
							<input type="button" class="buttonh"
								onclick="javascript:go_pageNum()" value="跳转">
						</center>
					</td>
				</tr>
				<tr>
					<td class="borderT2" align="center" width="100%"><font
						color="red">仅供参考,无任何法律效力,请核实后使用</font></td>
				</tr>

			</tbody>
		</table>
	</center>


</body>
</html>