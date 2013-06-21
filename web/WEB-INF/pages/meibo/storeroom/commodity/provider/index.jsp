<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../../../common/css.jsp"></jsp:include>
<jsp:include page="../../../../common/js.jsp"></jsp:include>
</head>
<body>
<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="供应商管理" style="padding: 3px">
			<table id="tt_newProvider" class="easyui-datagrid"
			data-options="fit:true,idField:'id',toolbar:'#tb_provider',collapsible:true,rownumbers:true,url:'/meibo/storeroom/commodity/provider/listContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'companyName',width:80">单位名称</th>
					<th data-options="field:'companyAddress',width:150">单位地址</th>
					<th data-options="field:'linkman',width:120">联系人</th>
					<th data-options="field:'contact',width:100">联系方式</th>
					<th data-options="field:'site',width:150">网站</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../../../main/footer.jsp"></jsp:include>
</body>
</html>