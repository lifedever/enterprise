<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
</head>
<body>
<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="材料定价" style="padding: 3px">
			<table id="tt_newPricing" class="easyui-datagrid"
			data-options="idField:'id', iconCls: 'icon-edit',toolbar: '#tb_pricing',fit:true,
			url: '/finace/pricing/listContent.html',onClickRow:onClickRow,
			pagination:true,rownumbers:true,singleSelect:true,cache:false">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'classifyName',width:80">分类</th>
					<th data-options="field:'name',width:140">名称</th>
					<th data-options="field:'standard',width:120">规格</th>
					<th data-options="field:'thickness',width:100">厚度</th>
					<th data-options="field:'unit',width:80">单位</th>
					<th data-options="field:'color',width:80">颜色</th>
					<th data-options="field:'count',width:60">数量</th>
					<th data-options="field:'price',width:80,formatter:formatMoney">产品单价</th>
					<th data-options="field:'xx',width:80,formatter:formatTotalPrice">总价</th>
					<th data-options="field:'providerName',width:120">供货商名称</th>
					<th data-options="field:'createDate',width:120,formatter:formatDate">入库时间</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../main/footer.jsp"></jsp:include>
</body>
</html>