<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<htmls>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(/images/left.gif);
}
-->
</style>
<link href="/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-easyui-1.3.1/jquery-1.8.0.js"></script>
<script type="text/javascript">
	$(function(){
		var winHeight = $(window).height();//winHeight即浏览器高度
		$("#menuBar").css("height",winHeight-100);
	});
</script>
</head>
<body>
	<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
		<tr>
			<TD>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="207" height="55" background="/images/nav01.gif">
							<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td width="25%" rowspan="2"><img src="/images/ico02.gif" width="35" height="35" /></td>
									<td width="75%" height="22" class="left-font01">您好： ${sessionScope.user.realName }</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<div style="overflow: auto;" id="menuBar">
					<c:forEach items="${functions }" var="fun" varStatus="index">
						<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
							<tr>
								<td height="29">
									<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td width="8%"><img name="img_${index.index}" id="img_${index.index}" src="/images/ico04.gif" width="8" height="11" /></td>
											<td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('${index.index}');" title="${fun.description }">${fun.functionName}</a></td>
										</tr>
									</table>
								</td>
							</tr>
						</TABLE>
						<table id="subtree_${index.index}" style="display: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
							<!-- 子菜单列表 -->
							<c:forEach items="${fun.functions}" var="subFun" varStatus="ii">
								<tr>
									<td width="9%" height="20"><img id="xiaotu_${subFun.id}" name="xiaotu" src="/images/ico06.gif" width="8" height="12" /></td>
									<td width="91%"><a href="${subFun.functionUrl }" target="mainFrame" class="left-font03" onClick="tupian('${subFun.id}');" title="${subFun.description }">${subFun.functionName }</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:forEach>
				</div>
			</TD>
		</tr>
	</table>
	<script type="text/javascript">
		function tupian(idt) {
			var xiaotu = document.getElementsByName("xiaotu");
			var len = xiaotu.length;
			var nametu = "xiaotu_" + idt;
			var tp = document.getElementById(nametu);
			//图片ico06为白色的正方形
			//图片ico05为蓝色的正方形 
			for ( var i = 0; i < len; i++) {
				xiaotu[i].src = "/images/ico06.gif";
			}
			tp.src = "/images/ico05.gif";
		}

		function list(idstr) {
			var name1 = "subtree_" + idstr;
			var name2 = "img_" + idstr;
			var objectobj = document.getElementById(name1);
			var imgobj = document.getElementById(name2);

			//alert(imgobj);

			if (objectobj.style.display == "none") {
				for ( var i = 1; i < 10; i++) {
					var name3 = "img_" + i;
					var name = "subtree_" + i;
					var o = document.getElementById(name);
					if (o != undefined) {
						//o.style.display = "none";
						var image = document.getElementById(name3);
						//alert(image);
						image.src = "/images/ico04.gif";
					}
				}
				objectobj.style.display = "";
				imgobj.src = "/images/ico03.gif";
			} else {
				objectobj.style.display = "none";
				imgobj.src = "/images/ico04.gif";
			}
		}
	</script>
</body>
</html>