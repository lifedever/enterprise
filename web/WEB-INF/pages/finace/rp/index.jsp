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
		<div title="奖惩管理" style="padding: 3px">
			<table id="tt_rp" class="easyui-datagrid" data-options="fit:true,idField:'id',toolbar:'#tb_rp',collapsible:true,rownumbers:true,
			url:'/finace/rp/listContent.html',pagination:true,singleSelect : true,cache:false" fitColumns="true">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'type',width:70,formatter:typeFormatter">类型</th>
						<th data-options="field:'userName',width:120">姓名</th>
						<th data-options="field:'sum',width:80,formatter:formatMoney">金额</th>
						<th data-options="field:'reason',width:150">缘由</th>
						<th data-options="field:'createDate',width:90,formatter:formatDate,sortable:true">日期</th>
						<th data-options="field:'remark',width:200">备注</th>
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