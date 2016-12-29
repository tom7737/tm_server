<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <a href="/tmweb/query.jsp"><font color="red">商标近似查询</font></a> -->
<!-- <a href="/tmweb/img_query.jsp"><font color="red">图形商标查询</font></a> -->
<script type="text/javascript">
	$(document).ready(function() {
		var json = [ {
			"ahref" : "/",
			"name" : "商标近似查询"
		}, {
			"ahref" : "/tmweb/img_query.jsp",
			"name" : "图形商标查询"
		} 
		, {
			"ahref" : "/tmweb/ftmid_query.jsp",
			"name" : "注册号查询"
		}
		, {
			"ahref" : "/tmweb/other_query.jsp",
			"name" : "其他查询"
		}
		, {
			"ahref" : "/tmweb/spdm_query.jsp",
			"name" : "商品/服务项目查询"
		}];
		var locapath = window.location.pathname;
		var writestr = "";
		$.each(json, function(index,  menu) {
			writestr+=' ';
			if(menu.ahref == locapath){
				writestr+='<font color="red">'+menu.name+'</font>';
			}else{
				writestr+='<a href="'+menu.ahref+'">'+menu.name+'</a>';
			}
			writestr+=' ';
		});
		$("#menu").html(writestr);
	});
</script>
