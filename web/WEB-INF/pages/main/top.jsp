<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

a {
	cursor: pointer;
}

.STYLE1 {
	font-size: 12px;
	color: #000000;
}

.STYLE5 {
	font-size: 12
}

.STYLE7 {
	font-size: 12px;
	color: #FFFFFF;
}
-->
</style>
<script type="text/javascript">
	function show() {
		var date = new Date(); //日期对象
		var now = "";
		now = date.getFullYear() + "年"; //读英文就行了
		now = now + (date.getMonth() + 1) + "月"; //取月的时候取的是当前月-1如果想取当前月+1就可以了
		now = now + date.getDate() + "日  ";
		now = now + date.getHours() + ":";
		now = now + date.getMinutes() + ":";
		now = now + date.getSeconds();
		document.getElementById("nowDiv").innerHTML = now; //div的html是now这个字符串 
		setTimeout("show()", 1000); //设置过1000毫秒就是1秒，调用show方法
	}
</script>
</head>

<body onload="show();">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="57" background="/images/main_03.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="378" height="57" background="/images/main_01.gif">&nbsp;</td>
						<td>&nbsp;</td>
						<td width="281" valign="bottom"><table width="100%"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="33" height="27"><img src="/images/main_05.gif"
										width="33" height="27" /></td>
									<td width="248" background="/images/main_06.gif"><table
											width="225" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<!-- 
												<td height="17"><div align="right">
														<img src="/images/pass.gif" width="69" height="17" />
													</div></td>
												<td><div align="right">
														<img src="/images/user.gif" width="69" height="17" />
													</div></td> -->
												<td>
													<div align="right">
														<img src="/images/modify.png" style="cursor: pointer"
															width="69" height="17" onclick="changeUser();" /> <img
															src="/images/message.png" style="cursor: pointer"
															width="69" height="17" onclick="messagecenter();" /> <img
															src="/images/quit.gif" style="cursor: pointer" width="69"
															height="17" onclick="window.top.frames['mainFrame'].logout();" />
													</div>
												</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="40" background="/images/main_10.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="194" height="40" background="/images/main_07.gif">&nbsp;</td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td width="21"><img src="/images/main_13.gif" width="19"
										height="14" /></td>
									<td width="35" class="STYLE7"><div align="center">
											<a onclick="top.location.href='/main/index.html'">首页</a>
										</div></td>
									<td width="21" class="STYLE7"><img
										src="/images/main_15.gif" width="19" height="14" /></td>
									<td width="35" class="STYLE7"><div align="center">
											<a onclick="history.go(-1)">后退</a>
										</div></td>
									<td width="21" class="STYLE7"><img
										src="/images/main_17.gif" width="19" height="14" /></td>
									<td width="35" class="STYLE7"><div align="center">
											<a onclick="history.go(1)">前进</a>
										</div></td>
									<td width="21" class="STYLE7"><img
										src="/images/main_19.gif" width="19" height="14" /></td>
									<td width="35" class="STYLE7"><div align="center">
											<a
												onclick="window.top.frames['mainFrame'].location.reload();">刷新</a>
										</div></td>
									<td>&nbsp;</td>
								</tr>
							</table></td>
						<td width="248" background="/images/main_11.gif"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="16%"><span class="STYLE5"></span></td>
									<td width="75%"><div align="center">
											<span class="STYLE7">时间：<span id="nowDiv" class="STYLE7"></span>
											</span>
										</div></td>
									<td width="9%">&nbsp;</td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<script type="text/javascript">
		
		function messagecenter() {
			window.top.frames['mainFrame'].showWin();
		}
		function changeUser() {
			window.top.frames['mainFrame'].modifyPassword();
		}
	</script>
</body>
</script>
</html>
