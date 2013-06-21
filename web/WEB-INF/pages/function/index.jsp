<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/function/listParentContent.html";
	$(function() {
		$("#p").panel({
			title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
		});
		$('#tt')
				.datagrid(
						{
							idField : 'id',//id字段
							rownumbers : true,//行号
							url : url,
							cascadeCheck : false,
							singleSelect : true,//是否单选
							toolbar : '#tb',
							columns : [ [
									{
										field : 'functionName',
										title : '功能名称',
										width : 100
									},
									{
										field : 'description',
										title : '功能描述',
										width : 200
									},
									{
										field : 'activeFlag',
										title : '是否有效',
										formatter : function(value) {
											if (value == 1) {
												return "<font color='green'>有效</font>";
											} else if (value == 0) {
												return "<font color='red'>无效</font>"
											}
										},
										width : 53
									},
									{
										field : 'id',
										title : '排序',
										width : 50,
										formatter : function(value, row) {
											var img1 = "<img  onclick='up("
													+ row.id
													+ ")' src='/images/icon/up.png' style='cursor:pointer' />";
											var img2 = "<img  onclick='down("
													+ row.id
													+ ")' src='/images/icon/down.png' style='cursor:pointer' />";
											return img1 + img2;
										}
									} ] ],

							onClickRow : function(rowIndex, rowData) {
								var fun_url = "/function/listContentByParent.html?funId="
										+ rowData.id;
								$('#tt_sub')
										.datagrid(
												{
													iconCls : 'icon-save',
													width : function() {
														return document.body.clientWidth * 0.9
													},
													height : 485,
													idField : 'id',//id字段
													rownumbers : true,//行号
													singleSelect : true,//是否多选
													url : fun_url,
													toolbar : [
															{
																id : 'btnadd',
																text : '添加链接',
																iconCls : 'icon-add',
																handler : function(
																		value) {
																	var row = $(
																			'#tt')
																			.datagrid(
																					'getSelected');
																	$(
																			'#dlg_sub')
																			.dialog(
																					'open')
																			.dialog(
																					'setTitle',
																					'新增功能模块');
																	$('#fm_sub')
																			.form(
																					'clear');
																	$(
																			'#activeFlag_sub')
																			.combobox(
																					'setValue',
																					1);
																	url = 'addFunction.html?funId='
																			+ row.id;
																}
															},
															"-",
															{
																id : 'btnadd',
																text : '编辑链接',
																iconCls : 'icon-edit',
																handler : editFun_sub
															},
															"-",
															{
																id : 'btnadd',
																text : '移除链接',
																iconCls : 'icon-remove',
																handler : removeFun_sub
															} ],
													//singleSelect : true,//是否单选
													columns : [ [
															{
																field : 'functionName',
																title : '链接名称',
																width : 80
															},
															{
																field : 'functionUrl',
																title : '链接地址',
																width : 260
															},
															{
																field : 'description',
																title : '链接描述',
																width : 210
															},
															{
																field : 'activeFlag',
																title : '是否有效',
																formatter : function(
																		value) {
																	if (value == 1) {
																		return "<font color='green'>有效</font>";
																	} else if (value == 0) {
																		return "<font color='red'>无效</font>"
																	}
																},
																width : 55
															},
															{
																field : 'orderIndex',
																title : '排序',
																width : 50,
																formatter : function(
																		value,
																		row) {
																	var img1 = "<img  onclick='up_sub("
																			+ row.id
																			+ ")' src='/images/icon/up.png' style='cursor:pointer' />";
																	var img2 = "<img  onclick='down_sub("
																			+ row.id
																			+ ")' src='/images/icon/down.png' style='cursor:pointer' />";
																	return img1
																			+ img2;
																}
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
			<div data-options="region:'west',split:true,title:'功能模块列表'"
				style="width: 450px;padding:3px;">
				<table id="tt">
				</table>
				<div style="padding: 5px">
					<font color="blue"><strong>提示：</strong> </font>单击功能以查看此功能下的所有链接列表。
				</div>
				<div id="tb">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add"
						plain="true" onclick="newFun()">添加</a> <a href="#"
						class="easyui-linkbutton" iconCls="icon-edit" plain="true"
						onclick="editFun()">编辑</a><a href="#" class="easyui-linkbutton"
						iconCls="icon-remove" plain="true" onclick="removeFun()">删除</a>
				</div>
			</div>
			<div 
				data-options="region:'center',title:'查看模块下的所有连接表'" style="padding:3px;">
				<table id="tt_sub">
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<jsp:include page="addSubForm.jsp"></jsp:include>
	<script type="text/javascript">
		//弹出添加框
		function newFun() {
			$('#dlg').dialog('open').dialog('setTitle', '新增功能模块');
			$('#fm').form('clear');
			$('#activeFlag').combobox('setValue', 1);
			url = 'addFunction.html';
		}
		//保存
		function saveFun() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					if (data) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg').dialog('close'); // close the dialog  
						$('#tt').datagrid('reload'); // reload the user data  
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}
		//编辑
		function editFun() {
			var row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '编辑功能模块');
				$('#fm').form('load', row);
				url = 'addFunction.html?id=' + row.id;
			}
		}
		//删除
		function removeFun() {
			var row = $('#tt').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('deleteFunction.html', {
							id : row.id
						}, function(result) {
							if (result.success) {
								$.messager.alert('成功', '删除成功！');
								$('#tt').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', result.message);
							}
						}, 'json');
					}
				});
			}
		}
		//保存连接表
		function saveFun_sub() {
			$('#fm_sub').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					if (data) {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg_sub').dialog('close'); // close the dialog  
						$('#tt_sub').datagrid('reload'); // reload the user data  
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}
		//编辑
		function editFun_sub() {
			var row = $('#tt_sub').datagrid('getSelected');
			var par_Row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#dlg_sub').dialog('open').dialog('setTitle', '编辑功能模块');
				$('#fm_sub').form('load', row);
				url = 'addFunction.html?funId=' + par_Row.id + '&id=' + row.id;
			}
		}
		//删除
		function removeFun_sub() {
			var row = $('#tt_sub').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('deleteFunction.html', {
							id : row.id
						}, function(result) {
							if (result.success) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_sub').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', result.message);
							}
						}, 'json');
					}
				});
			}
		}
	</script>
	<jsp:include page="order.jsp"></jsp:include>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>