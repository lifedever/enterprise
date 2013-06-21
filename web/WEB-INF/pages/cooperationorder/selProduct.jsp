<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<table id="tt_selProduct" class="easyui-datagrid" style="width: 870px; height: 340px" data-options="pagination:true,singleSelect:true,rownumbers : true,collapsible:true,url:'/product/listContent.html?f_isCooperation=0',toolbar : '#tb_selProduct'">
		<thead>
			<tr>
				<th data-options="field:'orderNo',width:100">订单编号</th>
				<th data-options="field:'productNo',width:100">产品编号</th>
				<th data-options="field:'customerName',width:80">客户姓名</th>
				<th data-options="field:'productName',width:80">产品名称</th>
				<th data-options="field:'productCount',width:80">产品数量</th>
				<th data-options="field:'materialRequired',width:80">质量要求</th>
				<th data-options="field:'productStartDate',width:140">制作开始时间</th>
				<th data-options="field:'productEndDate',width:140">制作结束时间</th>
			</tr>
		</thead>
	</table>
</div>
<div id="tb_selProduct" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="addSelProductOk();">确认选择</a>
	</div>
</div>
<script>
	
</script>