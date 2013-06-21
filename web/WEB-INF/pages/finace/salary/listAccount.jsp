<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tt_account" class="easyui-datagrid" title="" height: 520px" 
		data-options="singleSelect : true,toolbar:'#tb_a',
			collapsible:true,rownumbers:true,idField : 'id',
			url:'/finace/account/listAllContent.html'">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'accountType',width:90,formatter:accountTypeFormatter">账户类型</th>
			<th data-options="field:'accountName',width:250">账户名称</th>
			<th data-options="field:'accountNo',width:400">银行卡号</th>
		</tr>
	</thead>
</table>
<div id="tb_a">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="addAccount()">确认选择</a>
</div>
<script type="text/javascript">
function accountTypeFormatter(value){
	if(value == '1'){
		return '<font color="blue">银行账户</font>';
	}else{
		return '<font color="red">现金账户</font>';
	}
}
	function addAccount() {
		var row = $('#tt_account').datagrid('getSelected');
		if (row) {
			$('#win_accountName').window('close');
			//$.messager.alert('提示', '选择成功！');
			$('#accountId').val(row.id);
			$('#accountName').val(row.accountName);
		} else {
			$.messager.alert('提示', '请选择会计科目！');
		}
	}
</script>
