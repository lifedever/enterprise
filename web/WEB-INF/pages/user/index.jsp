<%@page import="com.app.permission.utils.UserSessionManager"%>
<%@page import="com.app.permission.model.User"%>
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
	var url = "/user/listContent.html";
	$(function() {
		$('#tt').datagrid({
			title : '',
			iconCls : 'icon-save',
			width : function() {
				return document.body.clientWidth * 0.9
			},
			//checkOnSelect : false,
			height : $(document).height() - 50,
			idField : 'id',//id字段
			rownumbers : true,//行号
			nowrap : false,
			singleSelect : true,//是否多选
			fit:true,
			url : url,
			//singleSelect : true,//是否单选
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'username',
				title : '用户帐号',
				width : 80
			}, {
				field : 'realName',
				title : '真实姓名',
				width : 80
			}, {
				field : 'sex',
				title : '性别',
				width : 60
			}, {
				field : 'tel',
				title : '电话',
				width : 150
			}, {
				field : 'mobileTel',
				title : '手机号',
				width : 150
			}, {
				field : 'email',
				title : '邮箱',
				width : 150
			}, {
				field : 'roleName',
				title : '角色',
				width : 100,
			}, {
				field : 'departmentName',
				title : '部门',
				width : 200,
			}
			/* , {
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
			} */
			, {
				field : 'createDate',
				title : '创建时间',
				width : 100,
				//日期格式转换
				formatter : function(value, row, index) {
					if (value) {
						return getDateFromJson(value);
					}
				}
			} ] ],
			pagination : true
		//启用分页
		});
	});
</script>
</head>
<body>
	<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="账户管理" style="padding: 3px">
			<table id="tt" data-options="toolbar:'#tb'">
			</table>
		</div>
	</div>
	<jsp:include page="toolBar.jsp"></jsp:include>
	<jsp:include page="addForm.jsp"></jsp:include>
	<jsp:include page="passForm.jsp"></jsp:include>
	<jsp:include page="../human/employee/empList.jsp"></jsp:include>
	<script type="text/javascript">
		var row;
		//弹出添加框
		function newUser() {
			$('#dlg').window('open').window('setTitle', '新增用户');
			$('#fm').form('clear');
			//$('#roleCombox').combobox('reload', '/role/loadCombobox.html');
			$('#deptCombox').combobox('reload', '/department/loadCombobox.html');
			$('#sex').combobox('setValue', '男');
			$('#activeFlag').combobox('setValue', '1');
			$('#username').attr('disabled',false);
			url = 'addUser.html';
		}
		//编辑用户
		function editUser() {
			var row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#dlg').window('open').window('setTitle', '编辑用户');
				$('#fm').form('load', row);
				/* if (row.roleName != "") {
					$('#roleCombox').combobox('setValue', row.roleId);
				}
				$('#roleCombox').combobox('reload', '/role/loadCombobox.html');
				 */
				if (row.departmentName != "") {
					$('#deptCombox').combobox('setValue', row.departmentId);
				}
				$('#deptCombox').combobox('reload','/department/loadCombobox.html');
				$('#e_departName').html(row.departmentName);
				$('#e_departId').val(row.departmentId);
				$('#username').attr('disabled','disabled');
				url = 'addUser.html?id=' + row.id;
			}
		}
		//保存用户
		function saveUser() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					/* var roleId = $('#roleCombox').combobox('getValue');
					if (roleId == null || roleId == '') {
						$('#roleCombox').combobox('setValue', '');
					} */
					return $(this).form('validate');
				},
				success : function(data) {
					var result = eval('(' + data + ')');
					if (!result.result) {
						$.messager.alert('错误', result.message);
					} else {
						$.messager.alert('提示信息', '操作成功！');
						$('#dlg').dialog('close'); // close the dialog  
						$('#tt').datagrid('reload'); // reload the user data  
					}
				}
			});
		}
		//删除用户
		function destroyUser() {
			var rows = $('#tt').datagrid('getSelections');
			if (rows != null && rows.length > 0) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						var ids = '';
						for ( var i = 0; i < rows.length; i++) {
							ids = ids + rows[i].id + ",";
						}
						$.post('deleteUser.html', {
							idsString : ids
						}, function(data) {
							var result = eval('(' + data + ')');
							if (result) {
								$.messager.alert('成功', '用户删除成功！');
								$('#tt').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '用户删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
		//修改密码
		function changePass() {
			row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#pass_dlg').dialog('open').dialog('setTitle', '修改用户密码');
				$('#pass_fm').form('load', row);
				url = 'savePass.html?id=' + row.id;
			}
		}
		//保存密码
		function savePass() {
			$('#pass_fm').form('submit', {
				url : url,
				onSubmit : function() {
					if ($('#newPassword').val() != $('#newPassword2').val()) {
						$.messager.alert("错误", "两次密码输入不一致，请重新输入");
						return false;
					}
					return true;
				},
				success : function(data) {
					var result = eval('(' + data + ')');
					if (result) {
						$.messager.alert('成功', '操作成功！');
						$('#pass_dlg').dialog('close'); // close the dialog
					}
				}
			});
		}

		function confirmSelect() {
			row = $('#tt_empList').datagrid('getSelected');
			$('#w_empList').window('close');
			newUser();
			$('#e_departName').html(row.empDeptName);
			$('#e_departId').val(row.empDeptId);
			$('#realName').val(row.empName);
			$('#tel').val(row.empContact);
			$('#mobileTel').val(row.empContact);
		}

		//查询
		function searchUser(value) {
			var key = $("#selectVal").val();
			var val = value;
			var sexVal = $("#sexVal").val();
			var query = {};
			query[key] = val;//{username:admin}
			query['s_sex'] = sexVal;
			$("#tt").datagrid('options').queryParams = query;
			$('#tt').datagrid('reload');
		}
		//验证旧密码是否正确
		$("#oldPassword").blur(function() {
			var op = $(this).val();
			$.post('/user/checkPass.html', {
				oldPassword : op,
				id : row.id
			}, function(data) {
				if (data.success) {
					$('#pass_msg2').css({
						'color' : 'green'
					}).html('密码正确');
				} else {
					$('#pass_msg2').css({
						'color' : 'red'
					}).html('密码错误，请重新输入');
					$("#oldPassword").focus();
				}
			}, 'json');
		});
	</script>
</body>
<jsp:include page="../main/footer.jsp"></jsp:include>
</html>