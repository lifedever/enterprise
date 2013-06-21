<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../../../common/css.jsp"></jsp:include>
<jsp:include page="../../../../common/js.jsp"></jsp:include>
</head>
<body>
<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="外发单管理" style="padding: 3px">
			<table id="tt_cooperationOrder" class="easyui-datagrid"
			data-options="idField:'id',toolbar:'#tb_cooperationOrder',collapsible:true,rownumbers:true,fit:true,
			url:'/meibo/operationalPart/cooperation/order/listContent.html',pagination:true,singleSelect : true,cache:false">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'productNo',width:120,formatter:cooperatorOrderformatter">加工单号</th>
					<th data-options="field:'productName',width:60">产品名称</th>
					<th data-options="field:'payStatus',width:60,formatter:payStatusFormatter">付款状态</th>
					<th data-options="field:'productCount',width:50">数量</th>
					<th data-options="field:'instoreCount',width:70">未入库数量</th>
					<th data-options="field:'price',width:60,formatter:formatMoney">单价</th>
					<th data-options="field:'sendMan',width:60">派单员</th>
					<th data-options="field:'image',width:60,formatter:formatImage">工程图</th>
					<th data-options="field:'idVehicle',width:70,formatter:formatVehicle">查看车辆</th>
					<th data-options="field:'idLogistics',width:70,formatter:formatLogistics">查看物流</th>
					<th data-options="field:'cooperationFactory',width:120">外发厂家名称</th>
					<th data-options="field:'setOrderDate',width:80,formatter:formatDate">下单时间</th>
					<th data-options="field:'id',width:80,formatter:instore">点击入库</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<jsp:include page="index-toolbar-page.jsp"></jsp:include>
	<jsp:include page="index-win-page.jsp"></jsp:include>
	<jsp:include page="index-script-page.jsp"></jsp:include>
	<jsp:include page="../../../../main/footer.jsp"></jsp:include>
</body>
</html>