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
		<div title="订单收款管理" style="padding: 3px">
			<table id="tt_newFinishedfee" class="easyui-datagrid"
				data-options="idField:'id',toolbar:'#tb_finishedfee',onExpandRow:onExpandRow,fit:true,
			view : detailview,detailFormatter:detailFormatter,collapsible:true,rownumbers:true,
			url:'/finace/finishedfee/listContent.html?f_isAudit=1',pagination:true,singleSelect : true,cache:false"
				fitColumns="true">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'isProof',width:60,formatter:isProofFormatter">类型</th>
						<th data-options="field:'orderNo',width:160,formatter:orderNoFormatter">订单编号</th>
						<th data-options="field:'xxx',width:70,formatter:finishFormatter">收款状态</th>
						<th data-options="field:'customerName',width:120">客户姓名</th>
						<th data-options="field:'allCount',width:160,formatter:formatMoney">全款金额</th>
						<th data-options="field:'hasCount',width:160,formatter:formatMoney">已收取金额</th>
						<!-- <th data-options="field:'recorder',width:100">未收取</th>
					<th data-options="field:'recorder',width:100">收取状态</th> -->
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="../../main/footer.jsp"></jsp:include>
</body>
</html>