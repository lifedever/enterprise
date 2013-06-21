<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
</head>
<body>
	<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="收支管理" style="padding: 3px">
			<table id="tt_expend" class="easyui-datagrid"data-options="fit:true,toolbar:'#tb_expend',collapsible:true,rownumbers:true,url:'/finace/expenditure/listContent.html',pagination:true,singleSelect : true">
				<thead>
					<tr>
						<th data-options="field : 'ck',checkbox : true"></th>
						<th data-options="field:'inOrOut',width:80,formatter:inOrOutFormater">类型</th>
						<th data-options="field:'money',width:100,formatter:formatMoney">金额</th>
						<th data-options="field:'remark',width:300">说明</th>
						<!-- <th data-options="field:'accountantName',width:160">相关科目</th> -->
						<th data-options="field:'accountName',width:160">相关账户</th>
						<th data-options="field:'changeDate',width:120,formatter:formatDate">变更时间</th>
						<th data-options="field:'createDate',width:120,formatter:formatDate">添加时间</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="tb_expend">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addExpend()">添加</a> <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delExpend()">删除</a>
	</div>
	<div class="easyui-window" id="win_accountantName" data-options="title:'选择会计科目',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 400px; padding: 10px;"></div>
	<div class="easyui-window" id="win_accountName" data-options="title:'选择银行账户',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 800px; height: 350px; padding: 10px;"></div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<script type="text/javascript">
		(function() {
			//弹出会计科目选择框 
			$('#accountantName').on('focus', function() {
				$('#win_accountantName').window({
					href : '/finace/expenditure/listAccountant.html'
				}).window('open');
			});
			//弹出银行账户 
			$('#accountName').on('focus', function() {
				$('#win_accountName').window({
					href : '/finace/expenditure/listAccount.html'
				}).window('open');
			});
		})();
		function inOrOutFormater(value) {
			if (value == '0') {
				return '<font color="red">支出</font>';
			} else if (value == '1') {
				return '<font color="blue">收入</font>';
			}
		}
		//添加收支条目 
		function addExpend() {
			$('#dlg_extend').dialog('open').dialog('setTitle', '新增账户');
			$('#fm_extend').form('clear');
			$('#in').attr('selected', 'selected');
		}
		//保存 
		function saveExpend() {
			$('#fm_extend').form('submit', {
				url : '/finace/expenditure/saveExpend.html',
				onSubmit : function() {
					if ($('#money').val() == '') {
						$.messager.alert('错误', '请输入金额！');
						return false;
					}
					if ($('#accountantName').val() == '') {
						$.messager.alert('错误', '请选择科目！');
						return false;
					}
					if ($('#accountName').val() == '') {
						$.messager.alert('错误', '请选择银行账户！');
						return false;
					}
					return $(this).form('validate');
				},
				success : function(data) {
					if (!data) {
						$.messager.alert('错误', '操作失败！');
					} else {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_extend').dialog('close'); // close the dialog  
						$('#tt_expend').datagrid('reload'); // reload the user data  
					}
				}
			});
		}
		function delExpend() {
			var row = $('#tt_expend').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('deleteExpend.html', {
							expendId : row.id
						}, function(result) {
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_expend').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
	</script>
</body>
<jsp:include page="../../main/footer.jsp"></jsp:include>
</html>