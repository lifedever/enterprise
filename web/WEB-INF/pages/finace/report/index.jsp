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
		<div title="利润表" style="padding: 3px" data-options="iconCls:'icon-table'">
			<table id="tt_newProfit" class="easyui-datagrid" style="" data-options="fit:true,idField:'id',
					toolbar:'#tb_profit',collapsible:true,rownumbers:true,
					url:'/finace/report/profit/listContent.html',pagination:true,
					singleSelect : true,cache:false">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'createDate',width:120,formatter:formatDate">日期</th>
						<th data-options="field:'bzhdw',width:120">编制单位</th>
					</tr>
				</thead>
			</table>
		</div>
		<div title="资产负债表" style="padding: 3px" data-options="iconCls:'icon-table1'">
			<table id="tt_newAsserts" class="easyui-datagrid" style="" data-options="fit:true,idField:'id',
					collapsible:true,rownumbers:true,toolbar:'#tb_asserts',
					url:'/finace/report/asserts/listContent.html',pagination:true,
					singleSelect : true,cache:false">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'createDate',width:120,formatter:formatDate">日期</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<jsp:include page="profit/index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="asserts/index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="profit/index-script-page.jsp"></jsp:include>
	<jsp:include page="asserts/index-script-page.jsp"></jsp:include>
	<jsp:include page="profit/index-win-page.jsp"></jsp:include>
	<jsp:include page="asserts/index-win-page.jsp"></jsp:include>
	<jsp:include page="../../main/footer.jsp"></jsp:include>
</body>
</html>