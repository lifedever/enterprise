<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${title }</title>
<jsp:include page="../common/js.jsp"></jsp:include>
<jsp:include page="../common/css.jsp"></jsp:include>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 70px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow: hidden;
}

.STYLE1 {
	color: #000000;
	font-size: 12px;
}
-->
</style>
</head>
<body>
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" >
		<tr>
			<td>
				<table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td height="235" background="/images/login/login_03.gif">&nbsp;</td>
					</tr>
					<tr>
						<td height="53">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="394" height="53" background="/images/login/login_05.gif">&nbsp;</td>
									<td width="206" background="/images/login/login_06.gif">
									<form method="post" action="/login/checkLogin.html" id="loginForm">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="20%" height="25"><div align="right">
															<span class="STYLE1">姓名：</span>
														</div></td>
													<td width="57%" height="25"><div align="center">
															<input type="text" name="username" id="username"
																style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
														</div></td>
													<td width="27%" height="25">&nbsp;</td>
												</tr>
												<tr>
													<td height="25">
														<div align="right">
															<span class="STYLE1">密码：</span>
														</div>
													</td>
													<td height="25">
														<div align="center">
															<input type="password" name="password"
																style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
														</div>
													</td>
													<td height="25">
														<div align="left">
															<input type="image" src="/images/login/dl.gif" />
														</div>
													</td>
												</tr>
											</table>
										</form>
									</td>
									<td width="362" background="/images/login/login_07.gif">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="213" background="/images/login/login_08.gif">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		(function() {
			$('#username').focus();
			if (window.parent.frames["mainFrame"])
				window.parent.location.reload();
		})();
	</script>
</body>
</html>