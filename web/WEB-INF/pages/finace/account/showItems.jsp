<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<table id="tt_expend" style="height:300px;" class="easyui-datagrid" data-options="collapsible:true,rownumbers:true,url:'/finace/expenditure/listContent.html?f_accountId=${id }',pagination:true,singleSelect : true">
		<thead>
			<tr>
				<th data-options="field:'inOrOut',width:60,formatter:inOrOutFormater">类型</th>
				<th data-options="field:'money',width:80,formatter:formatMoney">金额</th>
				<th data-options="field:'remark',width:300">说明</th>
				<th data-options="field:'changeDate',width:120,formatter:formatDate">变更时间</th>
				<th data-options="field:'createDate',width:120,formatter:formatDate">添加时间</th>
			</tr>
		</thead>
	</table>
</div>
<script type="text/javascript">
	function inOrOutFormater(value) {
		if (value == '0') {
			return '<font color="red">支出</font>';
		} else if (value == '1') {
			return '<font color="blue">收入</font>';
		}
	}
</script>