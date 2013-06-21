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
		<div title="订单管理" style="padding: 3px">
			<table id="tt_order" class="easyui-datagrid"
				data-options="idField:'id',toolbar:'#tb_customer',onExpandRow:onExpandRow,fit:true,
			view : detailview,detailFormatter:detailFormatter,collapsible:true,rownumbers:true,
			url:'/meibo/order/listContent.html',pagination:true,singleSelect : true,cache:false">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'isProof',width:60,formatter:isProofFormatter">类型</th>
						<th data-options="field:'orderNo',width:120,formatter:orderFormatter">订单编号</th>
						<th data-options="field:'customerName',width:80">客户姓名</th>
						<th data-options="field:'signState',width:120,formatter:signFormatter">签单信息</th>
						<th data-options="field:'isAudit',width:80,formatter:formatAuditState">审批状态</th>
						<th data-options="field:'auditUser',width:80">审批人</th>
						<th data-options="field:'orderStatus',width:80">订单状态</th>
						<th data-options="field:'allCount',width:80,formatter:formatMoney">全款金额</th>
						<th data-options="field:'hasCount',width:80,formatter:formatMoney">已收取金额</th>
						<th data-options="field:'xxx',width:70,formatter:finishFormatter">收款状态</th>
						<th data-options="field:'startDate',width:80,formatter:formatDate">开始时间</th>
						<th data-options="field:'endDate',width:80,formatter:formatDate">结束时间</th>
						<th data-options="field:'createDate',width:80,formatter:formatDate,sortable:true">创建时间</th>
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