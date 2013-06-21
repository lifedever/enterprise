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
		$("#p")
				.panel(
						{
							title : '欢迎您：${sessionScope.user.username}，所属部门：${sessionScope.user.department.departmentName}'
						});
		$('#tt_role').datagrid(
				{
					idField : 'id',//id字段
					rownumbers : true,//行号
					url : url,
					singleSelect : true,//是否单选
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
						var per_url = "/permission/listContent.html?roleId="
								+ rowData.id;
						$('#tt_permission').datagrid({
							width : function() {
								return document.body.clientWidth * 0.9
							},
							idField : 'id',//id字段
							rownumbers : true,//行号
							//simpleSelect : true,//是否多选
							url : per_url,
							toolbar : [ {
								id : 'btnrm',
								text : '添加权限',
								iconCls : 'icon-per-add',
								handler : addPermission
							}, '-', {
								id : 'btnadd',
								text : '移除权限',
								iconCls : 'icon-per-del',
								handler : removePermission
							}, '-' ],
							singleSelect : true,//是否单选
							columns : [ [ {
								field : 'title',
								title : '对象',
								width : 100
							}, {
								field : 'className',
								title : '标识',
								width : 100
							}, {
								field : 'operation',
								title : '操作类型',
								width : 100,
								formatter : function(value) {
									if (value == 'list') {
										return '列表';
									}
								}
							}, {
								field : 'cause',
								title : '控制范围',
								width : 140,
								formatter : function(value) {
									if (value == 'userId') {
										return '用户';
									} else if (value == 'departmentId') {
										return '部门';
									}
								}
							} ] ],
							pagination : false
						});
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
			</div>
			<div data-options="region:'center',title:'授权管理',singleSelect:true" style="padding: 5px;">
				<table id="tt_permission">
				</table>
				<div style="margin-top: 5px;">
					<div><strong>操作类型默认为：</strong>“列表”</div>
					<div><strong>控制范围分为：</strong>“用户”和“部门”。
					如果选“用户”，则默认登陆用户只能看到与自己相关的标识所指的对象列表（即：表单中所填标识）；
					如果选“部门”，则，默认登陆用户能看到与自己所在部门相关的标识所指的对象列表
					</div>
					<div><span style="color: red;"><strong>注意标识区分大小写！</strong></span></div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<script type="text/javascript">
		//弹出添加框
		function addPermission() {
			var row = $('#tt_role').datagrid('getSelected');
			$('#dlg').dialog('open').dialog('setTitle', '新增权限');
			$('#fm').form('clear');
			url = '/permission/savePermission.html?roleId=' + row.id;
		}
		//保存
		function savePermission() {
			$('#fm').form('submit', {
				url : url,
				success : function(data) {
					if (!data) {
						$.messager.alert('提示信息', "数据已存在，操作失败！");
					} else {
						$.messager.alert('提示信息', "操作成功！");
						$('#dlg').dialog('close'); // close the dialog  
						$('#tt_permission').datagrid('reload'); // reload the user data  

					}
				}
			});
		}
		//删除
		function removePermission() {
			var row = $('#tt_permission').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('removePermission.html', {
							id : row.id
						}, function(data) {
							if (data) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_permission').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
		//向角色中添加用户
		function addUsersToRole() {
			showUserList("/user/listContent.html?q_roleId=is null");
		}
		//将用户从角色中删除
		function removeUsersFromRole() {
			var row = $('#tt_user').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要移除选择吗?', function(rr) {
					if (rr) {
						$.post('/user/removeRoleOfUser.html', {
							id : row.id
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
			}
		}
		function addUserOk1() {
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