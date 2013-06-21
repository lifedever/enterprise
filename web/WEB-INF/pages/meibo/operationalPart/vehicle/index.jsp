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
		<div title="车辆管理" style="padding: 3px">
			<table id="tt_vehicle" class="easyui-datagrid" 
			data-options="idField:'id',toolbar:'#tb_vehicle',collapsible:true,rownumbers:true,fit:true,
			url:'/meibo/operationalPart/vehicle/listContent.html',pagination:true,singleSelect : true,cache:false"
			fitColumns="true">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'date',width:70,formatter:formatDate,sortable:true">日期时间</th>
					<th data-options="field:'orderNo',width:120">加工单号</th>
					<th data-options="field:'number',width:70">件数</th>
					<th data-options="field:'deliveryAddress',width:160">送货地址</th>
					<th data-options="field:'vehicleType',width:100">车辆类型</th>
					<th data-options="field:'sum',width:70,formatter:formatMoney">金额</th>
					<th data-options="field:'driver',width:100">司机</th>
					<th data-options="field:'clerk',width:100">业务员</th>
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