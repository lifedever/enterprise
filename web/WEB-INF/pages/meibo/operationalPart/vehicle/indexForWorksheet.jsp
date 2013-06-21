<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<table id="tt_viewvehicle" class="easyui-datagrid" 
data-options="idField:'id',collapsible:true,rownumbers:true,fit:true,
url:'/meibo/operationalPart/vehicle/listContent.html?f_orderNo=${orderNo }',pagination:true,singleSelect:true,cache:false">
<thead>
	<tr>
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
