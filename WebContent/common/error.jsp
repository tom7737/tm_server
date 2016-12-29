<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/inc.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>操作失败</title>
</head>

<body>
	<div class="container">
		<!-- 内容区域 -->
		<div class="itemtitle">
			<h1>提示</h1>
		</div>

		<!-- 列表区域-->
		<div id="content" class="content">
			<div style="padding-top: 20px; text-align: center;">
				<div>
					<h2>
						<font color="red">操作失败！</font>
					</h2>
					<h2>
						<font color="red">错误原因： <c:choose>
								<c:when test="${error_msg==null || error_msg==''}">系统未知错误</c:when>
								<c:otherwise>${error_msg}</c:otherwise>
							</c:choose>
						</font>
					</h2>
				</div>
			</div>
		</div>
	</div>
</body>
</html>