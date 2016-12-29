<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%--<base href=".">--%>
<title>分类表第${page}页</title>
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
	onkeydown="KeyDown()" oncontextmenu="return false" >
	<br> <center> <img id="spdmimg"
			src="/spdmimage/getimage.html?page=${page}" alt="分类表第${page}页"
			style="height: 100%;" /> </center> <script type="text/javascript">
				$(document).ready(
						function() {
							var screenheight = window.screen.availHeight;
							alert(screenheight);
							$("#spdmimg").attr("style",
									"height:" + screenheight + "px;");
						});
			</script>
</body>
</html>