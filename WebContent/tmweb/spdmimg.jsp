<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>共腾商品分类表</title>
<link href="/css/bookcss/style.css" type="text/css" rel="stylesheet" />
<link type="text/css" href="/css/bookcss/book.css" rel="stylesheet" />
</head>

<body topmargin="0" marginwidth="0" marginheight="0"
	onkeydown="KeyDown()" oncontextmenu="return false">
	<form id="frm" name="frm" method="post" action="/spdmimage/tospdmimg.html">
		<input type="hidden" id="page" name="page"
			value="<fmt:formatNumber type='number' value='${page/2*2}' maxFractionDigits='0'/>">
	</form>
	<br />
	<!--演示内容开始-->

	<div id="book" style="margin: 0 auto;">
		<div class="arrow" style="left: -27px;">
			<div class="mask"></div>
			<div class="al" title="上一页"></div>
		</div>
		<div id="flip">
			<div class="container">
				<div class="label"></div>
				<div class="content"></div>
				<div class="pager"></div>
			</div>
			<div class="overlayer ie_l">
				<img src="/css/bookcss/flip_r.png" width="100%" height="941" />
			</div>
		</div>
		<div id="left">
			<br>
			<div class="label">
				跳转到第<input type="text" size="3" id="skippage">页<input type="button"
					value="跳转 " id="skip">
			</div>
			<div class="content">
				<div class="default">
					<a
						href="/img/spdm/<fmt:formatNumber type='number' value='${page/2*2}' maxFractionDigits='0'/>.jpg"
						target="_blank"> <img title="点击看大图"
						src="/img/spdm/<fmt:formatNumber type='number' value='${page/2*2}' maxFractionDigits='0'/>.jpg"
						style="height: 100%; width: 100%" /></a>
					<p align="center"></p>
				</div>
			</div>
			<div class="pager"></div>
		</div>

		<div id="right">
			<br>
			<div class="label"></div>
			<div class="content">
				<div class="default">
					<a
						href="/img/spdm/<fmt:formatNumber type='number' value='${page/2*2}' maxFractionDigits='0'/>.jpg"
						target="_blank"> <img title="点击看大图"
						src="/img/spdm/<fmt:formatNumber type='number' value='${page/2*2+1}' maxFractionDigits='0'/>.jpg"
						style="height: 100%; width: 100%" />
					</a>
				</div>
			</div>
			<br>
			<!-- 			<div class="glide"> -->
			<!-- 				<div style="left: 50%;"></div> -->
			<!-- 			</div> -->
		</div>

		<div id="foot"></div>

		<div class="arrow" style="left: 1448px;">
			<div class="mask"></div>
			<div class="ar" title="下一页"></div>
		</div>

	</div>
	<script type="text/javascript" src="/javascript/page.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="/javascript/book.js"
		charset="utf-8"></script>
	<!--演示内容结束-->

</body>
</html>