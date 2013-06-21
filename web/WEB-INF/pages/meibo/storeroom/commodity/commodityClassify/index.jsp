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
		<div title="货源类型管理" style="padding: 3px">
			<table id="tt_newCommodityClassify" class="easyui-datagrid"
			data-options="fit:true,idField:'id',toolbar:'#tb_classify',collapsible:true,rownumbers:true,url:'/meibo/storeroom/commodity/commodityClassify/listContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'classifyCode',width:150">货源分类编码</th>
					<th data-options="field:'classifyName',width:150">货源分类名称</th>
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