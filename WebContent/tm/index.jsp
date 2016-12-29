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
<title>商标查询</title>
</head>

<body scroll="no" style="overflow-x: hidden">	
	<br/>
	<br/>
	<input type="button" value="商标近似查询" class="tinput2" style="background-color:#FC69D7;" onclick="javascript:location.href='/tm/query.jsp';">
	<br/>
	<br/>
	<input type="button" value="图形商标查询" class="tinput2" style="background-color:#FA6B7A;" onclick="javascript:location.href='/tm/img_query.jsp';">
	<br/>
	<br/>
	<input type="button" value="注册号查询" class="tinput2" onclick="javascript:location.href='/tm/ftmid_query.jsp';">
	<br/>
	<br/>
	<input type="button" value="注册人查询" class="tinput2" style="background-color:#FD8F35;" onclick="javascript:location.href='/other/gootherquery.html?field=sqr';">
	<br/>
	<br/>
	<input type="button" value="注册地址查询" class="tinput2" style="background-color:#F7EE6E;" onclick="javascript:location.href='/other/gootherquery.html?field=addr';">
	<br/>
	<br/>
	<input type="button" value="使用商品查询" class="tinput2" style="background-color:#72FD68;" onclick="javascript:location.href='/other/gootherquery.html?field=sysp';">
	<br/>
	<br/>
	<input type="button" value="代理组织查询" class="tinput2" style="background-color:#6AEDFB;" onclick="javascript:location.href='/other/gootherquery.html?field=dlzz';">
	<br/>
	<br/>
	<input type="button" value="公告期号查询" class="tinput2" style="background-color:#6874FD;" onclick="javascript:location.href='/other/gootherquery.html?field=ggqh';">
	<br/>
	<br/>
	<input type="button" value="备注信息查询" class="tinput2" style="background-color:#E86AFB;" onclick="javascript:location.href='/other/gootherquery.html?field=bz';">
	<br/>
	<br/>
	<input type="button" value="商品/服务项目查询" class="tinput2" style="background-color:#6B6B6B;" onclick="javascript:location.href='/tm/spdm_query.jsp';">
	<br/>
	<br/>
</body>
</html>