<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>商标查询</title>
</head>

<body scroll="no" style="overflow-x: hidden" 	topmargin="0" marginwidth="0" marginheight="0"
		onkeydown="KeyDown()" oncontextmenu="return false">
	<%@ include file="/tm/head.jsp"%>
	<form name="frm" method="post" action="/tm/webquery.html">
<!-- 	position: fixed; -->
<div  style="margin-top: 48px;">
		<div style="width: 99%;">
			<input id="querystr" name="querystr" type="text" class="tinput"
				placeholder='请输入查询词' />
				
		</div>
<!-- 		<input type="text" class="tinput"> -->
		<div align="center" style="width: 100%;">
			<input type="hidden" id="tmlb" name="tmlb" value=""/> <input
				type="button" id="select_all" value="全选" class="t_btn_selectall1"/>
			<input type="button" name="btn_tmlb" id="btn_tmlb_1" value="1"
				class="t_btn_tmlb1"/> <input type="button" name="btn_tmlb"
				id="btn_tmlb_2" value="2" class="t_btn_tmlb1"/> <input
				type="button" name="btn_tmlb" id="btn_tmlb_3" value="3"
				class="t_btn_tmlb1"/>
		</div>
		<div align="center" style="width: 100%;">
			<c:forEach begin="4" end="45" var="x">
				<input type="button" name="btn_tmlb" id="btn_tmlb_${x}" value="${x}"
					class="t_btn_tmlb1"/>
			</c:forEach>
		</div>
		<br />
		<div align="center" style="width: 100%;">
			<input type="button" name="btn_chin_selectall"
				id="btn_chin_selectall" value="中文查询选项" class="tinput">
		</div>
		<br />
		<div align="center" style="width: 100%;">
			<input type="button" id="btn_chin_1" name="btn_chin" value="查拼音"
				class="tinput3"> <input type="button" id="btn_chin_2"
				name="btn_chin" value="同音字" class="tinput3"> <input
				type="button" id="btn_chin_3" name="btn_chin" value="形似字"
				class="tinput3"> <input type="button" id="btn_chin_4"
				name="btn_chin" value="英文同义" class="tinput3"> <input
				type="hidden" id="btn_chin_1v" name="isquerypy" value="false">
			<input type="hidden" id="btn_chin_2v" name="isqueryty" value="false">
			<input type="hidden" id="btn_chin_3v" name="isquerytx" value="false">
			<input type="hidden" id="btn_chin_4v" name="isqueryywty"
				value="false">
		</div>
		<br />
		<div align="center" style="width: 100%;">
			<input type="button" name="btn_eng_selectall" id="btn_eng_selectall"
				value="英文查询选项" class="tinput">
		</div>
		<br />
		<div align="center" style="width: 100%;">
			<input type="button" id="btn_eng_1" name="btn_eng" value="中文同义"
				class="tinput5"> <input type="button" id="btn_eng_2"
				name="btn_eng" value="同音汉字" class="tinput5"> <input
				type="hidden" id="btn_eng_1v" name="isqueryzwty" value="false">
			<input type="hidden" id="btn_eng_2v" name="isquerytyhz" value="false">
		</div>
		<input type="hidden" id="pagesize" name="pagesize" value="50"> <input
			type="hidden" id="pageno" name="pageno" value="1"> <input type="hidden"
			id="querytype" id="querytype" name="querytype" value="1"> <input
			type="hidden" id="tmstatus" name="tmstatus" value="0">
				<br/>
				<br/>
<!-- 	<input type="text" class="tinput"> -->
<!-- 		<div align="center"> -->
<!-- 		style="position: fixed;"  -->
			<input id="query" type="button" class="tsubmit"
				 value="相同查询"> <input id="query2"
				type="button" class="tsubmit2" value="近似查询">
<!-- 		</div> -->
	</div>
	</form>
	<script Language="javaScript" src="/tm/js/query.js"></script>
</body>
</html>