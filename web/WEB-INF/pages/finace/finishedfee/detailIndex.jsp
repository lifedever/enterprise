<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<div class="easyui-panel">
	<div style="padding: 10px 0 10px 10px;">
		合计：${hasMoney }
	</div>
	<table id="tt_newDetailFinishedfee" class="easyui-datagrid"
		style="height: 320px"
		data-options="idField:'id',
		collapsible:true,rownumbers:true,url:'/finace/finishedfee/detailListContent.html?f_orderNo=${orderNo }',
		pagination:true,singleSelect : true,cache:false">
		<thead>
			<tr>
				<th data-options="field:'orderNo',width:180">订单号</th>
				<th data-options="field:'hasCount',width:120,formatter:formatMoney">收取金额</th>
				<th data-options="field:'payee',width:100">收款人</th>
				<th data-options="field:'payer',width:100">付款方</th>
				<th data-options="field:'accountName',width:120">转入银行</th>
				<th data-options="field:'createDate',width:100,formatter:formatDate">收取日期</th>
			</tr>
		</thead>
	</table>
</div>