<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<table id="tt_selFactory" class="easyui-datagrid" style="width: 930px; height: 340px" 
		data-options="
			pagination:true,
			singleSelect:true,
			rownumbers : true,
			collapsible:true,
			nowrap : false,
			url:'/cooperationfactory/listContent.html',
			toolbar : '#tb_selFactory'">
		<thead>
			<tr>
				<th data-options="field:'factoryNo',width:100">工厂编号</th>
				<th data-options="field:'factoryName',width:150">工厂名称</th>
				<th data-options="field:'factoryProp',width:80">工厂性质</th>
				<th data-options="field:'factoryStar',width:80,formatter:formatStar">工厂星级</th>
				<th data-options="field:'factorySite',width:120,formatter:formatSite">工厂网址</th>
				<th data-options="field:'employee',width:80">外发人员</th>
				<th data-options="field:'contactMan',width:80">联系人</th>
				<th data-options="field:'address',width:200">地址</th>
			</tr>
		</thead>
	</table>
</div>
<div id="tb_selFactory" style="padding: 5px; height: auto">
	<div style="margin-bottom: 5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="addSelFactoryOk();">确认选择</a>
	</div>
</div>
<script>
function formatStar(value) {
	if (value != 0) {
		var star = "";
		for (i = 0; i < value; i++) {
			star = star + '★';
		}
		return star;
	}
}
function formatSite(value) {
	return '<a href="'+value+'" target=_blank>'+value+'</a>';
}
</script>