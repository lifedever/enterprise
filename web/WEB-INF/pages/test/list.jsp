<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/test/listContent.html";
	$(function() {
		$('#tt').datagrid({
			title : '用户数据表',
			iconCls : 'icon-save',
			width : 900,
			height : 350,
			idField : 'id',//id字段
			rownumbers : true,//行号
			multipleSelect : true,//是否多选
			url : url,
			//singleSelect : true,//是否单选
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'username',
				title : '用户名',
				width : 100
			}, {
				field : 'realName',
				title : '真实姓名',
				width : 100
			}, {
				field : 'mobileTel',
				title : '手机号',
				width : 200
			}, {
				field : 'email',
				title : '邮箱',
				width : 250
			}, {
				field : 'createDate',
				title : '创建时间',
				width : 200,
				//日期格式转换
				formatter : function(value, row, index) {
					if (value) {
						return getDateTimeFromJson(value);
					}
				}
			} ] ],
			pagination : true,
		});
		//设置分页
		$('#tt').datagrid('getPager').pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
</script>
</head>
<body>
	<h2>JqueryEasyUi练习</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>
			用户列表<small>这是一个演示事例，大部分功能已包括</small>
		</div>
	</div>
	<table id="tt" data-options="toolbar:'#tb'">
	</table>
	<jsp:include page="toolBar.jsp"></jsp:include>
	<jsp:include page="addForm.jsp"></jsp:include>
	<script type="text/javascript">
		//处理函数

		//弹出添加框
		function newUser() {
			$('#dlg').dialog('open').dialog('setTitle', '新增用户');
			$('#fm').form('clear');
			url = 'addUser.html';
		}
		//编辑用户
		function editUser() {
			var row = $('#tt').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '编辑用户');
				$('#fm').form('load', row);
				url = 'addUser.html?id=' + row.id;
			}
		}
		//保存用户
		function saveUser() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (!result.errorMsg) {
						$.messager.show({
							title : 'Error',
							msg : result.errorMsg
						});
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
						}, function(result) {
							if (result.success) {
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
		//查询
		function searchUser() {
			var key = $("#selectVal").val() + '';
			var val = $("#searchVal").val() + '';
			var query = {};
			query[key] = val;
			$("#tt").datagrid('options').queryParams = query;
			$('#tt').datagrid('reload');
		}
	</script>
</body>
</html>
