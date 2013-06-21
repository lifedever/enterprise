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
		<div title="记账凭证" style="padding: 3px" data-options="iconCls:'icon-table'">
			<table id="tt_newVoucher" class="easyui-datagrid" style="" data-options="fit:true,idField:'id',
					toolbar:'#tb_voucher',rownumbers:true,
					url:'/finace/voucher/listContent.html',pagination:true,
					singleSelect : true,cache:false">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'createDate',width:120,formatter:formatDate">日期</th>
						<th data-options="field:'jizi',width:120">记字</th>
						<th data-options="field:'fdshj',width:120">附单据数</th>
						<th data-options="field:'master',width:120">主管</th>
						<th data-options="field:'voucher',width:120">记账</th>
						<th data-options="field:'auditer',width:120">审核</th>
						<th data-options="field:'chahier',width:120">出纳</th>
						<th data-options="field:'systems',width:120">制单</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="summaryForm.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="../../main/footer.jsp"></jsp:include>
</body>
</html>