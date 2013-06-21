<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/role/listContent.html";
	$(function() {
		$("#p").panel({
			title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
		});
		$('#tt_role').datagrid({
			idField : 'id',//id字段
			rownumbers : true,//行号
			url : url,
			singleSelect : true,//是否单选
			toolbar : '#tb',
			columns : [ [ {
				field : 'roleName',
				title : '角色名',
				width : 180
			}, {
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
			} ] ],
			onClickRow : function(rowIndex, rowData) {
				var user_url = "/user/listContent.html?f_roleId=" + rowData.id;
				$('#tt_user').datagrid({
					iconCls : 'icon-save',
					width : function() {
						return document.body.clientWidth * 0.9
					},
					height : 485,
					idField : 'id',//id字段
					rownumbers : true,//行号
					simpleSelect : true,//是否多选
					url : user_url,
					toolbar : [ {
						id : 'btnrm',
						text : '添加用户',
						iconCls : 'icon-user-add',
						handler : addUsersToRole
					}, '-', {
						id : 'btnadd',
						text : '移除用户',
						iconCls : 'icon-user-del',
						handler : removeUsersFromRole
					}, '-' ],
					//singleSelect : true,//是否单选
					columns : [ [ {
						field : 'ck',
						checkbox : true
					},{
						field : 'username',
						title : '用户名',
						width : 80
					}, {
						field : 'realName',
						title : '真实姓名',
						width : 80
					}, {
						field : 'mobileTel',
						title : '手机号',
						width : 120
					}, {
						field : 'email',
						title : '邮箱',
						width : 140
					}, {
						field : 'departmentName',
						title : '部门',
						width : 130
					}, {
						field : 'activeFlag',
						title : '是否有效',
						formatter : function(value) {
							if (value == 1) {
								return "<font color='green'>有效</font>";
							} else if (value == 0) {
								return "<font color='red'>无效</font>"
							}
						},
						width : 60
					}, {
						field : 'createDate',
						title : '创建时间',
						width : 150,
						//日期格式转换
						formatter : function(value, row, index) {
							if (value) {
								return getDateTimeFromJson(value);
							}
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
			<div data-options="region:'west',split:true,title:'角色列表'" style="width: 290px; padding: 5px;">
				<table id="tt_role">
				</table>
				<div style="padding: 5px">
					<font color="blue"><strong>提示：</strong></font>点击角色以查看角色下的用户列表。
				</div>
				<div id="tb">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRole()">添加</a> <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRole()">编辑</a><a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeRole()">删除</a>
				</div>
			</div>
			<div data-options="region:'center',title:'按角色查看用户列表'" style="padding: 5px;">
				<table id="tt_user">
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<jsp:include page="userList.jsp"></jsp:include>
	<script type="text/javascript">
		//弹出添加框
		function newRole() {
			$('#dlg').dialog('open').dialog('setTitle', '新增角色');
			$('#fm').form('clear');
			$('#activeFlag').combobox('setValue', 1);
			url = 'addRole.html';
		}
		//保存
		function saveRole() {
			$('#fm').form('submit', {
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
						$('#dlg').dialog('close'); // close the dialog  
						$('#tt_role').datagrid('reload'); // reload the user data  
					}
				}
			});
		}
		//编辑
		function editRole() {
			var row = $('#tt_role').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '编辑角色');
				$('#fm').form('load', row);
				url = 'addRole.html?id=' + row.id;
			}
		}
		//删除
		function removeRole() {
			var row = $('#tt_role').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('deleteRole.html', {
							id : row.id
						},
								function(data) {
									var result = eval('(' + data + ')');
									if (result) {
										$.messager.alert('成功', '删除成功！');
										$('#tt_role').datagrid('reload'); // reload the user data  
									} else {
										$.messager.alert('失败',
												'删除失败！请先移除角色下的用户信息然后重试');
									}
								}, 'json');
					}
				});
			}
		}
		//向角色中添加用户
		function addUsersToRole() {
			var row = $('#tt_role').datagrid('getSelected');
			if(row){
				showUserList2("/user/listContent.html?q_roleId=is null");
			}
		}
		//将用户从角色中删除
		function removeUsersFromRole() {
			var rows = $('#tt_user').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要移除选择吗?', function(rr) {
					if (rr) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('/user/removeRoleOfUser.html', {
							ids : ids
						}, function(result) {
							if (result.success) {
								$.messager.alert('成功', '操作成功！');
								$('#tt_user').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '操作失败，请稍后重试');
							}
						}, 'json');
					}
				});
			}else{
				$.messager.alert('提示','请选择条目');
			}
		}
		function addUserToRole() {
			var rows = $('#tt_userList').datagrid('getSelections');
			var row = $('#tt_role').datagrid('getSelected');
			if (rows != null && rows.length > 0) {
				var ids = '';
				for ( var i = 0; i < rows.length; i++) {
					ids = ids + rows[i].id + ",";
				}
				$.post('/user/addUsersToRole.html', {
					idsString : ids,
					roleId : row.id
				}, function(data) {
					var result = eval('(' + data + ')');
					if (result) {
						$('#w_userList').window('close');
						$.messager.alert('成功', '操作成功！');
						$('#tt_user').datagrid('reload'); // reload the user data  
					} else {
						$.messager.alert('失败', '操作失败！');
					}
				}, 'json');
			}
		}
	</script>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>