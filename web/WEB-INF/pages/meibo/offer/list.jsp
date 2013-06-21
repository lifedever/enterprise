<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<table id="tt_offer2" class="easyui-datagrid" style="height: 370px"
	data-options="idField:'id',collapsible:true,rownumbers:true,url:'/meibo/offer/listContent.html?f_customer.id=${customer.id }',pagination:true,singleSelect : true,cache:false" fitColumns="true">
	<thead>
		<tr>
			<th data-options="field:'createDate',width:120,formatter:formatDate">询价日期</th>
			<th data-options="field:'itemCount',width:80">条目数量</th>
			<th data-options="field:'remark',width:200">备注</th>
			<th data-options="field:'xxxx',width:100,formatter:showItemsFormat">详情</th>
		</tr>
	</thead>
</table>
