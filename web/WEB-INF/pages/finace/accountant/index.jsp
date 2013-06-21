<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/finace/accountant/listAccountTypes.html";
	$(function() {
		$("#p").panel({
			title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
		});
		$('#tt_type')
				.datagrid(
						{
							idField : 'id',//id字段
							rownumbers : true,//行号
							url : url,
							singleSelect : true,//是否单选
							toolbar : '#tb',
							columns : [ [ {
								field : 'typeName',
								title : '科目类别',
								width : 230
							} ] ],
							onClickRow : function(rowIndex, rowData) {
								var user_url = "/finace/accountant/listAccountants.html?typeId="
										+ rowData.id;
								$('#tt_account')
										.datagrid(
												{
													iconCls : 'icon-save',
													width : function() {
														return document.body.clientWidth * 0.9
													},
													height : 490,
													idField : 'id',//id字段
													rownumbers : true,//行号
													singleSelect : true,//是否多选
													url : user_url,
													toolbar : [
															{
																id : 'btnadd',
																text : '添加科目',
																iconCls : 'icon-add',
																handler : addAccount
															},
															"-",
															{
																id : 'btnadd',
																text : '编辑科目',
																iconCls : 'icon-edit',
																handler : editAccount
															},
															"-",
															{
																id : 'btnadd',
																text : '移除科目',
																iconCls : 'icon-remove',
																handler : removeAccount
															} ],
													//singleSelect : true,//是否单选
													columns : [ [
															{
																field : 'accountNo',
																title : '科目编号',
																width : 80
															},
															{
																field : 'accountName',
																title : '科目名称',
																width : 150
															},
															//{
															//	field : 'activeFlag',
															//	title : '是否有效',
															//	formatter : function(
															//			value) {
															//		if (value == 1) {
															//			return "<font color='green'>有效</font>";
															//		} else if (value == 0) {
															//			return "<font color='red'>无效</font>"
															//		}
															//	},
															//	width : 60
															//},
															{
																field : 'accountDesc',
																title : '备注',
																width : 320
															} ] ],
													pagination : true
												//启用分页
												});
								//设置分页
							}
						});
	});
</script>
<body>
	<div id="p">
		<div class="easyui-layout" style="height: 520px;">
			<div data-options="region:'west',split:true,title:'科目类别列表'"
				style="width: 270px;">
				<table id="tt_type">
				</table>
				<div style="padding: 5px">
					<font color="blue"><strong>提示：</strong></font>点击类别以查看该类别下的会计科目汇总表。
				</div>
				<div id="tb">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add"
						plain="true" onclick="newType()">添加</a> <a href="#"
						class="easyui-linkbutton" iconCls="icon-edit" plain="true"
						onclick="editType()">编辑</a><a href="#" class="easyui-linkbutton"
						iconCls="icon-remove" plain="true" onclick="removeType()">删除</a>
				</div>
			</div>
			<div
				data-options="region:'center',title:'会计科目汇总表'">
				<table id="tt_account">
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<jsp:include page="addAccountForm.jsp"></jsp:include>
	<script type="text/javascript">
		//弹出添加框
		function newType() {
			$('#dlg_type').dialog('open').dialog('setTitle', '新增科目类别');
			$('#fm_type').form('clear');
			//$('#activeFlag').combobox('setValue', 1);
			url = 'addType.html';
		}
		//保存
		function saveType() {
			$('#fm_type').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					var result = eval('(' + data + ')');
					if (!result.result) {
						$.messager.alert('提示信息', result.message);
					} else {
						$.messager.alert('提示信息', result.message);
						$('#dlg_type').dialog('close'); // close the dialog  
						$('#tt_type').datagrid('reload'); // reload the user data  
					}
				}
			});
		}
		//编辑
		function editType() {
			var row = $('#tt_type').datagrid('getSelected');
			if (row) {
				$('#dlg_type').dialog('open').dialog('setTitle', '编辑类别');
				$('#fm_type').form('load', row);
				url = 'addType.html?id=' + row.id;
			}
		}
		//删除
		function removeType() {
			var row = $('#tt_type').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('deleteType.html', {
							typeId : row.id
						},
								function(result) {
									if (result) {
										$.messager.alert('成功', '删除成功！');
										$('#tt_type').datagrid('reload'); // reload the user data  
									} else {
										$.messager.alert('失败',
												'删除失败！请先移除类别下的科目信息然后重试');
									}
								}, 'json');
					}
				});
			}
		}

		//************ 科目操作 ***************//
		function addAccount() {
			$('#dlg_account').dialog('open').dialog('setTitle', '新增科目');
			$('#fm_account').form('clear');
			$('#activeFlag').combobox('setValue', 1);
			var row = $('#tt_type').datagrid('getSelected');
			$('#typeId').val(row.id);
			url = 'addAccount.html';
		}
		function editAccount() {
			var row = $('#tt_account').datagrid('getSelected');
			if (row) {
				$('#dlg_account').dialog('open').dialog('setTitle', '编辑类别');
				$('#fm_account').form('load', row);
				url = 'addAccount.html?id=' + row.id;
			}

		}
		function saveAccount() {
			$('#fm_account').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					var result = eval('(' + data + ')');
					if (!result.result) {
						$.messager.alert('提示信息', result.message);
					} else {
						$.messager.alert('提示信息', result.message);
						$('#dlg_account').dialog('close'); // close the dialog  
						$('#tt_account').datagrid('reload'); // reload the user data  
					}
				}
			});
		}
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
	</script>
</body>
<jsp:include page="../../main/footer.jsp"></jsp:include>
</html>