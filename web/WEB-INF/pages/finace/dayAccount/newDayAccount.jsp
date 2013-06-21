<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tt_dayAccount" title='' class="easyui-datagrid" style="width: 670px; height: 340px;"
	data-options="idField:'id',toolbar:'#tb_dayAccount',
		collapsible:true,rownumbers:true,url:'/finace/dayAccount/listContent.html?f_totalAccount.id=${totalAccount.id }&orderBy=id&order=asc',
		pagination:true,singleSelect : true,cache:false" fitColumns="true">
	<thead>
		<tr>
			<th data-options="field : 'ck',checkbox : true"></th>
			<th data-options="field:'createDate',width:100,formatter:formatDate">日期</th>
			<th data-options="field:'remark',width:160">摘要</th>
			<th data-options="field:'debtor',width:80">借方</th>
			<th data-options="field:'lender',width:80">贷方</th>
			<th data-options="field:'balance',width:100,formatter:formatMoney">余额</th>
		</tr>
	</thead>
</table>
<div style="margin-top: 10px;color: red;font-size:14px;font-weight: bold;">账户余额：<label id="money">${totalAccount.thisMoney }</label></div>
<div id="tb_dayAccount">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDayAccount()">添加</a> 
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeDayAccount()">删除</a>
</div>
<div class="easyui-window" id="win_dayAccount" data-options="title:'添加银行日记账',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 400px; height: 300px; padding: 10px;"></div>
<script type="text/javascript">
	function newDayAccount(){
		var row = $('#tt_account').datagrid('getSelected');
		$('#win_dayAccount').window({
			href : '/finace/dayAccount/dayAccountForm.html?totalAccountId=${totalAccount.id}'
		}).window('open');
	}
	
	function removeDayAccount(){
		var row = $('#tt_dayAccount').datagrid('getSelected');
		$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
			if (r) {
				$.post('/finace/dayAccount/removeDayAccoun.html',{
					dayAccountId:row.id
				},function(data){
					if(data){
						$.messager.alert('提示信息','操作成功！');
						$('#tt_dayAccount').datagrid('reload'); // reload the user data
						$('#tt_totalAccount').datagrid('reload'); // reload the user data
					}
				});
			}
		});
	}
</script>
