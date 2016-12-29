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
<script type="text/javascript" src="/files/utils.js"></script>
<script type="text/javascript" src="/files/popup.js"></script>
<script type="text/javascript" src="/files/popupclass.js"></script>
<script type="text/javascript" src="/tmweb/js/list.js"></script>
</head>
<body topmargin="0" marginwidth="0" marginheight="0"
	onkeydown="KeyDown()" oncontextmenu="return false">
	<center>
		<br>
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
						id="code_but"></td>
				</tr>
				<tr>
					<td class="norightt1" width="100%">
						<center>
							<%
								Set<TtmNew> set = (Set<TtmNew>) request.getAttribute("result");
								if (set == null) {
									set = new LinkedHashSet<TtmNew>();
								}
								List<TtmNew> list = null;
								list = new ArrayList<TtmNew>(set);
							%>
							<input type="hidden" id="pagesize" value="50" /> <input
								type="hidden" id="sum" value="${resultsize}" /> <input
								type="hidden" id="pagenum" value="1" /> <input type="hidden"
								id="countpage"
								value="<%=(int) (Math.ceil((set.size() * 1.0) / 50))%>" /> 每页<font>50</font>条记录&nbsp;共<font>${resultsize}</font>条记录&nbsp;&nbsp;
							第<font id="pageno">1</font>页&nbsp;&nbsp;共<font><%=(int) (Math.ceil((set.size() * 1.0) / 50))%></font>页&nbsp;&nbsp;
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
				<c:if test="${resultsize>5000}">
					<tr>
						<td class="borderT2" align="center" width="100%"><font
							color="red">本次查询共有${resultsize}条记录，只显示前5000条</font></td>
					</tr>
				</c:if>
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


								<c:forEach items="${result}" varStatus="i" var="ttm">

									<tr id="tr_${i.index+1}"
										<c:if test="${i.index >= 50}">style="display:none;"</c:if>>
										<td class="list_01">${i.index+1}</td>
										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${ttm.ftmlb}')">
												${ttm.ftmids}</a></td>

										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${ttm.ftmlb}')">${ttm.ftmlb}</a>
										</td>

										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${ttm.ftmlb}')">
												${ttm.ftmchin ==null ?"":ttm.ftmchin} ${ttm.ftmeng==null ?"":ttm.ftmeng}
												${ttm.ftmpy==null ?"":ttm.ftmpy} ${ttm.ftmhead==null ?"":ttm.ftmhead}
												${ttm.ftmsz==null ?"":ttm.ftmsz}</a></td>

										<td class="list_01"><a href="javascript:void();"
											onclick="getdetail('${ttm.ftmides}','${ttm.ftmlb}')">查看</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</td>
				</tr>

				<tr>
					<td class="borderT2" align="center" width="100%"><font
						color="red">仅供参考,无任何法律效力,请核实后使用</font></td>
				</tr>
				<tr>
					<td class="t1" colspan="" width="100%"><input name="type"
						type="hidden" id="type" value="CHN"> <input name="intcls"
						type="hidden" id="intcls" value="25"> <input
						name="content" type="hidden" id="content" value="美特斯"> <input
						name="si" type="hidden" id="si" value=""> <input name="sf"
						type="hidden" id="sf" value=""></td>
				</tr>
			</tbody>
		</table>
	</center>


</body>
</html>