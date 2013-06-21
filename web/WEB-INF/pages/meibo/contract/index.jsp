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
		<div title="签单管理" style="padding: 3px">
			<table id="tt_contract" class="easyui-datagrid"data-options="
			fit:true,idField:'id',toolbar:'#tb_customer',collapsible:true,rownumbers:true,
			url:'/meibo/contract/listContent.html',pagination:true,singleSelect : true,cache:false"
				fitColumns="true">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'contractNo',width:80">合同编号</th>
						<th data-options="field:'orderNo',width:80,formatter:orderFormatter">订单编号</th>
						<th data-options="field:'signDate',width:80,formatter:formatDate" sortable="true">签订日期</th>
						<th data-options="field:'validateDate',width:80,formatter:formatDate" sortable="true">有效日期</th>
						<th data-options="field:'provider',width:60">供方签约人</th>
						<th data-options="field:'buyer',width:60">需方签约人</th>
						<th data-options="field:'content',width:120">合同条款</th>
						<th data-options="field:'createDate',width:80,formatter:formatDate" sortable="true">创建时间</th>

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