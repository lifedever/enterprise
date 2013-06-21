<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>

<script type="text/javascript">
	var emp_url = "/human/employee/listContent.html";
	$(function() {
		$('#tt_employee').datagrid({
			iconCls : 'icon-edit',
			width : function() {
				return document.body.clientWidth * 0.9
			},
			height : 480,
			idField : 'id',//id字段
			rownumbers : true,//行号
			url : emp_url,
			nowrap : false,
			singleSelect : true,//是否单选
			toolbar : '#tb_employee',
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'empNo',
				title : '编号',
				width : 100
			}, {
				field : 'empName',
				title : '姓名',
				width : 80
			}, {
				field : 'empSex',
				title : '性别',
				width : 50
			}, {
				field : 'empDeptName',
				title : '部门',
				width : 200
			}, {
				field : 'empPositionName',
				title : '职位',
				width : 100
			}, {
				field : 'empEdu',
				title : '学历',
				width : 100
			}, {
				field : 'empID',
				title : '身份证',
				width : 200
			}, {
				field : 'empOrigin',
				title : '籍贯',
				width : 200
			}, {
				field : 'empContact',
				title : '联系方式',
				width : 150
			}, {
				field : 'createDate',
				title : '入职时间',
				width : 150,
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
		//设置分页
	});
</script>
<jsp:include page="addForm.jsp"></jsp:include>
<div id="view_employee" class="easyui-window" data-options="title:'员工详细信息',modal:true,closed:true,cache:false" style="width: 660px; height: 350px; padding: 10px 20px" buttons="#dlg-buttons"></div>
<script type="text/javascript">
	//添加员工
	function addEmp() {
		$('#dlg_employee').dialog('open').dialog('setTitle', '编辑员工信息');
		$('#fm_employee').form('clear');
		var row = $('#ttree').tree('getSelected');
		$('#empDeptId').val(row.id);
		$('#empSex').combobox('setValue', '男');
		$('#empPosition').combobox('reload',
				'/human/position/loadCombobox.html');
		url = '/human/employee/saveEmployee.html';
	}
	//查看离职员工
	function viewLeave() {
		$('#tt_employee').datagrid({url:'/human/employee/listContentForLeaveEmp.html?f_isDelete=1'});
	}
	//编辑员工
	function editEmp() {
		var row = $('#tt_employee').datagrid('getSelected');
		var tree = $('#ttree').tree('getSelected');
		$('#empPosition').combobox('reload',
				'/human/position/loadCombobox.html');
		$('#empDeptId').val(tree.id);
		if (row) {
			$('#dlg_employee').dialog('open').dialog('setTitle', '编辑员工信息');
			$('#fm_employee').form('load', row);
			url = '/human/employee/saveEmployee.html?id=' + row.id;
		}
	}
	//员工离职
	function leaveEmp() {
		var row = $('#tt_employee').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '你确定让员工离职吗?', function(r) {
				if (r) {
					$.post('/human/employee/leaveJob.html', {
						id : row.id
					}, function(data) {
						if (data) {
							$.messager.alert('成功', '离职成功！');
							$('#tt_employee').datagrid('reload'); // reload the user data  
						} else {
							$.messager.alert('失败', '离职失败！请先移除职位下的员工然后重试');
						}
					}, 'json');
				}
			});
		}
	}
	//删除员工
	function removeEmp() {
		var row = $('#tt_employee').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
				if (r) {
					$.post('/human/employee/deleteEmployee.html', {
						id : row.id
					}, function(data) {
						if (data) {
							$.messager.alert('成功', '删除成功！');
							$('#tt_employee').datagrid('reload'); // reload the user data  
						} else {
							$.messager.alert('失败', '删除失败！请先移除职位下的员工然后重试');
						}
					}, 'json');
				}
			});
		}
	}
	//保存员工
	function saveEmp() {
		$('#fm_employee').form('submit', {
			url : url,
			success : function(data) {
				if (!data) {
					$.messager.alert('提示信息', '操作失败！');
				} else {
					$('#dlg_employee').dialog('close'); // close the dialog  
					$('#tt_employee').datagrid('reload'); // reload the user data  
					$.messager.alert('提示信息', '操作成功！');
				}
			}
		});
	}
	//查看员工信息
	function viewEmp() {
		var row = $('#tt_employee').datagrid('getSelected');
		$('#view_employee').window({
			href : '/human/employee/viewEmployee.html?id=' + row.id
		}).window('open');
	}
	//查询员工
	function searchEmps(value) {
		var query = {};
		query['s_empName'] = value;
		$("#tt_employee").datagrid('options').queryParams = query;
		$('#tt_employee').datagrid('reload');
	}
</script>
