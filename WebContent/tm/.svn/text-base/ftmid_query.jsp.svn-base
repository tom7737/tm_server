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
  <style type="text/css">
        #alertMsg {
            display: none;
            width: 400px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 1px 1px 10px black;
            padding: 10px;
            font-size: 12px;
            position: absolute;
            text-align: center;
            background: #fff;
            z-index: 100000;
        }

        #alertMsg_info {
            padding: 2px 15px;
            line-height: 1.6em;
            text-align: left;
        }

        #alertMsg_btn1, #alertMsg_btn2 {
            display: inline-block;
            background: url(images/gray_btn.png) no-repeat left top;
            padding-left: 3px;
            color: #000000;
            font-size: 12px;
            text-decoration: none;
            margin-right: 10px;
            cursor: pointer;
        }

        #alertMsg_btn1 cite, #alertMsg_btn2 cite {
            line-height: 24px;
            display: inline-block;
            padding: 0 13px 0 10px;
            background: url(images/gray_btn.png) no-repeat right top;
            font-style: normal;
        }

    </style>
</head>

<body scroll="no" style="overflow-x: hidden" 	topmargin="0" marginwidth="0" marginheight="0"
		onkeydown="KeyDown()" oncontextmenu="return false">
	<%@ include file="/tm/head.jsp"%>
	<form name="frm" method="post" action="/ftmid/mwebquery.html">
<!-- 	position: fixed; -->
<div  style="margin-top: 48px;">
		<div style="width: 99%;">
			<input id="ftmid" name="ftmid" type="text" class="tinput"
				placeholder='请输入注册号' />
				
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
				<br/>
				<br/>
<!-- 	<input type="text" class="tinput"> -->
<!-- 		<div align="center"> -->
<!-- 		style="position: fixed;"  -->
			<input id="query" type="button" class="tinput2"
				 value="查询"/> 
<!-- 		</div> -->
	</div>
	</form>
	<script Language="javaScript" src="/tm/js/ftmid_query.js"></script>
</body>
</html>