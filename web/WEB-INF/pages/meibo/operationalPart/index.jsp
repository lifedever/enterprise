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
			<table id="tt_operaOrder" class="easyui-datagrid" 
			data-options="idField:'id',toolbar:'#tb_customer',onExpandRow:onExpandRow,fit:true,
			view : detailview,detailFormatter:detailFormatter,collapsible:true,rownumbers:true,
			url:'/meibo/order/listContent.html?f_isAudit=1',pagination:true,singleSelect : true,cache:false"
			fitColumns="true">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'isProof',width:40,formatter:isProofFormatter">类型</th>
					<th data-options="field:'orderNo',width:80,formatter:orderFormatter">订单编号</th>
					<th data-options="field:'username',width:80">业务员姓名</th>
					<th data-options="field:'customerName',width:60">客户姓名</th>
					<th data-options="field:'signState',width:140,formatter:signFormatter">签单信息</th>
					<th data-options="field:'startDate',width:70,formatter:formatDate">开始时间</th>
					<th data-options="field:'endDate',width:70,formatter:formatDate">结束时间</th>
					<th data-options="field:'orderStatus',width:120">订单状态</th>
					<th data-options="field:'createDate',width:70,formatter:formatDate,sortable:true">创建时间</th>
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