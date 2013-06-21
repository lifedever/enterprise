<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../../common/tag.jsp"%>
<table id="tt_viewlogistics" class="easyui-datagrid" 
data-options="idField:'id',toolbar:'#tb_logistics',collapsible:true,rownumbers:true,fit:true,
url:'/meibo/operationalPart/logistics/listContent.html?f_orderNo=${orderNo }',pagination:true,singleSelect : true,cache:false">
<thead>
	<tr>
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
