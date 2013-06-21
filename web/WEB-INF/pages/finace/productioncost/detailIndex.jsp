<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="easyui-panel">
	<table id="tt_newDetailProductcost" class="easyui-datagrid" style="height: 200px" title="加工单用料明细" ,
		data-options="idField:'id',
		collapsible:true,rownumbers:true,url:'/finace/productioncost/detailListContent.html?productNo=${productNo }',
		singleSelect : true,cache:false,showFooter:true"
		fitColumns="true">
		<thead>
			<tr>
				<th data-options="field:'operation',width:80,formatter:operation">操作</th>
				<th data-options="field:'productNo',width:140">加工单号</th>
				<th data-options="field:'name',width:140">材料名称</th>
				<th data-options="field:'price',width:60,formatter:formatMoney">单价</th>
				<th data-options="field:'count',width:80">数量</th>
				<th data-options="field:'pickinger',width:120">领料人</th>
				<th data-options="field:'recorder',width:100">记录人</th>
				<th data-options="field:'createDate',width:100,formatter:formatDate" sortable="true">日期</th>
			</tr>
		</thead>
	</table>
	<table id="tt_newDetailProductcost" class="easyui-datagrid" style="height: 200px" title="加工单其它支出明细"
		,
		data-options="idField:'id',
		collapsible:true,rownumbers:true,url:'/finace/productioncost/extraCostListContent.html?productNo=${productNo }',
		singleSelect : true,cache:false, toolbar:'#tb_newDetailProductcost',showFooter:true" fitColumns="true">
		<thead>
			<tr>
				<th data-options="field:'remark',width:180">详情说明</th>
				<th data-options="field:'cost',width:60,formatter:formatMoney">花费</th>
				<th data-options="field:'createDate',width:100,formatter:formatDate" sortable="true">统计时间</th>
			</tr>
		</thead>
	</table>
</div>
<!-- <div id="tb_newDetailProductcost" style="padding: 5px; height: auto">
<a href="#" class="easyui-linkbutton" iconCls="icon-del" plain="true" onclick="delCost();">删除</a>
</div> -->