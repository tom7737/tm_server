<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=".">
<title>共腾商标查询-其他查询</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="共腾，商标，查询，其他查询">
<meta http-equiv="description" content="共腾商标查询">
<link rel="stylesheet" href="/files/newpublic2.css" type="text/css">
<script type="text/javascript" src="/files/utils.js"></script>
<script type="text/javascript" src="/tmweb/js/other_query.js"></script>
</head>
<body topmargin="0" marginwidth="0" marginheight="0"
	onkeydown="KeyDown()" oncontextmenu="return false">
	<br />
	<br />
	<br />
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="import">
		<tbody>
			<tr>
				<td class="background_01">&nbsp;</td>
				<td class="background_02">
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0" class="import_m">
						<tbody>
							<tr>
								<td class="background_01">&nbsp;</td>
								<td class="background_02">
									<table border="0" cellspacing="0" cellpadding="0"
										class="login_zylj">
										<tbody>
											<tr>
												<td class="background_01">&nbsp;</td>
												<td class="background_02">
													<table width="841" height="42" border="0" cellpadding="0"
														cellspacing="0">
														<tbody>
															<tr>
																<td width="36" align="center"><img
																	src="/files/login_icon_01.png" width="11" height="11"></td>
																<td width="805" id="menu"><%@ include
																		file="/tmweb/head.jsp"%></td>
															</tr>
														</tbody>
													</table>
												</td>
												<td class="background_03">&nbsp;</td>
											</tr>
										</tbody>
									</table>
									<form action="/other/webquery.html" method="post" name="frm"
										id="frm" target="_blank">
										<input type="hidden" id="pagesize" name="pagesize" value="50">
										<input type="hidden" id="pageno" name="pageno" value="1">
										<input type="hidden" id="countno" name="countno" value="0">
										<input type="hidden" id="querytype" name="querytype" /> <input
											type="hidden" id="querytmlbs" name="querytmlbs" />
										<table width="96%" border="0" align="center" cellpadding="0"
											cellspacing="0" class="import_tb">
											<tbody>
												<tr>
													<td width="17%" class="bg_01"><select id="field" name="field" >
														<option value="sqr">--注册人--</option>
														<option value="addr">--注册地址--</option>
														<option value="sysp">--使用商品--</option>
														<option value="dlzz">--代理组织--</option>
														<option value="ggqh">--公告期号--</option>
														<option value="bz">--备注信息--</option>
													</select> ： <input type="hidden" id="codeShow"></td>
													<td width="36%" class="bg_02"><label> <input
															name="querystr" type="text" id="querystr" size="40">&nbsp;
															<!-- 															 onpaste="javascript: return false;" -->
													</label></td>
													<td width="47%" class="bg_02"></td>
												</tr>
												<tr>
													<td class="bg_01">查询类型：</td>
													<td colspan="2" id="selectTd" class="bg_02">
														<table width="100%" class="import_select" height="100%"
															border="0" cellpadding="0" cellspacing="0">
															<tbody>
																<tr>
																	<td class="se_01" colspan="10"><input
																		type="checkbox" id="select_all">&nbsp;<font
																		color="blue" size="2">全选/取消</font></td>
																</tr>
																<tr>
																	<td class="se_01"><input type="checkbox"
																		value="01" id="" name="checked_tmlb">&nbsp;01</td>
																	<td class="se_01"><input type="checkbox"
																		value="02" id="" name="checked_tmlb">&nbsp;02</td>
																	<td class="se_01"><input type="checkbox"
																		value="03" id="" name="checked_tmlb">&nbsp;03</td>
																	<td class="se_01"><input type="checkbox"
																		value="04" id="" name="checked_tmlb">&nbsp;04</td>
																	<td class="se_01"><input type="checkbox"
																		value="05" id="" name="checked_tmlb">&nbsp;05</td>
																	<td class="se_01"><input type="checkbox"
																		value="06" id="" name="checked_tmlb">&nbsp;06</td>
																	<td class="se_01"><input type="checkbox"
																		value="07" id="" name="checked_tmlb">&nbsp;07</td>
																	<td class="se_01"><input type="checkbox"
																		value="08" id="" name="checked_tmlb">&nbsp;08</td>
																	<td class="se_01"><input type="checkbox"
																		value="09" id="" name="checked_tmlb">&nbsp;09</td>
																	<td class="se_01"><input type="checkbox"
																		value="10" id="" name="checked_tmlb">&nbsp;10</td>
																</tr>
																<tr>
																	<td class="se_01"><input type="checkbox"
																		value="11" id="" name="checked_tmlb">&nbsp;11</td>
																	<td class="se_01"><input type="checkbox"
																		value="12" id="" name="checked_tmlb">&nbsp;12</td>
																	<td class="se_01"><input type="checkbox"
																		value="13" id="" name="checked_tmlb">&nbsp;13</td>
																	<td class="se_01"><input type="checkbox"
																		value="14" id="" name="checked_tmlb">&nbsp;14</td>
																	<td class="se_01"><input type="checkbox"
																		value="15" id="" name="checked_tmlb">&nbsp;15</td>
																	<td class="se_01"><input type="checkbox"
																		value="16" id="" name="checked_tmlb">&nbsp;16</td>
																	<td class="se_01"><input type="checkbox"
																		value="17" id="" name="checked_tmlb">&nbsp;17</td>
																	<td class="se_01"><input type="checkbox"
																		value="18" id="" name="checked_tmlb">&nbsp;18</td>
																	<td class="se_01"><input type="checkbox"
																		value="19" id="" name="checked_tmlb">&nbsp;19</td>
																	<td class="se_01"><input type="checkbox"
																		value="20" id="" name="checked_tmlb">&nbsp;20</td>
																</tr>
																<tr>
																	<td class="se_01"><input type="checkbox"
																		value="21" id="" name="checked_tmlb">&nbsp;21</td>
																	<td class="se_01"><input type="checkbox"
																		value="22" id="" name="checked_tmlb">&nbsp;22</td>
																	<td class="se_01"><input type="checkbox"
																		value="23" id="" name="checked_tmlb">&nbsp;23</td>
																	<td class="se_01"><input type="checkbox"
																		value="24" id="" name="checked_tmlb">&nbsp;24</td>
																	<td class="se_01"><input type="checkbox"
																		value="25" id="" name="checked_tmlb">&nbsp;25</td>
																	<td class="se_01"><input type="checkbox"
																		value="26" id="" name="checked_tmlb">&nbsp;26</td>
																	<td class="se_01"><input type="checkbox"
																		value="27" id="" name="checked_tmlb">&nbsp;27</td>
																	<td class="se_01"><input type="checkbox"
																		value="28" id="" name="checked_tmlb">&nbsp;28</td>
																	<td class="se_01"><input type="checkbox"
																		value="29" id="" name="checked_tmlb">&nbsp;29</td>
																	<td class="se_01"><input type="checkbox"
																		value="30" id="" name="checked_tmlb">&nbsp;30</td>
																</tr>
																<tr>
																	<td class="se_01"><input type="checkbox"
																		value="31" id="" name="checked_tmlb">&nbsp;31</td>
																	<td class="se_01"><input type="checkbox"
																		value="32" id="" name="checked_tmlb">&nbsp;32</td>
																	<td class="se_01"><input type="checkbox"
																		value="33" id="" name="checked_tmlb">&nbsp;33</td>
																	<td class="se_01"><input type="checkbox"
																		value="34" id="" name="checked_tmlb">&nbsp;34</td>
																	<td class="se_01"><input type="checkbox"
																		value="35" id="" name="checked_tmlb">&nbsp;35</td>
																	<td class="se_01"><input type="checkbox"
																		value="36" id="" name="checked_tmlb">&nbsp;36</td>
																	<td class="se_01"><input type="checkbox"
																		value="37" id="" name="checked_tmlb">&nbsp;37</td>
																	<td class="se_01"><input type="checkbox"
																		value="38" id="" name="checked_tmlb">&nbsp;38</td>
																	<td class="se_01"><input type="checkbox"
																		value="39" id="" name="checked_tmlb">&nbsp;39</td>
																	<td class="se_01"><input type="checkbox"
																		value="40" id="" name="checked_tmlb">&nbsp;40</td>
																</tr>
																<tr>
																	<td class="se_01"><input type="checkbox"
																		value="41" id="" name="checked_tmlb">&nbsp;41</td>
																	<td class="se_01"><input type="checkbox"
																		value="42" id="" name="checked_tmlb">&nbsp;42</td>
																	<td class="se_01"><input type="checkbox"
																		value="43" id="" name="checked_tmlb">&nbsp;43</td>
																	<td class="se_01"><input type="checkbox"
																		value="44" id="" name="checked_tmlb">&nbsp;44</td>
																	<td class="se_01"><input type="checkbox"
																		value="45" id="" name="checked_tmlb">&nbsp;45</td>
																	<td class="se_01" colspan="5">&nbsp;</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
												<tr>
													<td height="50" colspan="3" class="bg_07"><input
														class="buttonhm" type="button" id="query" value="相同查询  "><input
														class="buttonhm" type="button" id="query2" value="近似查询  ">
														&nbsp; <input class="buttonhm" type="reset" value="重 填">
														&nbsp;</td>
												</tr>
												<tr>
													<td colspan="3" class="bg_09"><%@ include file="/tmweb/hint.jsp"%></td>
												</tr>
												<tr>
													<td height="60" colspan="3" align="right" class="bg_03">
														&nbsp;</td>
												</tr>
											</tbody>
										</table>
									</form>
								</td>
								<td class="background_03">&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</td>
				<td class="background_03">&nbsp;</td>
			</tr>
		</tbody>
	</table>
</body>
</html>