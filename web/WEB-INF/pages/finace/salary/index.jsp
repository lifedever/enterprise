<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<style type="text/css">
#employeeSalary {
	border-collapse: collapse;
	border-spacing: 0;
	border-left: 1px solid #888;
	border-top: 1px solid #888;
}

#employeeSalary td {
	border-right: 1px solid #888;
	border-bottom: 1px solid #888;
	padding: 8px;
}
</style>
<jsp:include page="../../common/css.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
<script type="text/javascript">
	var url = "/finace/salary/listContent.html";
	$(function() {
		$('#tt_salary')
				.datagrid(
						{
							title : '',
							iconCls : 'icon-edit',
							fit:true,
							idField : 'id',//id字段
							rownumbers : true,//行号
							url : url,
							singleSelect : true,//是否单选
							toolbar : '#tb_salary',
							pagination : true,
							columns : [ [
									{
										field : 'ck',
										checkbox : true
									},
									{
										field : 'employeeName',
										title : '员工姓名',
										width : 100
									},
									{
										field : 'employeeNo',
										title : '员工编号',
										width : 100
									},
									{
										field : 'baseSalary',
										title : '基本工资',
										width : 100,
										formatter : function(value) {
											return "￥ <strong>" + value
													+ "</strong>";
										}
									},
									{
										field : 'mustSalary',
										title : '应发工资',
										width : 100,
										formatter : function(value) {
											return "￥ <strong>" + value
													+ "</strong>";
										}
									},
									{
										field : 'realSalary',
										title : '实发工资',
										width : 100,
										formatter : function(value) {
											return "￥ <strong>" + value
													+ "</strong>";
										}
									},
									{
										field : 'state',
										title : '状态',
										width : 100,
										formatter : function(value, row) {
											if (row.realSalary >= row.mustSalary) {
												return "<font color='red'>已全额发放</font>";
											} else {
												return "<font color='green'>未全额发放</font>";
											}
										}
									},
									{
										field : 'allowance',
										title : '职务津贴',
										width : 100,
										formatter : function(value) {
											return "￥ <strong>" + value
													+ "</strong>";
										}
									},
									{
										field : 'jobSubsidy',
										title : '工种补助',
										width : 100,
										formatter : function(value) {
											return "￥ <strong>" + value
													+ "</strong>";
										}
									},
									{
										field : 'overtimeSubsidy',
										title : '加班补助',
										width : 100,
										formatter : function(value) {
											return "￥ <strong>" + value
													+ "</strong>";
										}
									},
									{
										field : 'overtimeSalary',
										title : '加班费',
										width : 100,
										formatter : function(value) {
											return "￥ <strong>" + value
													+ "</strong>";
										}
									},
									{
										field : 'leaveUnpay',
										title : '请假扣款',
										width : 100,
										formatter : function(value) {
											return "￥ <font color='red'>"
													+ "<strong>" + value
													+ "</strong>" + "</font>"
										}
									},
									{
										field : 'forfeit',
										title : '罚款',
										width : 100,
										formatter : function(value) {
											return "￥ <font color='red'>"
													+ "<strong>" + value
													+ "</strong>" + "</font>"
										}
									},
									{
										field : 'otherUnpay',
										title : '其他罚款',
										width : 140,
										formatter : function(value) {
											return "￥ <font color='red'>"
													+ "<strong>" + value
													+ "</strong>" + "</font>"
										}
									},
									{
										field : 'accountName',
										title : '发放帐号',
										width : 120
									},
									{
										field : 'createDate',
										title : '发放时间',
										width : 90,
										formatter : function(value, row, index) {
											if (value) {
												return getDateFromJson(value);
											}
										}
									} ] ],
						});
	});
</script>
<body>
	<div class="easyui-tabs" style="" data-options="fit:true">
		<div title="工资管理" style="padding: 3px">
			<table id="tt_salary">
			</table>
		</div>
	</div>
	<div id="tb_salary">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newSalary()">添加</a> <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="viewSalary()">查看</a> <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="removeSalary()">删除</a> <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="showMonthSalarys()">查看月度报表</a> <a href="#" class="easyui-linkbutton" iconCls="icon-print" plain="true" onclick="exportExcel()">导出报表</a> 员工姓名： <input id="key" class="easyui-searchbox"
			data-options="prompt:'输入查询关键字',searcher:searchEmp" />
	</div>
	<div id="viewSalary" class="easyui-window" title="工资信息" data-options="closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 650px; height: 450px; padding: 10px;"></div>
	<div class="easyui-window" id="win_employee" data-options="title:'选择员工',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 850px; height: 400px; padding: 10px;"></div>
	<div class="easyui-window" id="win_accountName" data-options="title:'选择银行账户',closed:true,modal:true,iconCls:'icon-save',cache:false" style="width: 800px; height: 350px; padding: 10px;"></div>
	<div class="easyui-window" id="win_months" data-options="title:'月度薪水报表',closed:true,modal:true,iconCls:'icon-save',maximized:true,cache:false" style="width: 800px; height: 450px; padding: 10px;"></div>
	<jsp:include page="addForm.jsp"></jsp:include>
	<jsp:include page="export.jsp"></jsp:include>
	<script type="text/javascript">
		//弹出员工列表
		$('#employeeName').on('focus', function() {
			$('#win_employee').window({
				href : '/finace/salary/listEmployee.html'
			}).window('open');
		});
		//弹出银行账户 
		$('#accountName').on('focus', function() {
			$('#win_accountName').window({
				href : '/finace/salary/listAccount.html'
			}).window('open');
		});
		//自动计算应发工资
		$('input').on(
				'focus',
				function() {
					var salary = (Number($('#baseSalary').val())
							+ Number($('#allowance').val())
							+ Number($('#jobSubsidy').val())
							+ Number($('#overtimeSubsidy').val())
							+ Number($('#overtimeSalary').val())
							- Number($('#leaveUnpay').val())
							- Number($('#forfeit').val()) - Number($(
							'#otherUnpay').val()));
					$('#mustSalary').val(salary);
					$('#realSalary').val(salary);
				});

		function newSalary() {
			$('#dlg_salary').window('open').window('setTitle', '工资发放');
			$('#fm_salary').form('clear');
			url = 'addSalary.html';
		}
		//保存
		function saveSalary() {
			$('#fm_salary').form(
					'submit',
					{
						url : url,
						onSubmit : function() {
							var salary = (Number($('#baseSalary').val())
									+ Number($('#allowance').val())
									+ Number($('#jobSubsidy').val())
									+ Number($('#overtimeSubsidy').val())
									+ Number($('#overtimeSalary').val())
									- Number($('#leaveUnpay').val())
									- Number($('#forfeit').val()) - Number($(
									'#otherUnpay').val()));
							$('#mustSalary').val(salary);
							if ($('#employeeName').val() == '') {
								$.messager.alert('错误', '请选择员工！');
								return false;
							}
							if ($('#accountName').val() == '') {
								$.messager.alert('错误', '请选择银行账户！');
								return false;
							}
							return $(this).form('validate');
						},
						success : function(data) {
							if (data) {
								$.messager.alert('提示信息', '操作成功！');
								$('#dlg_salary').dialog('close'); // close the dialog  
								$('#tt_salary').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('提示信息', '操作失败！');
							}
						}
					});
		}
		//保存并继续
		function saveAndGoon() {
			$('#fm_salary').form(
					'submit',
					{
						url : url,
						onSubmit : function() {
							var salary = (Number($('#baseSalary').val())
									+ Number($('#allowance').val())
									+ Number($('#jobSubsidy').val())
									+ Number($('#overtimeSubsidy').val())
									+ Number($('#overtimeSalary').val())
									- Number($('#leaveUnpay').val())
									- Number($('#forfeit').val()) - Number($(
									'#otherUnpay').val()));
							$('#mustSalary').val(salary);
							if ($('#employeeName').val() == '') {
								$.messager.alert('错误', '请选择员工！');
								return false;
							}
							if ($('#accountName').val() == '') {
								$.messager.alert('错误', '请选择银行账户！');
								return false;
							}
							return $(this).form('validate');
						},
						success : function(data) {
							if (data) {
								$('#tt_salary').datagrid('reload'); // reload the user data
								$('#win_employee').window({
									href : '/finace/salary/listEmployee.html'
								}).window('open');
							} else {
								$.messager.alert('提示信息', '操作失败！');
							}
						}
					});
		}
		function removeSalary() {
			var row = $('#tt_salary').datagrid('getSelected');
			if (row) {
				$.messager.confirm('警告', '你确定要删除选择吗?', function(r) {
					if (r) {
						$.post('removeSalary.html', {
							salaryId : row.id
						}, function(result) {
							if (result) {
								$.messager.alert('成功', '删除成功！');
								$('#tt_salary').datagrid('reload'); // reload the user data  
							} else {
								$.messager.alert('失败', '删除失败！');
							}
						}, 'json');
					}
				});
			}
		}
		//查看
		function viewSalary() {
			var row = $('#tt_salary').datagrid('getSelected');
			if (row) {
				$('#viewSalary').window({
					href : '/finace/salary/viewSalary.html?salaryId=' + row.id
				}).window('open');
			}
		}
		//查看月度报表
		function showMonthSalarys() {
			$('#win_months').window({
				href : '/finace/salary/listMonths.html'
			}).window('open');
		}
		//导出报表
		function exportExcel() {
			$('#dlg_export').window('open').window('setTitle', '导出报表');
			$('#fm_export').form('clear');
		}
		function exportOk() {
			$('#fm_export').form('submit', {
				url : "exportSalaryExcel.html",
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					if (data) {
					} else {
						$.messager.alert('提示信息', '操作失败！');
					}
				}
			});
		}
		function searchEmp(value) {
			var query = {};
			query['s_employee.empName'] = value;
			$("#tt_salary").datagrid('options').queryParams = query;
			$('#tt_salary').datagrid('reload');
		}
	</script>
</body>
<jsp:include page="../../main/footer.jsp"></jsp:include>
</html>