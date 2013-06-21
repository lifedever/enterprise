<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/tag.jsp"%>
<div class="ftitle">
	用料明细列表<span class="form_desc"></span>
</div>
<table id="tt_listMaterial" class="easyui-datagrid" style="width: 800px; height: 330px;"
	data-options="idField:'id',
		collapsible:true,rownumbers:true,url:'/meibo/offer/materialdetail/listTempByItemId.html?itemId=${itemId }',
		pagination:true,cache:false">
	<thead>
		<tr>
			<th data-options="field:'type',width:60,formatter:formatMType">材料类型</th>
			<th data-options="field:'name',width:100">名称</th>
			<th data-options="field:'standard',width:90">标准</th>
			<th data-options="field:'thickness',width:80">颜色厚度</th>
			<th data-options="field:'count',width:50">数量</th>
			<th data-options="field:'fullPage',width:130">整版</th>
			<th data-options="field:'createDate',width:80,formatter:formatDate">创建日期</th>
			<th data-options="field:'remark',width:160">备注</th>
		</tr>
	</thead>
</table>