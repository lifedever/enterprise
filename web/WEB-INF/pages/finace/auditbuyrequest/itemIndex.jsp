<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tt_employee" class="easyui-datagrid" title="" style="height: 350px"
		data-options="singleSelect : true,
			collapsible:true,rownumbers:true,idField : 'id',
			url:'/buyRequestItem/listContent.html?f_buyRequestId=${buyRequestId }',pagination:true">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'buyName',width:100">名称</th>
			<th data-options="field:'buyStandard',width:100">规格</th>
			<th data-options="field:'buyCount',width:80">数量</th>
			<th data-options="field:'unit',width:80">单位</th>
			<th data-options="field:'evaluate',width:80,formatter:oneCost">单价</th>
			<th data-options="field:'xx',width:80,formatter:allCost">总价</th>
			<th data-options="field:'beizhu',width:180">备注</th>
		</tr>
	</thead>
</table>
<script type="text/javascript">
	function oneCost(value){
		return '￥ '+value;
	}
	function allCost(value,row){
		return '￥ '+Number(row.buyCount)*Number(row.evaluate);
	}
</script>
