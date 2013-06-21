<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tt_totalAccount" title='' class="easyui-datagrid" style="width: 670px; height: 320px;"
	data-options="idField:'id',toolbar:'#tb_totalAccount',
		collapsible:true,rownumbers:true,url:'/finace/dayAccount/listTotalAccountContent.html?f_account.id=${accountId }&orderBy=createDate&order=asc',
		pagination:true,singleSelect : true,cache:false,onDblClickRow:onClickRowTotal," fitColumns="true">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'createDate',width:100,formatter:formatDate">添加日期</th>
			<th data-options="field:'remark',width:160">备注</th>
			<th data-options="field:'allMoney',width:80,formatter:formatMoney">初始总额</th>
			<th data-options="field:'thisMoney',width:100,formatter:formatMoney">现余额</th>
			<th data-options="field:'count',width:60">记账次数</th>
		</tr>
	</thead>
</table>
<div id="tb_totalAccount">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newTotalAccount()">添加</a> 
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeTotalAccount()">删除</a>
	&nbsp;&nbsp;<label style="color: red;">您可以双击行记录添加日记账！</label>
</div>
<div class="easyui-window" id="win_totalAccount" data-options="title:'添加账户总额',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 400px; height: 300px; padding: 10px;"></div>
<div class="easyui-window" id="win_dayAccount2" data-options="title:'添加日记账',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 700px; height: 450px; padding: 10px;"></div>
<script type="text/javascript">
	function newTotalAccount(){
		var row = $('#tt_account').datagrid('getSelected');
		$('#win_totalAccount').window({
			href : '/finace/dayAccount/totalAccountForm.html?accountId='+row.id
		}).window('open');
	}
	
	function removeTotalAccount(){
		var row = $('#tt_totalAccount').datagrid('getSelected');
		if(row){
			if(row.count==0){
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('/finace/dayAccount/removeTotalAccount.html',{
							totalAccountId:row.id
						},function(data){
							if(data){
								$.messager.alert('提示信息','操作成功！');
								$('#tt_totalAccount').datagrid('reload');
							}
						});
					}
				});
			}else{
				$.messager.alert('提示信息','账户已经记账，无法删除！');
			}
		}else{
			$.messager.alert('提示信息','请选择操作对象！');
		}
	}
	
	//银行日记账
	function onClickRowTotal(rowIndex, rowData){
		$('#win_dayAccount2').window({
			href : '/finace/dayAccount/newDayAccount.html?totalAccountId='+rowData.id
		}).window('open').window('setTitle','日记账');
	}
</script>
