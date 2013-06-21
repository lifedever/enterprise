<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/finace/account/listContent.html?accountType=1";
	$(function() {
		$('#tt_account').datagrid({
			title : '',
			iconCls : 'icon-edit',
			fit:true,
			idField : 'id',//id字段
			rownumbers : true,//行号
			onDblClickRow:onClickRow,
			//multipleSelect : true,//是否多选
			url : url,
			singleSelect : true,//是否单选
			toolbar : '#tb_account',
			columns : [ [ {
				field : 'accountName',
				title : '账户名称',
				width : 330
			}, {
				field : 'accountNo',
				title : '账户卡号',
				width : 430
			} ] ],
		});
	});
</script>
<body>
 <div class="easyui-tabs" style="" data-options="fit:true">
	<div title="银行账户" style="padding: 3px">
  		<table id="tt_account">
  		</table>
  	</div>
 </div>
  <div id="tb_account">
   <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newAccount()">添加</a> 
   <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editAccount()">编辑</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeAccount()">删除</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-table1" plain="true" onclick="showItems()">查看明细</a> 
    <label for="" style="color: red;">您可以双击行记录进行银行日记账</label>
  </div>
  <div class="easyui-window" id="win_newTotalAccount" data-options="title:'银行日记账',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 700px; height: 400px; padding: 10px;"></div>
  <div class="easyui-window" id="win_newDayAccount" data-options="title:'银行日记账',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 700px; height: 400px; padding: 10px;"></div>
  <div class="easyui-window" id="win_items" data-options="title:'款项明细',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 700px; height: 400px; padding: 10px;"></div>
 <jsp:include page="addForm.jsp"></jsp:include>
 <script type="text/javascript">
		//弹出添加框
		function newAccount() {
			$('#dlg_account').dialog('open').dialog('setTitle', '新增账户');
			$('#fm_account').form('clear');
			$('#accountType').val('1');
			url = 'addAccount.html';
		}
		//保存
		function saveAccount() {
			$('#fm_account').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					if (data) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_account').dialog('close'); // close the dialog  
						$('#tt_account').datagrid('reload'); // reload the user data  
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}
		//编辑
		function editAccount() {
			var row = $('#tt_account').datagrid('getSelected');
			if (row) {
				$('#dlg_account').dialog('open').dialog('setTitle', '编辑类别');
				$('#fm_account').form('load', row);
				url = 'addAccount.html?id=' + row.id;
			}
		}
		//删除
		function removeAccount() {
			var row = $('#tt_account').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('deleteAccount.html', {
							id : row.id
						}, function(result) {
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_account').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
		//银行日记账
		function onClickRow(rowIndex, rowData){
			$('#win_newTotalAccount').window({
				href : '/finace/dayAccount/newTotalAccount.html?accountId='+rowData.id
			}).window('open').window('setTitle','银行日记账');
		}
		//查看明细
		function showItems(){
			var row = $('#tt_account').datagrid('getSelected');
			if (row) {
				$('#win_items').window({
					href : '/finace/account/showItems.html?id='+row.id
				}).window('open').window('setTitle','款项明细');
			} else {
				$.messager.alert('提示信息', '请选择操作对象！');
			}
		}
	</script>
</body>
<jsp:include page="../../main/footer.jsp"></jsp:include>
</html>