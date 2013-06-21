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
		<div title="询价信息管理" style="padding: 3px">
			<table id="tt_offer" class="easyui-datagrid" 
				data-options="idField:'id',toolbar:'#tb_customer',onExpandRow:onExpandRow,fit:true,
			view : detailview,detailFormatter:detailFormatter,collapsible:true,rownumbers:true,
			url:'/meibo/offer/listContent.html',pagination:true,singleSelect : true,cache:false" fitColumns="true">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'isProof',width:60,formatter:isProofFormatter">类型</th>
						<th data-options="field:'offerState',width:80,formatter:offerStateFormatter">是否同意</th>
						<th data-options="field:'moneyState',width:60,formatter:offerMoneyStateFormatter">报价状态</th>
						<th data-options="field:'offerUser',width:60">审批人</th>
						<th data-options="field:'customerName',width:60">客户姓名</th>
					<!-- 	<th data-options="field:'signState',width:120,formatter:signFormatter">签单信息</th>
						<th data-options="field:'isOrder',width:100,formatter:orderFormatter">订单编号</th> -->
						<th data-options="field:'remark',width:200">备注</th>
						<th data-options="field:'createDate',width:80,formatter:formatDate" sortable="true">询价日期</th>
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