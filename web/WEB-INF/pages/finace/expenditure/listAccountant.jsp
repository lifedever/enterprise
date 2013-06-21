<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-layout" style="height: 100%; width: 100%">
	<div data-options="region:'west',split:true,title:'科目类别列表'" style="width: 200px;">
		<table id="tt_accountantType" class="easyui-datagrid" title="" height: 520px" 
		data-options="singleSelect : true,
			onClickRow:onClickRow,
			collapsible:true,rownumbers:true,idField : 'id',
			url:'/finace/accountant/listAccountTypes.html'">
			<thead>
				<tr>
					<th data-options="field:'typeName',width:150">科目类别</th>
				</tr>
			</thead>
		</table>
		<div style="padding: 5px">
			<font color="blue"><strong>提示：</strong></font>点击类别以查看该类别下的会计科目汇总表。
		</div>
	</div>
	<div data-options="region:'center',title:'会计科目汇总表'">
		<table id="tt_accountant" class="easyui-datagrid" height: 520px" 
				data-options="singleSelect : true,toolbar:'#tb_at',idField : 'id',collapsible:true,url:''">
			<thead>
				<tr>
					<th data-options="field : 'ck',checkbox : true"></th>
					<th data-options="field:'accountNo',width:150">科目编号</th>
					<th data-options="field:'accountName',width:150">科目名称</th>
					<th data-options="field:'accountDesc',width:150">科目编号</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="tb_at">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="addAccountant()">确认选择</a> 
	</div>
</div>
<script type="text/javascript">
	function onClickRow(rowIndex, rowData) {
		var accountantId = rowData.id;
		$('#tt_accountant').datagrid({url:'/finace/accountant/listAccountants.html?typeId='+ accountantId});
	}
	function addAccountant(){
		var row = $('#tt_accountant').datagrid('getSelected');
		if(row){
			$('#win_accountantName').window('close');
			$.messager.alert('提示','选择成功！');
			$('#accountantId').val(row.id);
			$('#accountantName').val(row.accountName);
		}else{
			$.messager.alert('提示','请选择会计科目！');
		}
	}
</script>
