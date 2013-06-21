<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../../common/css.jsp"></jsp:include>
<jsp:include page="../../../common/js.jsp"></jsp:include>
</head>
<body>
<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="物流管理" style="padding: 3px">
			<table id="tt_logistics" class="easyui-datagrid" 
			data-options="idField:'id',toolbar:'#tb_logistics',collapsible:true,rownumbers:true,fit:true,
			url:'/meibo/operationalPart/logistics/listContent.html',pagination:true,singleSelect : true,cache:false"
			fitColumns="true">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'shipDate',width:90,formatter:formatDate,sortable:true">发货日期</th>
					<th data-options="field:'orderNo',width:120">加工单号</th>
					<th data-options="field:'singleNo',width:70">单号</th>
					<th data-options="field:'addressee',width:80">收件人</th>
					<th data-options="field:'sender',width:80">发件人</th>
					<th data-options="field:'destination',width:150">目的地</th>
					<th data-options="field:'weight',width:100">重量</th>
					<th data-options="field:'volume',width:100">体积</th>
					<th data-options="field:'sum',width:80,formatter:formatMoney">金额</th>
					<th data-options="field:'goods',width:80">物品</th>
					<th data-options="field:'remark',width:150">备注</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../../main/footer.jsp"></jsp:include>
</body>
</html>